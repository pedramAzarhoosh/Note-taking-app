package com.example.notetakingapp.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "notes")
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true)
    public val id:Int,  //you can change the name of column with @ColumnInfo
    public val noteTitle:String,
    public val noteBody:String
):Parcelable
