package com.example.solicytaskproject.domain.repo

import com.example.solicytaskproject.models.MessageData
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun removeMessage(messageData: MessageData)
    suspend fun updateMessage(messageData: MessageData)
    fun getMessages(): Flow<List<MessageData>>
}