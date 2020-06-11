import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Die {

    private int sides;
    private int value;
    private int[] probabilities;

    private static final Logger logger = LogManager.getLogger(Die.class.getName());

    public Die(int dieSides, int... dieProbabilities) {
        this.sides = dieSides;
        this.probabilities = dieProbabilities;
        this.value = 1;
    }

    public void setProbabilities(){
        if (probabilities == null){
            probabilities = new int[]{1,1,1,1,1,1};
        }
        if (!(probabilities == null)){
            for (int probability : probabilities){
                if (probability < 0){
                    logger.error("negative probabilities not allowed");
                }
                if (probability < 1){
                    logger.error("probability sum must be greater than 0");
                }
            }
        }
        double[] numbers = {};
        int probabilitie = 0;
        for (int prob : probabilities) {
            probabilitie = probabilitie + prob;
        }
        double finalNum = 0;
        for (int i : probabilities) {
            double number = i/probabilitie;
            if (number<0){
                numbers[i] = number;
            }else{
                continue;
            }
        }
        for (double num : numbers) {
            finalNum = finalNum + num;
        }
    }

    public void roll() {
        value = ((int) (Math.random() * sides)) + 1;
    }

    public static void main(String[] args){

        Die die6 = new Die(6, new int[]{1,1,1,1,1,2});
        die6.roll();

        System.out.println(die6.value);

        Die die20 = DiceFactory.makeDie(20);
        die20.roll();

        Die anotherDie20 = DiceFactory.makeDie(20);
        anotherDie20.roll();

        System.out.println(die20.value);
        System.out.println(anotherDie20.value);
    }
}
