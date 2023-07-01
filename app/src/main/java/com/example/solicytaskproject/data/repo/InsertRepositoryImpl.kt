package com.example.solicytaskproject.data.repo

import com.example.solicytaskproject.domain.repo.InsertRepository
import com.example.solicytaskproject.data.MessageDao
import com.example.solicytaskproject.models.MessageData

class InsertRepositoryImpl(private val messageDao: MessageDao) : InsertRepository {
    override suspend fun insertMessages(messageData: MessageData) {
        messageDao.insertMessage(messageData)
    }
}