package com.example.solicytaskproject.data.repo

import com.example.solicytaskproject.domain.repo.LoginRepository
import com.example.solicytaskproject.models.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginRepositoryImpl : LoginRepository {
    override suspend fun login(email: String, password: String): Flow<User> {
        return flow {
            emit(
                User(
                    "Christian Bale",
                    "Christian@gmail.com",
                    "Christian2023",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Christian_Bale-7837.jpg/440px-Christian_Bale-7837.jpg"
                )
            )
        }
    }
}