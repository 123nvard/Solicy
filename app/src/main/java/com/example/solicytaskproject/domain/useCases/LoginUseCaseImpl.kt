package com.example.solicytaskproject.domain.useCases

import com.example.solicytaskproject.domain.interactors.LoginUseCase
import com.example.solicytaskproject.domain.repo.LoginRepository
import com.example.solicytaskproject.models.User
import kotlinx.coroutines.flow.Flow

class LoginUseCaseImpl(val loginRepository: LoginRepository) : LoginUseCase {
    override suspend fun login(email: String, password: String): Flow<User> {
        return loginRepository.login(email, password)
    }
}