package fr.univavignon.pokedex.impl;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by kouceila on 03/05/17.
 */

/**
 * permet le calcule de l'iv d'un pokemon via selenium webDrvier
 */
public class CalculatorIV {

    private static final String  PATH_IV = "https://pokeassistant.com/main/ivcalculator?locale=en";

    public int calculateIV(String name, int cp, int hp, int dust) {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        driver.get(PATH_IV);
        // nom de pokemon
        driver.findElement(By.xpath("//*[@id=\"search_pokemon_name\"]")).sendKeys(name);
        // init data
        driver.findElement(By.xpath("//*[@class=\"tt-dataset tt-dataset-0\"]")).click();
        // cp du pokemon
        driver.findElement(By.xpath("//*[@id=\"search_cp\"]")).sendKeys(String.valueOf(cp));
        // hp
        driver.findElement(By.xpath("//*[@id=\"search_hp\"]")).sendKeys(String.valueOf(hp));
        // dust
        driver.findElement(By.xpath("//*[@id=\"search_dust\"]")).sendKeys(String.valueOf(dust));
        driver.findElement(By.xpath("//*[@id=\"calculatebtn\"]")).click();
        // On attends le calcule
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
        }
        // on recupère l'iv max calculé
        String res = driver.findElement(By.xpath("//*[@id=\"possibleCombinationsStringmax\"]//b")).getText();
        // Close the driver
        driver.quit();
        // on arrondit
        return Math.round(Float.parseFloat(res.replace("%", "")));
    }
}
