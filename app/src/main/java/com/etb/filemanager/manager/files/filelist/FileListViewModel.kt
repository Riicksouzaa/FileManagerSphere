package com.etb.filemanager.manager.files.filelist

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.etb.filemanager.R
import com.etb.filemanager.manager.util.MaterialDialogUtils
import kotlinx.coroutines.*
import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import java.util.concurrent.Callable
import java.util.concurrent.Executors

class FileListViewModel : ViewModel() {
    private val TAG = "FileViewModel"

    private val _operationTitle = MutableLiveData<String>()
    private val _operationMsg = MutableLiveData<String>()
    private val _operationProgress = MutableLiveData<Int>()
    private val _startOperation = MutableLiveData<TypeOperation>()
    private val _cancelOperationProgress = MutableLiveData<Unit>()

    val operationProgress: LiveData<Int>
        get() = _operationProgress

    val startOperation: LiveData<TypeOperation>
        get() = _startOperation
    val cancelOperationProgress: LiveData<Unit>
        get() = _cancelOperationProgress
    val operationTitle: LiveData<String>
        get() = _operationTitle
     val operationMsg: LiveData<String>
        get() = _operationMsg

    fun deleteFilesAndFolders(filePaths: List<String>) {
        viewModelScope.launch {
            _operationProgress.value = 0
            for ((index, path) in filePaths.withIndex()) {
                DeleteOperation.deleteFilesOrDir(path)
                _operationProgress.value = ((index + 1) * 100) / filePaths.size
            }
            _operationProgress.value = 100
        }
    }



/*
    @OptIn(DelicateCoroutinesApi::class)
    fun moveFiles(sourceFiles: List<File>, destinationDir: File, context: Context) {
        viewModelScope.launch {
            val totalFiles = sourceFiles.size
            var completedFiles = 0


            val tasks = sourceFiles.map { sourceFile ->
                async(Dispatchers.IO) {
                    val destinationFile = destinationDir.resolve(sourceFile.name)
                    Log.i(TAG, "Path:: ${sourceFile.path}")

                    try {
                        completedFiles++
                        val progress = (completedFiles.toFloat() / totalFiles.toFloat()) * 100
                        val title = context.resources.getQuantityString(R.plurals.movingItems, 1, sourceFiles.size)
                        val numItems = sourceFiles.size
                        val msg = context.resources.getQuantityString(
                            R.plurals.movingItems,
                            numItems,
                            numItems,
                            sourceFile.name,
                            destinationFile.path
                        )

                        withContext(Dispatchers.Main) {
                            _operationTitle.value = title
                            _operationMsg.value = msg
                            _operationProgress.value = progress.toInt()
                        }

                        Files.move(
                            sourceFile.toPath(),
                            destinationFile.toPath()
                        )
                    } catch (e: Exception) {
                        if (e is java.nio.file.FileAlreadyExistsException){
                            try {
                                val title = context.resources.getQuantityString(R.plurals.plurals_file_already_exists,1)
                                val msg = context.resources.getQuantityString(R.plurals.plurals_file_already_exists, 2, sourceFile.name)
                                val textPositiveButton = context.getString(R.string.replace)
                                val textNegativeButton = context.getString(R.string.skip)

                                withContext(Dispatchers.Main){
                                MaterialDialogUtils().createDialogInfo(
                                    title, msg, textPositiveButton, textNegativeButton, context, true
                                ) { dialogResult ->
                                    val isConfirmed = dialogResult.confirmed
                                    val currentFile = sourceFile
                                    if (isConfirmed) {
                                        launch(Dispatchers.IO) {
                                            try {
                                                withContext(Dispatchers.Main) {
                                                    val progress = (completedFiles.toFloat() / totalFiles.toFloat()) * 100
                                                    _operationTitle.value = title
                                                    _operationMsg.value = "\"msg\""
                                                    _operationProgress.value = progress.toInt()
                                                }
                                                Files.move(
                                                    sourceFile.toPath(),
                                                    destinationFile.toPath(),
                                                    StandardCopyOption.REPLACE_EXISTING
                                                )
                                            } catch (e: Exception) {
                                                Log.e(TAG, "Error 2: $e")

                                            }
                                        }
                                    }
                                    val listFiles = sourceFiles.toMutableList()
                                    if (!listFiles.isEmpty()) {
                                        listFiles.remove(currentFile)
                                        moveFiles(listFiles.toList(), destinationFile, context)
                                    }

                                }
                                }
                            } catch (e: Exception){
                                Log.e(TAG, "Error 1: $e")
                            }
                        }
                        Log.e(TAG, "Error: $e")
                    }
                }
            }

            try {
                awaitAll(*tasks.toTypedArray())
                withContext(Dispatchers.Main) {
                    _cancelOperationProgress.value = Unit
                    Toast.makeText(context, "Arquivos movidos com sucesso", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error: $e")
            } finally {
                withContext(Dispatchers.Main) {
                    _cancelOperationProgress.value = Unit
                }
            }
        }
    }
*/

    @OptIn(DelicateCoroutinesApi::class)
    fun moveFiles(sourceFiles: List<File>, destinationDir: File, context: Context) {
        viewModelScope.launch {
            val totalFiles = sourceFiles.size
            var completedFiles = 0

            val tasks = sourceFiles.map { sourceFile ->
                async(Dispatchers.IO) {
                    val destinationFile = destinationDir.resolve(sourceFile.name)
                    Log.i(TAG, "Path:: ${sourceFile.path}")

                    try {
                        completedFiles++
                        val progress = (completedFiles.toFloat() / totalFiles.toFloat()) * 100
                        val title = context.resources.getQuantityString(R.plurals.movingItems, 1, sourceFiles.size - 1)
                        val numItems = sourceFiles.size - 1
                        val msg = context.resources.getQuantityString(
                            R.plurals.movingItems,
                            numItems,
                            numItems,
                            sourceFile.name,
                            destinationFile.path
                        )

                        withContext(Dispatchers.Main) {
                            _operationTitle.value = title
                            _operationMsg.value = msg
                            _operationProgress.value = progress.toInt()
                        }

                        if (sourceFile.isDirectory) {
                            Files.move(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING)
                        } else {
                            Files.move(sourceFile.toPath(), destinationFile.toPath())
                        }
                    } catch (e: Exception) {
                        if (e is java.nio.file.FileAlreadyExistsException){
                            // Tratamento para arquivo ou diretório já existente
                            try {
                                val title = context.resources.getQuantityString(R.plurals.plurals_file_already_exists, 1)
                                val msg = context.resources.getQuantityString(R.plurals.plurals_file_already_exists, 2, sourceFile.name)
                                val textPositiveButton = context.getString(R.string.replace)
                                val textNegativeButton = context.getString(R.string.skip)

                                withContext(Dispatchers.Main) {
                                    MaterialDialogUtils().createDialogInfo(
                                        title, msg, textPositiveButton, textNegativeButton, context, true
                                    ) { dialogResult ->
                                        val isConfirmed = dialogResult.confirmed
                                        val currentFile = sourceFile
                                        if (isConfirmed) {
                                            launch(Dispatchers.IO) {
                                                try {
                                                    withContext(Dispatchers.Main) {
                                                        val progress = (completedFiles.toFloat() / totalFiles.toFloat()) * 100
                                                        _operationTitle.value = title
                                                        _operationMsg.value = "\"msg\""
                                                        _operationProgress.value = progress.toInt()
                                                    }
                                                    if (sourceFile.isDirectory) {
                                                        Files.move(
                                                            sourceFile.toPath(),
                                                            destinationFile.toPath(),
                                                            StandardCopyOption.REPLACE_EXISTING
                                                        )
                                                    } else {
                                                        Files.move(
                                                            sourceFile.toPath(),
                                                            destinationFile.toPath(),
                                                            StandardCopyOption.REPLACE_EXISTING
                                                        )
                                                    }
                                                } catch (e: Exception) {
                                                    Log.e(TAG, "Error 2: $e")
                                                }
                                            }
                                        }
                                        val listFiles = sourceFiles.toMutableList()
                                        if (!listFiles.isEmpty()) {
                                            listFiles.remove(currentFile)
                                            moveFiles(listFiles.toList(), destinationFile, context)
                                        }
                                    }
                                }
                            } catch (e: Exception){
                                Log.e(TAG, "Error 1: $e")
                            }
                        }
                        Log.e(TAG, "Error: $e")
                    }
                }
            }

            try {
                awaitAll(*tasks.toTypedArray())
                withContext(Dispatchers.Main) {
                    _cancelOperationProgress.value = Unit
                    Toast.makeText(context, "Arquivos movidos com sucesso", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error: $e")
            } finally {
                withContext(Dispatchers.Main) {
                    _cancelOperationProgress.value = Unit
                }
            }
        }
    }


    fun startOperation(typeOperation: TypeOperation){
        _startOperation.postValue(typeOperation)
    }

    fun initOperation(typeOperation: TypeOperation, sourceFiles: List<File>, destinationDir: File, context: Context){
        when(typeOperation){
            TypeOperation.CUT -> { moveFiles(sourceFiles, destinationDir, context)}
        }
    }

    /*fun Path.moveTo(target: Path): Path{

    }
    fun Path.moveTo(target: Path, overwrite: Boolean = false): Path{

    }*/

}

enum class TypeOperation(){
    CUT,
   // COPY,
}

