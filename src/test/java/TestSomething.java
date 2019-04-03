import org.testng.annotations.Test;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TestSomething {
    @Test
    public void test(){
        NumericTest isEven = n -> System.out.println(String.valueOf(n));
        NumericTest isNegative = n -> System.out.println(String.valueOf(n + "haha"));

        isEven.computeTest(5);
        isNegative.computeTest(10);
    }
}

interface NumericTest {
    void computeTest(int n);
}