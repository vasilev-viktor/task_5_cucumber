package steps;


import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Когда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class StepsFood {

WebDriver driver;

    @Допустим("открыта страница по адресу {string}")
    public void открыта_страница_по_адресу(String string) {
        driver = new ChromeDriver();
        System.setProperty("webdriwer.chrome.driver",
                "D:\\Programming\\Project IBS\\task_5_cucumber\\src\\test\\resources\\chromedriver.exe");

        driver.get("http://localhost:8080");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @Допустим("всплывающий список {string}")
    public void всплывающий_список(String string) {
        pressTheSandboxButton();
    }

    @Допустим("выбираем {string}")
    public void выбираем(String string) {
        buttonGoods();
    }

    @Когда("нажимаем кнопку {string}")
    public void нажимаем_кнопку(String string){
        buttonAdd();
    }

    @Допустим("кликаем на поле {string} и вводим {string}")
    public void кликаем_на_поле_и_вводим(String name, String input) {
        inputFieldFruit(input);
    }

    @Допустим("раскрытие выпадающего списка и выбор типа {string}")
    public void раскрытие_выпадающего_списка_и_выбор_типа(String string) {
        dropDown();
        selectFruitType();
    }

    @Допустим("раскрытие выпадающего списка выбор типа {string}")
    public void раскрытие_выпадающего_списка_выбор_типа(String string) {
        dropDown();
        selectVegetableType();
    }

    @Допустим("чекбокс {string}")
    public void чекбокс(String string) {
        checkBoxExoticTrue();
    }

    @Допустим("нажимаем {string}")
    public void нажимаем(String string) {
        saveButton();
    }

    @Допустим("закрываем браузер {string}")
    public void закрываем_браузер(String string) {
        closeBrowser();
    }


    private void pressTheSandboxButton() {
        WebElement dropDownSandbox = driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        dropDownSandbox.click();
    }

    private void buttonGoods() {
        WebElement buttonGoods = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/div/a[1]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        buttonGoods.click();
    }

    private void buttonAdd() {
        WebElement buttonAdd = driver.findElement(By.xpath("//button[@data-toggle='modal']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        buttonAdd.click();
    }

    private void inputFieldFruit(String value){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        WebElement inputFieldFruit = driver.findElement(By.xpath("//input[@placeholder=\"Наименование\"]"));
        inputFieldFruit.click();
        inputFieldFruit.sendKeys(value);
    }

    private void dropDown() {
        WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"type\"]"));
        dropDown.click();
    }

    private void selectFruitType() {
        WebElement selectFruitType = driver.findElement(By.xpath("//*[@id=\"type\"]/option[2]"));
        selectFruitType.click();
    }

    private void selectVegetableType() {
        WebElement selectVegetableType = driver.findElement(By.xpath("//*[@id=\"type\"]/option[1]"));
        selectVegetableType.click();
    }

    private void checkBoxExoticTrue() {
        WebElement checkBoxExoticTrue = driver.findElement(By.xpath("//*[@id=\"exotic\"]"));
        checkBoxExoticTrue.click();
    }

    private void saveButton() {
        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"save\"]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        saveButton.click();
    }

    private void closeBrowser() {
        driver.quit();
    }

}
