package com.example.MusicApplication.musicApp.database;

import com.example.MusicApplication.musicApp.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song,Long> {

    @Query("select s from Song s where s.id = ?1")
    Song getSongById(Long songId);

    @Query(value = "select * from song where songname like ?1%", nativeQuery = true)
    List<Song> searchSongByName(String search);

    @Query(value = "select * from song where artistname like ?1%", nativeQuery = true)
    List<Song> searchSongByArtist(String artistName);

    @Query(value = "select * from song where songrating between ?1 and ?2", nativeQuery = true)
    List<Song> searchSongBySongRating(Double ratingFrom, Double ratingTo);

}
