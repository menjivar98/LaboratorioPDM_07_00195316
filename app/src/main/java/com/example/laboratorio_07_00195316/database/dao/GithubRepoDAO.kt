package com.example.laboratorio_07_00195316.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.laboratorio_07_00195316.database.entities.GithubRepo

@Dao
interface GithubRepoDAO {

    @Query("SELECT * FROM repos")
    fun getAllRepos():LiveData<List<GithubRepo>>


    @Query("DELETE FROM repos")
    fun nukeTable()


    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun insert(repo:GithubRepo)


}