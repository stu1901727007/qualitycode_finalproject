package uni.plovdiv.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import uni.plovdiv.selenium.models.H_MSearcResults;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class FirstSelenuimTest {
    WebDriver driver;
    H_MSearcResults hMSearcResults;

    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        hMSearcResults = new H_MSearcResults(driver);
    }

    @Test
    public void testSpringDocsGitHubIconExists() {
        driver.get("https://spring.io/projects/spring-boot");
        WebElement element = driver.findElement(By.className("link--github"));
        final String result = element.getAttribute("href");
        assertEquals("https://github.com/spring-projects/spring-boot", result);
    }

    @Test
    public void testHMSearchResults() {

        final String expectedURL = "https://www2.hm.com/bg_bg/search-results.html?q=%D0%BE%D1%87%D0%B8%D0%BB%D0%B0";

        hMSearcResults.navigateToMain();
        hMSearcResults.setSearchValue("очила");
        hMSearcResults.clickSearchButton();

        final String result = driver.getCurrentUrl();
        WebElement header = hMSearcResults.getHeaderElement();

        assertAll(
                () -> {
                    assertEquals(result, expectedURL);
                },
                () -> {
                    assertEquals(header.getText(), "ПОКАЗВАНЕ НА РЕЗУЛТАТИ ЗА \"очила\"");
                }
        );
    }


    @Test
    public void testHMSearchHasResults() {

        hMSearcResults.navigateToMain();
        hMSearcResults.setSearchValue("очила");
        hMSearcResults.clickSearchButton();
        List<WebElement> products = hMSearcResults.getListWithProducts();
        assertFalse(products.isEmpty());
    }

    @Test
    public void testHMDetailsProduct() {

        hMSearcResults.navigateToMain();
        hMSearcResults.setSearchValue("очила");
        hMSearcResults.clickSearchButton();

        List<WebElement> products = hMSearcResults.getListWithProducts();
        WebElement hrefFirst = products.get(0);

        driver.get(hrefFirst.getAttribute("href"));

        WebElement price =  driver.findElement(By.cssSelector("#product-price span"));
        WebElement title =  driver.findElement(By.cssSelector("h1.product-item-headline"));


        assertAll(
                () -> {
                    assertEquals(title.getText(), "Кръгли слънчеви очила");
                },
                () -> {
                    assertEquals(price.getText(), "14,99 лв");
                }
        );
    }


    @Test
    public void testHMFilterSearchResults() {

        hMSearcResults.navigateToMain();
        hMSearcResults.setSearchValue("очила");
        hMSearcResults.clickSearchButton();

        WebElement filterByKids = driver.findElement(By.id("dropdown-kids_all"));
        filterByKids.click();

        List<WebElement> productListing = driver.findElements(By.cssSelector("a.item-link"));

        assertFalse(productListing.isEmpty());
    }



    @Test
    public void testHMAddToFavorites() {

        hMSearcResults.navigateToMain();
        hMSearcResults.setSearchValue("очила");
        hMSearcResults.clickSearchButton();

        List<WebElement> productListing = driver.findElements(By.cssSelector("a.item-link"));

        for (int i=0; i<=2; i++) {
            WebElement item = productListing.get(i);
            WebElement favoritesButton = item.findElement(By.cssSelector(".js-favorite"));
            favoritesButton.click();
        }

        driver.get("https://www2.hm.com/bg_bg/favourites");
        List<WebElement> favoites = driver.findElements(By.cssSelector("ul li article"));

        assertEquals(3, favoites.size());
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }
}