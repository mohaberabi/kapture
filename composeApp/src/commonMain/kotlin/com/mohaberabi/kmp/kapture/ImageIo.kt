package com.mohaberabi.kmp.kapture


const val DIR_NAME = "katpture"

interface ImageIO {
    suspend fun save(bytes: ByteArray, url: String)
    suspend fun load(url: String): ByteArray?
}


