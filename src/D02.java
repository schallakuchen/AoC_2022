import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class D02 {

    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("./input/D02");
        String input = Files.readString(filePath);
        int score = 0;

        for(String line : input.split(System.lineSeparator())) {
            String enemy = line.split(" ")[0];
            String you = line.split(" ")[1];
            switch(enemy) {
                case "A":   //Rock
                    if (you.equals("X")) score += 3;
                    else if (you.equals("Y")) score += 6;
                    break;
                case "B":   //Paper
                    if (you.equals("Y")) score += 3;
                    else if (you.equals("Z")) score += 6;
                    break;
                case "C":   //Scissors
                    if (you.equals("Z")) score += 3;
                    else if (you.equals("X")) score += 6;
                    break;
            }
            switch (you) {
                case "X" -> score += 1;
                case "Y" -> score += 2;
                case "Z" -> score += 3;
            }
        }

        System.out.println(score);
    }
}
