package com.blannonnetwork.mynote.note_list.domain.use_case

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.blannonnetwork.mynote.core.data.repository.FakeNoteRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test



class GetAllNotesTest{

 @get:Rule
 var instantTaskExecutorRule = InstantTaskExecutorRule()

private lateinit var getAllNotes: GetAllNotes
private lateinit var fakeNoteRepository: FakeNoteRepository

@Before
fun setUp(){
    fakeNoteRepository = FakeNoteRepository()
    getAllNotes = GetAllNotes(fakeNoteRepository)

   fakeNoteRepository.shouldHaveFilledList(true)

}
 @Test
 fun `get notes, returns 4 notes` ()= runTest {
  val notes = getAllNotes.invoke(true)

  assert(notes.size == 4)
 }





 @Test
 fun `get notes sorted by tittle, sorted by tittle` ()= runTest {
  val notes = getAllNotes.invoke(true)

  for (i in 0 .. notes.size - 2) {
   assert(notes[i].title <= notes[i+1].title)
  }

 }

 @Test
 fun `get notes sorted by date added, sorted by date added` ()= runTest {
  val notes = getAllNotes.invoke(false)

  for (i in 0 .. notes.size - 2) {
   assert(notes[i].dateAdded <= notes[i+1].dateAdded)
  }

 }

}