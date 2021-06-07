package com.revature.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.model.Rating;
import com.revature.repository.RatingRepository;

@Service
public class RatingService {

	private RatingRepository rateRepo;
	private UserService userServ;
	
	public RatingService(RatingRepository rRepo, UserService userServ) {
		this.rateRepo = rRepo;
		this.userServ = userServ;
	}
	
	public Integer getRating(LocalDate imageDate, Long userId) {
		try {
			Integer ratingValue = 0;
			Rating rating = rateRepo.findRatingByImageDateAndUserId(imageDate, userId);
			if (rating != null) {
				ratingValue = rating.getRatingValue();
			} 
			return ratingValue;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public String createRating(Integer finalRating, LocalDate imageDate, Long userId) {
		try {
			rateRepo.save(new Rating(finalRating, imageDate, userId));
			return "rating successfully updated";
		}catch(Exception e) {
			e.printStackTrace();
			return "rating not successfully updated";
		}
		
	}
}
