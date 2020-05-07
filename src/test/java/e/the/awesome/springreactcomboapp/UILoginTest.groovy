package e.the.awesome.springreactcomboapp

import geb.Browser
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.boot.test.context.SpringBootTest

import static org.junit.jupiter.api.Assertions.assertEquals


@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
class UILoginTest {

  @Test
  void loginTest() {

    System.setProperty("webdriver.gecko.driver", "/home/pfilip/Downloads/geckodriver")


    Browser.drive {
      go 'http://localhost:8080/'
      assert title == "Login | UPCE"

      // a) typing text into input using GEB jQuery-like API
      $("input[name='username']").value("devglan")

      // a) typing text into input using core WebDriver API
      driver.findElement(By.name("password")).sendKeys("devglan")

      driver.findElement(By.xpath("//button[*[contains(text(),'Login')]]")).click()

      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.titleIs("List user | UPCE"))

    }
  }


}