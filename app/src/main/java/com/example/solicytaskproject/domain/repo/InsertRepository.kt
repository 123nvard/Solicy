package com.example.solicytaskproject.domain.repo

import com.example.solicytaskproject.models.MessageData

interface InsertRepository {
    suspend fun insertMessages(messageData: MessageData)
}