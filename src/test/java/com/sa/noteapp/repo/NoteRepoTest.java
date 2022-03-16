package com.sa.noteapp.repo;

import com.sa.noteapp.model.Note;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class NoteRepoTest {
    @Autowired
    public NoteRepo noteRepo;
    public Note note;

    @BeforeEach
    public void addNote() {
        note = new Note("TitleHere", "BodyHere");
    }

    @AfterEach
    public void tearDown() {
        noteRepo.deleteAll();
        note = null;
    }

    @Test
    public void GivenGetAllNoteShouldReturnListOfAllNotes(){
        Note note1 = new Note("title1", "body1");
        Note note2 = new Note("title2", "body2");
        noteRepo.save(note1);
        noteRepo.save(note2);
        List<Note> noteList = (List<Note>) noteRepo.findAll();
        assertEquals("title2", noteList.get(1).getTitle());
    }

    @Test
    public void givenIdThenShouldReturnNoteOfThatId() {
        Note note1 = new Note("Titleblabla", "Bodyblablalb");
        Note note2 = noteRepo.save(note1);
        Optional<Note> optional = noteRepo.findById(note2.getNoteId());
        assertEquals(note2.getNoteId(), optional.get().getNoteId());
        assertEquals(note2.getTitle(), optional.get().getTitle());
    }

    @Test
    public void givenIdTODeleteThenShouldDeleteTheNote() {
        Note note = new Note("Note123Title", "Note123Body");
        noteRepo.save(note);
        noteRepo.deleteById(note.getNoteId());
        Optional optional = noteRepo.findById(note.getNoteId());
        assertEquals(Optional.empty(), optional);
    }
}
