import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * created by bnorbert on 31,10,2017
 * bnorbertcristian@gmail.com
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        FiniteAutomata finiteAutomata = new FiniteAutomata();

        boolean goOn = true;
        while (goOn) {

            System.out.println(menu());
            String opt = scanner.nextLine();
            switch (opt) {
                case "0":
                    goOn = false;
                    break;
                case "1":
                    System.out.println(finiteAutomata.toString());
                    break;
                case "2":
                    System.out.println("Please insert a sequence (delimited by space):");
                    String seq = scanner.nextLine();
                    List sequenceList = Arrays.stream(seq.split(" ")).collect(Collectors.toList());
                    System.out.println(String.format("The sequence is %b", finiteAutomata.testSequence(sequenceList)));
                    break;
                default:
                    System.out.println("Not valid option!");
            }
        }
    }

    private static String menu(){

        return new StringBuilder()
                .append("0. Exit\n")
                .append("1. Display automata state\n")
                .append("2. Test a sequence\n")
                .append("Insert your option:")
                .toString();
    }

}
