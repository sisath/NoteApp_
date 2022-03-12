package com.sa.noteapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name="notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long noteId;
    private String noteTitle;
    private String noteBody;
    private Date noteCreatedDate;
    private Date noteUpdatedDate;

    public Note(String noteTitle, String noteBody, Date noteCreatedDate, Date noteUpdatedDate) {
        this.noteTitle = noteTitle;
        this.noteBody = noteBody;
        this.noteCreatedDate = noteCreatedDate;
        this.noteUpdatedDate = noteUpdatedDate;
    }
}
