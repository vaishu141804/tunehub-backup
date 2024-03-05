package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.serviceimpl.SongServiceimpl;


@Controller
public class SongController {
	@Autowired
	SongServiceimpl ssl;
	@PostMapping("/addsong")
	public String addsong(@ModelAttribute Song song) {
		

		boolean status = ssl.songExists(song.getName());
		if(status == false) {
			ssl.addSong(song);
			System.out.println("song added");

		}
		else {
			System.out.println("song is already exists");
		}
		return "addsong";
	}
	@GetMapping("/viewsongs")
	public String viewsongs(Model model) {
		List<Song>songList = ssl.fetchAllSongs();
		model.addAttribute("songs",songList);
		return "displaysongs";
	}
	@PostMapping("/playsongs")
	public String playsongs(Model model) {
		boolean premium = true;
		if(premium) {
		List<Song>songList = ssl.fetchAllSongs();
		model.addAttribute("songs",songList);
		return "displaysongs";
		}else {
		return "subscription";	
		}
	}


}
