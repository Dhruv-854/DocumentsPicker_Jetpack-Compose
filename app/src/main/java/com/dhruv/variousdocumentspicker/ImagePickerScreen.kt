package com.dhruv.variousdocumentspicker

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun ImagePickerScreen(modifier: Modifier = Modifier) {


    val selectImage = remember {
        mutableStateOf<Uri?>(null)
    }

    val launcherImage =
        rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) {
            selectImage.value = it
        }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Button(onClick = {
            launcherImage.launch(
                PickVisualMediaRequest(
                    ActivityResultContracts.PickVisualMedia.ImageOnly
                )
            )
        }) {
            Text(text = "Pick Image")
        }
        selectImage.value?.let {
            val painter = rememberAsyncImagePainter(
                ImageRequest
                    .Builder(LocalContext.current)
                    .data(data = it)
                    .build()
            )
            Image(
                painter = painter, contentDescription = null,
                modifier = modifier.size(750.dp , 500.dp).padding(50.dp)
            )
        }
    }


}