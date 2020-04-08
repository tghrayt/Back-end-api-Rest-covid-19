package tg.ma.covid.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tg.ma.covid.helpper.Helpper;
import tg.ma.covid.service.CovidService;
import zone.nora.coronavirus.Coronavirus;
import zone.nora.coronavirus.data.CoronavirusData;
import zone.nora.coronavirus.data.latest.LatestData;
import zone.nora.coronavirus.data.locations.Location;


@Service
public class CovidServiceImpl implements CovidService {
	
	@Autowired
	private Helpper helpper;
	

	@Override
	public List<Location> getLocations() throws IOException {
		Coronavirus coronavirus = new Coronavirus();
		CoronavirusData coronavirusData = coronavirus.getConfirmed();
		return coronavirusData.getLocations();
	}

	@Override
	public LatestData getLatest() throws IOException {
		Coronavirus coronavirus = new Coronavirus();
		return coronavirus.getLatestData();
	}

	

	@Override
	public Location getLocationByCountry(String country) throws IOException {
		Coronavirus coronavirus = new Coronavirus();
		CoronavirusData coronavirusData = coronavirus.getConfirmed();
		List<Location> locations = coronavirusData.getLocations();
		return helpper.locationHelpper(country, locations);
	}

	@Override
	public List<Integer> getLocationByDateAtCountry(String country, String date) throws IOException {
		
		Coronavirus coronavirus = new Coronavirus();
		CoronavirusData coronavirusData = coronavirus.getConfirmed();
		List<Location> locations = coronavirusData.getLocations();
		List<Integer> dates = new ArrayList<>();
		dates.add(helpper.locationDateHelpper(country, date, locations));
		return dates;
	}

	@Override
	public int getLatestByCountry(String country) throws IOException {
		Coronavirus coronavirus = new Coronavirus();
		CoronavirusData coronavirusData = coronavirus.getConfirmed();
		List<Location> locations = coronavirusData.getLocations();
		Location location = helpper.locationHelpper(country, locations);
		return location.getLatest();
	}

	
}
