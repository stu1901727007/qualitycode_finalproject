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
     * Constructor Initialize instance of Page object Model
     *
     * @param driver
     */
    public H_MSearcResults(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Navivate to main url
     */
    public void navigateToMain() {
        driver.get("https://www2.hm.com/bg_bg/index.html");
    }

    /**
     * Send string as keyboard event
     *
     * @param searchValue String
     */
    public void setSearchValue(String searchValue) {
        searchInput.clear();
        searchInput.sendKeys(searchValue);
    }

    /**
     * Send click event to DOM Node
     */
    public void clickSearchButton() {
        searchButton.click();
    }

    /**
     * Searches for DOM Node
     *
     * @return WebElement object with searched DOM node
     */
    public WebElement getHeaderElement() {
        return driver.findElement(By.tagName("h1"));
    }

    /**
     * Searches for DOM Nodes
     *
     * @return List with WebElement objects
     */
    public List<WebElement> getListWithProducts() {
        return productListing.findElements(By.className("item-link"));
    }
}
