package sql;

import PetManager.PetLog;

/**
 * Helper class to pack PetLogData conveniently
 */
public class PetLogData {
    public PetLog diet;
    public PetLog exercise;
    public PetLog medicine;
    public PetLogData(PetLog diet, PetLog exercise, PetLog medicine) {
        this.diet = diet; this.exercise = exercise; this.medicine = medicine;
    }
}