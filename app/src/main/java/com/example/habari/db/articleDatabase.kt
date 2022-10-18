package com.example.habari.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.habari.Article
import com.example.habari.MainActivity

@Database
    (entities = [Article::class],
version =1
)
     abstract class articleDatabase:RoomDatabase() {
    //function that returns an articleDao
    abstract fun getDao(): articlesDao


    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: articleDatabase? = null

        fun getDatabase(context: MainActivity): articleDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    articleDatabase::class.java,
                    "ArticlesDatabase"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}




