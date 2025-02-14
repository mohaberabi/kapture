package com.mohaberabi.kmp.kapture

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.decodeToImageBitmap


@OptIn(ExperimentalResourceApi::class)
@Composable
fun AsyncImage(
    modifier: Modifier = Modifier,
    loading: @Composable () -> Unit,
    error: @Composable () -> Unit,
    forPreview: (@Composable (Modifier) -> Unit)? = null,
    contentDescription: String? = null,
    url: String,
) {
    if (forPreview != null) {
        forPreview(modifier)
    } else {
        RuntimeAsyncImage(
            modifier = modifier,
            loading = loading,
            error = error,
            url = url,
            contentDescription = contentDescription
        )

    }


}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun RuntimeAsyncImage(
    modifier: Modifier = Modifier,
    loading: @Composable () -> Unit,
    error: @Composable () -> Unit,
    url: String,
    contentDescription: String? = null,
) {
    val kapture = rememberKapture()
    var result by remember {
        mutableStateOf<ImageResult>(ImageResult.Loading)
    }


    LaunchedEffect(
        Unit,
    ) {
        result = kapture.load(url)

    }
    Box(
        modifier = modifier,
    ) {
        when (result) {
            is ImageResult.Done -> {

                Column() {

                    Image(
                        bitmap = (result as ImageResult.Done).imageData.bytes.decodeToImageBitmap(),
                        contentDescription = contentDescription
                    )
                    Text("Image Loaded From :${(result as ImageResult.Done).imageData.source.name}")
                }
            }

            is ImageResult.Error -> error()
            ImageResult.Loading -> loading()
        }
    }
}