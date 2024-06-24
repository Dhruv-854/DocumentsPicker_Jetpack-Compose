package com.dhruv.variousdocumentspicker

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun DocumentsPickerScreen(modifier: Modifier = Modifier) {

    val selectPdf = remember {
        mutableStateOf<Uri?>(null)
    }
    val launcherPdf = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) {
        selectPdf.value = it
    }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Button(onClick = {
            //select documents like pdf

            launcherPdf.launch(arrayOf("application/pdf"))

        }) {
            Text(text = "Select Documents")
        }
        selectPdf.value?.let {
            Text(text = it.toString())
        }
    }
}