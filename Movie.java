package com.ProjectAssignment.Movies3;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Movie 
{@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
@PrimaryKeyJoinColumn
	private int srno;
	String movieName;
	@OneToOne(targetEntity=Year.class,cascade=CascadeType.ALL)
	private Year year;
	
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Year getYear() {
		return year;
	}
	public void setYear(Year year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Movie [srno=" + srno + ", movieName=" + movieName + ", year=" + year + "]";
	}
	
	
	
	

}
