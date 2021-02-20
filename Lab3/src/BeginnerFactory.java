public class BeginnerFactory implements IF_PlayerModeFactory
{
    public IF_Weapon createWeapon()
    {
        return new BeginnerWeapon();
    }

    public IF_Character createCharacter()
    {
        return new BeginnerCharacter();
    }
}
