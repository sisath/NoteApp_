package com.sa.noteapp.api;

import com.sa.noteapp.dao.NoteRepo;
import com.sa.noteapp.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.LongFunction;

@RequestMapping("api/v1/note")
@RestController
public class NoteController {

    @Autowired
    private NoteRepo noteRepo;

    @PostMapping
    public void addNote(@NonNull @RequestBody Note note) {
        Date now = new Date();
        note.setNoteCreatedDate(now);
        note.setNoteUpdatedDate(now);
        noteRepo.save(note);
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }

    @GetMapping(path="{id}")
    public Note getNoteById(@PathVariable("id") Long id) {
        return noteRepo.getById(id);
    }

    @PutMapping(path="{id}")
    public void updateNote(@PathVariable("id") Long id, @NonNull @RequestBody Note note) {
        Note existing = noteRepo.getById(id);
        existing.setNoteTitle(note.getNoteTitle());
        existing.setNoteBody(note.getNoteBody());
        existing.setNoteUpdatedDate(new Date());
        noteRepo.save(existing);
    }

    @DeleteMapping(path="{id}")
    public void deleteNoteByID(@PathVariable("id") Long id) {
        noteRepo.deleteById(id);
    }
}
