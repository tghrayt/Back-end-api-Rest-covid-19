package tg.ma.covid.service;



import java.io.IOException;
import java.util.List;

import zone.nora.coronavirus.data.latest.LatestData;
import zone.nora.coronavirus.data.locations.Location;



public interface CovidService {
	
	public List<Location> getLocations() throws IOException;
	public LatestData getLatest() throws IOException;
	public Location getLocationByCountry(String country) throws IOException;
	public List<Integer> getLocationByDateAtCountry(String country, String date) throws IOException;
	public int getLatestByCountry(String country) throws IOException; 
	

}
