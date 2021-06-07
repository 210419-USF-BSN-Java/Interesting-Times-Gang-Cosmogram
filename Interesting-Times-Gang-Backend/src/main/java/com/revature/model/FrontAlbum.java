package com.revature.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="front_album") // will not be saved to database, so there is no real table for it
public class FrontAlbum {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="front_album_id", unique=true, nullable=false)
	private Integer frontAlbumId;
	
	// Unknown
	@Column(name="images", unique=true, nullable=false)
    @ElementCollection(targetClass=Image.class)
	private List<Image> images;

	
	
	public FrontAlbum() {
		super();
	}
	public FrontAlbum(List<Image> images) {
		super();
		this.images = images;
	}
	public FrontAlbum(Integer frontAlbumId, List<Image> images) {
		super();
		this.frontAlbumId = frontAlbumId;
		this.images = images;
	}
	public Integer getFrontAlbumId() {
		return frontAlbumId;
	}
	public void setFrontAlbumId(Integer frontAlbumId) {
		this.frontAlbumId = frontAlbumId;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((frontAlbumId == null) ? 0 : frontAlbumId.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
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
		FrontAlbum other = (FrontAlbum) obj;
		if (frontAlbumId == null) {
			if (other.frontAlbumId != null)
				return false;
		} else if (!frontAlbumId.equals(other.frontAlbumId))
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FrontAlbum [frontAlbumId=" + frontAlbumId + ", images=" + images + "]";
	}
}
