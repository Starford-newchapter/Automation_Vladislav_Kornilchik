package Lecture_10;

import org.testng.annotations.*;

public class Lecure_10 {

    @BeforeSuite(groups = "Smoke")
    public void beforeSuite() {
        System.out.println("BeforeSuite");
    }

    @BeforeClass(groups = "Smoke")
    public void beforeClass() {
        System.out.println("BeforeClass");
    }

    @BeforeTest(groups = "Smoke")
    public void beforeTest() {
        System.out.println("BeforeTest");
    }

    @BeforeGroups(groups = {"Smoke"})
    public void beforeGroup() {
        System.out.println("BeforeGroup");
    }

    @BeforeMethod(groups = "Smoke")
    public void beforeMethod() {
        System.out.println("BeforeMethod");
    }

    @Test(groups = {"Smoke"})
    public void test1() {
        System.out.println("Test1");
    }

    @AfterSuite(groups = "Smoke")
    public void AfterSuite() {
        System.out.println("AfterSuite");
    }

    @AfterSuite(groups = "Smoke")
    public void AfterClass() {
        System.out.println("AfterClass");
    }

    @AfterTest(groups = "Smoke")
    public void AfterTest() {
        System.out.println("AfterTest");
    }

    @AfterGroups(groups = {"Smoke"})
    public void AfterGroup() {
        System.out.println("AfterGroup");
    }

    @AfterMethod(groups = "Smoke")
    public void AfterMethod() {
        System.out.println("AfterMethod");
    }

}
