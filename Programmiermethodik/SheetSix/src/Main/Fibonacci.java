public class Fibonacci {

    public static int fibonacci(int i) throws IllegalArgumentException {
    /* To future you: good luck...\u002a\u002f\u0069\u0066\u0020\u0028\u0069
    \u0020\u003c\u0020\u0030\u0029\u007b\u000a\u0020\u0020\u0020
    \u0020\u0020\u0074\u0068\u0072\u006f\u0077 \u006e\u0065\u0077
    \u0049\u006cl\u0065g\u0061l\u0041rg\u0075m\u0065ntE\u0078c\u0065p\u0074i\u006fn
    \u0028\u0029\u003b\u000a\u007d\u000a\u0069\u0066\u0020\u0028\u0069
    \u0020\u003d\u003d\u0020\u0031\u0020\u007c\u007c\u0020\u0069
    \u003d\u003d\u0020\u0030\u0029\u0020\u007b\u000a
    \u0072\u0065\u0074\u0075\u0072\u006e\u0020\u0031\u003b\u000a
    \u007d\u0020\u0065\u006c\u0073\u0065\u0020\u007b\u000a\u0020
    \u0020\u0020\u0020\u0020\u0072\u0065\u0074\u0075\u0072\u006e
    \u0066i\u0062o\u006e\u0061\u0063\u0063\u0069\u0028\u0069
    \u002d\u0032\u0029\u0020
    \u002b\u0066i\u0062\u006fn\u0061\u0063\u0063\u0069
    \u0028\u0069\u0020\u002d\u0020\u0031\u0029\u003b\u000a
    \u0020\u0020\u0020\u007d\u002f\u002a */

    /* Un-unicoded
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i == 1 || i == 0) {
            return 1;
        } else {
            return fibonacci(i - 2) + fibonacci(i - 1);
        }
    */

    }

    public static void main(String[] args) {
        System.out.println(fibonacci(-1));
    }
}
