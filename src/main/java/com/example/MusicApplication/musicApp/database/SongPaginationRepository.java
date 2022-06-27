package com.example.MusicApplication.musicApp.database;

import com.example.MusicApplication.musicApp.model.SearchSong;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongPaginationRepository extends PagingAndSortingRepository<SearchSong, Long> {
}
