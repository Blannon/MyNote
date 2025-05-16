package com.blannonnetwork.mynote.core.di

import android.app.Application
import androidx.room.Room
import com.blannonnetwork.mynote.core.data.local.NoteDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Singleton
    fun provideNoteDB(application: Application): NoteDB{
        return Room.inMemoryDatabaseBuilder(
            application,
            NoteDB::class.java,
        ).build()
    }
}