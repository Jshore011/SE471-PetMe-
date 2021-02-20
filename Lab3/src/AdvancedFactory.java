
public class AdvancedFactory implements IF_PlayerModeFactory
{
    public IF_Weapon createWeapon()
    {
        return new AdvancedWeapon();
    }

    public IF_Character createCharacter()
    {
        return new AdvancedCharacter();
    }
}
