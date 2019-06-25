public class Test {
    public static int count(String input) {
        int total = 0;
        int i = 0;
        while (i != -1) {
            i = input.indexOf("$", i);
            int j = input.lastIndexOf(" ", i);
            if (i != -1 && j != -1) {
                int price = Integer.parseInt(input.substring(j + 1, i));
                total += price;
                i++;
            }
        }
        return total;
    }

    public static int fibonacciAt(int n) {
        if (n <= 1){
            return n;
        }

        return fibonacciAt(n - 1) + fibonacciAt(n - 2);
    }

    @org.testng.annotations.Test
    public void test() {
//        int total = Test.count("ahiaih 200$, asdfjkafas 300$, sadfjfa 100$");
//        System.out.println(total);
//        0 1 1 2 3 5
        System.out.println(Test.fibonacciAt(5));
    }
}
