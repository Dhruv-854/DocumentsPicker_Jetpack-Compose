package com.dhruv.variousdocumentspicker

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun MultipleImagePickerScreen(modifier: Modifier = Modifier) {

    val mltImagePicker = remember {
        mutableStateOf<List<Uri>>(emptyList())
    }
    val launcherMlt =
        rememberLauncherForActivityResult(ActivityResultContracts.PickMultipleVisualMedia()) {
            mltImagePicker.value = it
        }

    Column {
        Button(onClick = {
            launcherMlt.launch(
                PickVisualMediaRequest(
                    ActivityResultContracts.PickVisualMedia.ImageOnly
                )
            )
        }) {
            Text(text = "Pick Multiple Image")
        }
        mltImagePicker.value.let { image ->
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            ) {
                items(image) {
                    val showImage = rememberAsyncImagePainter(
                        ImageRequest.Builder(
                            LocalContext.current
                        ).data(data = it).build()
                    )
                    Image(
                        painter = showImage,
                        contentDescription = null,
                        modifier = modifier.size(234.dp , 234.dp)
                    )
                }
            }

        }
    }


}