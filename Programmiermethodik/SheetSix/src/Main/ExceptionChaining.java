public class ExceptionChaining {
    public static void throwSomething(int number) throws Ex1, Ex2, Ex3, Ex4, Ex5, Ex6 {
        switch (number) {
            case 1:
                throw new Ex1();
            case 2:
                throw new Ex2();
            case 3:
                throw new Ex3();
            case 4:
                throw new Ex4();
            case 5:
                throw new Ex5();
            case 6:
                throw new Ex6();
            default:
                throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) throws Ex1, IllegalArgumentException {
        for (int i = 0; i < 7; i++) {
            try {
                throwSomething(i);
            } catch (Ex6 ex6) {
                throw new IllegalArgumentException(ex6);
            } catch (Ex4 ex4) {
                System.out.println("Ex1 or Ex4");
            } catch (Ex2 | Ex5 ex25) {
                System.out.println("Ex2 or Ex5");
            } catch (Ex3 ex3) {
                // shouldn't do anything
            } catch (Ex1 ex1) {
                System.out.println("Ex1 or Ex4");
            } catch (Exception ex) {
                System.out.println("Some other Exception: " + ex);
            }
        }
    }


    private static class Ex1 extends Exception {
    }

    private static class Ex2 extends Ex1 {
    }

    private static class Ex3 extends Ex1 {
    }

    private static class Ex4 extends Ex2 {
    }

    private static class Ex5 extends Ex3 {
    }

    private static class Ex6 extends Ex2 {
    }
}

