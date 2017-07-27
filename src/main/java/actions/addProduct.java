package actions;

import object.Constant;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.homePage;
import pageObject.productPage;

public class addProduct {

    public static WebDriver driver = null;

    public static void execute(WebDriver driver){

        driver.get(Constant.homePage);
        homePage.prod_Backpack(driver).click();
        productPage.button_AddToCart(driver);
        Assert.assertTrue(productPage.getProductAddedSuccessMessage(driver).isDisplayed());
        System.out.println("4.Add product to Cart");
    }
}
