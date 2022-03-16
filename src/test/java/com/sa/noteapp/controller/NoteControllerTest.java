package com.sa.noteapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa.noteapp.model.Note;
import com.sa.noteapp.repo.NoteRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.NestedServletException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NoteController.class)
class NoteControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    NoteRepo noteRepo;

    Note NOTE_1 = new Note("Title1", "Body1");
    Note NOTE_2 = new Note("Title2", "Body2");
    Note NOTE_3 = new Note("Title3", "Body3");

    @Test
    void addNote() throws Exception {

        Note note4 = new Note("Title4", "Body4");

        when(noteRepo.save(note4)).thenReturn(note4);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/v1/notes")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(note4));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.title", is("Title4")));
    }

    @Test
    void getAllNotes() throws Exception {
        List<Note> notes = new ArrayList<>(Arrays.asList(NOTE_1, NOTE_2, NOTE_3));

        when(noteRepo.findAll()).thenReturn(notes);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/notes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].title", is("Title3")));

    }

    @Test
    void getNoteById() throws Exception {
        when(noteRepo.findById(1L)).thenReturn(Optional.of(NOTE_1));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/notes/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.title", is("Title1")));
    }

    @Test
    void updateNote() throws Exception {

        Note updatedNote = new Note(1L, "Title4", "Body4");

        when(noteRepo.findById(2L)).thenReturn(Optional.of(NOTE_1));
        when(noteRepo.save(updatedNote)).thenReturn(updatedNote);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/v1/notes")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(updatedNote));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.title", is("Title4")));
    }

    @Test
    void updateNoteWhenNoteNotFound() throws Exception {
        Note updatedNote = new Note(2L, "Title4", "Body4");

        when(noteRepo.findById(any())).thenReturn(Optional.empty());

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/api/v1/notes/2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(updatedNote));

        NestedServletException thrown = assertThrows(
                NestedServletException.class,
                () -> mockMvc.perform(mockRequest),
                "Note with ID 2 does not exist.");
        assertTrue(thrown.getMessage().contains("Note with ID 2"));
    }

    @Test
    public void updateNoteWhenNoteNullID() throws Exception {
        Note updatedRecord = Note.builder()
                .title("Title4")
                .body("Body4")
                .build();

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/v1/notes")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(updatedRecord));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$", notNullValue()))
//                .andExpect(jsonPath("$.title", is("Title4")));
    }

    @Test
    void deleteNoteByID() throws Exception {
        when(noteRepo.findById(2L)).thenReturn(Optional.of(NOTE_2));

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/notes/2")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

    @Test
    void deleteNoteByIDWhenNoteNotFound() throws Exception {
        when(noteRepo.findById(2L)).thenReturn(Optional.empty());

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/api/v1/notes/2")
                .contentType(MediaType.APPLICATION_JSON);

        NestedServletException thrown = assertThrows(
                NestedServletException.class,
                () -> mockMvc.perform(mockRequest),
                "Note with ID 2 does not exist.");
        assertTrue(thrown.getMessage().contains("Note with ID 2"));
    }
}

