package com.example.notetakingapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.notetakingapp.model.Note
import com.example.notetakingapp.repository.Repository
import kotlinx.coroutines.launch

class MyViewModel(app : Application, val repo:Repository) : AndroidViewModel(app) {

    fun addNote(note: Note){
        viewModelScope.launch {
            repo.insertNote(note)
        }
    }

    fun deleteNote(note:Note){
        viewModelScope.launch {
            repo.deleteNote(note)
        }
    }

    fun updateNote(note:Note){
        viewModelScope.launch {
            repo.updateNote(note)
        }
    }

    fun getAllNotes() = repo.getAllNotes()
    fun searchNote(query:String?) = repo.searchNote(query)
}