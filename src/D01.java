import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class D01 {

    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("./input/D01");
        String input = Files.readString(filePath);
        int top3Calories = 0;

        ArrayList<Integer> elveCalories = new ArrayList<>();

        for(String elve : input.split(System.lineSeparator() + System.lineSeparator())) {
            int calories = 0;
            for(String line : elve.split(System.lineSeparator())) {
                calories += Integer.parseInt(line);
            }
            elveCalories.add(calories);
        }

        elveCalories.sort(Collections.reverseOrder());
        top3Calories = top3Calories + elveCalories.get(0) + elveCalories.get(1) + elveCalories.get(2);

        System.out.println("Part 1: " + elveCalories.get(0));
        System.out.println("Part 2: " + top3Calories);
    }
}
