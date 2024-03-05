package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.repository.SongRepository;
import com.kodnest.tunehub.service.SongService;

@Service
public class SongServiceimpl implements SongService {
	@Autowired
	SongRepository sri;
	public String addSong(Song song) {
		sri.save(song);
		return "song added successfully";
	}
	public boolean songExists(String name) {
		Song song=sri.findByName(name);
		if(song==null) {
			return false;
		}
		else {
		return true;
	}
	}

	

	public List<Song> fetchAllSongs() {
		List<Song> songs = sri.findAll();
		return songs;
	}
	@Override
	public void updateSong(Song s) {
		sri.save(s);
	}

	

}
