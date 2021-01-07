package com.exemple.highcharts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exemple.highcharts.model.World_Covid;

@Repository
public interface Covid_DAO3 extends JpaRepository<World_Covid ,Integer>{

}
