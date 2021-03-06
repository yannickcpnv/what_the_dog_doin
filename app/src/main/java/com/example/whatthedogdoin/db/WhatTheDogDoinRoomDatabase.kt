package com.example.whatthedogdoin.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.whatthedogdoin.db.dao.*
import com.example.whatthedogdoin.db.entities.*
import kotlinx.coroutines.CoroutineScope

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(Breed::class, Category::class, Client::class, ClientTakeService::class, Consultation::class, Disease::class, Dog::class, DogHaveDisease::class, DogHaveService::class, Locality::class, Service::class), version = 1, exportSchema = false)
@TypeConverters(TypeConverter::class)
abstract class WhatTheDogDoinRoomDatabase : RoomDatabase() {

    // DAOs
    abstract fun dogDao(): DogDao
    abstract fun diseaseDao(): DiseaseDao
    abstract fun clientDao(): ClientDao
    abstract fun breedDao(): BreedDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: WhatTheDogDoinRoomDatabase? = null

        fun getDatabase(context: Context): WhatTheDogDoinRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WhatTheDogDoinRoomDatabase::class.java,
                    "WhatTheDogDoinBase.db"
                )
                    .createFromAsset("database/WhatTheDogDoin.db")
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}