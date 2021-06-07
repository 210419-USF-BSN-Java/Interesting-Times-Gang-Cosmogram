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
@Table(name = "tag_junction")
public class TagJunction {

	@Id
	@Column(name = "tj_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tag_id")
	private Long tagId;

	@Column(name = "image_date")
	private LocalDate imageDate;

	public TagJunction() {
		super();
	}

	public TagJunction(Long tagId, LocalDate imageDate) {
		super();
		this.tagId = tagId;
		this.imageDate = imageDate;
	}

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public LocalDate getImageDate() {
		return imageDate;
	}

	public void setImageDate(LocalDate imageDate) {
		this.imageDate = imageDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageDate == null) ? 0 : imageDate.hashCode());
		result = prime * result + ((tagId == null) ? 0 : tagId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TagJunction other = (TagJunction) obj;
		if (imageDate == null) {
			if (other.imageDate != null)
				return false;
		} else if (!imageDate.equals(other.imageDate))
			return false;
		if (tagId == null) {
			if (other.tagId != null)
				return false;
		} else if (!tagId.equals(other.tagId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TagJunction [tagId=" + tagId + ", imageDate=" + imageDate + "]";
	}
}
