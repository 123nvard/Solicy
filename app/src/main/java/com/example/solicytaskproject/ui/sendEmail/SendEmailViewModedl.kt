package com.example.solicytaskproject.ui.sendEmail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solicytaskproject.domain.interactors.SendEmailUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import com.example.solicytaskproject.domain.interactors.LoginUseCase
import com.example.solicytaskproject.models.User
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SendEmailViewModel(private val sendEmailUseCase: SendEmailUseCase) : ViewModel() {

    val successLiveData = MutableLiveData<Boolean>()

    fun sendEmail(from: String, to: String, title: String, message: String) {
        viewModelScope.launch {
            sendEmailUseCase.sendEmail(from, to, title, message).collectLatest {
                successLiveData.value = it
            }
        }
    }
}