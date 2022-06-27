package com.example.MusicApplication.musicApp.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "song")

public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String songname;
    private String artistname;
    private String songurl;
    private Double songrating;
    @CreationTimestamp
    private LocalDateTime createdat;
    @UpdateTimestamp
    private LocalDateTime lastupdatedat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getArtistname() {
        return artistname;
    }

    public void setArtistname(String artistname) {
        this.artistname = artistname;
    }

    public String getSongurl() {
        return songurl;
    }

    public void setSongurl(String songurl) {
        this.songurl = songurl;
    }

    public Double getSongrating() {
        return songrating;
    }

    public void setSongrating(Double songrating) {
        this.songrating = songrating;
    }

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }

    public LocalDateTime getLastupdatedat() {
        return lastupdatedat;
    }

    public void setLastupdatedat(LocalDateTime lastupdatedat) {
        this.lastupdatedat = lastupdatedat;
    }
}
