package com.example.solicytaskproject.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.solicytaskproject.models.MessageData
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao {

    @Query("SELECT * FROM message_table")
    fun getMessages(): Flow<List<MessageData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMessage(messageData: MessageData)
    @Delete
    suspend fun deleteMessage(messageData: MessageData)
    @Update
    suspend fun updateMessage(messageData: MessageData)
}