package com.project.core.base.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.core.base.architecture.IntentVM
import com.project.core.base.architecture.SideEffect
import com.project.core.base.architecture.UiState
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<Intent : IntentVM, State : UiState, Effect : SideEffect>(initState: State) :
    ViewModel() {

    private val mutableUiState: MutableStateFlow<State> = MutableStateFlow(initState)
    val uiState = mutableUiState.asStateFlow()
    protected val currentState: State
        get() = uiState.value

    private val mutableIntent: MutableSharedFlow<Intent> = MutableSharedFlow()

    private val mutableEffect: MutableSharedFlow<Effect> =
        MutableSharedFlow(extraBufferCapacity = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val sideEffects = mutableEffect.asSharedFlow()

    init {
        subscribeEvents()
    }

    private fun subscribeEvents() {
        viewModelScope.launch {
            mutableIntent.collect(::handleIntent)
        }
    }

    abstract fun handleIntent(intent: Intent)

    fun sendIntent(intent: Intent) {
        viewModelScope.launch {
            mutableIntent.emit(intent)
        }
    }

    protected fun setEffect(effectValue: Effect) {
        viewModelScope.launch {
            mutableEffect.emit(effectValue)
        }
    }

    protected fun updateUiState(uiState: State) {
        mutableUiState.value = uiState
    }
}