package com.sa.noteapp.controller;

import com.sa.noteapp.model.Note;
import com.sa.noteapp.repo.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/notes")
@CrossOrigin(origins = "*")
@RestController
public class NoteController {

    @Autowired
    private NoteRepo noteRepo;

    @PostMapping
    public Note addNote(@NonNull @RequestBody Note note) {
       return noteRepo.save(note);
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }

    @GetMapping(path="{id}")
    public Note getNoteById(@PathVariable("id") Long id) {
        return noteRepo.findById(id).get();
    }

    @PutMapping(path="{id}")
    public void updateNote(@PathVariable("id") Long id, @NonNull @RequestBody Note note) throws NotFoundException {
        if (note.getNoteId() == null) {
            throw new BadRequestException("Note ID must not be null.");
        }
        Optional<Note> optionalNote = noteRepo.findById(note.getNoteId());
        if (optionalNote.isEmpty()) {
            throw new NotFoundException("Note with ID " + note.getNoteId() + " does not exist.");
        }

        Note existingNote = optionalNote.get();
        existingNote.setTitle(note.getTitle());
        existingNote.setBody(note.getBody());
        noteRepo.save(existingNote);
    }

    @DeleteMapping(path="{id}")
    public void deleteNoteByID(@PathVariable("id") Long id) throws NotFoundException {
        if (noteRepo.findById(id).isEmpty()) {
            throw new NotFoundException("Note with ID " + id + " does not exist.");
        }
        noteRepo.deleteById(id);
    }
}
