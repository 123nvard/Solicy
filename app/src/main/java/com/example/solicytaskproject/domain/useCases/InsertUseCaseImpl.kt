package com.example.solicytaskproject.domain.useCases

import com.example.solicytaskproject.domain.interactors.InsertUseCase
import com.example.solicytaskproject.domain.repo.InsertRepository
import com.example.solicytaskproject.models.MessageData

class InsertUseCaseImpl(val insertRepository: InsertRepository) : InsertUseCase {
    override suspend fun insertMessages(messageData: MessageData) {
insertRepository.insertMessages(messageData)
    }
}