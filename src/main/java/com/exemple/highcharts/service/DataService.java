package com.exemple.highcharts.service;

import java.util.List;

import com.exemple.highcharts.model.CovidModel;
import com.exemple.highcharts.model.Maroc_cas;
import com.exemple.highcharts.model.World_Covid;

public interface DataService {
	
	public Iterable<CovidModel> findAll();
	
	public Iterable<Maroc_cas> findAll2();
	
	public List<CovidModel> listAll();
	
	public List<World_Covid> listAll2();
	
	public List<Maroc_cas> listAll3();

	public Iterable<World_Covid> findAll3();

}
