package com.revature.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Album;
import com.revature.model.AlbumJunction;
import com.revature.repository.AlbumJunctionRepository;

@Service
public class AlbumJunctionService {
	private AlbumJunctionRepository albumJunctRepo;

	public AlbumJunctionService() {}

	@Autowired
	public AlbumJunctionService(AlbumJunctionRepository albumRepo) {
		this.albumJunctRepo = albumRepo;
	}

	public String createAlbumJunction(Long userId, String sessionToken, Long albumId, LocalDate imageDate) {
		return null;
	}

	public List<AlbumJunction> getAlbumJunctionsByAlbumId(Integer id) {
		System.out.println("Album Junction Service: " + id);
		List<AlbumJunction> juncts = albumJunctRepo.findAlbumJunctionsByAlbumId(id);
		System.out.println("Album Junction Service: " + juncts);
		return juncts;
	}
	public AlbumJunction insertIntoAlbumJunct(Integer albumId, LocalDate date) {
		AlbumJunction albumjunct = new AlbumJunction(albumId, date);
		return albumJunctRepo.save(albumjunct);
	}
	public Long removeFromAlbumJunct(Integer albumId, LocalDate date) {
		return albumJunctRepo.deleteByAlbumIdAndImageDate(albumId, date);
	}
}
