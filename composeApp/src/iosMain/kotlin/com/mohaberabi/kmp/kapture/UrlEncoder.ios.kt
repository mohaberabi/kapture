package com.mohaberabi.kmp.kapture


actual class UrlEncoder {
    actual fun encode(url: String): String {
        return url.replace("[^a-zA-Z0-9._-]".toRegex(), "_")
    }

}