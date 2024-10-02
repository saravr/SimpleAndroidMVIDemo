package com.sandymist.simplemvidemo.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sandymist.simplemvidemo.viewmodel.MyScreenViewModel

@Composable
fun MyScreen(
    modifier: Modifier,
    myScreenViewModel: MyScreenViewModel
) {
    val state by myScreenViewModel.state.collectAsState()

    when {
        state.isLoading -> {
            Box(modifier = modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
        state.errorMessage != null -> {
            Box(modifier = modifier.fillMaxSize()) {
                Text(
                    text = state.errorMessage!!,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        else -> {
            LazyColumn(
                modifier = modifier.padding(top = 20.dp),
                contentPadding = PaddingValues(20.dp),
            ) {
                items(state.data) {
                    Text(text = it, style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(vertical = 10.dp))
                    HorizontalDivider()
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewMyScreen() {
    val viewModel = MyScreenViewModel()
    MyScreen(modifier = Modifier, myScreenViewModel = viewModel)
}