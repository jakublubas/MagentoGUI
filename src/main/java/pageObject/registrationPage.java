package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Random;

public class registrationPage {

    private static WebElement element = null;

    public static WebElement input_FirstName(WebDriver driver){
        element = driver.findElement(By.id("firstname"));
        return element;
    }

    public static WebElement input_LastName(WebDriver driver){
        element = driver.findElement(By.id("lastname"));
        return element;
    }

    public static WebElement input_Email(WebDriver driver){
        element = driver.findElement(By.id("email_address"));
        return element;
    }

    public static WebElement input_Password(WebDriver driver){
        element = driver.findElement(By.id("password"));
        return element;
    }

    public static WebElement input_ConfirmPassword(WebDriver driver){
        element = driver.findElement(By.id("password-confirmation"));
        return element;
    }

    public static WebElement button_CreateAnAccount(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button"));
        return element;
    }

    public static String getRequiredFieldsErrorMessage(WebDriver driver){

        WebElement firstNameError = driver.findElement(By.id("firstname-error"));
        WebElement lastNameError = driver.findElement(By.id("lastname-error"));
        WebElement emailNameError = driver.findElement(By.id("email_address-error"));
        WebElement passwordNameError = driver.findElement(By.id("password-error"));
        WebElement confirmPasswordfirstNameError = driver.findElement(By.id("password-confirmation-error"));

        String messageError =  "User left required fields empty";
        String messageSuccess =  "User don't left required fields empty";

        if (firstNameError.isDisplayed() || lastNameError.isDisplayed()|| emailNameError.isDisplayed() || passwordNameError.isDisplayed() || confirmPasswordfirstNameError.isDisplayed())
            return messageError;
        else
            return messageSuccess;
    }


    private static String getRandomString(){
        Random random = new Random();
        Random r = new Random();
        char randomLetter = (char)(r.nextInt(26) + 'a');
        int randomInt = random.nextInt(100);
        char randomLetter1 = (char)(r.nextInt(26) + 'a');
        int randomInt1 = random.nextInt(100);

        return "Rnd"+randomInt+randomLetter+randomInt1+randomLetter1 ;
    }

    public String getCorrectFirstNameRandom(){

        return "FirstName"+getRandomString();
    }

    public String getCorrectLastNameRandom(){

        return "LastName"+getRandomString();
    }

    public String getCorrectEmailRandom(){

        return "Email"+getRandomString()+"@test.com";
    }

    public String getCorrectPassword(){

        return "test1234";
    }

}


