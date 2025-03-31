package org.example;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.Assert.assertEquals;

public class Main {

    @Test
    public void FirstTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Home\\IdeaProjects\\Selenium\\drivers\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://habr.com/ru/all/");
        driver.findElement(By.xpath("//*[@class=\"tm-svg-img tm-header-user-menu__icon tm-header-user-menu__icon_search\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@class=\"tm-search__input tm-input-text-decorated__input\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"tm-search__input tm-input-text-decorated__input\"]")).sendKeys("Selenium WebDriver");
        driver.findElement(By.xpath("//*[@class='tm-svg-img tm-svg-icon']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.linkText("Что такое Selenium?")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals("28 сен 2012 в 17:14", driver.findElement(By.xpath("//*[@title='2012-09-28, 17:14']")).getText());
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().setSize(new Dimension(1280,1025));
        driver.findElement(By.xpath("//a[@href=\"/ru/articles/\" and @class=\"footer-menu__item-link\"]")).click();
        driver.quit();
    }

    @Test
    public void TwoTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Home\\IdeaProjects\\Selenium\\drivers\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://eios.kemsu.ru/a/eios");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//*[@name='username']")).click();
        driver.findElement(By.xpath("//*[@name='username']")).clear();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("stud71628");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@name='password']")).click();
        driver.findElement(By.xpath("//*[@name='password']")).clear();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("(sveta)-(211)");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@class='css-h0m9oy efn4aem0']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals("Кривалова С.В.", driver.findElement(By.xpath("//a[contains(@class, 'css-10pdxt6') and contains(@class, 'efn4aem0')]")).getText());
        System.out.println("Аккаунт соответсвует");
        driver.findElement(By.xpath("//*[@class='css-lfyao8 e13dsguq0']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@name='username']")).isDisplayed();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Выход выполнен");
        driver.quit();
    }
}