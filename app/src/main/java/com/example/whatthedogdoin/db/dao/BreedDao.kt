package com.example.whatthedogdoin.db.dao

import androidx.room.*
import com.example.whatthedogdoin.db.entities.Breed;
import com.example.whatthedogdoin.db.entities.relations.ClientWithLocalityAndDogWithBreedAndDiseases
import kotlinx.coroutines.flow.Flow

@Dao
interface BreedDao {
    @Query("SELECT * FROM breeds")
    fun getBreeds(): Flow<List<Breed>>

    @Query("SELECT * FROM breeds WHERE id = :id")
    suspend fun find(id: Int): Breed

    @Query("SELECT * FROM breeds WHERE id = :id")
    suspend fun getBreed(id: Int): Breed

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(breed: Breed)

    @Update
    suspend fun updateBreeds(vararg breeds: Breed)

    @Delete
    suspend fun deleteBreeds(vararg breeds: Breed)
}