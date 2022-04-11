package com.example.myapplication.data.modun

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface LocationDao {
    @Insert
    fun insert(location: Location)

    @Update
    fun update(location: Location)

    @Delete
    fun delete(vararg location: Location)

    @Query("SELECT * FROM locationTable ORDER BY date asc")
    fun getListLocation(): LiveData<List<Location>?>
}