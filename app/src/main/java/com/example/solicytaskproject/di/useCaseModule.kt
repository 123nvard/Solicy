package com.example.solicytaskproject.di

import com.example.solicytaskproject.domain.interactors.GetMessagesUseCase
import com.example.solicytaskproject.domain.interactors.InsertUseCase
import com.example.solicytaskproject.domain.interactors.LoginUseCase
import com.example.solicytaskproject.domain.interactors.RemoveUseCase
import com.example.solicytaskproject.domain.interactors.SendEmailUseCase
import com.example.solicytaskproject.domain.interactors.UpdateUseCase
import com.example.solicytaskproject.domain.useCases.GetMessagesUseCaseImpl
import com.example.solicytaskproject.domain.useCases.InsertUseCaseImpl
import com.example.solicytaskproject.domain.useCases.LoginUseCaseImpl
import com.example.solicytaskproject.domain.useCases.RemoveUseCaseImpl
import com.example.solicytaskproject.domain.useCases.SendEmailUseCaseImpl
import com.example.solicytaskproject.domain.useCases.UpdateUseCaseImpl
import org.koin.dsl.module

val useCaseModule= module {

    factory<GetMessagesUseCase> {
       GetMessagesUseCaseImpl(
            get()
        )
    }
    factory<InsertUseCase> {
        InsertUseCaseImpl(
            get()
        )
    }
    factory<RemoveUseCase> {
       RemoveUseCaseImpl(
            get()
        )
    }
    factory<UpdateUseCase> {
       UpdateUseCaseImpl(
            get()
        )
    }
    factory<LoginUseCase> {
        LoginUseCaseImpl(
            get()
        )
    }
    factory<SendEmailUseCase> {
        SendEmailUseCaseImpl(
            get()
        )
    }
}