package com.example.solicytaskproject.di

import com.example.solicytaskproject.data.RepositoryImpl
import com.example.solicytaskproject.data.repo.InsertRepositoryImpl
import com.example.solicytaskproject.data.repo.LoginRepositoryImpl
import com.example.solicytaskproject.data.repo.RemoveRepositoryImpl
import com.example.solicytaskproject.data.repo.SendEmailRepositoryImpl
import com.example.solicytaskproject.domain.repo.InsertRepository
import com.example.solicytaskproject.domain.repo.LoginRepository
import com.example.solicytaskproject.domain.repo.RemoveRepository
import com.example.solicytaskproject.domain.repo.Repository
import com.example.solicytaskproject.domain.repo.SendEmailRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<InsertRepository> { InsertRepositoryImpl(get()) }
    factory<RemoveRepository> { RemoveRepositoryImpl(get()) }
    factory<Repository> { RepositoryImpl(get()) }
    factory<LoginRepository> { LoginRepositoryImpl() }
    factory<SendEmailRepository> { SendEmailRepositoryImpl() }
}