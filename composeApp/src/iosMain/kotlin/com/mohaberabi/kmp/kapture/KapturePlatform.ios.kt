package com.mohaberabi.kmp.kapture

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.mohaberabi.kmp.kapture.fetcher.IosRemoteImageFetcher

@Composable
actual fun rememberKapture(): Kapture {


    val fetcher = remember {
        IosRemoteImageFetcher(ImageCompression())
    }

    val imageIo = remember {
        IosImageIO(UrlEncoder())
    }
    return remember {
        KaptureImpl(fetcher, imageIo = imageIo)
    }
}