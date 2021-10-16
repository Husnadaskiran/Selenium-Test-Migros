import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UiTest extends BaseTest{
    @Test
    public void deliveryMethod(){
        driver.findElement(By.cssSelector(".delivery-options-inner")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".delivery-option--store ")).click();
    }

    public void chooseAStore(){
        driver.findElement(By.id("delivery-options-modal_city")).click();
        driver.findElement(By.id("mat-option[id='mat-option-0']")).click();
        driver.findElement(By.id("delivery-store-modal_town")).click();
        driver.findElement(By.id("mat-option-82")).click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("div[id='mat-select-value-5']")).click();
        driver.findElement(By.id("mat-option-113")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    public void searchAKeyword(){
        driver.findElement(By.id("product-search-combobox--trigger")).sendKeys("şeftali");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

    }

    public void selectAProduct(){
        driver.findElement(By.cssSelector("a[href=\"/seftali-lux-kg-p-1a0e2b4\"]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("div[class='ng-tns-c294-3']")).click();
        driver.findElement(By.cssSelector("button[class='subtitle-2']"));
    }

    public void basketControl(){
        //sepete ürün eklenmediğinde sepetim sayfasına gidilemediği için, sepetim sayfasının URL'ine giderek sepete ürün eklendiğinin kontrolünü yapabiliriz.
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.migros.com.tr/sepetim");
    }
}
