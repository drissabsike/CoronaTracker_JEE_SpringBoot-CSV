package com.exemple.highcharts.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.exemple.highcharts.service.DataService;

@Controller
public class HomeController {


	@Autowired
	private DataService dataService;
	
	
    @RequestMapping("/select-chart-data")
	public String ShowHome2() {
		return "select-chart-data";
	}
	
	@RequestMapping("/")
	public String viewHomePage(ModelMap modelMap) {
		modelMap.addAttribute("dataService",dataService.findAll());
		modelMap.addAttribute("dataServiceW",dataService.findAll3());
		return "index";
	}
	
	@GetMapping("/index")
	public String showHome2(ModelMap modelMap){
		modelMap.addAttribute("dataService",dataService.findAll());
		modelMap.addAttribute("dataServiceW",dataService.findAll3());
		return "index";
	}
	
	@GetMapping("/index2")
	public String showHome3(ModelMap modelMap){
		modelMap.addAttribute("dataService2",dataService.findAll2());
		return "index2";
	}	
	
}
