package com.example.MusicApplication.musicApp.database;

import com.example.MusicApplication.musicApp.model.SearchSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchSongRepository extends JpaRepository<SearchSong,Long> {

    @Query(value = "select * from song where songname like ?1%", nativeQuery = true)
    List<SearchSong> searchSongByName(String search);

    @Query(value = "select * from song where artistname like ?1%", nativeQuery = true)
    List<SearchSong> searchSongByArtist(String artistName);

    @Query(value = "select * from song where songrating between ?1 and ?2", nativeQuery = true)
    List<SearchSong> searchSongBySongRating(Double ratingFrom, Double ratingTo);

}
