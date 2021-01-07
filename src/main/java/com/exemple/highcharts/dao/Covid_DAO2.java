package com.exemple.highcharts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exemple.highcharts.model.Maroc_cas;

@Repository
public interface Covid_DAO2 extends JpaRepository<Maroc_cas ,Integer>{

}
