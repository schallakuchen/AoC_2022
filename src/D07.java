import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class D07 {
    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("./input/D07_test");
        String input = Files.readString(filePath);

        ArrayList<String> dirStack = new ArrayList<>();
        HashMap<String, Integer> dirSizes = new HashMap<>();

        int sum = 0;

        for(String line : input.split(System.lineSeparator())) {
            String[] words = line.split(" ");
            if(words[0].equals("$")) {
                if(words[1].equals("cd")) {
                    if(words[2].equals("..")) {
                        //Go one directory up
                        dirStack.remove(dirStack.size() - 1);
                    } else {
                        //Add to directory list and open directory
                        dirSizes.putIfAbsent(words[2], 0);
                        dirStack.add(words[2]);
                    }
                } else if(words[1].equals("ls")) {
                    //Do nothing - elements will follow
                }
            } else if (words[0].equals("dir")) {
                //Do nothing because it's size is 0, and you navigate to it later anyway
            } else {
                for(String dir : dirStack) {
                    dirSizes.replace(dir, dirSizes.get(dir) + Integer.parseInt(words[0]));
                }
            }
            //System.out.println(dirStack);
        }

        for(int size : dirSizes.values()) {
            if(size <= 100000) sum += size;
        }

        //ArrayList<Integer> sorted = new ArrayList<>(dirSizes.values());
        //Collections.sort(sorted);
        System.out.println(dirSizes);
        //System.out.println(sorted);
        System.out.println(sum);
    }
}