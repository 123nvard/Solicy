package com.example.solicytaskproject.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solicytaskproject.domain.interactors.LoginUseCase
import com.example.solicytaskproject.models.User
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LoginViewModel(val loginUseCase: LoginUseCase) : ViewModel() {
    val successLiveData = MutableLiveData<User>()
    val errorLiveData = MutableLiveData<String>()

    fun login(email: String, password: String){
        viewModelScope.launch {
            loginUseCase.login(email, password).collect {
                successLiveData.value = it
            }
        }
    }
}