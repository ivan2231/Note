package com.example.note.room

import androidx.lifecycle.LiveData

class NoteRepository(private val noteEntityDao: NoteEntityDao) {

    private val notes = noteEntityDao.getAll()

    fun getAll(): LiveData<List<NoteEntity>> {
        return notes
    }

    suspend fun insert (note: NoteEntity){
        noteEntityDao.insert(note)
    }

    fun getByID(id: Int): NoteEntity?{
        return notes.value?.firstOrNull{
            it.id == id
        }
    }
}