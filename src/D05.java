import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class D05 {
    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("./input/D05");
        String input = Files.readString(filePath);

        String startingStacks = input.split(System.lineSeparator() + System.lineSeparator())[0];
        String moves = input.split(System.lineSeparator() + System.lineSeparator())[1];

        System.out.println(startingStacks);

        ArrayList<ArrayList<Character>> stack = new ArrayList<>();

        ArrayList<Character> templist1 = new ArrayList<>(Arrays.asList('Z', 'J', 'G'));
        ArrayList<Character> templist2 = new ArrayList<>(Arrays.asList('Q','L','R','P','W','F','V','C'));
        ArrayList<Character> templist3 = new ArrayList<>(Arrays.asList('F','P','M','C','L','G','R'));
        ArrayList<Character> templist4 = new ArrayList<>(Arrays.asList('L','F','B','W','P','H','M'));
        ArrayList<Character> templist5 = new ArrayList<>(Arrays.asList('G','C','F','S','V','Q'));
        ArrayList<Character> templist6 = new ArrayList<>(Arrays.asList('W','H','J','Z','M','Q','T','L'));
        ArrayList<Character> templist7 = new ArrayList<>(Arrays.asList('H','F','S','B','V'));
        ArrayList<Character> templist8 = new ArrayList<>(Arrays.asList('F','J','Z','S'));
        ArrayList<Character> templist9 = new ArrayList<>(Arrays.asList('M','C','D','P','F','H','B','T'));

        stack.add(templist1);
        stack.add(templist2);
        stack.add(templist3);
        stack.add(templist4);
        stack.add(templist5);
        stack.add(templist6);
        stack.add(templist7);
        stack.add(templist8);
        stack.add(templist9);

        System.out.println(stack);

        moves = moves.replace("move ", "").replace("from ", "").replace("to ", "");
        //System.out.println(moves);

        for(String move : moves.split(System.lineSeparator())) {
            String[] actions = move.split(" ");
            int amount = Integer.parseInt(actions[0]);
            int from = Integer.parseInt(actions[1]) - 1;
            int to = Integer.parseInt(actions[2]) - 1;


            ArrayList<Character> tempList = new ArrayList<>();
            /* //Part 1
            for(int i = 0; i < amount; i ++) {
                tempList.add(stack.get(from).get(stack.get(from).size() - 1));
                stack.get(from).remove(stack.get(from).size() - 1);
                stack.get(to).add(tempList.get(i));
            }
             */
            // Part 2
            for(int i = 0; i < amount; i ++) {
                tempList.add(stack.get(from).get(stack.get(from).size() - 1));
                stack.get(from).remove(stack.get(from).size() - 1);
            }
            Collections.reverse(tempList);
            for(int i = 0; i < amount; i++) stack.get(to).add(tempList.get(i));
            tempList.clear();

            System.out.println(stack);
            System.out.println();
        }

        for(int i = 0; i < 9; i++) {
            System.out.print(stack.get(i).get(stack.get(i).size() - 1));
        }
    }
}
