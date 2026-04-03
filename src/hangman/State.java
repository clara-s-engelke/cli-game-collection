package hangman;

public enum State {
    RUNNING{
        @Override
        public String message() {
            return "You can do it, I know it!";
        }
    },
    WON{
        @Override
        public String message() {
            return "Congratulations, you guessed it!";
        }
    },
    LOST{
        @Override
        public String message() {
            return "What a shame, you didnt guess it this time :(";
        }
    };

    public abstract String message();
}
