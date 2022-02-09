package com.cybertek.tests.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class eu2homework2Guideline {
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
    public  void guidline() throws InterruptedException {
        //Test case #1 Step 1. Go to “https://practice-cybertekschool.herokuapp.com”Step
        // 2. Click on “Registration Form”Step
        // 3. Enter “wrong_dob” into date of birth input box.Step
        // 4. Verify that warning message is displayed: “The date of birth is not valid”

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        WebElement registrationForm=driver.findElement(By.xpath("//*[.='Registration Form']//a"));

        registrationForm.click();
        WebElement dateOfBirth= driver.findElement(By.xpath("//input[@name='birthday']"));

        dateOfBirth.sendKeys("wrong_dob");

        Thread.sleep(2000);
        String Expected="The date of birth is not valid";

        WebElement notValid=driver.findElement(By.xpath("//small[@data-bv-validator=\"date\"]"));
        String Actual=notValid.getText();
        Assert.assertEquals(Actual,Expected);

    }
    @Test
    public void test2(){
       // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”Step
        // 2. Click on “Registration Form”Step
        // 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        WebElement registrationForm=driver.findElement(By.xpath("//*[.='Registration Form']//a"));

        registrationForm.click();
        WebElement cPlusPlus=driver.findElement(By.xpath("//label[@for=\"inlineCheckbox1\"]"));
        String Actual=cPlusPlus.getText();
        Assert.assertEquals("C++",Actual);

        WebElement Java=driver.findElement(By.xpath("//label[@for=\"inlineCheckbox2\"]"));

        Assert.assertEquals("Java",Java.getText());

        WebElement JavaScript=driver.findElement(By.xpath("//label[@for=\"inlineCheckbox3\"]"));

        Assert.assertEquals("JavaScript",JavaScript.getText());
    }
    @Test
    public void test3(){
       // cybertekschool.herokuapp.com”Step
        // 2. Click on “Registration Form”Step
        // 3. Enter only one alphabetic character into first name input box.Step
        // 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        WebElement registrationForm=driver.findElement(By.xpath("//*[.='Registration Form']//a"));

        registrationForm.click();
        WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("a");

        WebElement invalidfirstName=driver.findElement(By.xpath("//small[@data-bv-result='INVALID']"));
        Assert.assertEquals("first name must be more than 2 and less than 64 characters long",invalidfirstName.getText());

    }
    @Test
    public void test4() {
        //Test case #4 Step 1. Go to https://practice-cybertekschool.herokuapp.comStep
        // 2. Click on “Registration Form”Step
        // 3. Enter only one alphabetic character into last name input box.Step
        // 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        WebElement registrationForm=driver.findElement(By.xpath("//*[.='Registration Form']//a"));

        registrationForm.click();
        WebElement lastname=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastname.sendKeys("a");
        WebElement invalidLastname=driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));
        Assert.assertEquals("The last name must be more than 2 and less than 64 characters long",invalidLastname.getText());

         }

    @Test
    public void test5() throws InterruptedException {
        // Test case #5 Step 1. Go to “https://practice-cybertekschool.herokuapp.com”Step
        // 2. Click on “Registration Form”Step
        // 3. Enter any valid first name.Step
        // 4. Enter any valid last name.Step
        // 5. Enter any valid user name.Step
        // 6. Enter any valid password.Step
        // 7. Enter any valid phone number.Step
        // 8. Select gender.Step
        // 9. Enter any valid date of birth.Step
        // 10. Select any department.Step
        // 11. Enter any job title.Step
        // 12. Select java as a programming language. Step
        // 13. Click Sign up.Step
        // 14. Verify that following success message is displayed: “You've successfully completed registration!”


        driver.get("https://practice-cybertekschool.herokuapp.com/");
        WebElement registrationForm=driver.findElement(By.xpath("//*[.='Registration Form']//a"));

        registrationForm.click();
        WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Ali");
        WebElement lastname=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastname.sendKeys("Akil");
        WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("akilar");
        WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("akilar@gmail.com");
        WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("a34lar12");
        WebElement phone=driver.findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys("555-444-1414");
        WebElement male=driver.findElement(By.xpath("//input[@type='radio']"));
        male.click();
        WebElement birthday=driver.findElement(By.xpath("//input[@name='birthday']"));
        birthday.sendKeys("01/01/1975");

       WebElement departmentOffice=driver.findElement(By.xpath("//select[@name='department']"));
        departmentOffice.click();
        Select department = new Select(departmentOffice);

        List<WebElement> departmentOptions= department.getOptions();
        for (WebElement departmentOption : departmentOptions) {

        }
        departmentOptions.get(2).click();

        WebElement job_titles=driver.findElement(By.xpath("//select[@name='job_title']"));
        job_titles.click();
        Select job_title = new Select(job_titles);

        List<WebElement> job_titleOptions= job_title.getOptions();

        for (WebElement job_titleOption : job_titleOptions) {

        }
        job_titleOptions.get(2).click();





        WebElement  programmingLanguages=driver.findElement(By.id("inlineCheckbox1"));
        programmingLanguages.isSelected();
        WebElement  signUp=driver.findElement(By.id("wooden_spoon"));
        signUp.click();
        Thread.sleep(2000);

        WebElement successfully=driver.findElement(By.xpath("//p"));
        String expected="You've successfully completed registration!";
        Assert.assertEquals(expected,successfully.getText());

    }
    @Test
    public void test6() throws InterruptedException {

       // Test case #6
        // Step 1. Go to "https://www.tempmailaddress.com/"
        // Step 2. Copy and save email as a string.
        // Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
        // Step 4. And click on “Sign Up For Mailing List".
        // Step 5. Enter any valid name.
        // Step 6. Enter email from the Step 2.
        // Step 7. Click Sign Up
        // Step 8. Verify that following message is displayed: “Thank you for signing up. Click the button below to return to the home page.”
        // Step 9. Navigate back to the “https://www.tempmailaddress.com/”
        // Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”Step 11. Click on that email to open it.Step 12. Verify that email is from: “do-not-reply@practice.cybertekschool.com”Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”


        driver.get("https://www.tempmailaddress.com/");
        WebElement email=driver.findElement(By.xpath("//span[@id='email']"));

        String fakeEmail=email.getText();

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        WebElement signUpFor=driver.findElement(By.xpath("//a[@href='/sign_up']"));
        signUpFor.click();

        WebElement fullName=driver.findElement(By.xpath("//input[@type='text']"));
        fullName.sendKeys("Ali");

        WebElement emailbox=driver.findElement(By.xpath("//input[@type='email']"));
        emailbox.sendKeys(fakeEmail);

        WebElement signUp=driver.findElement(By.xpath("//button[@type='submit']"));
        signUp.click();

        Thread.sleep(2000);
        WebElement thankYou=driver.findElement(By.xpath("//h3[@class='subheader']"));

        String expected="Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(expected,thankYou.getText());


        driver.get("https://www.tempmailaddress.com/");


        Thread.sleep(5000);
        WebElement clickEmail=driver.findElement(By.xpath("//td[text()='do-not-reply@practice.cybertekschool.com']"));

        String expectedclickEmail=" do-not-reply@practice.cybertekschool.com";

        Assert.assertEquals(expectedclickEmail,clickEmail.getText());


        WebElement cybertekMail=driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-envelope'][1]"));

        cybertekMail.click();

        Thread.sleep(2000);

//        WebElement thanksForSubscribing=driver.findElement(By.id("predmet"));
//        thanksForSubscribing.getText();
//        String expected2="Thanks for subscribing to practice.cybertekschool.com!";
//        Assert.assertEquals(expected2,thanksForSubscribing.getText());









    }
    @Test
    public void test7(){

        //Test case #7
        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        // Step 2. And click on “File Upload".
        // Step 3. Upload any file with .txt extension from your computer.
        // Step 4. Click “Upload” button.
        // Step 5. Verify that subject is: “File Uploaded!”
        // Step 6. Verify that uploaded file name is displayed.

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/upload']")).click();

        WebElement chooseFile=driver.findElement(By.name("file"));

        //sending file with sendKeys method
        chooseFile.sendKeys("/Users/ilhanaltan/Desktop/file.txt");
        //clicking uopload button
        driver.findElement(By.id("file-submit")).click();
        String actualFileName=driver.findElement(By.id("uploaded-files")).getText();

        //verify file name is file.txt
        Assert.assertEquals(actualFileName,"file.txt");


    }
    @Test
    public  void test8() throws InterruptedException {

        //Test case #8
        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        // Step 2. And click on “Autocomplete”.
        // Step 3. Enter “United States of America” into country input box.
        // Step 4. Verify that following message is displayed: “You selected: United States of America”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[@href='/autocomplete']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@type='button']")).click();

        String expected="You selected: United States of America";
        Assert.assertEquals(expected,driver.findElement(By.id("result")).getText());
        //Test case #9
        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        // Step 2. And click on “Status Codes”.
        // Step 3. Then click on “200”.
        // Step 4. Verify that following message is displayed: “This page returned a 200 status code”
    }
    @Test
    public  void test9(){
        //Test case #9
        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        // Step 2. And click on “Status Codes”.
        // Step 3. Then click on “200”.
        // Step 4. Verify that following message is displayed: “This page returned a 200 status code”

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[text()='Status Codes']")).click();
        driver.findElement(By.xpath("//*[text()='200']")).click();


        String expected10="This page returned a 200 status code";
        String actual=driver.findElement(By.xpath("//p")).getText();


       Assert.assertEquals(actual,expected10);
    }
    @Test
    public  void test10(){

        //Test case #10
        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        // Step 2. And click on “Status Codes”.
        // Step 3. Then click on “301”.
        // Step 4. Verify that following message is displayed: “This page returned a 301 status code”

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[text()='Status Codes']")).click();
        driver.findElement(By.xpath("//*[text()='301']")).click();
        String expected10="This page returned a 301 status code.";
        String actual=driver.findElement(By.xpath("//p")).getText();


        Assert.assertEquals(actual,expected10);
    }
    @Test
    public  void test11(){

        //Test case #12
        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        // Step 2. And click on “Status Codes”.
        // Step 3. Then click on “500”.
        // Step 4. Verify that following message is displayed: “This page returned a 301 status code”

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[text()='Status Codes']")).click();
        driver.findElement(By.xpath("//*[text()='500']")).click();
        String expected10="This page returned a 500 status code.";
        String actual=driver.findElement(By.xpath("//p")).getText();


        Assert.assertEquals(actual,expected10);
    }
    @Test
    public  void test12(){

        //Test case #11
        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        // Step 2. And click on “Status Codes”.
        // Step 3. Then click on “404”.
        // Step 4. Verify that following message is displayed: “This page returned a 301 status code”

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[text()='Status Codes']")).click();
        driver.findElement(By.xpath("//*[text()='404']")).click();
        String expected10="This page returned a 404 status code.";
        String actual=driver.findElement(By.xpath("//p")).getText();


        Assert.assertEquals(actual,expected10);
    }
}
