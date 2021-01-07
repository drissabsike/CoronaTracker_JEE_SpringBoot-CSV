package com.exemple.highcharts.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.exemple.highcharts.model.World_Covid;

@Repository("dataRepositorry2")
public interface DataRepositorry2 extends CrudRepository<World_Covid,Integer>{

}
