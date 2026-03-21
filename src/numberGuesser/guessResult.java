package numberGuesser;

public enum guessResult {
    TOO_SMALL{
      public String print(){
          return "Too small!";
      }
    },
    TOO_BIG{
        public String print(){
            return "Too big!";
        }
    },
    CORRECT{
        public String print(){
            return "Correct- you win!";
        }
    }, ;

    public abstract String print();
}

