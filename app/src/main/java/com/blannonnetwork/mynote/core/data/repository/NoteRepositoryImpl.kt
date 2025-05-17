package com.blannonnetwork.mynote.core.data.repository

import com.blannonnetwork.mynote.core.data.local.NoteDB
import com.blannonnetwork.mynote.core.data.mapper.toNoteEntityForInsert
import com.blannonnetwork.mynote.core.data.mapper.toNoteItem
import com.blannonnetwork.mynote.core.domain.model.NoteItem
import com.blannonnetwork.mynote.core.domain.repository.NoteRepository

class NoteRepositoryImpl(
    noteDB: NoteDB
): NoteRepository{

    private val noteDao = noteDB.noteDao

    override suspend fun upsertNote(noteItem: NoteItem) {
        noteDao.upsertNoteEntity(noteItem.toNoteEntityForInsert())
    }

    override suspend fun deleteNote(noteItem: NoteItem) {
        noteDao.deleteNoteEntity(noteItem.toNoteEntityForInsert())
    }

    override suspend fun getAllNotes(): List<NoteItem> {
        return noteDao.getAllNoteEntities().map { it.toNoteItem() }
    }

}