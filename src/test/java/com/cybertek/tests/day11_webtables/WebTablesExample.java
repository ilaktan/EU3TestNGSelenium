package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");

    }
    @AfterMethod
    public  void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();



    }
    @Test
    public void test1(){

        WebElement table=driver.findElement(By.xpath("//table[@id='table1']"));

        System.out.println("+++++++++");
        System.out.println(table.getText());
        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));

    }
    @Test
    public void getAllHeaders(){
        //How many columns we have
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println(headers.get(0).getText());

        System.out.println("headers.size() = " + headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }
        System.out.println("+++++++");
        //headers
        WebElement  header = driver.findElement(By.xpath("//table[@id='table1']//thead"));
        System.out.println("header = " + header.getText());
    }
    @Test
    public void printTableSize(){



        //How many columns we have
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        //number of rows
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("allRowsWithHeader.size() = " + allRowsWithHeader.size());

        ////number of rows without header
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("allRowsWithoutHeader.size() = " + allRowsWithoutHeader.size());


    }
    @Test
    public void getRow(){
        //print the second row information
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        System.out.println("allRowsWithoutHeader.size() = " + allRowsWithoutHeader.size());
        System.out.println("allRowsWithoutHeader.get(1).getText() = " + allRowsWithoutHeader.get(1).getText());
        System.out.println("+++++++++");

        WebElement row2=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println("row2.getText() = " + row2.getText());
        System.out.println("+++++++++");

        for (WebElement webElement : allRowsWithoutHeader) {
            System.out.println(webElement.getText());
        }

        System.out.println("+++++++++");
            List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

            for (int i = 1; i <= numRows.size(); i++) {
                WebElement row=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
                System.out.println("row.getText() = " + row.getText());
            }



    }
    @Test
    public void getAllCellInOneRow(){
        List<WebElement>  allCellInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[2]/td"));


        for (WebElement element : allCellInOneRow) {
            System.out.println(element.getText());

        }


    }

    @Test
    public void test11(){
//        List<WebElement>  allCellInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[3]/td"));
//
//        System.out.println(allCellInOneRow.get(4).getText());

        WebElement singleCellJdoeCom=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[5]"));

        System.out.println(singleCellJdoeCom.getText());

        WebElement singleCellFbach=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[3]"));

        System.out.println(singleCellFbach.getText());


    }
    @Test
    public  void printAllCellsByIndex(){
        int rowNumber=getNumberOfRows();
        int colNumber=getNumberOfColumns();
        System.out.println("colNumber = " + colNumber);
        System.out.println("rowNumber = " + rowNumber);

        //nested loop
        for (int i = 1; i <=rowNumber; i++) {


            for (int j = 1; j <=colNumber; j++) {
                WebElement singleCelljdoe=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]"));

                System.out.println(singleCelljdoe.getText());

            }
        }


    }
    @Test
    public void getCellInRelationToAnotherCellInSameRow(){
        String firstName="Jason";

        String xpath="//table[@id='table1']//td[.='"+firstName+"']/../td[3]";
        WebElement email=driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());

    }

    private int getNumberOfColumns() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));

        return headers.size();
    }

    private int getNumberOfRows() {
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        return allRowsWithoutHeader.size();
    }
}
