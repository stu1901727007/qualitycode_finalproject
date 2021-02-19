package selenium.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class H_MSearcResults {

    private WebDriver driver;

    @FindBy(id = "main-search")
    WebElement searchInput;

    @FindBy(className = "menu__search_submit")
    WebElement searchButton;

    @FindBy(className = "products-listing")
    WebElement productListing;

    /**
     * Constructor Initialize instance of Wikipedia Page object Model
     *
     * @param driver
     */
    public H_MSearcResults(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToMain() {
        driver.get("https://www2.hm.com/bg_bg/index.html");
    }

    public void setSearchValue(String searchValue) {
        searchInput.clear();
        searchInput.sendKeys(searchValue);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public WebElement getHeaderElement() {
        return driver.findElement(By.tagName("h1"));
    }

    public List<WebElement> getListWithProducts() {
        return productListing.findElements(By.className("item-link"));
    }
}
