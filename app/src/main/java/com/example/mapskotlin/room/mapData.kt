package com.example.mapskotlin.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Maps::class], version = 1)
abstract class mapData : RoomDatabase() {
    abstract fun mapD(): mapDao
}