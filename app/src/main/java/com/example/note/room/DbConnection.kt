package com.example.note.room


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi

@Database(entities = [NoteEntity::class], version = 1)
abstract class DbConnection : RoomDatabase() {
    abstract fun entityDao(): NoteEntityDao
    companion object{
        private var INSTANCE: DbConnection? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): DbConnection{
            if (INSTANCE == null){
                kotlinx.coroutines.internal.synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context, DbConnection::class.java, "contact_database")
                            .build()
                }
            }
            return INSTANCE!!
        }
    }
}