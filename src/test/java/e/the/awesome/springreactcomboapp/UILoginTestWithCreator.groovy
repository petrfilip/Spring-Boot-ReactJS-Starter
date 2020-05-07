package e.the.awesome.springreactcomboapp

import e.the.awesome.springreactcomboapp.model.User
import geb.Browser
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
class UILoginTestWithCreator {

  @Autowired
  private Creator creator;

  @Test
  void loginTest() {

    System.setProperty("webdriver.gecko.driver", "/home/pfilip/Downloads/geckodriver")

    creator.saveEntity(new User(age: 10,firstName: "Marek"));

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

      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='User Details']")))
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Marek']")))

    }
  }


}