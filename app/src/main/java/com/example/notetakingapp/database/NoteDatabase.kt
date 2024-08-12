package com.example.notetakingapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.notetakingapp.model.Note

@Database(entities = [Note::class], version = 2)
abstract class NoteDatabase :RoomDatabase() {

    abstract fun getNote():NoteDAO

    companion object{
        //to create just one instance of the database
        @Volatile //say the jvm that the line of under that changes should be visible for all other threads
        private var instance: NoteDatabase? = null
        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock){
            instance?: createDatabase(context).also{
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NoteDatabase::class.java,
                "note_db"
            )
                .fallbackToDestructiveMigration() // This will drop the database and recreate it on schema changes
                .build()

    }
}