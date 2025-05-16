package com.blannonnetwork.mynote.notes_app_test.core.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.blannonnetwork.mynote.core.data.local.NoteDB
import com.blannonnetwork.mynote.core.data.local.NoteDao
import com.blannonnetwork.mynote.core.di.AppModule
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject


@HiltAndroidApp
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
}