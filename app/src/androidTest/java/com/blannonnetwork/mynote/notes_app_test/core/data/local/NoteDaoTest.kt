package com.blannonnetwork.mynote.notes_app_test.core.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.blannonnetwork.mynote.core.data.local.NoteDB
import com.blannonnetwork.mynote.core.data.local.NoteDao
import com.blannonnetwork.mynote.core.data.local.NoteEntity
import com.blannonnetwork.mynote.core.di.AppModule
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject


@HiltAndroidTest
@SmallTest
@UninstallModules(AppModule::class)
class NoteDaoTest {

    @get:Rule

    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var noteDB: NoteDB
    private lateinit var dao: NoteDao

    @Before
    fun setUp(){
        hiltRule.inject()
        dao = noteDB.noteDao
    }

    @After
    fun tearDown(){
        noteDB.close()
    }

    @Test
    fun getAllNotesFromEmptyDb_noteListIsEmpty() = runTest {
        assertThat(
            dao.getAllNoteEntities().isEmpty()
        )
    }

    @Test
    fun getAllNotesFromDb_noteListIsNotEmpty() = runTest {
        for (i in 1..4){
            val noteEntity = NoteEntity(
                id = i,
                title = "title$i",
                description = "content$i",
                imageUrl = "image $i",
                dateAdded = System.currentTimeMillis()
            )
            dao.upsertNoteEntity(noteEntity)
        }
        assertThat(
            dao.getAllNoteEntities().isEmpty()
        )
    }

    @Test
    fun upsertNote_noteIsUpsert() = runTest {
            val noteEntity = NoteEntity(
                id = 1,
                title = "title",
                description = "content",
                imageUrl = "image",
                dateAdded = System.currentTimeMillis()
            )
            dao.upsertNoteEntity(noteEntity)

        assertThat(
            dao.getAllNoteEntities().contains(noteEntity)
        )
    }

    @Test
    fun deleteNote_noteIsDeleted() = runTest {
        val noteEntity = NoteEntity(
            id = 1,
            title = "title",
            description = "content",
            imageUrl = "image",
            dateAdded = System.currentTimeMillis()
        )
        dao.upsertNoteEntity(noteEntity)

        assertThat(
            dao.getAllNoteEntities().contains(noteEntity)
        ).isTrue()

        dao.deleteNoteEntity(noteEntity)

        assertThat(
            dao.getAllNoteEntities().contains(noteEntity)
        ).isFalse()

    }
}