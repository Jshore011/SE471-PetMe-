public class CharacterFactory implements PlayerModeFactory {

    public BeginnerMode createBeginner() { return new BeginnerCharacter(); }

    public IntermediateMode createIntermediate() { return new IntermediateCharacter(); }

    public AdvancedMode createAdvanced() { return new AdvancedCharacter(); }

}
