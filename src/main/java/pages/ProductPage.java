package pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;

import java.util.Map;

public class ProductPage extends BasePage{
    private final String sizeButton = "//div[@option-label='[SIZE]']";
    private final String colorButton = "//div[@aria-label='[COLOR]']";
    private final By quantityInput = By.xpath("//input[@name='qty']");
    private final By addToCartButton = By.xpath("//button[@title='Add to Cart']");
    private final By requiredFieldError = By.xpath("//div[@class='mage-error']");
    private final By quantityError = By.xpath("//div[@id='qty-error']");
    private final By productPageMessagePrompt = By.xpath("//div[@class='messages']");
    private final By addToWishListButton = By.xpath("//a[@data-action='add-to-wishlist']");
    private final By addToCompareButton = By.xpath("//a[@data-role='add-to-links']");

    //ADDING REVIEW
    private final By reviewsTab = By.xpath("//a[contains(text(), 'Reviews')]");
    private final String starsInput = "//input[@id='Rating_[NO_OF_STARS]']";
    private final By nicknameInput = By.xpath("//input[@name='nickname']");
    private final By summaryInput = By.xpath("//input[@name='title']");
    private final By reviewInput = By.xpath("//textarea[@name='detail']");
    private final By submitReviewButton = By.xpath("//button[normalize-space(.)='Submit Review']");
    private final By noReviewsInfo = By.xpath("//div[@class='reviews-actions']//a[contains(text(), 'Be the first')]");


    public By getSizeButton(String size) {
        return By.xpath(sizeButton.replace("[SIZE]", size));
    }

    public By getColorButton(String colorName) {
        return By.xpath(colorButton.replace("[COLOR]", colorName));
    }

    public By getQuantityInput() {
        return quantityInput;
    }

    public By getAddToCartButton() {
        return addToCartButton;
    }

    public By getRequiredFieldError() {
        return requiredFieldError;
    }

    public By getQuantityError() {
        return quantityError;
    }

    public By getProductPageMessagePrompt() {
        return productPageMessagePrompt;
    }

    public By getAddToWishListButton() {
        return addToWishListButton;
    }

    public By getAddToCompareButton() {
        return addToCompareButton;
    }

    public By getReviewsTab() {
        return reviewsTab;
    }

    public void pickStars(int starsCount) {
        clickElementJS(By.xpath(starsInput.replace("[NO_OF_STARS]", String.valueOf(starsCount))));
    }

    public By getNicknameInput() {
        return nicknameInput;
    }

    public By getSummaryInput() {
        return summaryInput;
    }

    public By getReviewInput() {
        return reviewInput;
    }

    public By getSubmitReviewButton() {
        return submitReviewButton;
    }

    public By getNoReviewsInfo() {
        return noReviewsInfo;
    }

    public void fillReviewFields(DataTable dataTable) {
        Map<String, String> values = dataTable.asMaps().get(0);

        inputValue(getNicknameInput(), values.get("Nickname"));
        inputValue(getSummaryInput(), values.get("Summary"));
        inputValue(getReviewInput(), values.get("Review"));
    }
}
