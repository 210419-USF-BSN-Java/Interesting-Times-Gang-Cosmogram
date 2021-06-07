///*
package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Album;
import com.revature.repository.AlbumRepository;

@Service
public class AlbumService {
	private AlbumRepository albumRepo;

	public AlbumService() {}

	@Autowired
	public AlbumService(AlbumRepository repo) {
		this.albumRepo = repo;
	}

	public List<Album> getAlbumsByUserId(Integer id) {
		List<Album> a = albumRepo.findAlbumsByUserId(id);
		return a;
	}

	public Album createAlbum(String albumName, Integer userId) {
		Album album = new Album(albumName, userId);
		return albumRepo.save(album);
	}
}
//*/