package com.example.solicytaskproject.domain.interactors

//import com.example.solicytaskproject.models.MessageData
import com.example.solicytaskproject.models.MessageData
import kotlinx.coroutines.flow.Flow

interface GetMessagesUseCase {
    fun getMessages(): Flow<List<MessageData>>

}