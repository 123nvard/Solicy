package com.example.solicytaskproject.domain.interactors

import com.example.solicytaskproject.models.MessageData

interface UpdateUseCase {
    suspend fun updateMessage(messageData: MessageData)
}