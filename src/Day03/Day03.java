package Day03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isDigit;

public class Day03 {

    public static void main(String[] args) throws IOException {
        List<String> arr = new ArrayList<>();
        int sum = 0;
        int sum2 = 0;
        try ( BufferedReader br = new BufferedReader(new FileReader("src/Day03/Day03-input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                arr.add(line);
            }
            sum += part1(arr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(sum + 452 + 489);
        System.out.println(sum2);
    }

    private static int part1(List<String> arr) {
        int i = 0;
        int j;
        int sum = 0;
        List<Integer> ints = new ArrayList<>();
        while (i < arr.size()) {
            j = 0;
            while (j < arr.get(i).length()) {
                if (!ints.isEmpty()) {
                    for (int k = 0; k < ints.size(); k++) {
                        if (isNeighbour(i,ints.get(k),arr)) {
                            StringBuilder number = new StringBuilder();
                            for (Integer integer : ints) {
                                number.append(arr.get(i).charAt(integer));
                            }
                            if (number.toString().equals("...")) System.out.println(ints + " " + i);
                            if  (!number.toString().equals("...")) {
                                sum += Integer.parseInt(number.toString());
                            }
                            break;
                        }
                    }
                }
                if (isDigit(arr.get(i).charAt(j))) {
                    while (j < arr.get(i).length() && isDigit(arr.get(i).charAt(j))) {

                        ints.add(j);
                        j++;
                    }
                } else {
                    ints.clear();
                    j++;
                }
            }
            i++;
        }
        return sum;
    }

    private static boolean isNeighbour(int i, int j, List<String> arr) {
        int maxRows = arr.size();
        int maxCols = arr.get(0).length();

        if (i > 0 && j > 0) {
            if (arr.get(i - 1).charAt(j - 1) != '.' && !isDigit(arr.get(i - 1).charAt(j - 1))) {
                return true;
            }
        }
        if (i > 0) {
            if (arr.get(i - 1).charAt(j) != '.' && !isDigit(arr.get(i - 1).charAt(j))) {
                return true;
            }
        }
        if (i > 0 && j < maxCols - 1) {
            if (arr.get(i - 1).charAt(j + 1) != '.' && !isDigit(arr.get(i - 1).charAt(j + 1))) {
                return true;
            }
        }
        if (j > 0) {
            if (arr.get(i).charAt(j - 1) != '.' && !isDigit(arr.get(i).charAt(j - 1))) {
                return true;
            }
        }
        if (j < maxCols - 1) {
            if (arr.get(i).charAt(j + 1) != '.' && !isDigit(arr.get(i).charAt(j + 1))) {
                return true;
            }
        }
        if (i < maxRows - 1 && j > 0) {
            if (arr.get(i + 1).charAt(j - 1) != '.' && !isDigit(arr.get(i + 1).charAt(j - 1))) {
                return true;
            }
        }
        if (i < maxRows - 1) {
            if (arr.get(i + 1).charAt(j) != '.' && !isDigit(arr.get(i + 1).charAt(j))) {
                return true;
            }
        }
        if (i < maxRows - 1 && j < maxCols - 1) {
            if (arr.get(i + 1).charAt(j + 1) != '.' && !isDigit(arr.get(i + 1).charAt(j + 1))) {
                return true;
            }
        }
        return false;
    }
}
