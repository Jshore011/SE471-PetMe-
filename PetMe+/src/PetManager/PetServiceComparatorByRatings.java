package PetManager;

import java.util.Comparator;

public class PetServiceComparatorByRatings implements Comparator<PetService>{
    
    @Override
    public int compare(PetService petservice1, PetService petservice2) {
        
        if(petservice1 != null && petservice2 != null){
            
            Float rating1 = petservice1.getRatings();
            Float rating2 = petservice2.getRatings();
            
            return rating1.compareTo(rating2);
        }
        return 0;
    }

    
}
