package pages.mobile;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MobileSignInPage {
    private final SelenideElement phoneNumberEntry = $x("//input[@type='tel']");
    private final SelenideElement nextButton = $x("//button[@type='submit']");
    private final SelenideElement failedText = $x("//div[@data-testid='error']");
    private final SelenideElement succesfulText = $x("//div[@data-testid='error']");

    public void changePhoneNuberEntry(String phoneNumber) {
        phoneNumberEntry.setValue(phoneNumber);
    }

    public void clickOnNextButton() {
        nextButton.click();
    }

    public String getSuccesfulText() {
        return succesfulText.text();
    }

    public String getFailedText() {
        return failedText.text();
    }
}
