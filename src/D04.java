import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class D04 {
    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("./input/D04");
        String input = Files.readString(filePath);

        int sumOfFullyContains = 0;
        int sumOfOverlaps = 0;

        for (String pair : input.split(System.lineSeparator())) {
            String[] sections = pair.split(",");
            int[] limitsSection1 = {Integer.parseInt(sections[0].split("-")[0]), Integer.parseInt(sections[0].split("-")[1])};
            int[] limitsSection2 = {Integer.parseInt(sections[1].split("-")[0]), Integer.parseInt(sections[1].split("-")[1])};

            /* Part 1 */
            if(limitsSection1[0] <= limitsSection2[0] && limitsSection1[1] >= limitsSection2[1]) sumOfFullyContains ++;
            else if (limitsSection1[0] >= limitsSection2[0] && limitsSection1[1] <= limitsSection2[1]) sumOfFullyContains ++;

            /* Part 2 */
            if(limitsSection1[1] >= limitsSection2[0] && limitsSection1[0] <= limitsSection2[1]) sumOfOverlaps ++;
        }

        System.out.println("Part1: " + sumOfFullyContains);
        System.out.println("Part2: " + sumOfOverlaps);
    }
}