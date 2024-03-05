package com.kodnest.tunehub.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.serviceimpl.SongServiceimpl;
import com.kodnest.tunehub.serviceimpl.UserServiceimpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserServiceimpl userService;
	@Autowired
	
	SongServiceimpl ssl;
	@GetMapping("/register")
	public String addUser(@ModelAttribute User user) {

		//email taken from the registration form
		String email = user.getEmail();

		//checking if  email as entered in registration form is present in database or not.
		boolean status	= userService.emailExists(email);

		//System.out.println(user.getUsername()+ " " + user.getEmail() + " " +user.getPassword()  + " " + user.getGender() + " " +user.getRole() + " " + user.getAddress());
		if(status == false) {
			userService.addUser(user);
			System.out.println("user added");
		}
		else {
			System.out.println("user already exist");

		}
		return "login";

	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/registration")
	public String registration() {
		return "registration";

	}
	@GetMapping("/validate")
	String validate(@RequestParam("email") String email,@RequestParam("password") String password,HttpSession session,Model model ) {
		if(userService.validateUser(email,password) == true){
			String role = userService.getRole(email);
			session.setAttribute("email",email);
			if(role.equalsIgnoreCase("admin")) {
				return "admin";
			}

			else {
				User user = userService.getUser(email);
				boolean userstatus = user.isIspremium();
				
				List<Song>songList = ssl.fetchAllSongs();
				model.addAttribute("songs",songList);

				model.addAttribute("ispremium",userstatus);
				return "customer";
			}
		}

		else {
			return "login";
		}
	}
	@GetMapping("/logout") 
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";	

	}
	
}







