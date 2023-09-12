import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static final int[][] TEST_CASES = {
            {10, 20, 30, 40},
            {5, 7, 12}
    };

    private static final String[] TEST_CASES_RESULT = {
            "20", "1"
    };

    public static void main(String[] args) {
        for (int i = 0; i < TEST_CASES.length; i++) {
                System.out.println("Test Case " + (i + 1) + " = " + test(TEST_CASES[i], TEST_CASES_RESULT[i]));
        }
        System.out.printf("정답률 = %.3f%%", (correct / TEST_CASES.length * 100));
    }

    private static double correct = 0;


    private static boolean test(int[] input, String result) {
        if (solution(input).equals(result)) {
            correct++;
            return true;
        }

        return false;
    }


    public static int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return gcd(num2, num1 % num2);
        }
    }


    public static String solution(int[] input) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                list.add(gcd(input[i], input[j]));
            }
        }
        Collections.sort(list);

        int max;
        max = list.get(list.size() - 1);

        return String.valueOf(max);
    }

}
