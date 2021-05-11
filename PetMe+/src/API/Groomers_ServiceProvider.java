package API;

import PetManager.PetService;
import com.google.maps.model.PlaceType;
import java.util.Map;

public class Groomers_ServiceProvider implements LocationServiceProvider{

    private GoogleLocationServiceProvider locationManager = GoogleLocationServiceProvider.newInstanace();

    @Override
    public Map<String, PetService> getNearestServicesLocation() {
        
        Map<String, PetService> petServices = locationManager.getNearestServicesLocation(PlaceType.PET_STORE);
        return petServices;
    }

    @Override
    public PetService getHighestRatedService() {
        
        PetService petService = locationManager.getHighestRatedService(PlaceType.PET_STORE);
        
        return petService;
    }  
}
