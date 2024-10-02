package com.sandymist.simplemvidemo.reducer

import com.sandymist.simplemvidemo.intent.MyScreenIntent
import com.sandymist.simplemvidemo.model.MyScreenState

fun myReducer(state: MyScreenState, intent: MyScreenIntent): MyScreenState {
    return when(intent) {
        is MyScreenIntent.LoadData -> {
            state.copy(isLoading = true, errorMessage = null)
        }

        is MyScreenIntent.LoadDataSuccess -> {
            state.copy(isLoading = false, data = intent.data, errorMessage = null)
        }

        is MyScreenIntent.ShowError -> {
            state.copy(errorMessage = intent.message)
        }
    }
}
