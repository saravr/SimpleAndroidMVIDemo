package com.sandymist.simplemvidemo.viewmodel

import androidx.lifecycle.ViewModel
import com.sandymist.simplemvidemo.intent.MyScreenIntent
import com.sandymist.simplemvidemo.model.MyScreenState
import com.sandymist.simplemvidemo.reducer.myReducer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MyScreenViewModel : ViewModel() {
    private val _state = MutableStateFlow(MyScreenState())
    val state: StateFlow<MyScreenState> get() = _state

    fun handleIntent(intent: MyScreenIntent) {
        _state.value = myReducer(state.value, intent)
    }
}
