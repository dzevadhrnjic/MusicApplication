package com.example.MusicApplication.musicApp.controller;

import com.example.MusicApplication.musicApp.exception.SongNotFound;
import com.example.MusicApplication.musicApp.model.Song;
import com.example.MusicApplication.musicApp.service.SongService;
import com.example.MusicApplication.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/songs")

public class SongController {

    private final SongService songService;
//    private final UserService loginService;

    public SongController(SongService songService, UserService loginService) {
        this.songService = songService;
//        this.loginService = loginService;
    }

    @GetMapping(path = "pagination")
    public ResponseEntity<Object> listSongs(@RequestParam(value = "size", required = false) Integer pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(songService.listSongs(pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<Object> searchSongByName(@RequestParam(name = "search", required = false) String search,
                                                   @RequestParam(name = "artist", required = false) String artist,
                                                   @RequestParam(name = "ratingFrom", required = false) Double ratingFrom,
                                                   @RequestParam(name = "ratingTo", required = false) Double ratingTo){
        try {
            List<Song> findSongByName = songService.listSongs(search, artist, ratingFrom, ratingTo);
            return ResponseEntity.status(HttpStatus.OK).body(findSongByName);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> createNewSong(@RequestBody Song song) {
         try {
             songService.createSong(song);
             return ResponseEntity.status(HttpStatus.CREATED).body(song);
         }catch (Exception e){
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
         }
    }

    @PutMapping(path = "{songId}")
    public ResponseEntity<Object> updateSong(@PathVariable("songId") Long songId,
                                             @RequestBody Song song){
        try {
            Song updateSong = songService.updateSong(songId,song);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updateSong);
        }catch (SongNotFound e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "{songId}")
    public ResponseEntity<Object> deleteSong(@PathVariable("songId") Long songId){
        try {
            songService.deleteSong(songId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(songId);
        }catch (SongNotFound e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
