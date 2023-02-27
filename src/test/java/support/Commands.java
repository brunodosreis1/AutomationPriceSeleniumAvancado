package support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumber;

public class Commands extends RunCucumber {

    public static void waitElementBeClickable(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitElementBePresent(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void clickElement(By element) {
        System.out.println("########################################");
        try {
           System.out.println("********* Vai clicar no elemento:" + element);
            waitElementBeClickable(element, 100);
            getDriver().findElement(element).click();
           System.out.println("********* Clicou no elemento:" + element);
        } catch (Exception error) {
            System.out.println("********* aconteceu um erro ao tentar clicar no elemento" + element);
            System.out.println(error);
        }
        }

    public static void fillField(By element, String value) {
        try {
             System.out.println("********* Vai preencher o campo:" + element);
            waitElementBePresent(element, 100);
            getDriver().findElement(element).sendKeys(value);
            System.out.println("********* Preencheu o campo: " + element);
        } catch (Exception error) {
            System.out.println("********* Aconteceu um erro ao tentar preencher o campo: " + element);
            System.out.println(error);
        }
    }
    public static void checkMessage(By element, String expectedMessage) {
          waitElementBePresent(element, 100);
          String actualMessage = getDriver().findElement(element).getText();
          Assert.assertEquals("Erro ao validar mensagem", expectedMessage, actualMessage);
        System.out.println("Validou mensagem: " + expectedMessage);
        }
    }

