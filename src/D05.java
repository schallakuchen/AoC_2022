import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class D05 {
    public static void main(String[] args) throws IOException {

        /* Oh my f***ing god, how could I've been so stupid??
        * Please just store the stacks as Strings and manipulate them */

        Path filePath = Path.of("./input/D05");
        String input = Files.readString(filePath);

        String startingStacks = input.split(System.lineSeparator() + System.lineSeparator())[0];
        String moves = input.split(System.lineSeparator() + System.lineSeparator())[1];

        System.out.println(startingStacks);

        ArrayList<ArrayList<Character>> stackPart1 = new ArrayList<>();
        ArrayList<ArrayList<Character>> stackPart2 = new ArrayList<>();

        ArrayList<Character> templist1 = new ArrayList<>(Arrays.asList('Z', 'J', 'G'));
        ArrayList<Character> templist2 = new ArrayList<>(Arrays.asList('Q','L','R','P','W','F','V','C'));
        ArrayList<Character> templist3 = new ArrayList<>(Arrays.asList('F','P','M','C','L','G','R'));
        ArrayList<Character> templist4 = new ArrayList<>(Arrays.asList('L','F','B','W','P','H','M'));
        ArrayList<Character> templist5 = new ArrayList<>(Arrays.asList('G','C','F','S','V','Q'));
        ArrayList<Character> templist6 = new ArrayList<>(Arrays.asList('W','H','J','Z','M','Q','T','L'));
        ArrayList<Character> templist7 = new ArrayList<>(Arrays.asList('H','F','S','B','V'));
        ArrayList<Character> templist8 = new ArrayList<>(Arrays.asList('F','J','Z','S'));
        ArrayList<Character> templist9 = new ArrayList<>(Arrays.asList('M','C','D','P','F','H','B','T'));

        stackPart1.add(templist1);
        stackPart1.add(templist2);
        stackPart1.add(templist3);
        stackPart1.add(templist4);
        stackPart1.add(templist5);
        stackPart1.add(templist6);
        stackPart1.add(templist7);
        stackPart1.add(templist8);
        stackPart1.add(templist9);

        for(ArrayList<Character> e : stackPart1) {
            stackPart2.add((ArrayList<Character>) e.clone());
        }

        moves = moves.replace("move ", "").replace("from ", "").replace("to ", "");

        for(String move : moves.split(System.lineSeparator())) {
            String[] actions = move.split(" ");
            int amount = Integer.parseInt(actions[0]);
            int from = Integer.parseInt(actions[1]) - 1;
            int to = Integer.parseInt(actions[2]) - 1;

            ArrayList<Character> tempListPart1 = new ArrayList<>();
            ArrayList<Character> tempListPart2 = new ArrayList<>();

            //Part 1
            for(int i = 0; i < amount; i ++) {
                tempListPart1.add(stackPart1.get(from).get(stackPart1.get(from).size() - 1));
                stackPart1.get(from).remove(stackPart1.get(from).size() - 1);
                stackPart1.get(to).add(tempListPart1.get(i));
            }
            tempListPart1.clear();

            // Part 2
            for(int i = 0; i < amount; i ++) {
                tempListPart2.add(stackPart2.get(from).get(stackPart2.get(from).size() - 1));
                stackPart2.get(from).remove(stackPart2.get(from).size() - 1);
            }
            Collections.reverse(tempListPart2);
            for(int i = 0; i < amount; i++) stackPart2.get(to).add(tempListPart2.get(i));
            tempListPart2.clear();

        }

        System.out.print("Part 1: ");
        for(int i = 0; i < 9; i++) {
            System.out.print(stackPart1.get(i).get(stackPart1.get(i).size() - 1));
        }
        System.out.println();

        System.out.print("Part 2: ");
        for(int i = 0; i < 9; i++) {
            System.out.print(stackPart2.get(i).get(stackPart2.get(i).size() - 1));
        }
        System.out.println();
    }
}
