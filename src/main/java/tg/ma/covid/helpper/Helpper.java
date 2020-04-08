package tg.ma.covid.helpper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


import zone.nora.coronavirus.data.locations.Location;

@Service
public class Helpper {
	
	public Location locationHelpper(String param, List<Location> locations) throws IOException {
		for(Location location : locations) {
			if(location.getCountry().equals(param)) {
				return location;
			}
		}
		
		return null;
	}
	
	public int locationDateHelpper(String param,String date, List<Location> locations) throws IOException {
		for(Location location : locations) {
			if(location.getCountry().equals(param)) {
				if(location.getHistory().containsKey(date)) {
					return locationNumbreByDate(date, location.getHistory());
				}
			}
		}
		
		return 0;
	}
	
	public int locationNumbreByDate(String date , Map<String,Integer> history) {
		
		return history.get(date);
	}

}
