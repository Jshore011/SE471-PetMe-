package PetManager2;

/**
 * Enum type to represent types of pet logs
 */
public enum PetLogType {
    Diet,
    Exercise,
    Medicine;

    /**
     * Converts a string representation of the pet log type to it's interal type
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
