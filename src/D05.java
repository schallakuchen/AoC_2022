import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class D05 {
    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("./input/D05_test");
        String input = Files.readString(filePath);

        String startingStacks = input.split(System.lineSeparator() + System.lineSeparator())[0];
        String moves = input.split(System.lineSeparator() + System.lineSeparator())[1];

        System.out.println(startingStacks);

        moves = moves.replace("move ", "").replace("from ", "").replace("to ", "");
        System.out.println(moves);

        for(String move : moves.split(System.lineSeparator())) {
            String[] actions = move.split(" ");
            int amount = Integer.parseInt(actions[0]);
            int from = Integer.parseInt(actions[1]);
            int to = Integer.parseInt(actions[2]);
        }
    }
}
