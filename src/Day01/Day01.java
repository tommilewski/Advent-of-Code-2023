package Day01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Character.isDigit;

public class Day01 {

    public static void main(String[] args) throws IOException {
        int sum = 0;
        int sum2 = 0;
        try ( BufferedReader br = new BufferedReader(new FileReader("src/Day01/Day01-input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                sum += getNumber(line);
                sum2 += changeStringToNumber(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(sum);
        System.out.println(sum2);
    }

    private static int getNumber(String line) {
        String number = "";

        for (int i = 0; i < line.length(); i++) {
            if (isDigit(line.charAt(i))) {
                number += line.charAt(i);
                break;
            }
        }

        for (int i = line.length() - 1; i >= 0; i--) {
            if (isDigit(line.charAt(i))) {
                number += line.charAt(i);
                break;
            }
        }
        return Integer.parseInt(number);
    }

    private static int changeStringToNumber(String line) {
        Map<String, String> digits = new HashMap<>();
        digits.put("one", "1");
        digits.put("two", "2");
        digits.put("three", "3");
        digits.put("four", "4");
        digits.put("five", "5");
        digits.put("six", "6");
        digits.put("seven", "7");
        digits.put("eight", "8");
        digits.put("nine", "9");

        StringBuilder word;

        List<String> numbers = new ArrayList<>();

        for (int i = 0; i < line.length() - 1; i++) {
            word = new StringBuilder();
            word.append(line.charAt(i));

            if (isDigit(line.charAt(i))) {
                numbers.add(String.valueOf(line.charAt(i)));
            }

            for (int j = i + 1; j < line.length(); j++) {
                word.append(line.charAt(j));
                if (digits.containsKey(word.toString())) {
                    numbers.add(digits.get(word.toString()));
                    break;
                }
            }
        }
        if (isDigit(line.charAt(line.length() - 1))) {
            numbers.add(String.valueOf(line.charAt(line.length() - 1)));
        }
        return Integer.parseInt(numbers.get(0) + numbers.get(numbers.size() - 1));
    }
}
