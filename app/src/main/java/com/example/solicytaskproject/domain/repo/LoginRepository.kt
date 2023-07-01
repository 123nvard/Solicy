package com.example.solicytaskproject.domain.repo

import com.example.solicytaskproject.models.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun login(email: String, password: String): Flow<User>
}