package com.exemple.highcharts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@lombok.Data
@Setter
@Getter
@Entity
@Table(name= "maroc_cov")
public class Maroc_cov {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private	 String ville;
	
	@Column
	private double cas_covid;

}
