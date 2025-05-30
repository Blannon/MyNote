package com.blannonnetwork.mynote.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [NoteEntity::class],
    version = 1
)

abstract class NoteDB: RoomDatabase(){
    abstract val noteDao: NoteDao
}