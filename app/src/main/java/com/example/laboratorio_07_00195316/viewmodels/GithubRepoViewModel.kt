package com.example.laboratorio_07_00195316.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.laboratorio_07_00195316.database.RoomDB
import com.example.laboratorio_07_00195316.database.entities.GithubRepo
import com.example.laboratorio_07_00195316.database.repositories.GithubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(app: Application): AndroidViewModel(app) {

    private val repository: GithubRepoRepository

    init {

        val repoDAO = RoomDB.getInstance(app).repoDAO()

        repository = GithubRepoRepository(repoDAO)

    }

    fun getRepoList(): LiveData<List<GithubRepo>> = repository.getAll()

    fun insert(repo: GithubRepo) = viewModelScope.launch (Dispatchers.IO){
        repository.insert(repo)
    }
}