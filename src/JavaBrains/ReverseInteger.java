package JavaBrains;

public class ReverseInteger {

    public static void main(String[] args) {
        int resp =  reverseInteger(123456789);
        System.out.println(resp);
    }

    private static int reverseInteger(int number) {
        int reversed = 0;
        while (number != 0) {
            reversed = reversed * 10 + number % 10 ;
            number /= 10;
            if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE)
                return 0;
        }
        return reversed;
    }
}
