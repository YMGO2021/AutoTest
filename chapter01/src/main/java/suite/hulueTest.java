package suite;

import org.testng.annotations.Test;

public class hulueTest {
    @Test
    public void test01(){
        System.out.println("1111111");
    }
    @Test(enabled = false)
    public void test02(){
        System.out.println("222222");
    }
    @Test(enabled = true)
    public void test03(){
        System.out.println("33333");
    }
}
