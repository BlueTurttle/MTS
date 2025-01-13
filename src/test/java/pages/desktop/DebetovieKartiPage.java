package pages.desktop;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DebetovieKartiPage {
    private final SelenideElement mtsDengiButton = $x("//*[@id=\"__next\"]/div[4]/div[6]/div/div/div[2]/div[1]/div[3]/a/h2");

    public void clickOnMtsDengiButton() {
        mtsDengiButton.click();
    }
}
