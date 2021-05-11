package API;

import PetManager.PetService;
import com.google.maps.model.PlaceType;
import java.util.Map;

public class Veterinary_ServiceProvider implements LocationServiceProvider{
    
    private GoogleLocationServiceProvider locationManager = GoogleLocationServiceProvider.newInstanace();

    @Override
    public Map<String, PetService> getNearestServicesLocation() {
        
        Map<String, PetService> petServices = locationManager.getNearestServicesLocation(PlaceType.VETERINARY_CARE);
        return petServices;
    }

    @Override
    public PetService getHighestRatedService() {
        
        PetService petService = locationManager.getHighestRatedService(PlaceType.VETERINARY_CARE);
        
        return petService;
    }
    
}
