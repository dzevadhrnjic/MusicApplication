package com.example.MusicApplication.musicApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")

public class Category {

    @Id
    private Long id;
    private String categoryName;

}
