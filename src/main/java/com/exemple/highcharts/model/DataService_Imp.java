package com.exemple.highcharts.model;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exemple.highcharts.dao.Covid_DAO;
import com.exemple.highcharts.dao.Covid_DAO2;
import com.exemple.highcharts.dao.Covid_DAO3;
import com.exemple.highcharts.dao.DataRepositorry;
import com.exemple.highcharts.dao.DataRepositorry2;
import com.exemple.highcharts.service.DataService;


@Service("dataService")
public class DataService_Imp implements DataService{


	@Autowired
	public DataRepositorry dataRepo;
	
	@Autowired
	public DataRepositorry2 dataRepo2;
	
	@Autowired
	public Covid_DAO2 Covid_DAO;
	
	@Autowired
	public Covid_DAO covidDaoResp;
	
	@Autowired
	public Covid_DAO3 covidDaoResp3;
	

	
	@Override
	public Iterable<CovidModel> findAll() {
		return dataRepo.findAll();
	}
	
	@Override
	public Iterable<World_Covid> findAll3() {
		return dataRepo2.findAll();
	}


	@Override
	public Iterable<Maroc_cas> findAll2() {
		return Covid_DAO.findAll();
	}


	@Override
	public List<CovidModel> listAll(){
		return covidDaoResp.findAll();
	}

	@Override
	public List<World_Covid> listAll2() {
		return covidDaoResp3.findAll();
	}

	@Override
	public List<Maroc_cas> listAll3() {
		return Covid_DAO.findAll();
	}
	


}
