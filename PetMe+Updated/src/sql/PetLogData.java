package sql;

import PetManager.PetCommandFactory;

/**
 * Helper class to pack PetLogData conveniently
 */
public class PetLog {
    public PetLog diet;
    public PetLog exercise;
    public PetLog medicine;
    public PetLog(PetLog diet, PetLog exercise, PetLog medicine) {
        this.diet = diet; this.exercise = exercise; this.medicine = medicine;
    }
}