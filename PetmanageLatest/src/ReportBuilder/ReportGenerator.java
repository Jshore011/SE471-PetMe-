/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportBuilder;

import PetManager.Pet;
import java.io.IOException;

public interface ReportGenerator {
    void export(Pet pet) throws IOException;
}