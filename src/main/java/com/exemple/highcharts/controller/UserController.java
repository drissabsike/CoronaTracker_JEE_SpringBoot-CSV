package com.exemple.highcharts.controller;



import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.exemple.highcharts.OpenPdfClass.CovidPDFExporter1;
import com.exemple.highcharts.OpenPdfClass.CovidPDFExporter2;
import com.exemple.highcharts.OpenPdfClass.CovidPDFExporter3;
import com.exemple.highcharts.dao.Covid_DAO;
import com.exemple.highcharts.dao.Covid_DAO2;
import com.exemple.highcharts.dao.marocCov_dao;
import com.exemple.highcharts.model.CovidModel;
import com.exemple.highcharts.model.Maroc_cas;
import com.exemple.highcharts.model.Maroc_cov;
import com.exemple.highcharts.model.World_Covid;
import com.exemple.highcharts.service.DataService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lowagie.text.DocumentException;

@Controller
public class UserController {
	
/*	@Autowired
	DataDAO dataDAO;*/

	@Autowired	
	private Covid_DAO covidDAO;
	
	@Autowired
	private Covid_DAO2 covidDAO2;
	
	@Autowired
	private DataService dt;
	
	@Autowired
	marocCov_dao marocDao;
	

	
	@RequestMapping("/Pie_chart2")
	public ResponseEntity<?> getDataCovid(){
		 List<Maroc_cov> covid_chart_List =  marocDao.findAll();
		 return new ResponseEntity<>(covid_chart_List,HttpStatus.OK);
	}
	
	
	@RequestMapping("/Pie_chart")
	@ResponseBody
	public String getDataFromDB(){
		List<CovidModel> covid_chart_List = covidDAO.findAll();
		JsonArray jsonArrayPlace = new JsonArray();
		JsonArray jsonArrayPTotal_Case = new JsonArray();
		JsonArray jsonArrayPTotal_Death = new JsonArray();
		JsonObject jsonObject = new JsonObject();
		covid_chart_List.forEach(data->{
			jsonArrayPlace.add(data.getPlace() );
			jsonArrayPTotal_Case.add(data.getPTotal_Cases());
			jsonArrayPTotal_Death.add(data.getPTotal_Death());
		});
		jsonObject.add("Place", jsonArrayPlace);
		jsonObject.add("PTotal_Cases", jsonArrayPTotal_Case);
		jsonObject.add("PTotal_Death",jsonArrayPTotal_Death);
		return jsonObject.toString();
	}
	
	@RequestMapping("/Pie_chart4")
	@ResponseBody
	public String getDataFromDB2(){
		List<Maroc_cas> covid_chart_List2 = covidDAO2.findAll();
		JsonArray jsonArrayLieu = new JsonArray();
		JsonArray jsonArrayCas = new JsonArray();
		JsonArray jsonArrayDeces = new JsonArray();
		JsonObject jsonObject = new JsonObject();
		covid_chart_List2.forEach(data->{
			jsonArrayLieu.add(data.getLieu() );
			jsonArrayCas.add(data.getCas() );
			jsonArrayDeces.add(data.getDeces());
		});
		jsonObject.add("lieu", jsonArrayLieu);
		jsonObject.add("cas", jsonArrayCas);
		jsonObject.add("deces",jsonArrayDeces);
		return jsonObject.toString();
	}
	
	@GetMapping("/users/export")
	public void exportToCSV(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String datetime = dateFormatter.format(new Date());
		String fileName = "World_List"+datetime+".csv";
		String headerKey = "Content-Disposition";
		
		String headerValue = "attachment; filename="+fileName;
		
		response.setHeader(headerKey, headerValue);
		
		List<CovidModel> ListCovid = dt.listAll();
		
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),CsvPreference.STANDARD_PREFERENCE);
		
		String[] csvHeader = {"Place","Total Cases","Total Death","Total recupere"};
		String[] nameMapping = {"Place","PTotal_Cases","PTotal_Death","Total_recupere"};
		
		
		csvWriter.writeHeader(csvHeader);
		
		for(CovidModel cv : ListCovid) {
				csvWriter.write(cv, nameMapping);
		}
		
			csvWriter.close();
		
	}
	
	@GetMapping("/users/export2")
	public void exportToCSV2(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String datetime = dateFormatter.format(new Date());
		String fileName = "World_List"+datetime+".csv";
		String headerKey = "Content-Disposition";
		
		String headerValue = "attachment; filename="+fileName;
		
		response.setHeader(headerKey, headerValue);
		
		List<World_Covid> ListCovid2 = dt.listAll2();
		
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),CsvPreference.STANDARD_PREFERENCE);
		
		String[] csvHeader = {"Place","Total des cas","Nouveaux cas","Total décès","Actualités Décès","Total récupéré","Cas actifs","Critique","Des tests","Population"};                                  
		String[] nameMapping = {"Place","Total_Cases","New_Cases","Total_Deaths","News_Deaths","Total_Recovered","Actives_Cases","Critical","Tests","Population"};                                 
		
		
		csvWriter.writeHeader(csvHeader);
		
		for(World_Covid cv : ListCovid2) {
				csvWriter.write(cv, nameMapping);
		}
		
			csvWriter.close();
		
	}
	
	@GetMapping("/users/export3")
	public void exportToCSV3(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String datetime = dateFormatter.format(new Date());
		String fileName = "Maroc_List"+datetime+".csv";
		String headerKey = "Content-Disposition";
		
		String headerValue = "attachment; filename="+fileName;
		
		response.setHeader(headerKey, headerValue);
		
		List<Maroc_cas> ListCovid3 = dt.listAll3();
		
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),CsvPreference.STANDARD_PREFERENCE);
		
		String[] csvHeader = {"Lieu","Cas","guerisons","deces"};                                  
		String[] nameMapping = {"lieu","cas","guerisons","deces"};                                 
		
		
		csvWriter.writeHeader(csvHeader);
		
		for(Maroc_cas cv : ListCovid3) {
				csvWriter.write(cv, nameMapping);
		}
		
			csvWriter.close();
		
	}
	
	
	//Open PDF
	
	@GetMapping("/users/exportPDF")
	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
			response.setContentType("application/pdf");
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
			String datetime = dateFormatter.format(new Date());
			String headerKey = "Content-Disposition";
			String headerValue = "attachment; filename=World_cov_"+datetime+".pdf";
			response.setHeader(headerKey, headerValue);
			
			List<CovidModel> ListCovid = dt.listAll();
			
			CovidPDFExporter1 exporter = new CovidPDFExporter1(ListCovid);
			exporter.export(response);
			
	}
	// export covid world 2020
	@GetMapping("/users/exportPDF2")
	public void exportToPDF2(HttpServletResponse response) throws DocumentException, IOException {
			response.setContentType("application/pdf");
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
			String datetime = dateFormatter.format(new Date());
			String headerKey = "Content-Disposition";
			String headerValue = "attachment; filename=World_cov_"+datetime+".pdf";
			response.setHeader(headerKey, headerValue);
			
			List<World_Covid> ListCovid2 = dt.listAll2();
			
			CovidPDFExporter2 exporter = new CovidPDFExporter2(ListCovid2);
			exporter.export(response);
	}

	
	// export covid Maroc 2020
		@GetMapping("/users/exportPDF3")
		public void exportToPDF3(HttpServletResponse response) throws DocumentException, IOException {
				response.setContentType("application/pdf");
				DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
				String datetime = dateFormatter.format(new Date());
				String headerKey = "Content-Disposition";
				String headerValue = "attachment; filename=Maroc_cov_"+datetime+".pdf";
				response.setHeader(headerKey, headerValue);
				
				List<Maroc_cas> ListCovid3 = dt.listAll3();
				
				CovidPDFExporter3 exporter = new CovidPDFExporter3(ListCovid3);
				exporter.export(response);
		}
	
	
	
	
	
	
	
	
	
}
