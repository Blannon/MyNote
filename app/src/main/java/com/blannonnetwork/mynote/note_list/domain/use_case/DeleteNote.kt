package com.blannonnetwork.mynote.note_list.domain.use_case

import com.blannonnetwork.mynote.core.domain.repository.NoteRepository

class DeleteNote(
    private val noteRepository: NoteRepository
) {
}