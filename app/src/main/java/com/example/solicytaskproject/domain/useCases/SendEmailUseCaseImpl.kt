package com.example.solicytaskproject.domain.useCases

import com.example.solicytaskproject.domain.interactors.SendEmailUseCase
import com.example.solicytaskproject.domain.repo.SendEmailRepository
import kotlinx.coroutines.flow.Flow

class SendEmailUseCaseImpl(val sendEmailRepository: SendEmailRepository) : SendEmailUseCase {
    override suspend fun sendEmail(
        from: String,
        to: String,
        title: String,
        message: String
    ): Flow<Boolean> {
        return sendEmailRepository.sendEmail(from, to, title, message)
    }
}