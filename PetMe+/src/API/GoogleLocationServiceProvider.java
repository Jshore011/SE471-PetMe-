package API;

import PetManager.PetService;
import PetManager.PetServiceComparatorByRatings;
import com.google.maps.GeoApiContext;
import com.google.maps.GeolocationApi;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeolocationPayload;
import com.google.maps.model.GeolocationPayload.GeolocationPayloadBuilder;
import com.google.maps.model.GeolocationResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GoogleLocationServiceProvider {

    private static volatile GoogleLocationServiceProvider object = null;
    
    private static final String GOOGLE_API_KEY = "AIzaSyB_wMx4KnhLkYBwSCBi2_VmiO3y7Fp4FtU";
    private static final int GOOGLE_PROXIMITY_RADIUS = 2000;
    private final GeoApiContext googleContext;
        
    private GoogleLocationServiceProvider() {
        googleContext = new GeoApiContext.Builder() 
        .apiKey(GOOGLE_API_KEY)
        .build();
    }

    public static GoogleLocationServiceProvider newInstanace() {
        GoogleLocationServiceProvider object = GoogleLocationServiceProvider.object;
        if (object == null) {

            synchronized (GoogleLocationServiceProvider.class) {
                object = GoogleLocationServiceProvider.object;
                if (object == null) {
                    GoogleLocationServiceProvider.object = object = new GoogleLocationServiceProvider();//It's lazy loading of Location Manager. Object will only be created once you call this method.
                }
            }
        }
        return object;
    }
        
    public Location getCurrentLocation()
    {
        try {
            GeolocationPayloadBuilder builder = new GeolocationPayload.GeolocationPayloadBuilder();
            GeolocationPayload payload = builder.createGeolocationPayload();
            
            
            GeolocationResult georesults = GeolocationApi.geolocate(googleContext, payload).await();
            LatLng latlng = georesults.location;
            double accuracy = georesults.accuracy;
            
            Location location = new Location(latlng.lat, latlng.lng);

            return location;
        } catch (ApiException ex) {
            Logger.getLogger(GoogleLocationServiceProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(GoogleLocationServiceProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GoogleLocationServiceProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    public Map<String, PetService> getNearestServicesLocation(PlaceType type) {
        
        try {
            Map<String, PetService> petServices = new HashMap<>();
            Location location = getCurrentLocation();
            LatLng latlng = new LatLng(location.getLatitude(), location.getLongitude());
            
            PlacesSearchResponse response = PlacesApi.nearbySearchQuery(googleContext, latlng).type(type).radius(GOOGLE_PROXIMITY_RADIUS).await();
            PlacesSearchResult[] results = response.results;
            
            for(int i = 0; i < results.length; i++)
            {
                PetService service = new PetService();
                service.setName(results[i].name);
                service.setVicinity(results[i].vicinity);
                service.setRatings(results[i].rating);
                service.setBusinessStatus(results[i].businessStatus);
                
                if(results[i].openingHours != null && results[i].openingHours.periods != null)
                    System.out.print(results[i].openingHours.periods[0].open + " : " + results[i].openingHours.periods[0].close);
                
                System.out.println(results[i].toString());
                
                petServices.put(service.getName(), service);
            }
            return petServices;
        } catch (ApiException ex) {
            Logger.getLogger(GoogleLocationServiceProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(GoogleLocationServiceProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GoogleLocationServiceProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public PetService getHighestRatedService(PlaceType type){
    
        Map<String, PetService> petServicesMap = getNearestServicesLocation(type);
        
        Collection<PetService> petServices = petServicesMap.values();
        
        PetService petService = Collections.max(petServices, new PetServiceComparatorByRatings());
                
        return petService;
    }
    
    public static void main(String[] args) {
        
        GoogleLocationServiceProvider locationManager = GoogleLocationServiceProvider.newInstanace();
        locationManager.getHighestRatedService(PlaceType.BANK);
    }
}
