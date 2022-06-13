package com.example.whatthedogdoin.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dogs_have_diseases")
data class DogHaveDisease (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo val id: Int,
    @ColumnInfo(name = "id_dog") val idDog: Int,
    @ColumnInfo(name = "id_disease") val idDisease: Int,
)