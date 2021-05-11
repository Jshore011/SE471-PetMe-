package API;

import PetManager.PetService;
import java.util.Map;

public interface LocationServiceProvider {
        
    Map<String, PetService> getNearestServicesLocation();
    PetService getHighestRatedService();
    
}
