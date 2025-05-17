package com.blannonnetwork.mynote.core.domain.repository

import com.blannonnetwork.mynote.core.domain.model.NoteItem

interface NoteRepository {

    suspend fun upsertNote(noteItem: NoteItem)

    suspend fun deleteNote(noteItem: NoteItem)

    suspend fun getAllNotes(): List<NoteItem>
}