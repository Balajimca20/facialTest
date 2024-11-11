package com.example.facialtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.facialtest.UiScreen.CameraX
import com.example.facialtest.permission.getCameraPermission
import com.example.facialtest.permission.getStoragePermission
import com.example.facialtest.viewModel.CameraViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cameraPermission = getCameraPermission(this)
        val storagePermission = getStoragePermission(this)
        val viewModel = ViewModelProvider(this).get(CameraViewModel::class.java)
        enableEdgeToEdge()
        setContent {
            Scaffold(
                content = {
                    Column(modifier = Modifier.padding(it)) {
                        CameraX(cameraPermission = cameraPermission, storagePermission = storagePermission, viewModel = viewModel,)
                    }

                }
            )
            //MainScreens(onTakePhotoClick = {})
        }
    }
}