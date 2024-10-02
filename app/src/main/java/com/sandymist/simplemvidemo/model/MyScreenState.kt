package com.sandymist.simplemvidemo.model

data class MyScreenState(
    val isLoading: Boolean = false,
    val data: List<String> = emptyList(),
    val errorMessage: String? = null
)
