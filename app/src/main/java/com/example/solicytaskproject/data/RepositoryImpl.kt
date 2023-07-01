package com.example.solicytaskproject.data


import com.example.solicytaskproject.domain.repo.Repository
import com.example.solicytaskproject.models.MessageData
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(private val messageDao: MessageDao) : Repository {

    override suspend fun removeMessage(messageData: MessageData) {
        messageDao.deleteMessage(messageData)
    }

    override suspend fun updateMessage(messageData: MessageData) {
        messageDao.updateMessage(messageData)
    }


    override fun getMessages(): Flow<List<MessageData>> {
        return messageDao.getMessages()
    }
}