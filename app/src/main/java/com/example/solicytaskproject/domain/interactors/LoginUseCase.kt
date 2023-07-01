package com.example.solicytaskproject.domain.interactors

import com.example.solicytaskproject.models.User
import kotlinx.coroutines.flow.Flow

interface LoginUseCase {
    suspend fun login(email: String, password: String): Flow<User>
}