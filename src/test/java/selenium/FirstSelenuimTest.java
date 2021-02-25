package selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.models.H_MSearcResults;

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

    /**
     * Validate that github icon exists
     */
    @Test
    public void testSpringDocsGitHubIconExists() {
        driver.get("https://spring.io/projects/spring-boot");
        WebElement element = driver.findElement(By.className("link--github"));
        final String result = element.getAttribute("href");
        assertEquals("https://github.com/spring-projects/spring-boot", result);
    }

    /**
     * Validates search result and the main header of the page
     */
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
                    assertEquals(expectedURL, result);
                },
                () -> {
                    assertEquals("ПОКАЗВАНЕ НА РЕЗУЛТАТИ ЗА \"очила\"", header.getText());
                }
        );
    }

    /**
     * Validates that search result pahe is not empty
     */
    @Test
    public void testHMSearchHasResults() {

        hMSearcResults.navigateToMain();
        hMSearcResults.setSearchValue("очила");
        hMSearcResults.clickSearchButton();
        List<WebElement> products = hMSearcResults.getListWithProducts();
        assertFalse(products.isEmpty());
    }

    /**
     * Validates the first product title and price
     */
    @Test
    public void testHMDetailsProduct() {

        hMSearcResults.navigateToMain();
        hMSearcResults.setSearchValue("очила");
        hMSearcResults.clickSearchButton();

        List<WebElement> products = hMSearcResults.getListWithProducts();
        WebElement hrefFirst = products.get(0);

        driver.get(hrefFirst.getAttribute("href"));

        WebElement price = driver.findElement(By.cssSelector("#product-price span"));
        WebElement title = driver.findElement(By.cssSelector("h1.product-item-headline"));


        assertAll(
                () -> {
                    assertEquals("Очила с прозрачни рамки", title.getText());
                },
                () -> {
                    assertEquals("14,99 лв", price.getText());
                }
        );
    }

    /**
     * Validates that the there are products after filter has been applied
     *
     * @throws InterruptedException
     */
    @Test
    public void testHMFilterSearchResults() throws InterruptedException {

        hMSearcResults.navigateToMain();
        hMSearcResults.setSearchValue("дънки");
        hMSearcResults.clickSearchButton();

        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement filterByladies = wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdown-kids_all")));
        //filterByladies.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("$('#dropdown-ladies_all').trigger('click');");


        List<WebElement> productListing = driver.findElements(By.cssSelector("a.item-link"));

        assertFalse(productListing.isEmpty());
    }

    /**
     * Validates Favorites functionality
     */
    @Test
    public void testHMAddToFavorites() {

        hMSearcResults.navigateToMain();
        hMSearcResults.setSearchValue("очила");
        hMSearcResults.clickSearchButton();

        List<WebElement> productListing = driver.findElements(By.cssSelector("a.item-link"));

        for (int i = 0; i <= 2; i++) {
            WebElement item = productListing.get(i);
            WebElement favoritesButton = item.findElement(By.cssSelector(".js-favorite"));
            favoritesButton.click();
        }

        driver.get("https://www2.hm.com/bg_bg/favourites");
        List<WebElement> favoites = driver.findElements(By.cssSelector("ul li article"));

        assertEquals(3, favoites.size());
    }

    /**
     * Closes the connection
     */
    @AfterEach
    void tearDown() {
        driver.close();
    }
}