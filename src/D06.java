import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class D06 {

    public static void main (String[] args) throws IOException {

        Path filePath = Path.of("./input/D06");
        String input = Files.readString(filePath);

        Queue<Character> queue = new ConcurrentLinkedQueue<>();
        int sopMarkerPosition = 0;
        int sofMarkerPosition = 0;

        /* Part 1 */
        for(char c : input.toCharArray()) {
            queue.add(c);
            if(queue.size() > 4) queue.poll();
            sopMarkerPosition ++;
            HashSet<Character> set = new HashSet<>(queue);
            if(set.size() == 4) break;
            else set.clear();
        }

        /* Part 2 */
        for(char c : input.toCharArray()) {
            queue.add(c);
            if(queue.size() > 14) queue.poll();
            sofMarkerPosition ++;
            HashSet<Character> set = new HashSet<>(queue);
            if(set.size() == 14) break;
            else set.clear();
        }

        System.out.println("Part 1: " + sopMarkerPosition);
        System.out.println("Part 2: " + sofMarkerPosition);

    }
}
