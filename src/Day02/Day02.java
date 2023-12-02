package Day02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day02 {

    public static void main(String[] args) throws IOException {
        int sum = 0;
        int sum2 = 0;
        try ( BufferedReader br = new BufferedReader(new FileReader("src/Day02/Day02-input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                sum += part1(line);
                sum2 += part2(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(5050 - sum);
        System.out.println(sum2);
    }

    private static int part1(String line) {
        Map<String, Integer> allowedBalls = new HashMap<>();
        allowedBalls.put("green", 13);
        allowedBalls.put("blue", 14);
        allowedBalls.put("red", 12);

        String[] lineArr = line.split("[:;] ");
        for (int i = 1; i < lineArr.length; i++) {
            String[] set = lineArr[i].split(", ");
            for (String s : set) {
                String[] game = s.split(" ");
                if (Integer.parseInt(game[0]) > allowedBalls.get(game[1])) {
                    return Integer.parseInt(lineArr[0].split(" ")[1]);
                }
            }
        }
        return 0;
    }

    private static int part2(String line) {
        String[] lineArr = line.split("[:;] ");

        Map<String, Integer> maximum = new HashMap<>();
        maximum.put("blue", 0);
        maximum.put("green", 0);
        maximum.put("red", 0);

        for (int i = 1; i < lineArr.length; i++) {
            String[] set = lineArr[i].split(", ");
            for (String s : set) {
                String[] game = s.split(" ");
                if (maximum.get(game[1]) < Integer.parseInt(game[0])) {
                    maximum.put(game[1], Integer.parseInt(game[0]));
                }
            }
        }

        return maximum
                .values()
                .stream()
                .reduce((integer, integer2) -> integer * integer2)
                .orElse(0);
    }
}
