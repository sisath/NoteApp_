package com.sa.noteapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name="notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long noteId;
    private String title;
    private String body;

    public Note(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
