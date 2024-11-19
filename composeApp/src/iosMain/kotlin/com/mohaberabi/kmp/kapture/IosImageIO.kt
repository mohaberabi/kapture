package com.mohaberabi.kmp.kapture

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import org.jetbrains.skia.Image
import platform.Foundation.NSCachesDirectory
import platform.Foundation.NSSearchPathDirectory
import platform.Foundation.NSSearchPathForDirectoriesInDomains
import platform.Foundation.NSUserDomainMask
import platform.Foundation.*

class IosImageIO(
    private val urlEncoder: UrlEncoder,
) : ImageIO {
    override suspend fun save(
        bytes: ByteArray,
        url: String
    ) {
        withContext(Dispatchers.IO) {
            val nsData = bytes.toNSData()
            val encoded = urlEncoder.encode(url)
            val file = "${createAppDirectory()}/${encoded}"
            nsData.writeToFile(file, true)
        }

    }


    override suspend fun load(url: String): ByteArray? {
        val encoded = urlEncoder.encode(url)

        val directory = "${createAppDirectory()}/${encoded}"
        val nsData = NSData.create(contentsOfFile = directory) ?: return null
        return nsData.toByteArray()
    }


    @OptIn(ExperimentalForeignApi::class)
    private fun createAppDirectory(): String {
        val directoryPath = "${cacheDir}/${DIR_NAME}"
        val fileManager = NSFileManager.defaultManager
        if (!fileManager.fileExistsAtPath(directoryPath)) {
            fileManager.createDirectoryAtPath(
                directoryPath,
                withIntermediateDirectories = true,
                attributes = null,
                error = null
            )
        }
        return directoryPath
    }

    private val cacheDir
        get() = NSSearchPathForDirectoriesInDomains(
            NSCachesDirectory,
            NSUserDomainMask,
            expandTilde = true
        ).first() as String
}