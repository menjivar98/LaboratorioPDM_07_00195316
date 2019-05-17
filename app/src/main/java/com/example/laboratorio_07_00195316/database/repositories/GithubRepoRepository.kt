package com.example.laboratorio_07_00195316.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.laboratorio_07_00195316.database.dao.GithubRepoDAO
import com.example.laboratorio_07_00195316.database.entities.GithubRepo

class GithubRepoRepository(private val repoDAO: GithubRepoDAO) {


    // Obtener todos
    fun getAll():LiveData<List<GithubRepo>> = repoDAO.getAllRepos()

    //Borrar
    fun nuke() = repoDAO.nukeTable()


    //Insertar
    @WorkerThread
    suspend fun insert(repo: GithubRepo) = repoDAO.insert(repo)

}