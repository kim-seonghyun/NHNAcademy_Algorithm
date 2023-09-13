

public class 소인수분해 {

    public static void main(String[] args) {
        System.out.println(soinsu(1234567890, 2, new StringBuilder()).toString());
    }

    private static double correct = 0;

    public static StringBuilder soinsu(int n, int i, StringBuilder sb) {
        if (n == 1) {
            return sb;
        }
        if (n % i == 0) {
            sb.append(i).append(" ");
            return soinsu(n / i, 2, sb);
        } else {
            i += 1;
            return soinsu(n, i, sb);
        }
    }
}
