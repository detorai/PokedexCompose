@file:Suppress("UNREACHABLE_CODE")

package com.example.profiki.Common

import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun loadImage(url: String): ImageBitmap {
    var imageBitmap by remember { mutableStateOf<ImageBitmap>(ImageBitmap(1, 1)) }
    LaunchedEffect(url) {
        imageBitmap = loadImageBitmap(url)
    }

    return imageBitmap
}

suspend fun loadImageBitmap(url: String): ImageBitmap {
    return withContext(Dispatchers.IO) {
        try {
            val bitmap: Bitmap = Picasso.get().load(url).get()
            bitmap.asImageBitmap()
        } catch (e: Exception) {
            ImageBitmap(1, 1)
        }
    }
}