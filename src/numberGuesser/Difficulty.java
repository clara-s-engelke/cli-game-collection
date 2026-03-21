package numberGuesser;

public enum Difficulty {
    EASY{
        @Override
        public int getMaxNum() {
            return 50;
        }
        @Override
        public int getMaxTries() {
            return 15;
        }
    },
    NORMAL{
        @Override
        public int getMaxNum() {
            return 100;
        }
        @Override
        public int getMaxTries() {
            return 10;
        }
    },
    HARD{
        @Override
        public int getMaxNum() {
            return 1000;
        }
        @Override
        public int getMaxTries() {
            return 10;
        }
    },
    IMPOSSIBLE{
        @Override
        public int getMaxNum() {
            return 1000;
        }
        @Override
        public int getMaxTries() {
            return 5;
        }
    };

    public abstract int getMaxTries();
    public abstract int getMaxNum();
}
