package base;

import io.qameta.allure.Owner;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.desktop.*;
import pages.mobile.MobileMainPage;
import pages.mobile.MobileSignInPage;

@Execution(ExecutionMode.CONCURRENT)
public class MtsBankTestsMobile extends BaseTestMobile {

    //private final static String url = "https://www.mtsbank.ru/";


    @Test
    @Owner("Kochergin")
    @Description("Проверка текста")
    public void test1() {
        MainPage mainPage = new MainPage();
        mainPage.openPage("https://www.mtsbank.ru/");
        mainPage.hoverOnKarti();
        String a = mainPage.getProcent();
        String b = mainPage.getKashback();
        mainPage.clickOnKarta();

        MtsDengiPage mtsDengiPage = new MtsDengiPage();
        String a1 = mtsDengiPage.getProcent();
        String b1 = mtsDengiPage.getKashback();

        Assertions.assertEquals(b, b1);
        Assertions.assertEquals(a, a1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"9519998874", "9663488819"})
    public void test2(String phoneNumber) {
        MainPage mainPage = new MainPage();
        mainPage.openPage("https://www.mtsbank.ru/");
        mainPage.hoverOnSignInButton();
        mainPage.clickOnChastnLicamButton();
        SignInPage signInPage = new SignInPage();
        signInPage.changePhoneNuberEntry(phoneNumber);
        signInPage.clickOnNextButton();
        Assertions.assertEquals("Введите код из SMS", signInPage.getSuccesfulText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1111111111", "5555555555"})
    public void test3(String phoneNumber) {
        MobileMainPage mobileMainPage = new MobileMainPage();

        mobileMainPage.openPage("https://www.mtsbank.ru/");
        mobileMainPage.clickOnMobileSignInButton();

        MobileSignInPage mobileSignInPage = new MobileSignInPage();
        mobileSignInPage.changePhoneNuberEntry(phoneNumber);
        mobileSignInPage.clickOnNextButton();
        Assertions.assertEquals("Неправильный номер телефона", mobileSignInPage.getFailedText());

    }

    @ParameterizedTest
    @CsvSource({
            "9519898874, Петров Петр Петрович",
            "1234567890, Ф Ф Ф"
    })
    public void test4(String phone, String fio) {
        MainPage mainPage = new MainPage();
        mainPage.openPage("https://www.mtsbank.ru/");
        mainPage.clickOnDebetovieButton();
        DebetovieKartiPage debetovieKartiPage = new DebetovieKartiPage();
        debetovieKartiPage.clickOnMtsDengiButton();
        DebetovayaMtsDengiPage debetovayaMtsDengiPage = new DebetovayaMtsDengiPage();
        debetovayaMtsDengiPage.changePhone(phone);
        debetovayaMtsDengiPage.clickOnFio();
        debetovayaMtsDengiPage.sendFio(fio);
        int i = 0;
        debetovayaMtsDengiPage.changeMail("kkk@gmail.com");
        debetovayaMtsDengiPage.clickOnNextButton();
        Assertions.assertEquals("ВВЕДИТЕ КОД", debetovayaMtsDengiPage.getKodText());
    }

}
