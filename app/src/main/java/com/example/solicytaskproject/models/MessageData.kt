package com.example.solicytaskproject.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "message_table")
data class MessageData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "senderName")
    val senderName: String,
    @ColumnInfo(name = "senderEmail")
    val senderEmail: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "subjectOfMessage")
    val subjectOfMessage: String,
    @ColumnInfo(name = "message")
    val message: String,
    @ColumnInfo(name = "isRead")
    val isRead: Boolean,
    @ColumnInfo(name = "isFavorite")
    val isFavorite: Boolean,
    @ColumnInfo(name = "userImage")
    val userImage: String
) : Parcelable