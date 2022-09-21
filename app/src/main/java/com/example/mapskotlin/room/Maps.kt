package com.example.mapskotlin.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Maps(
    @ColumnInfo(name = "latitude") val latitude: Double,
    @ColumnInfo(name = "longtude") val longtude: Double,
    @ColumnInfo(name = "title") val title: String
)
{
    @PrimaryKey(autoGenerate = true)
    var id = 0
}