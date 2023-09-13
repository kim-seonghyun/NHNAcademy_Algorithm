
public class 최소공배수 {
    private static final int[][] TEST_CASES = {
            {1, 1},
            {98, 49},
            {2, 81},
            {3, 7},
            {19, 87},
            {1, 40}
    };

    private static final int[] TEST_CASES_RESULT = {
            1, 98
            , 162, 21, 1653, 40
    };

    public static void main(String[] args) {
        for (int i = 0; i < TEST_CASES.length; i++) {
            System.out.println("Test Case " + (i + 1) + " = " + test(TEST_CASES[i], TEST_CASES_RESULT[i]));
        }
        System.out.printf("정답률 = %.3f%%", (correct / TEST_CASES.length * 100));
    }

    private static double correct = 0;


    private static boolean test(int[] input, int result) {
        if (solution(input) == result) {
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


    public static int solution(int[] input) {
        int a = input[0];
        int b = input[1];
        int gcd = gcd(a, b);
        return (a * b)/ gcd;
    }

}

