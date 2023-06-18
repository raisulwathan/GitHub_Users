package com.example.submissionawal

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.submissionawal.data.local.FavUser
import com.example.submissionawal.data.local.FavUserDao
import com.example.submissionawal.data.local.UserDatabase

class FavoriteViewModel(application: Application) : AndroidViewModel(application) {

    private var userDao: FavUserDao?
    private var userDb: UserDatabase?

    init {
        userDb = UserDatabase.getDatabase(application)
        userDao = userDb?.favoriteUserDao()
    }

    fun getFavorite(): LiveData<List<FavUser>>? {
        return userDao?.getFavorite()
    }
}