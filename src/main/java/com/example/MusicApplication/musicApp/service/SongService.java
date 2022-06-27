package com.example.MusicApplication.musicApp.service;

import com.example.MusicApplication.musicApp.database.SearchSongRepository;
import com.example.MusicApplication.musicApp.database.SongPaginationRepository;
import com.example.MusicApplication.musicApp.database.SongRepository;
import com.example.MusicApplication.musicApp.exception.SongNotFound;
import com.example.MusicApplication.musicApp.model.SearchSong;
import com.example.MusicApplication.musicApp.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class SongService {

    @Autowired
    SongRepository songRepository;

    @Autowired
    SearchSongRepository searchSongRepository;

    @Autowired
    SongPaginationRepository songPaginationRepository;

    public Page<SearchSong> listSongs(Integer pageable){

        return songPaginationRepository.findAll(Pageable.ofSize(pageable));
    }

    public List<Song> listSongs(String search, String artistName, Double ratingFrom, Double ratingTo){

        if (search != null){
            return songRepository.searchSongByName(search);
        }else if (artistName != null){
            return songRepository.searchSongByArtist(artistName);
        }else if (ratingFrom != null && ratingTo != null){
            return songRepository.searchSongBySongRating(ratingFrom, ratingTo);
        }else {
            return songRepository.findAll();
        }
    }

    public Song createSong(Song song){

        songRepository.save(song);

        return song;
    }

    public Song updateSong(Long songId,Song song){

        Song updateSong = songRepository.getSongById(songId);

        if (updateSong == null){
            throw new SongNotFound("No song with that id, try again");
        }

        LocalDateTime localDateTime = LocalDateTime.now();
        song.setCreatedat(updateSong.getCreatedat());
        song.setLastupdatedat(localDateTime);
        song.setId(songId);

        songRepository.save(song);

        return song;
    }

    public void deleteSong(Long songId){

        Song song = songRepository.getSongById(songId);

        if (song == null){
            throw new SongNotFound("No song with that id, try again");
        }

        songRepository.deleteById(songId);
    }
}
