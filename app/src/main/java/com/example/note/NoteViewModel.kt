package com.example.note

import android.app.Application
import androidx.lifecycle.*
import com.example.note.room.DbConnection
import com.example.note.room.NoteEntity
import com.example.note.room.NoteRepository
import kotlinx.coroutines.launch

class PageViewModel(application: Application) : AndroidViewModel(application) {


    var repository: NoteRepository

    init {
        val noteEntityDao = DbConnection.getDatabase(application.applicationContext).entityDao()
        repository = NoteRepository(noteEntityDao)
    }

    var note = repository.getAll()

    fun insert(noteEntity: NoteEntity) {
        viewModelScope.launch {
            repository.insert(noteEntity)
        }

    }
}