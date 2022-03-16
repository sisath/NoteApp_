package com.sa.noteapp.repo;

import com.sa.noteapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {
}

