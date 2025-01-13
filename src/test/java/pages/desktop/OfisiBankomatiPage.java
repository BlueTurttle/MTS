package pages.desktop;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class OfisiBankomatiPage {

    private final SelenideElement propertiesButton = $x("//*[@id=\"__next\"]/div[4]/div[2]/div/div/div[2]/div[1]/div[1]");
    private final SelenideElement spiskomButton = $x("//*[@id=\"__next\"]/div[4]/div[2]/div/div/div[3]/div[1]/div/button[2]");
    private final SelenideElement kruglosutochnoButton = $x("//*[@id=\"__next\"]/div[4]/div[2]/div/div/div[2]/div[1]/div[2]/div/div/div/div[11]");
    private final SelenideElement primenitButton = $x("//*[@id=\"change_region_modal\"]/div/button[2]/div");
    private final SelenideElement openText = $x("//*[@id=\"__next\"]/div[4]/div[2]/div/div/div[3]/div[3]/div/div[1]/div[1]/div/div[3]/div");

    public void clickOnPropertiesButton() {
        propertiesButton.click();
    }
    public void clickOnSpiskomButton() {
        spiskomButton.click();
    }
    public void clickOnKruglosutochnoButton() {
        kruglosutochnoButton.click();
    }
    public void clickOnPrimenitButton() {
        primenitButton.click();
    }
    public String getOpenText() {
        return openText.getText();
    }
}
