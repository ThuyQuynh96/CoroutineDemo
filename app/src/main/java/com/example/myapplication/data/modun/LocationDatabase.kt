package com.example.myapplication.data.modun

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Location::class)], version = 1)
abstract class LocationDatabase : RoomDatabase() {

    abstract fun locationDao(): LocationDao

    companion object {
        private const val databaseName = "location_database"

        @Volatile
        private var Instance: LocationDatabase? = null

        fun getDatabase(context: Context): LocationDatabase {
            // truyền contact -> nếu null thi khởi tạo nó, khác null thì trả về
            val tempInstance = Instance
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                return Room.databaseBuilder(
                    context.applicationContext,
                    LocationDatabase::class.java,
                    databaseName
                ).build().apply {
                    Instance = this
                }
            }
        }
    }
}