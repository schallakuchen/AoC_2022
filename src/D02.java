import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class D02 {
    /* I know the way I solved this is ugly */

    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("./input/D02");
        String input = Files.readString(filePath);
        int part1Score = 0;
        int part2Score = 0;

        for(String line : input.split(System.lineSeparator())) {
            String enemy = line.split(" ")[0];
            String you = line.split(" ")[1];
            switch (enemy) {
                case "A" -> {   //Rock
                    if (you.equals("X")) part1Score += 3;
                    else if (you.equals("Y")) part1Score += 6;
                    switch (you) {
                        case "X" -> part2Score += 3;
                        case "Y" -> part2Score = part2Score + 1 + 3;
                        case "Z" -> part2Score = part2Score + 2 + 6;
                    }
                }
                case "B" -> {   //Paper
                    if (you.equals("Y")) part1Score += 3;
                    else if (you.equals("Z")) part1Score += 6;
                    switch (you) {
                        case "X" -> part2Score += 1;
                        case "Y" -> part2Score = part2Score + 2 + 3;
                        case "Z" -> part2Score = part2Score + 3 + 6;
                    }
                }
                case "C" -> {   //Scissors
                    if (you.equals("Z")) part1Score += 3;
                    else if (you.equals("X")) part1Score += 6;
                    switch (you) {
                        case "X" -> part2Score += 2;
                        case "Y" -> part2Score = part2Score + 3 + 3;
                        case "Z" -> part2Score = part2Score + 1 + 6;
                    }
                }
            }
            switch (you) {
                case "X" -> part1Score += 1;
                case "Y" -> part1Score += 2;
                case "Z" -> part1Score += 3;
            }
        }

        System.out.println("Part 1: " + part1Score);
        System.out.println("Part 2: " + part2Score);
    }
}
