package ru.voskhod.edu.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Александра on 19.04.2016.
 */
public class Accred {
    private WebDriver driver;
    private Config config;
@BeforeClass
public void initDriver() throws IOException {
    config= new Config("config.properties");
    WebDriver driver= new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    this.driver=driver;


}
@Test
    //порядок аккредитации
    public  void test_accred() throws InterruptedException {
    driver.get(config.get("url"));

    driver.findElement(By.xpath(".//*[@id='loginSnilsFrm']/form/div/div[1]/dl[1]/dd/input")).sendKeys(config.get("login"));
    driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(config.get("password"));
    driver.findElement(By.xpath(".//*[@id='loginSnilsFrm']/form/div/div[1]/div[2]/button")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath(".//*[@id='page']/div[2]/div[1]/ul/li[4]")).click();
    Thread.sleep(1000);
    System.out.println(driver.findElements(By.xpath(".//*[@id='data-container']/tr[.]/td")).size());
    //    Assert.assertEquals(driver.findElement(By.xpath("html/body/div/div[3]/div[1]")).getText(),"Данный раздел содержит информацию об установленном порядке аккредитации удостоверяющих центров");
//    //аккредитованные уц
//    driver.get(config.get("url2_2"));
//    Assert.assertEquals(isElementPresent(By.xpath("html/body/div/div[3]/div[1]/div[1]")),true);
//    Assert.assertEquals(driver.findElement(By.xpath("html/body/div/div[3]/div[1]/div[1]")).getText(),"Данный раздел содержит перечень аккредитованных удостоверяющих центров");
//    List<WebElement> list = driver.findElements(By.xpath("html/body/div/div[3]/table/tbody/tr[.]/td[2]"));
//    Assert.assertTrue(list.size()>1);
//    //проверки уц
//    driver.get(config.get("url2_3"));
//    isElementPresent(By.xpath("html/body/div/div[3]/div[1]"));
//    Assert.assertEquals(driver.findElement(By.xpath("html/body/div/div[3]/div[1]")).getText(),"Данный раздел содержит информацию о порядке проверки соблюдения аккредитованными удостоверяющими центрами установленных требований");
//    driver.get(config.get("url3"));
//    List<WebElement> list1=driver.findElements(By.partialLinkText("Постановлением"));
//    System.out.println(list1.size());
//    Assert.assertEquals(driver.findElement(By.xpath("html/body/div/div[3]/div[2]/fieldset[6]/legend")).getText(),"ПАК \"УЦ 2 ИС ГУЦ\"");
}
    public boolean isElementPresent(By locator){
        List<WebElement> list = driver.findElements(locator);
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        if (list.size()==0){
            return false;
        }else return list.get(0).isDisplayed()&&list.get(0).isEnabled();
    }

@AfterClass
public void closeDriver(){
if (driver!=null){
    driver.close();
    driver.quit();
}

}
}