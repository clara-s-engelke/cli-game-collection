package numberGuesser;

public enum Difficulty {
    EASY(50, 15),
    NORMAL(100, 10),
    HARD(1000, 10),
    IMPOSSIBLE(1000, 5);

    private final int maxNum;
    private final int maxTries;

    Difficulty(int maxNum, int maxTries) {
        this.maxNum = maxNum;
        this.maxTries = maxTries;
    }

    public int getMaxTries() {
        return maxTries;
    }

    public int getMaxNum() {
        return maxNum;
    }
}
