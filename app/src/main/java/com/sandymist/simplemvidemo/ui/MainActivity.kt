package com.sandymist.simplemvidemo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.sandymist.simplemvidemo.intent.MyScreenIntent
import com.sandymist.simplemvidemo.ui.theme.SimpleMVIDemoTheme
import com.sandymist.simplemvidemo.viewmodel.MyScreenViewModel
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    private val myScreenViewModel: MyScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleMVIDemoTheme {
                LaunchedEffect(Unit) {
                    myScreenViewModel.handleIntent(MyScreenIntent.ShowError("Oops, hold on!!!"))
                    delay(1000L)
                    myScreenViewModel.handleIntent(MyScreenIntent.LoadData)
                    delay(2000L)
                    val data = (1..10).map {
                        "Data item $it"
                    }
                    myScreenViewModel.handleIntent(MyScreenIntent.LoadDataSuccess(data))
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyScreen(
                        modifier = Modifier.padding(innerPadding),
                        myScreenViewModel = myScreenViewModel
                    )
                }
            }
        }
    }
}
