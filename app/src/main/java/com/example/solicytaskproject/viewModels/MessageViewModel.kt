package com.example.solicytaskproject.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solicytaskproject.domain.interactors.GetMessagesUseCase
import com.example.solicytaskproject.domain.interactors.InsertUseCase
import com.example.solicytaskproject.domain.interactors.UpdateUseCase
import com.example.solicytaskproject.models.MessageData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MessageViewModel(
    private var getMessagesUseCase: GetMessagesUseCase,
    private var updateUseCase: UpdateUseCase,
    private var insertUseCase: InsertUseCase
) : ViewModel() {

    private var _listOfMessages: MutableStateFlow<List<MessageData>> = MutableStateFlow(listOf())
    var listOfMessages = _listOfMessages.asSharedFlow()
    private var listOfInsertMessages = listOf<MessageData>(
        MessageData(
            0,
            "ddd",
            "dddd",
            "11:45pm",
            "ddd",
            "dddddd",
            false,
            false,
            "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Christian_Bale-7837.jpg/440px-Christian_Bale-7837.jpg"
        )
    )

    init {
        getMessages()
        if (_listOfMessages.value.toMutableList().isEmpty()) {
            insertTodo(listOfInsertMessages)
            getMessages()
        }

    }

    fun insertTodo(messageData: List<MessageData>) {
        viewModelScope.launch {
            messageData.forEach {
                insertUseCase.insertMessages(it)
            }
        }
    }

    fun getMessages(): Flow<List<MessageData>> {
        viewModelScope.launch {
            getMessagesUseCase.getMessages().collectLatest {
                _listOfMessages.value = it
            }
        }
        return listOfMessages
    }


    fun updateMessage(messageData: MessageData) {
        viewModelScope.launch {
            updateUseCase.updateMessage(messageData)
        }

    }


}
