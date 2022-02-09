package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("Chrome");
        //driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

    }
    @AfterMethod
    public  void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();


    }
    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/upload");
        //locating  choose file button
        WebElement chooseFile=driver.findElement(By.name("file"));

        //sending file with sendKeys method
        chooseFile.sendKeys("/Users/ilhanaltan/Desktop/file.txt");
        //clicking uopload button
        driver.findElement(By.id("file-submit")).click();
        //getting the file name from browser
        String actualFileName=driver.findElement(By.id("uploaded-files")).getText();

        //verify file name is file.txt
        Assert.assertEquals(actualFileName,"file.txt");
    }
    @Test
    public  void test7(){
        driver.get("http://practice.cybertekschool.com/upload");
        //locating  choose file button
        WebElement chooseFile=driver.findElement(By.name("file"));

        //sending file with sendKeys method
        chooseFile.sendKeys("/Users/ilhanaltan/Desktop/file.txt");
        System.out.println(System.getProperty("user.dir"));

        String projectPath=System.getProperty("user.dir");
        String filePath="src/test/resources/textfile.txt";
        String fullPath=projectPath+"/"+filePath;
        chooseFile.sendKeys(fullPath);

        //clicking uopload button
        driver.findElement(By.id("file-submit")).click();
        //getting the file name from browser
        String actualFileName=driver.findElement(By.id("uploaded-files")).getText();

        //verify file name is file.txt
        Assert.assertEquals(actualFileName,"textfile.txt");

    }


}

