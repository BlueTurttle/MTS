package pages.desktop;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SignInPage {
    private final SelenideElement phoneNumberEntry = $x("//*[@id=\"phone\"]");
    private final SelenideElement nextButton = $x("//*[@id=\"app\"]/div[1]/main/form/button");
    private final SelenideElement succesfulText = $x("//*[@id=\"app\"]/div[1]/main/div[1]/h1");
    private final SelenideElement failedText = $x("//*[@id=\"app\"]/div[1]/main/form/div[2]");

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
