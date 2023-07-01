package com.example.solicytaskproject.domain.useCases

import com.example.solicytaskproject.domain.interactors.GetMessagesUseCase
import com.example.solicytaskproject.domain.repo.Repository
import com.example.solicytaskproject.models.MessageData
import kotlinx.coroutines.flow.Flow

class GetMessagesUseCaseImpl(val repository: Repository) : GetMessagesUseCase {

    override fun getMessages(): Flow<List<MessageData>> {
        return repository.getMessages()
    }

}