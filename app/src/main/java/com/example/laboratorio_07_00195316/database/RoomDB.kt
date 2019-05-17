package com.example.laboratorio_07_00195316.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.laboratorio_07_00195316.database.dao.GithubRepoDAO
import com.example.laboratorio_07_00195316.database.entities.GithubRepo

@Database(entities = [GithubRepo::class], version = 1,exportSchema = false)
public abstract class RoomDB : RoomDatabase() {

    abstract fun repoDAO(): GithubRepoDAO

    companion object {

        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getInstance(AppContext: Context): RoomDB{
            val temp= INSTANCE

            if (temp != null){
                return temp
            }

            synchronized(this){
                val instance = Room
                    .databaseBuilder(AppContext, RoomDB::class.java, " RepoDB")
                    .build()

                INSTANCE = instance
                return instance


            }

        }
    }

}