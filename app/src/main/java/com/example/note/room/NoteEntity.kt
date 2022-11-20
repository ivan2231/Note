package com.example.note.room


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteEntity(
    var title: String,
    var body: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}