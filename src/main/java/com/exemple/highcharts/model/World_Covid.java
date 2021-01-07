package com.exemple.highcharts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "covidword2")
public class World_Covid {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String Place;
	@Column
	private String Total_Cases;
	@Column
	private String New_Cases;
	@Column
	private String Total_Deaths;
	@Column
	private String News_Deaths;
	@Column
	private String Total_Recovered;
	@Column
	private String Actives_Cases;
	@Column
	private String Critical;
	@Column
	private String Tests;
	@Column
	private String Population;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlace() {
		return Place;
	}
	public void setPlace(String place) {
		Place = place;
	}
	public String getTotal_Cases() {
		return Total_Cases;
	}
	public void setTotal_Cases(String total_Cases) {
		Total_Cases = total_Cases;
	}
	public String getNew_Cases() {
		return New_Cases;
	}
	public void setNew_Cases(String new_Cases) {
		New_Cases = new_Cases;
	}
	public String getTotal_Deaths() {
		return Total_Deaths;
	}
	public void setTotal_Deaths(String total_Deaths) {
		Total_Deaths = total_Deaths;
	}
	public String getNews_Deaths() {
		return News_Deaths;
	}
	public void setNews_Deaths(String news_Deaths) {
		News_Deaths = news_Deaths;
	}
	public String getTotal_Recovered() {
		return Total_Recovered;
	}
	public void setTotal_Recovered(String total_Recovered) {
		Total_Recovered = total_Recovered;
	}
	public String getActives_Cases() {
		return Actives_Cases;
	}
	public void setActives_Cases(String actives_Cases) {
		Actives_Cases = actives_Cases;
	}
	public String getCritical() {
		return Critical;
	}
	public void setCritical(String critical) {
		Critical = critical;
	}
	public String getTests() {
		return Tests;
	}
	public void setTests(String tests) {
		Tests = tests;
	}
	public String getPopulation() {
		return Population;
	}
	public void setPopulation(String population) {
		Population = population;
	}
	
	
}
