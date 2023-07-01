package com.example.solicytaskproject.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solicytaskproject.domain.interactors.RemoveUseCase
import com.example.solicytaskproject.models.MessageData
import kotlinx.coroutines.launch

class RemoveViewModel(
    private var removeUseCase: RemoveUseCase
) : ViewModel() {

    fun removeMessage(messageData: MessageData) {
        viewModelScope.launch {
            removeUseCase.removeMessage(messageData)

        }
    }

}
