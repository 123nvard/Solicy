package com.example.solicytaskproject.domain.interactors

import com.example.solicytaskproject.models.MessageData


interface RemoveUseCase {
    suspend fun removeMessage(messageData: MessageData)

}