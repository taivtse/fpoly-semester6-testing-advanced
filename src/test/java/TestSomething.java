import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.Date;

public class TestSomething {
    @Test
    public void test(){
        Timestamp a = new Timestamp(System.currentTimeMillis());
        System.out.println(new Date(a.getTime()));
    }
}
