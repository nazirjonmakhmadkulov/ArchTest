package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.owner.dao.OwnerDao
import com.example.database.owner.entities.OwnerEntity

@Database(
    entities = [OwnerEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun ownerDao(): OwnerDao
}