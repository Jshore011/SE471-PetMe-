package PetManager;

import java.time.LocalDateTime;

/**
 * Java representation of pet data
 */
public class Pet {
    // internal SQL id - do not set manually.
    public int id;
    public int tracking_id;
    public String name;
    public String owner;
    public LocalDateTime petBirthday;
    public String breed;
    public String gender;
    public String city;
    public PetLog diet;
    public PetLog medicine;
    public PetLog exercise;
    public String type;
    public String icon;
}
