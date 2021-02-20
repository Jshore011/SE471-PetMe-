public class WeaponFactory implements IF_PlayerModeFactory{

    public BeginnerMode createBeginner()
    {
        return new BeginnerWeapon;
    }

    public IntermediateMode createIntermediate()
    {
        return new IntermediateWeapon;
    }

    public AdvancedMode createAdvanced()
    {
        return new AdvancedWeapon;
    }
}
