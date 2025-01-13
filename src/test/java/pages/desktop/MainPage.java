package pages.desktop;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$x;


public class MainPage {
    private final SelenideElement kartiButton = $x("//a[@href='/chastnim-licam/karti/']");
    private final SelenideElement procentText = $x("//*[@id=\"__next\"]/div[1]/nav/div[1]/div[1]/div[1]/div[1]/div[2]/div/div[1]");
    private final SelenideElement kashbackText = $x("//*[@id=\"__next\"]/div[1]/nav/div[1]/div[1]/div[1]/div[1]/div[2]/div/div[2]");
    private final SelenideElement goToNextPage = $x("//*[@id=\"__next\"]/div[1]/nav/div[1]/div[1]/div[1]/div[1]/div[2]/a[2]/div");
    private final SelenideElement signInButtob = $x("//*[@id=\"bottom\"]/div/button");
    private final SelenideElement chastnLicamButton = $x("//*[@id=\"bottom\"]/div/div/a[1]");
    private final SelenideElement debetovieButton = $x("//a[@href='/chastnim-licam/karti/all/debet/']");
    private final SelenideElement oficiBankomatiButton = $x("//a[@href='/ofisi-i-bankomati/']");
    private final SelenideElement regionButton = $x("//*[@id=\"__next\"]/div[1]/div[1]/div/div/button[1]/div");

    public void openPage(String url) {
        Selenide.open(url);
    }

    public void hoverOnKarti() {
        kartiButton.hover();
    }

    public String getProcent() {
        return procentText.getText();
    }

    public String getKashback() {
        return kashbackText.getText();
    }

    public void clickOnKarta() {
        goToNextPage.click();
    }

    public void hoverOnSignInButton() {
        signInButtob.hover();
    }

    public void clickOnChastnLicamButton() {
        chastnLicamButton.click();
    }

    public void clickOnDebetovieButton() {
        debetovieButton.click();
    }

    public void clickOnRegionButton() {
        regionButton.click();
    }

    public void clickOnOficiBankomatiButton() {
        oficiBankomatiButton.click();
    }


}