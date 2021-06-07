package com.revature.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "rating")
public class Rating {
	
	@Id
	@Column(name = "rating_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ratingId;
	
	@Column(name = "rating_value")
	private Integer ratingValue;
	
	@Column(name = "image_date")
	private LocalDate imageDate;
	
	@Column(name = "user_id")
	private Long userId;

	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Rating(Integer ratingValue, LocalDate imageDate, Long userId) {
		super();
		this.ratingValue = ratingValue;
		this.imageDate = imageDate;
		this.userId = userId;
	}



	public Rating(Long ratingId, Integer ratingValue, LocalDate imageDate, Long userId) {
		super();
		this.ratingId = ratingId;
		this.ratingValue = ratingValue;
		this.imageDate = imageDate;
		this.userId = userId;
	}

	public Long getRatingId() {
		return ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	public Integer getRatingValue() {
		return ratingValue;
	}

	public void setRatingValue(Integer ratingValue) {
		this.ratingValue = ratingValue;
	}

	public LocalDate getImageDate() {
		return imageDate;
	}

	public void setImageDate(LocalDate imageDate) {
		this.imageDate = imageDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId2) {
		this.userId = userId2;
	}
	
	
}
