package suite;

import org.testng.annotations.*;

public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("suite之前");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("suite之后");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Test执行之前");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("Test执行之后");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Method执行之前");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("Method执行之后");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("类执行之前");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("类执行之后");
    }
    @Test
    public void test01(){
        System.out.println("99999999999");
    }

}
