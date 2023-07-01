package com.example.solicytaskproject.domain.useCases

import com.example.solicytaskproject.domain.interactors.UpdateUseCase
import com.example.solicytaskproject.domain.repo.Repository
import com.example.solicytaskproject.models.MessageData

class UpdateUseCaseImpl(val updateRepository: Repository) : UpdateUseCase {
    override suspend fun updateMessage(messageData: MessageData) {
        updateRepository.updateMessage(messageData)
    }

}