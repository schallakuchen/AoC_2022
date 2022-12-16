import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class D08 {

    public static void main(String[] args) throws IOException {

        final int SIZE = 99;

        Path filePath = Path.of("./input/D08");
        String input = Files.readString(filePath);
        input = input.replace(System.lineSeparator(), "");

        /* [x][y] */
        int [][] trees = new int[SIZE][SIZE];
        int sum = 0;
        int bestScore = 0;

        for(int y = 0; y < SIZE; y++) {
            for(int x = 0; x < SIZE; x++) {
                trees[y][x] = Integer.parseInt(String.valueOf(input.charAt(y * SIZE + x)));
                //System.out.print(trees[y][x]);
            }
            //System.out.println();
        }

        for(int y = 1; y < SIZE - 1; y++) {
            for(int x = 1; x < SIZE - 1; x++) {
                //System.out.print((trees[y][x]));
                int invisible = 0;
                int right;
                int down;
                int left;
                int up;

                for(right = 1; right < SIZE - x; right++) {
                    if(trees[y][x] <= trees[y][x + right]) {
                        invisible++;
                        break;
                    } else if(x + right >= SIZE - 1) break;
                }
                //System.out.println("from " + trees[y][x] + " right " + right);

                for(down = 1; down < SIZE - y; down++) {
                    if(trees[y][x] <= trees[y + down][x]) {
                        invisible++;
                        break;
                    } else if(y + down >= SIZE - 1) break;
                }
                //System.out.println("from " + trees[y][x] + " down " + down);

                for(left = 1; left < x + 1; left++) {
                    if(trees[y][x] <= trees[y][x - left]) {
                        invisible++;
                        break;
                    } else if(x - left <= 0) break;
                }
                //System.out.println("from " + trees[y][x] + " left " + left);

                for(up = 1; up < y + 1; up++) {
                    if(trees[y][x] <= trees[y - up][x]) {
                        invisible++;
                        break;
                    } else if(y - up <= 0) break;
                }
                //System.out.println("from " + trees[y][x] + " up " + up);

                if(invisible < 4) {
                    sum++;
                    //System.out.println(" is visible from " + (4 - invisible) + " sides");
                } else {
                    //System.out.println(" is not visible from any side");
                }
                //System.out.println();

                int score = right * down * left * up;
                if(score > bestScore) {
                    bestScore = score;
                }
            }
        }
        System.out.println("Part 1: " + (sum + (SIZE * 4 - 4)));
        System.out.println("Part 2: " + bestScore);
    }
}
