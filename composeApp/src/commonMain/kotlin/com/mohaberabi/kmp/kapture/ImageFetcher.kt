package com.mohaberabi.kmp.kapture

import com.mohaberabi.kmp.kapture.lru.LruCache


typealias ImageLRU = LruCache<String, ByteArray>

interface ImageFetcher {
    suspend fun fetch(
        url: String,
    ): ByteArray
}