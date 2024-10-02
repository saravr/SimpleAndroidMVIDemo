package com.sandymist.simplemvidemo.intent

sealed class MyScreenIntent {
    data object LoadData : MyScreenIntent()
    data class LoadDataSuccess(val data: List<String>) : MyScreenIntent()
    data class ShowError(val message: String) : MyScreenIntent()
    // Add more intents as needed
}
