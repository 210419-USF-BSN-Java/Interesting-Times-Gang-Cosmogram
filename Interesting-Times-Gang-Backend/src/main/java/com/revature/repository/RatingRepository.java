package com.revature.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Rating;

@Repository
@Transactional
public interface RatingRepository extends JpaRepository<Rating, Long>{
	public Rating findRatingByRatingId(Integer id);
	public Rating findRatingByImageDateAndUserId(LocalDate imageDate, Long userId);
}
