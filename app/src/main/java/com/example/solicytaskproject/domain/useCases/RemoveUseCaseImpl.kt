package com.example.solicytaskproject.domain.useCases

import com.example.solicytaskproject.domain.interactors.RemoveUseCase
import com.example.solicytaskproject.domain.repo.RemoveRepository
import com.example.solicytaskproject.models.MessageData

class RemoveUseCaseImpl(val repository: RemoveRepository) : RemoveUseCase {
    override suspend fun removeMessage(messageData: MessageData) {
        return repository.removeMessage(messageData)
    }
}