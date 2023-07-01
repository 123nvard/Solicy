package com.example.solicytaskproject.data.repo

import com.example.solicytaskproject.domain.repo.SendEmailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SendEmailRepositoryImpl: SendEmailRepository {
    override suspend fun sendEmail(
        from: String,
        to: String,
        title: String,
        message: String
    ): Flow<Boolean> {
        return flow {
            emit(true)
        }
    }
}