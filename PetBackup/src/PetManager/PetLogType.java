package PetManager;

/**
 * Enum type to represent types of pete logs
 */
public enum PetLogType {
    Diet,
    Exercise,
    Medicine;

    /**
     * Converts a string representation of the pet log type to it's internal type
     * @param str String representation
     * @return pet log type
     */
    public static PetLogType fromString(String str) {
        if (str.equals("medicine")) {
            return PetLogType.Medicine;
        } else if (str.equals("exercise")) {
            return PetLogType.Exercise;
        } else {
            return PetLogType.Diet;
        }
    }

    /**
     * Converts a PetLogType to it's string representation
     * @return string representation
     */
    public String toString() {
        String str = null;
        switch(this) {
            case Diet:
                str = "diet";
                break;
            case Medicine:
                str = "medicine";
                break;
            case Exercise:
                str = "exercise";
                break;
        }

        return str;
    }
}
