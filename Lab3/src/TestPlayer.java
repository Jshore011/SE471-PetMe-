
public class TestPlayer {
    private BeginnerMode beginnerMode;





    //super help-desk class
    public static class PlayerMaker {
        public enum PlayerModeType{
            BEGINNER, INTERMEDIATE, ADVANCED
        }

        public static PlayerModeFactory makePlayerModeFactory(PlayerModeType type){
            switch (type){
                case BEGINNER:
                    return new BeginnerFactory();
                case INTERMEDIATE:
                    return new IntermediateFactory();
                case ADVANCED:
                    return new AdvancedFactory();
                default:
                    throw new IllegalArgumentException("Player Mode does not exist. Enter valid mode.")
            }
        }
    }

    public static void main(String[] args) {

        TestPlayer app = new TestPlayer();

        System.out.println("Beginner Mode");
        app.createPlayer(PlayerMaker.makePlayerModeFactory(PlayerMaker.PlayerModeType.BEGINNER));
        System.out.println(app.getWeapon().getDescription());
        System.out.println(app.getCharacter().getDescription());

        System.out.println("Intermediate Mode");
        app.createPlayer(PlayerMaker.makePlayerModeFactory(PlayerMaker.PlayerModeType.INTERMEDIATE));
        System.out.println(app.getWeapon().getDescription());
        System.out.println(app.getCharacter().getDescription());

        System.out.println("Advanced Mode");
        app.createPlayer(PlayerMaker.makePlayerModeFactory(PlayerMaker.PlayerModeType.ADVANCED));
        System.out.println(app.getWeapon().getDescription());
        System.out.println(app.getCharacter().getDescription());
    }
}
