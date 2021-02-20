
public class TestPlayer {
    private BeginnerMode beginnerMode;





    //super help-desk class
    public static class PlayerMaker
    {
        public enum PlayerModeType{
            BEGINNER, INTERMEDIATE, ADVANCED
        }

        public static PlayerModeFactory makePlayerModeFactory(PlayerModeType type){
            switch (type){
                case BEGINNER:
                    return new CharacterFactory();
                case INTERMEDIATE:

            }
        }
    }
}
