import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import praktikum.GuiTestBase;
import praktikum.pages.MainPage;


import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;
import static praktikum.Constants.*;

public class ConstructorTest extends GuiTestBase  {

    @Test
    @DisplayName("Scroll to Sauce")
    @Description("Проверка прокрутки до списка соусов при клике на вкладку Соусы")
    public void scrollingToSauce() throws Exception {
        driver.get(BASE_URI);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickTabSauce();
        assertTrue(objMainPage.checkToCurrentTab(objMainPage.getTabLocator(SAUCE)));
        assertTrue(objMainPage.checkScrollingToFirstPositions(objMainPage.getFirstSauceLocator()));
    }

    @Test
    @DisplayName("Scroll to Main")
    @Description("Проверка прокрутки до списка начинок при клике на вкладку Начинки")
    public void scrollingToMain() throws Exception {
        driver.get(BASE_URI);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickTabMain();
        assertTrue(objMainPage.checkToCurrentTab(objMainPage.getTabLocator(MAIN)));
        assertTrue(objMainPage.checkScrollingToFirstPositions(objMainPage.getFirstMainLocator()));
    }

    @Test
    @DisplayName("Scroll to Bun")
    @Description("Проверка прокрутки до списка булочек при клике на вкладку Булки")
    public void scrollingToBun() throws Exception {
        driver.get(BASE_URI);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickTabMain();
        sleep(3_000);
        objMainPage.clickTabBun();
        assertTrue(objMainPage.checkToCurrentTab(objMainPage.getTabLocator(BUN)));
        assertTrue(objMainPage.checkScrollingToFirstPositions(objMainPage.getFirstBunLocator()));
    }

}
