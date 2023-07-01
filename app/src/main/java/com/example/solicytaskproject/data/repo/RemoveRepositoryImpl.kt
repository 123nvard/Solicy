package com.example.solicytaskproject.data.repo

import com.example.solicytaskproject.domain.repo.RemoveRepository
import com.example.solicytaskproject.data.MessageDao
import com.example.solicytaskproject.models.MessageData

class RemoveRepositoryImpl(private val messageDao: MessageDao) : RemoveRepository {
    override suspend fun removeMessage(messageData: MessageData) {
     messageDao.deleteMessage(messageData)
    }

}