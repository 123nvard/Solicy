package com.example.solicytaskproject.di

import com.example.solicytaskproject.data.MessageDatabase
import org.koin.dsl.module

val messageModule = module {
    single {
        MessageDatabase.getDatabase(get()).messageDao()
    }
}