package com.etb.filemanager.files.file.common.mime

import com.etb.filemanager.R

enum class MimeTypeIcon(val resourceId: Int) {
    APK(R.drawable.file_apk_icon),
    ARCHIVE(R.drawable.file_archive_icon),
    AUDIO(R.drawable.file_audio_icon),
    CALENDAR(R.drawable.file_calendar_icon),
    CERTIFICATE(R.drawable.file_certificate_icon),
    CODE(R.drawable.file_code_icon),
    CONTACT(R.drawable.file_contact_icon),
    DIRECTORY(R.drawable.file_directory_icon),
    DOCUMENT(R.drawable.file_document_icon),
    EBOOK(R.drawable.file_ebook_icon),
    EMAIL(R.drawable.file_email_icon),
    FONT(R.drawable.file_font_icon),
    GENERIC(R.drawable.file_generic_icon),
    IMAGE(R.drawable.file_image_icon),
    PDF(R.drawable.file_pdf_icon),
    PRESENTATION(R.drawable.file_presentation_icon),
    SPREADSHEET(R.drawable.file_spreadsheet_icon),
    TEXT(R.drawable.file_text_icon),
    VIDEO(R.drawable.file_video_icon),
    WORD(R.drawable.file_word_icon),
    EXCEL(R.drawable.file_excel_icon),
    POWERPOINT(R.drawable.file_powerpoint_icon)
}


val MimeType.icon: MimeTypeIcon
    get() =
        mimeTypeToIconMap[this] ?: typeToIconMap[type] ?: suffix?.let { suffixToIconMap[it] }
        ?: MimeTypeIcon.GENERIC

private val mimeTypeToIconMap = mapOf(
    "application/vnd.android.package-archive" to MimeTypeIcon.APK,
    "application/gzip" to MimeTypeIcon.ARCHIVE,
    "application/java-archive" to MimeTypeIcon.ARCHIVE,
    "application/mac-binhex40" to MimeTypeIcon.ARCHIVE,
    "application/rar" to MimeTypeIcon.ARCHIVE,
    "application/zip" to MimeTypeIcon.ARCHIVE,
    "application/vnd.debian.binary-package" to MimeTypeIcon.ARCHIVE,
    "application/vnd.ms-cab-compressed" to MimeTypeIcon.ARCHIVE,
    "application/vnd.rar" to MimeTypeIcon.ARCHIVE,
    "application/x-7z-compressed" to MimeTypeIcon.ARCHIVE,
    "application/x-apple-diskimage" to MimeTypeIcon.ARCHIVE,
    "application/x-bzip" to MimeTypeIcon.ARCHIVE,
    "application/x-bzip2" to MimeTypeIcon.ARCHIVE,
    "application/x-compress" to MimeTypeIcon.ARCHIVE,
    "application/x-cpio" to MimeTypeIcon.ARCHIVE,
    "application/x-deb" to MimeTypeIcon.ARCHIVE,
    "application/x-debian-package" to MimeTypeIcon.ARCHIVE,
    "application/x-gtar" to MimeTypeIcon.ARCHIVE,
    "application/x-gtar-compressed" to MimeTypeIcon.ARCHIVE,
    "application/x-gzip" to MimeTypeIcon.ARCHIVE,
    "application/x-iso9660-image" to MimeTypeIcon.ARCHIVE,
    "application/x-java-archive" to MimeTypeIcon.ARCHIVE,
    "application/x-lha" to MimeTypeIcon.ARCHIVE,
    "application/x-lzh" to MimeTypeIcon.ARCHIVE,
    "application/x-lzma" to MimeTypeIcon.ARCHIVE,
    "application/x-lzx" to MimeTypeIcon.ARCHIVE,
    "application/x-rar-compressed" to MimeTypeIcon.ARCHIVE,
    "application/x-stuffit" to MimeTypeIcon.ARCHIVE,
    "application/x-tar" to MimeTypeIcon.ARCHIVE,
    "application/x-webarchive" to MimeTypeIcon.ARCHIVE,
    "application/x-webarchive-xml" to MimeTypeIcon.ARCHIVE,
    "application/x-xz" to MimeTypeIcon.ARCHIVE,
    "application/ogg" to MimeTypeIcon.AUDIO,
    "application/x-flac" to MimeTypeIcon.AUDIO,
    "text/calendar" to MimeTypeIcon.CALENDAR,
    "text/x-vcalendar" to MimeTypeIcon.CALENDAR,
    "application/pgp-keys" to MimeTypeIcon.CERTIFICATE,
    "application/pgp-signature" to MimeTypeIcon.CERTIFICATE,
    "application/x-pkcs12" to MimeTypeIcon.CERTIFICATE,
    "application/x-pkcs7-certificates" to MimeTypeIcon.CERTIFICATE,
    "application/x-pkcs7-certreqresp" to MimeTypeIcon.CERTIFICATE,
    "application/x-pkcs7-crl" to MimeTypeIcon.CERTIFICATE,
    "application/x-pkcs7-mime" to MimeTypeIcon.CERTIFICATE,
    "application/x-pkcs7-signature" to MimeTypeIcon.CERTIFICATE,
    "application/x-x509-ca-cert" to MimeTypeIcon.CERTIFICATE,
    "application/x-x509-server-cert" to MimeTypeIcon.CERTIFICATE,
    "application/x-x509-user-cert" to MimeTypeIcon.CERTIFICATE,
    "application/ecmascript" to MimeTypeIcon.CODE,
    "application/javascript" to MimeTypeIcon.CODE,
    "application/json" to MimeTypeIcon.CODE,
    "application/typescript" to MimeTypeIcon.CODE,
    "application/xml" to MimeTypeIcon.CODE,
    "application/x-csh" to MimeTypeIcon.CODE,
    "application/x-ecmascript" to MimeTypeIcon.CODE,
    "application/x-javascript" to MimeTypeIcon.CODE,
    "application/x-latex" to MimeTypeIcon.CODE,
    "application/x-perl" to MimeTypeIcon.CODE,
    "application/x-python" to MimeTypeIcon.CODE,
    "application/x-ruby" to MimeTypeIcon.CODE,
    "application/x-sh" to MimeTypeIcon.CODE,
    "application/x-shellscript" to MimeTypeIcon.CODE,
    "application/x-texinfo" to MimeTypeIcon.CODE,
    "application/x-yaml" to MimeTypeIcon.CODE,
    "text/css" to MimeTypeIcon.CODE,
    "text/html" to MimeTypeIcon.CODE,
    "text/ecmascript" to MimeTypeIcon.CODE,
    "text/javascript" to MimeTypeIcon.CODE,
    "text/jscript" to MimeTypeIcon.CODE,
    "text/livescript" to MimeTypeIcon.CODE,
    "text/xml" to MimeTypeIcon.CODE,
    "text/x-asm" to MimeTypeIcon.CODE,
    "text/x-c++hdr" to MimeTypeIcon.CODE,
    "text/x-c++src" to MimeTypeIcon.CODE,
    "text/x-chdr" to MimeTypeIcon.CODE,
    "text/x-csh" to MimeTypeIcon.CODE,
    "text/x-csharp" to MimeTypeIcon.CODE,
    "text/x-csrc" to MimeTypeIcon.CODE,
    "text/x-dsrc" to MimeTypeIcon.CODE,
    "text/x-ecmascript" to MimeTypeIcon.CODE,
    "text/x-haskell" to MimeTypeIcon.CODE,
    "text/x-java" to MimeTypeIcon.CODE,
    "text/x-javascript" to MimeTypeIcon.CODE,
    "text/x-literate-haskell" to MimeTypeIcon.CODE,
    "text/x-pascal" to MimeTypeIcon.CODE,
    "text/x-perl" to MimeTypeIcon.CODE,
    "text/x-python" to MimeTypeIcon.CODE,
    "text/x-ruby" to MimeTypeIcon.CODE,
    "text/x-shellscript" to MimeTypeIcon.CODE,
    "text/x-tcl" to MimeTypeIcon.CODE,
    "text/x-tex" to MimeTypeIcon.CODE,
    "text/x-yaml" to MimeTypeIcon.CODE,
    "text/vcard" to MimeTypeIcon.CONTACT,
    "text/x-vcard" to MimeTypeIcon.CONTACT,
    "inode/directory" to MimeTypeIcon.DIRECTORY,
    MimeType.DIRECTORY.value to MimeTypeIcon.DIRECTORY,
    "application/rtf" to MimeTypeIcon.DOCUMENT,
    "application/vnd.oasis.opendocument.text" to MimeTypeIcon.DOCUMENT,
    "application/vnd.oasis.opendocument.text-master" to MimeTypeIcon.DOCUMENT,
    "application/vnd.oasis.opendocument.text-template" to MimeTypeIcon.DOCUMENT,
    "application/vnd.oasis.opendocument.text-web" to MimeTypeIcon.DOCUMENT,
    "application/vnd.stardivision.writer" to MimeTypeIcon.DOCUMENT,
    "application/vnd.stardivision.writer-global" to MimeTypeIcon.DOCUMENT,
    "application/vnd.sun.xml.writer" to MimeTypeIcon.DOCUMENT,
    "application/vnd.sun.xml.writer.global" to MimeTypeIcon.DOCUMENT,
    "application/vnd.sun.xml.writer.template" to MimeTypeIcon.DOCUMENT,
    "application/x-abiword" to MimeTypeIcon.DOCUMENT,
    "application/x-kword" to MimeTypeIcon.DOCUMENT,
    "text/rtf" to MimeTypeIcon.DOCUMENT,
    "application/epub+zip" to MimeTypeIcon.EBOOK,
    "application/vnd.amazon.ebook" to MimeTypeIcon.EBOOK,
    "application/x-cbr" to MimeTypeIcon.EBOOK,
    "application/x-cbz" to MimeTypeIcon.EBOOK,
    "application/x-ibooks+zip" to MimeTypeIcon.EBOOK,
    "application/x-mobipocket-ebook" to MimeTypeIcon.EBOOK,
    "application/vnd.ms-outlook" to MimeTypeIcon.EMAIL,
    "message/rfc822" to MimeTypeIcon.EMAIL,
    "application/font-cff" to MimeTypeIcon.FONT,
    "application/font-off" to MimeTypeIcon.FONT,
    "application/font-sfnt" to MimeTypeIcon.FONT,
    "application/font-ttf" to MimeTypeIcon.FONT,
    "application/font-woff" to MimeTypeIcon.FONT,
    "application/vnd.ms-fontobject" to MimeTypeIcon.FONT,
    "application/vnd.ms-opentype" to MimeTypeIcon.FONT,
    "application/x-font" to MimeTypeIcon.FONT,
    "application/x-font-ttf" to MimeTypeIcon.FONT,
    "application/x-font-woff" to MimeTypeIcon.FONT,
    "application/vnd.oasis.opendocument.graphics" to MimeTypeIcon.IMAGE,
    "application/vnd.oasis.opendocument.graphics-template" to MimeTypeIcon.IMAGE,
    "application/vnd.oasis.opendocument.image" to MimeTypeIcon.IMAGE,
    "application/vnd.stardivision.draw" to MimeTypeIcon.IMAGE,
    "application/vnd.sun.xml.draw" to MimeTypeIcon.IMAGE,
    "application/vnd.sun.xml.draw.template" to MimeTypeIcon.IMAGE,
    "application/vnd.visio" to MimeTypeIcon.IMAGE,
    "application/pdf" to MimeTypeIcon.PDF,
    "application/vnd.oasis.opendocument.presentation" to MimeTypeIcon.PRESENTATION,
    "application/vnd.oasis.opendocument.presentation-template" to MimeTypeIcon.PRESENTATION,
    "application/vnd.stardivision.impress" to MimeTypeIcon.PRESENTATION,
    "application/vnd.sun.xml.impress" to MimeTypeIcon.PRESENTATION,
    "application/vnd.sun.xml.impress.template" to MimeTypeIcon.PRESENTATION,
    "application/x-kpresenter" to MimeTypeIcon.PRESENTATION,
    "application/vnd.oasis.opendocument.spreadsheet" to MimeTypeIcon.SPREADSHEET,
    "application/vnd.oasis.opendocument.spreadsheet-template" to MimeTypeIcon.SPREADSHEET,
    "application/vnd.stardivision.calc" to MimeTypeIcon.SPREADSHEET,
    "application/vnd.sun.xml.calc" to MimeTypeIcon.SPREADSHEET,
    "application/vnd.sun.xml.calc.template" to MimeTypeIcon.SPREADSHEET,
    "application/x-kspread" to MimeTypeIcon.SPREADSHEET,
    "application/x-quicktimeplayer" to MimeTypeIcon.VIDEO,
    "application/x-shockwave-flash" to MimeTypeIcon.VIDEO,
    "application/msword" to MimeTypeIcon.WORD,
    "application/vnd.openxmlformats-officedocument.wordprocessingml.document" to MimeTypeIcon.WORD,
    "application/vnd.openxmlformats-officedocument.wordprocessingml.template" to MimeTypeIcon.WORD,
    "application/vnd.ms-excel" to MimeTypeIcon.EXCEL,
    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" to MimeTypeIcon.EXCEL,
    "application/vnd.openxmlformats-officedocument.spreadsheetml.template" to MimeTypeIcon.EXCEL,
    "application/vnd.ms-powerpoint" to MimeTypeIcon.POWERPOINT,
    "application/vnd.openxmlformats-officedocument.presentationml.presentation"
            to MimeTypeIcon.POWERPOINT,
    "application/vnd.openxmlformats-officedocument.presentationml.slideshow"
            to MimeTypeIcon.POWERPOINT,
    "application/vnd.openxmlformats-officedocument.presentationml.template"
            to MimeTypeIcon.POWERPOINT
).mapKeys { it.key.asMimeType() }

private val typeToIconMap = mapOf(
    "audio" to MimeTypeIcon.AUDIO,
    "font" to MimeTypeIcon.FONT,
    "image" to MimeTypeIcon.IMAGE,
    "text" to MimeTypeIcon.TEXT,
    "video" to MimeTypeIcon.VIDEO
)

private val suffixToIconMap = mapOf(
    "json" to MimeTypeIcon.CODE,
    "xml" to MimeTypeIcon.CODE,
    "zip" to MimeTypeIcon.ARCHIVE
)

val MimeType.iconRes: Int
    get() = icon.resourceId