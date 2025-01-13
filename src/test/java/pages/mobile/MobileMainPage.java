package pages.mobile;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MobileMainPage {
    private final SelenideElement mobileSignInButton = $x("//*[@id=\"__next\"]/div[1]/div[2]/a[2]");

    public void openPage(String url) {
        Selenide.open(url);
    }

    public void clickOnMobileSignInButton(){
        mobileSignInButton.click();
    }
}
