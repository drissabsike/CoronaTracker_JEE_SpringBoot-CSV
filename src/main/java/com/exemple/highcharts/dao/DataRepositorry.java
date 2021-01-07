package com.exemple.highcharts.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exemple.highcharts.model.CovidModel;

@Repository("dataRepositorry")
public interface DataRepositorry extends CrudRepository<CovidModel,Integer>{

}
