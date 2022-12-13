import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;

public class D03 {
    /* I know the way I solved this is ugly */

    public static void main (String[] args) throws IOException {

        Path filePath = Path.of("./input/D03");
        String input = Files.readString(filePath);

        int sumOfPriorities_part1 = 0;
        int sumOfPriorities_part2 = 0;

        HashSet <Character> itemIntersection1 = new HashSet<>();
        HashSet <Character> itemIntersection2 = new HashSet<>();

        int i = 0;
        char badge = '0';

        for (String line : input.split(System.lineSeparator())) {

            /* Part 1 */
            int lineLength = line.length();
            String compartment1 = line.substring(0, lineLength / 2);
            String compartment2 = line.substring(lineLength / 2);

            HashSet <Character> compartment1Items = new HashSet<>();
            HashSet <Character> compartment2Items = new HashSet<>();

            System.out.println(compartment1 + " | " + compartment2);

            char commonItem = '0';

            for (char item : compartment1.toCharArray()) {
                compartment1Items.add(item);
            }
            for (char item : compartment2.toCharArray()) {
                compartment2Items.add(item);
                if(compartment1Items.contains(item)) commonItem = item;
            }

            System.out.println(commonItem);

            if(commonItem >= 97) sumOfPriorities_part1 = sumOfPriorities_part1 + commonItem - 96;
            else sumOfPriorities_part1 = sumOfPriorities_part1 + commonItem -38;

            /* Part 2 */
            switch (i % 3) {
                case 0:
                    itemIntersection1.clear();
                    itemIntersection2.clear();
                    for (char item : line.toCharArray()) {
                        itemIntersection1.add(item);
                    }
                    break;
                case 1:
                    for (char item : line.toCharArray()) {
                        if (itemIntersection1.contains(item)) itemIntersection2.add(item);
                    }
                    break;
                case 2:
                    for (char item : line.toCharArray()) {
                        if (itemIntersection2.contains(item)) badge = item;
                    }
                    if(badge >= 97) sumOfPriorities_part2 = sumOfPriorities_part2 + badge - 96;
                    else sumOfPriorities_part2 = sumOfPriorities_part2 + badge -38;
                    break;
            }

            System.out.println(badge);

            i++;
        }
        System.out.println("Part 1: " + sumOfPriorities_part1);
        System.out.println("Part 2: " + sumOfPriorities_part2);

    }
}
