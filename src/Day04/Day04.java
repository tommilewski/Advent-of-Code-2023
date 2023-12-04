package Day04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Day04 {

    public static void main(String[] args) throws IOException {
        int sum = 0;
        int sum2 = 0;
        try ( BufferedReader br = new BufferedReader(new FileReader("src/Day04/Day04-input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                sum += part1(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(sum);
        System.out.println(sum2);
    }

    private static int part1(String line) {
        String[] arr = line.split("[:|] ");

        String[] winNumbers = arr[1].split(" ");
        List<Integer> winningNumbers =
                    Arrays.stream(winNumbers)
                            .filter(s -> !s.equals(""))
                            .map(Integer::parseInt).toList();

        String[] userNumber = arr[2].split(" ");

        List<Integer> userNumbers =
                Arrays.stream(userNumber)
                        .filter(s -> !s.equals(""))
                        .map(Integer::parseInt).toList();

        int counter = 0;
        for (Integer number : userNumbers) {
            for (Integer winningNumber : winningNumbers) {
                if (number == winningNumber) counter++;
            }
        }
        return counter == 0 ? 0 : (int) Math.pow(2, counter - 1);
    }


    private static int part2(String line) {
        String[] arr = line.split("[:|] ");

        String[] winNumbers = arr[1].split(" ");
        List<Integer> winningNumbers =
                Arrays.stream(winNumbers)
                        .filter(s -> !s.equals(""))
                        .map(Integer::parseInt).toList();

        String[] userNumber = arr[2].split(" ");

        List<Integer> userNumbers =
                Arrays.stream(userNumber)
                        .filter(s -> !s.equals(""))
                        .map(Integer::parseInt).toList();

        int counter = 0;
        for (Integer number : userNumbers) {
            for (Integer winningNumber : winningNumbers) {
                if (number == winningNumber) counter++;
            }
        }
        return counter;
    }
}
