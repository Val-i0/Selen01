package Exercise18;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;


public class Exercises18 extends MainDriver {
    @Test
    public void jsAlert1Test() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Alert')]")).click();

//        driver.switchTo().alert().accept();

        Alert alert = driver.switchTo().alert();
//        alert.accept();
        alert.dismiss();

        WebElement result = driver.findElement(By.id("result"));
        assertEquals(result.getText(), "You successfully clicked an alert");
    }

    @Test
    public void jsAlert2Test() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Confirm')]")).click();

//        driver.switchTo().alert().accept();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        WebElement result = driver.findElement(By.id("result"));
        assertEquals(result.getText(), "You clicked: Cancel");
    }

    @Test
    public void jsAlert3Test() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//ul/li[3]/button")).click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Test typing in alert");
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        assertEquals(result.getText(), "You entered: Test typing in alert");
    }

    @Test
    public void newTabTest() {
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        WebElement header = driver.findElement(By.tagName("h3"));
        String headerText = header.getText();
        assertEquals("New Window", headerText);

        // add assert

        driver.close(); // close second tab
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    public void nestedFramesTest() {
        driver.get("https://the-internet.herokuapp.com/frames");

        driver.findElement(By.linkText("Nested Frames")).click();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        WebElement leftElement = driver.findElement(By.tagName("body"));
        leftElement.getText();

        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
    }

    @Test
    public void iFrameRichTextEditorTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame("mce_0_ifr");
        WebElement textField = driver.findElement(By.cssSelector("body#tinymce p"));
        textField.clear();
        textField.sendKeys("Ragdoll test");

        driver.switchTo().defaultContent();

        WebElement menuEdit = driver.findElement(By.xpath("//div[@role='menubar']/button[2]"));
        menuEdit.click();
        WebElement selectAll = driver.findElement(By.xpath("//div[@title='Select all']"));
        selectAll.click();

        WebElement buttonBold = driver.findElement(By.cssSelector("button[title='Bold']"));
        buttonBold.click();

        Thread.sleep(3000);
    }

    /*
    https://the-internet.herokuapp.com/tables
    //table[@id="table1"]//td[contains(text(), 'Frank')]/../td/a[contains(text(), 'edit')]
     */
}
