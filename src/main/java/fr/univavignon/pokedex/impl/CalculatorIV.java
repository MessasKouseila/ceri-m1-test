package fr.univavignon.pokedex.impl;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by kouceila on 03/05/17.
 */

/**
 *
 */
public class CalculatorIV {

    private static final String  PATH_IV = "https://pokeassistant.com/main/ivcalculator?locale=en";
    WebDriver driver;
    /**
     *
     * @param browser nom du navigateur à utiliser
     */
    public CalculatorIV(String browser) {
        switch (browser) {
            case "firefox":
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                EdgeDriverManager.getInstance().setup();
                driver = new EdgeDriver();

        }
    }
    public int calculateIV(String name, int cp, int hp, int dust) {

        driver.get(PATH_IV);
        // nom de pokemon
        driver.findElement(By.xpath("//*[@id=\"search_pokemon_name\"]")).sendKeys(name);
        driver.findElement(By.xpath("//*[@class=\"tt-dataset tt-dataset-0\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"search_cp\"]")).sendKeys(String.valueOf(cp));
        driver.findElement(By.xpath("//*[@id=\"search_hp\"]")).sendKeys(String.valueOf(hp));
        driver.findElement(By.xpath("//*[@id=\"search_dust\"]")).sendKeys(String.valueOf(dust));
        driver.findElement(By.xpath("//*[@id=\"calculatebtn\"]")).click();
        // On attends le calcule
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // on recupère l'iv max calculé
        String res = driver.findElement(By.xpath("//*[@id=\"possibleCombinationsStringmax\"]//b")).getText();
        // Close the driver
        driver.quit();
        // on arrondit
        return Math.round(Float.parseFloat(res.replace("%", "")));
    }
}
