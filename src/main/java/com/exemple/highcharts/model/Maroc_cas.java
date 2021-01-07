package com.exemple.highcharts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "maroc_cas")
public class Maroc_cas {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String lieu;;
	@Column
	private Integer cas;
	@Column
	private Integer guerisons;
	@Column
	private Integer deces;
	

	
	
}
