import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class D09 {
    public static void main(String[] args) throws IOException {

        final int SIZE = 100;

        Path filePath = Path.of("./input/D07");
        String input = Files.readString(filePath);

        char[][] map = new char[SIZE][SIZE];

        Coordinate start = new Coordinate(0, SIZE - 1);
        Coordinate head = new Coordinate(start);
        Coordinate tail = new Coordinate(start);

        for(int y = 1; y < SIZE - 1; y++) {
            for (int x = 1; x < SIZE - 1; x++) {
                map[y][x] = '.';
                System.out.print(map[y][x]);
            }
            System.out.println();
        }
        map[start.y][start.x] = 's';

        System.out.println(start);
        System.out.println(head);
        System.out.println(tail);

    }

    public static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Coordinate(Coordinate p) {
            this.x = p.x;
            this.y = p.y;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public void set(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Coordinate that = (Coordinate) o;

            if (x != that.x) return false;
            return y == that.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
