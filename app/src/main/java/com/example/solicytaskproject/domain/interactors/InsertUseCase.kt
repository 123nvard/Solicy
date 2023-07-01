package com.example.solicytaskproject.domain.interactors

import com.example.solicytaskproject.models.MessageData


interface InsertUseCase {
    suspend fun insertMessages(messageData: MessageData)
}