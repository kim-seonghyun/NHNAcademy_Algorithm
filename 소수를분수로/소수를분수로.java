import java.math.BigDecimal;



public class 소수를분수로 {

    public static class Fraction {

        @Override
        public String toString() {
            if(getNumerator() <0 ^ getDenominator() < 0){
                return "-" +  Math.abs(getNumerator()) + "/"+ Math.abs(getDenominator()) ;
            }else{
                return getNumerator() + "/" + getDenominator();
            }
        }

        private int numerator;  // 분자
        private int denominator;    // 분모

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;

            normalize();
        }

        public int getNumerator() {
            return numerator;
        }

        public int getDenominator() {
            return denominator;
        }


        public void normalize() {
            int gcd = gcd(getDenominator(), getNumerator());
            this.denominator /= gcd;
            this.numerator /= gcd;
        }


    }

    public static int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return gcd(num2, num1 % num2);
        }
    }

    /**
     * 소수점 값에 대해 자리 수 계산 하는 메서드.    <br/>
     * ex)  <br/>
     * 0.01 -> 100을 곱하기 위해 2를 return    <br/>
     * 0.1 -> 10을 곱하기 위해 1을 return
     *
     * @param num 소수 값
     * @return 소수점 이하 자리 수 값
     */
    public static int getDecimalNumber(BigDecimal num) {
        String str = num.toPlainString();
        String[] array = str.split("\\. ");
        return array[1].length();
    }

    public static String solution(String input) {

        BigDecimal number = new BigDecimal(input);
        int decimalNumber = getDecimalNumber(number);
        double denominator = Math.pow(10, decimalNumber);

        int numerator = (int) (number.doubleValue() * denominator) ;

        return new Fraction(numerator, (int) denominator).toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("0.01"));
        System.out.println(solution("0.25"));
        System.out.println(solution("0.125"));
        System.out.println(solution("0.1"));
        System.out.println(solution("-0.01"));
        System.out.println(solution("-0.25"));
        System.out.println(solution("-0.125"));
    }

}