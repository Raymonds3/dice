public class DiceFactory {

    public static Die makeDie(int sides, int... probabilities){
        Die die = new Die(sides, probabilities);
        return die;
    }
}
