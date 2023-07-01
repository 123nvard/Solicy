package com.example.solicytaskproject.di

import com.example.solicytaskproject.ui.home.HomeViewModel
import com.example.solicytaskproject.ui.login.LoginViewModel
import com.example.solicytaskproject.ui.sendEmail.SendEmailViewModel
//import com.example.solicytaskproject.ui.sendEmail.SendEmailViewModel
import com.example.solicytaskproject.viewModels.MessageViewModel
import com.example.solicytaskproject.viewModels.RemoveViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SendEmailViewModel(get()) }
    viewModel { MessageViewModel(get(), get(), get()) }
    viewModel { RemoveViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { HomeViewModel() }
//    viewModel { SendEmailViewModel(get())}
}