package com.blannonnetwork.mynote.note_list.domain.use_case

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.blannonnetwork.mynote.core.data.repository.FakeNoteRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DeleteNoteTest{
  @get:Rule
  var instantTaskExecutorRule = InstantTaskExecutorRule()

  private lateinit var deleteNote: DeleteNote
  private lateinit var fakeNoteRepository: FakeNoteRepository

  @Before
  fun setUp(){
   fakeNoteRepository = FakeNoteRepository()
   deleteNote = DeleteNote(fakeNoteRepository)

   fakeNoteRepository.shouldHaveFilledList(true)

  }

}
@Test
fun `delete note from list, note is deleted` (): Unit = runTest {
    val notes = getAllNotes.invoke(true)

    assert(notes.size == 4)
}
