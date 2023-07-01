package com.example.solicytaskproject.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.solicytaskproject.models.MessageData

@Database(entities = arrayOf(MessageData::class), version = 1, exportSchema = false)
abstract class MessageDatabase : RoomDatabase() {

    abstract fun messageDao(): MessageDao

    companion object {
        @Volatile
        private var INSTANCE: MessageDatabase? = null
        fun getDatabase(context: Context): MessageDatabase {
            return INSTANCE ?: synchronized(this) {
                return Room.databaseBuilder(context, MessageDatabase::class.java, "message_database")
                    .build()
            }
        }

    }
}