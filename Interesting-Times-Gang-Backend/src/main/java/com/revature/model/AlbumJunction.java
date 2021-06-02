package com.revature.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "album_junction")
public class AlbumJunction {

	@Column(name = "album_id")
	private Long albumId;

	@Column(name = "image_id")
	private LocalDate imageDate;

	public AlbumJunction() {
		super();
	}

	public AlbumJunction(Long albumId, LocalDate imageDate) {
		super();
		this.albumId = albumId;
		this.imageDate = imageDate;
	}

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
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
		result = prime * result + ((albumId == null) ? 0 : albumId.hashCode());
		result = prime * result + ((imageDate == null) ? 0 : imageDate.hashCode());
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
		AlbumJunction other = (AlbumJunction) obj;
		if (albumId == null) {
			if (other.albumId != null)
				return false;
		} else if (!albumId.equals(other.albumId))
			return false;
		if (imageDate == null) {
			if (other.imageDate != null)
				return false;
		} else if (!imageDate.equals(other.imageDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlbumJunction [albumId=" + albumId + ", imageDate=" + imageDate + "]";
	}
}
