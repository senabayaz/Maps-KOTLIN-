package com.example.mapskotlin.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface mapDao {
    @Query("SELECT * FROM user")
    fun getAll(): Flowable<List<Maps>>

    @Insert
    fun insertAll(vararg maps: Maps) : Completable

    @Delete
    fun delete(maps: Maps) : Completable
}