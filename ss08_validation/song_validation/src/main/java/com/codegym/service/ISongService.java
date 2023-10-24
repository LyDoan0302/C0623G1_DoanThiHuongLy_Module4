package com.codegym.service;

import com.codegym.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISongService {
    Page<Song> findAll(Pageable pageable);
    List<Song> findAll();
    Song findSongById(Long id);
    void save(Song song);
    void delete(Long id);
}
