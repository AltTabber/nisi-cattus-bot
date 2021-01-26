package com.alttabber.malbot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\code\\Java\\nisi-cattus-bot\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        for(int i = 71; i <= 100; i++){
            driver.get("https://www.anime-planet.com/characters/all?page=" + i);
            driver.findElements(By.xpath(".//*[@id=\"siteContainer\"]/table/tbody/tr/td[contains(@class, 'tableCharInfo')]/a")).forEach(
                    webElement -> {
                        String name = webElement.getText();
                        By animeXpath = By.xpath("./../../td[contains(@class, 'tableAnime')]/div[1]/ul/li[1]/a");
                        if(checkWebElementExist(webElement, animeXpath)){
                            WebElement animeElem = webElement.findElement(animeXpath);
                            String anime = webElement.findElement(By.xpath("./../../td[contains(@class, 'tableAnime')]/div[1]/ul/li[1]/a")).getText();
                            String image = webElement.findElement(By.xpath("./../../td[contains(@class, 'tableAvatar')]//img")).getAttribute("src");
                            System.out.println(name + "     " + anime + "    " + image);
                        }else{
                            System.out.println(name + "     ANIME IS NOT FOUND");
                        }

//                        System.out.println(name + "     " + anime);
                    });
        }

//        String anime = driver.findElements(By.xpath("//*[@id=\"siteContainer\"]/table/tbody/tr/td[contains(@class, 'tableAnime')]/div[1]/ul/li[1]/a"));


        driver.close();
    }

    private static boolean checkWebElementExist(WebElement webElement, By animeXpath) {
        try{
            webElement.findElement(animeXpath).getText();
            return true;
        }catch(Throwable e){
            return false;
        }
    }

}
