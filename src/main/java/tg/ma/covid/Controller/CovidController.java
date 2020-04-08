package tg.ma.covid.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tg.ma.covid.service.CovidService;
import zone.nora.coronavirus.data.latest.LatestData;
import zone.nora.coronavirus.data.locations.Location;

@RestController
@RequestMapping("/covid")
@CrossOrigin("*")
public class CovidController {
	
	@Autowired
	private CovidService covidService;
	
	
	@GetMapping(path = "/latestData")
	public LatestData getTotalConfirmedCases() throws IOException {
		return covidService.getLatest();
	}
	
	@GetMapping(path = "/totalRecoveredCases")
	public int getTotalRecoveredCases() throws IOException {
		return covidService.getLatest().getRecovered();
	}
	
	@GetMapping(path = "/totalDeathsCases")
	public int getTotalDeathsCases() throws IOException {
		return covidService.getLatest().getDeaths();
	}
	
	@GetMapping(path = "/locations")
	public List<Location> getLocations() throws IOException{
		return covidService.getLocations();
	}
	
	@GetMapping(path = "/locations/{country}/history")
	public Location getLocationByCountry(@PathVariable String country) throws IOException{
		return covidService.getLocationByCountry(country);
	}
	
	
	@GetMapping(path = "/locations/{country}/toDay")
	public List<Integer> getLocationByHistory(@PathVariable String country) throws IOException{
		Date history = new Date();
		history .setTime(history.getTime()-24*60*60*1000);
		DateFormat dateForma = new SimpleDateFormat("M/d/yy");
		System.out.println(dateForma.format(history));
		
		return covidService.getLocationByDateAtCountry(country, dateForma.format(history));
	}
	@GetMapping(path ="/locations/{country}/latest")
	public int getgetLatestByCountry(@PathVariable String country) throws IOException {
		return covidService.getLatestByCountry(country);
	}

}
