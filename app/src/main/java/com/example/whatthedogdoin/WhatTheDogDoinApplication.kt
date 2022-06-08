package com.example.whatthedogdoin

import android.app.Application
import com.example.whatthedogdoin.db.WhatTheDogDoinRoomDatabase
import com.example.whatthedogdoin.repositories.CategoryRepository
import com.example.whatthedogdoin.repositories.DogRepository
import com.example.whatthedogdoin.repositories.ClientRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WhatTheDogDoinApplication: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { WhatTheDogDoinRoomDatabase.getDatabase(this, applicationScope) }
    val dogRepository by lazy { DogRepository(database.dogDao()) }
    val clientRepository by lazy { ClientRepository(database.clientDao()) }
    val categoryRepository by lazy { CategoryRepository(database.categoryDao()) }
}