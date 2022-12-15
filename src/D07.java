import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class D07 {
    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("./input/D07");
        String input = Files.readString(filePath);

        ArrayList<String> dirStack = new ArrayList<>();
        HashMap<String, Integer> dirSizes = new HashMap<>();

        int sumPart1 = 0;

        int papagai = 0;
        for(String line : input.split(System.lineSeparator())) {
            String[] words = line.split(" ");
            if(words[0].equals("$")) {
                if(words[1].equals("cd")) {
                    if(words[2].equals("..")) {
                        //Go one directory up
                        dirStack.remove(dirStack.size() - 1);
                    } else {
                        //Rename folder if it already exists in map
                        if(dirSizes.containsKey(words[2])) {
                            words[2] += String.valueOf(papagai);
                            papagai++;
                        }
                        //Add to directory list and open directory
                        dirSizes.putIfAbsent(words[2], 0);
                        dirStack.add(words[2]);
                    }
                } else if(words[1].equals("ls")) {  // Could be removed
                    //Do nothing - elements will follow
                }
            } else if (words[0].equals("dir")) {    // Could be removed when identifying a file by numeric start
                //Do nothing because it's size is 0, and you navigate to it later anyway
            } else {
                for(String dir : dirStack) {
                    dirSizes.replace(dir, dirSizes.get(dir) + Integer.parseInt(words[0]));
                }
            }
        }

        for(int size : dirSizes.values()) {
            if(size <= 100000) sumPart1 += size;
        }

        int toDeleteSize = 30000000 - (70000000 - dirSizes.get("/"));

        List<Integer> list = new ArrayList<>(dirSizes.values());
        Collections.sort(list);
        for(int size : list) {
            if(size >= toDeleteSize) {
                System.out.println("Part 2: " + size);
                break;
            }
        }
        System.out.println("Part 1: " + sumPart1);
    }
}