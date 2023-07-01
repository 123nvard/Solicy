package com.example.solicytaskproject.domain.interactors

import kotlinx.coroutines.flow.Flow

interface SendEmailUseCase {
    suspend fun sendEmail(from: String, to: String, title: String, message: String): Flow<Boolean>
}