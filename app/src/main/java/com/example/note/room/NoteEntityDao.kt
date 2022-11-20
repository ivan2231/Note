package com.example.note.room


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface NoteEntityDao {

    @Query("select * from NoteEntity")
    fun getAll(): LiveData<List<NoteEntity>>

    @Insert(onConflict = REPLACE)
    suspend fun insert(entity: NoteEntity)
}