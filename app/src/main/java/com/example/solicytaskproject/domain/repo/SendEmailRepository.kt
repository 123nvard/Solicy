package com.example.solicytaskproject.domain.repo

import kotlinx.coroutines.flow.Flow

interface SendEmailRepository {
    suspend fun sendEmail(from: String, to: String, title: String, message: String): Flow<Boolean>
}