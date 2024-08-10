package com.example.notetakingapp.repository

import com.example.notetakingapp.database.NoteDatabase
import com.example.notetakingapp.model.Note

class Repository(val db:NoteDatabase) {
    suspend fun insertNote(note:Note) = db.getNote().insertNote(note)
    suspend fun deleteNote(note: Note) = db.getNote().deleteNote(note)
    suspend fun updateNote(note: Note) = db.getNote().updateNote(note)

    fun getAllNotes() = db.getNote().getAllNotes()
    fun searchNote(query : String?) = db.getNote().searchNote(query)
}