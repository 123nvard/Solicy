package com.example.solicytaskproject.domain.repo

import com.example.solicytaskproject.models.MessageData


interface RemoveRepository {
    suspend fun removeMessage(messageData: MessageData)
}