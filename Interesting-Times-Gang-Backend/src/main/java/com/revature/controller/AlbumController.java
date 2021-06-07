///*
package com.revature.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Album;
import com.revature.model.AlbumJsonModel;
import com.revature.model.AlbumJunction;
import com.revature.service.AlbumJunctionService;
import com.revature.service.AlbumService;

@RestController
@RequestMapping(value = "/album")
@CrossOrigin(origins = "*")
public class AlbumController {

	private AlbumService albumServ;

	private AlbumJunctionService albumJunctServ;

	@Autowired
	public AlbumController(AlbumService serv, AlbumJunctionService serv2) {
		this.albumServ = serv;
		this.albumJunctServ = serv2;
	}

	@GetMapping(value = "/")
	public ResponseEntity<List<AlbumJsonModel>> getAlbumsByUserId(@RequestParam Integer userId) {
		System.out.println(userId);
		// 1 Use the userId to get all of the Albums with that id

		List<AlbumJsonModel> ajmList = new ArrayList<>();

		List<Album> albums = albumServ.getAlbumsByUserId(userId);
		System.out.println(albums);

		// cycles through the albums by user id
		for (Album a : albums) {
			AlbumJsonModel ajm = new AlbumJsonModel();
			ajm.setAlbum(a);
			List<LocalDate> dates = new ArrayList<>();
			List<AlbumJunction> albumJuncs = albumJunctServ.getAlbumJunctionsByAlbumId(a.getAlbumId());

			// cycle through album junctions to find correct albums according to current
			// album a
			// adds date
			for (AlbumJunction aj : albumJuncs) {
				if (aj.getAlbumId().equals(a.getAlbumId())) {
					dates.add(aj.getImageDate());
				}
			}

			ajm.setImageDates(dates);
			ajmList.add(ajm);
		}

		return new ResponseEntity<List<AlbumJsonModel>>(ajmList, HttpStatus.OK);
	}

	@PostMapping(value = "/create")
	public ResponseEntity<Album> createAlbum(@RequestParam String name, @RequestParam Integer userId) {
		albumServ.createAlbum(name, userId);
		
		return new ResponseEntity<Album>(HttpStatus.CREATED);
	}

	@PostMapping(value = "/insert")
	public ResponseEntity<Album> addToAlbum(@RequestParam Integer albumId, @RequestParam String date) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//convert String to LocalDate
		LocalDate localDate = LocalDate.parse(date, formatter);
		
		albumJunctServ.insertIntoAlbumJunct(albumId, localDate);
		
		return new ResponseEntity<Album>(HttpStatus.CREATED);
	}

	@PostMapping(value = "/remove")
	public ResponseEntity<Album> removeFromAlbum(@RequestParam Integer albumId, @RequestParam String date) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//convert String to LocalDate
		LocalDate localDate = LocalDate.parse(date, formatter);

		Long albumJunct = albumJunctServ.removeFromAlbumJunct(albumId, localDate);
		
		return new ResponseEntity<Album>(HttpStatus.OK);
	}
}
//*/