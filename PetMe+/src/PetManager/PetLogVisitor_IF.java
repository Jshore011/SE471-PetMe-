/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetManager;

/**
 *
 * @author owner
 */
public interface PetLogVisitor_IF {

    public void visitDiet(DietLog diet);

    public void visitExercise(ExerciseLog exercise);

    public void visitMedication(MedicineLog medication);
}
