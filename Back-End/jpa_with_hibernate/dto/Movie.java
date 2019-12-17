package com.cap.jpawithhibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Movie {
	@Id
	@Column (name = "movieid")
	private int id;
	@Column
	private String name;
	@Column
	private String ratings;
	
	public int getMovieid() {
		return id;
	}
	public void setMovieid(int movieid) {
		this.id = movieid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	
//	@Override
//	public String toString() {
//		return "Movie [movieid=" + id + ", name=" + name + ", ratings=" + ratings + "]";
//	}
//	
	
	
}
