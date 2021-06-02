///*
package com.revature.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Image;
import com.revature.repository.ImageRepository;

@Service
public class ImageService {
	private ImageRepository imageRepo;
	
	public ImageService() {
		
	}
	
	@Autowired
	public ImageService(ImageRepository repo) {
		this.imageRepo = repo;
	}
	
	public Image getImageByDate(Date date) {
		Image i = imageRepo.findImageByDate(date);
		return i;
	}
}
//*/
