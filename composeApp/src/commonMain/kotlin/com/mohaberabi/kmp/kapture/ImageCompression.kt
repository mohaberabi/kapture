package com.mohaberabi.kmp.kapture


expect class ImageCompression {
    suspend fun compressImage(
        bytes: ByteArray,
        maxSize: Int,
    ): ByteArray
}