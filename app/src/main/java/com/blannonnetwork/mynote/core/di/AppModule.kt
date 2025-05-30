package com.blannonnetwork.mynote.core.di

import android.app.Application
import androidx.room.Room
import com.blannonnetwork.mynote.core.data.local.NoteDB
import com.blannonnetwork.mynote.core.data.repository.NoteRepositoryImpl
import com.blannonnetwork.mynote.core.domain.repository.NoteRepository
import com.blannonnetwork.mynote.note_list.domain.use_case.DeleteNote
import com.blannonnetwork.mynote.note_list.domain.use_case.GetAllNotes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDB(application: Application): NoteDB{
        return Room.databaseBuilder(
            application,
            NoteDB::class.java,
            "note_db.db"
        ).build()
    }

    @Provides
    @Singleton

    fun provideNoteRepository(
        noteDB: NoteDB
    ): NoteRepository {
        return NoteRepositoryImpl(noteDB)
    }

    @Provides
    @Singleton

    fun provideGetAllNotesUseCase(
        noteRepository: NoteRepository
    ): GetAllNotes {
        return GetAllNotes(noteRepository)
    }

    @Provides
    @Singleton

    fun provideDeleteNotesUseCase(
        noteRepository: NoteRepository
    ): DeleteNote {
        return DeleteNote(noteRepository)
    }

}