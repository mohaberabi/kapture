package com.mohaberabi.kmp.kapture

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kapture.composeapp.generated.resources.Res
import kapture.composeapp.generated.resources.compose_multiplatform


val images = listOf(
    "https://plus.unsplash.com/premium_photo-1664474619075-644dd191935f?q=80&w=2938&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
    "https://i0.wp.com/picjumbo.com/wp-content/uploads/frosted-rosehip-free-photo.jpg?w=2210&quality=70",
    "https://i0.wp.com/picjumbo.com/wp-content/uploads/frosted-rosehip-free-photo.jpg?w=2210&quality=70",
    "https://i0.wp.com/picjumbo.com/wp-content/uploads/frosted-rosehip-free-photo.jpg?w=2210&quality=70",
    "https://i0.wp.com/picjumbo.com/wp-content/uploads/first-heavy-snow-winter-scenery-painting-free-image.jpg?w=2210&quality=70",
    "https://i0.wp.com/picjumbo.com/wp-content/uploads/first-heavy-snow-winter-scenery-painting-free-image.jpg?w=2210&quality=70",
    "https://i0.wp.com/picjumbo.com/wp-content/uploads/first-heavy-snow-winter-scenery-painting-free-image.jpg?w=2210&quality=70",
    "https://i0.wp.com/picjumbo.com/wp-content/uploads/first-heavy-snow-winter-scenery-painting-free-image.jpg?w=2210&quality=70",
    "https://i0.wp.com/picjumbo.com/wp-content/uploads/first-heavy-snow-winter-scenery-painting-free-image.jpg?w=2210&quality=70",
    "https://i0.wp.com/picjumbo.com/wp-content/uploads/first-heavy-snow-winter-scenery-painting-free-image.jpg?w=2210&quality=70",
    "https://i0.wp.com/picjumbo.com/wp-content/uploads/first-heavy-snow-winter-scenery-painting-free-image.jpg?w=2210&quality=70",
)

@Composable
@Preview
fun App() {
    MaterialTheme {

        Scaffold { padding ->
            LazyColumn(
                modifier = Modifier.padding(padding).padding(20.dp).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                items(images) { url ->
                    AsyncImage(
                        modifier = Modifier.size(200.dp),
                        loading = {
                            CircularProgressIndicator()
                        },
                        error = {
                            Text("Error Loading Image ")
                        },
                        url = url
                    )
                }

            }
        }
    }
}