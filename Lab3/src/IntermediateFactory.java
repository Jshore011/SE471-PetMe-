public class IntermediateFactory implements IF_PlayerModeFactory
{
    public IF_Weapon createWeapon()
    {
        return new IntermediateWeapon();
    }

    public IF_Character createCharacter()
    {
        return new IntermediateCharacter();
    }
}
