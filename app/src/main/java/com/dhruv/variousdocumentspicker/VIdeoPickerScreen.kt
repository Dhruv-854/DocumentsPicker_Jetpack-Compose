package com.dhruv.variousdocumentspicker

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun VideoPickerScreen(modifier: Modifier = Modifier) {
    
    
    val videoPicker = remember {
        mutableStateOf<Uri?>(null)
    }
    val launcherVideo = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) {
        videoPicker.value = it
    }
    Column(
    ) {
        Button(onClick = {
            launcherVideo.launch(
                PickVisualMediaRequest(
                    ActivityResultContracts.PickVisualMedia.VideoOnly
                )
            )
        }) {
            Text(text = "Video Pick")
        }
        videoPicker.value?.let{
            Text(text = it.path.toString())
        }
    }
    
}






























