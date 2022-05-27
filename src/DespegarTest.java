import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

public class DespegarTest {

@Test(description = "Validar la carga de un destino con pasajeros")
public void ValidarSeleccionDespegar() throws Exception {  System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");  
WebDriver driver = new ChromeDriver();
driver.get("https://www.despegar.com.ar/");
WebElement BotonAlojamiento = driver.findElement(By.cssSelector(".header-products-container [href='//www.despegar.com.ar/hoteles/']"));  
Assert.assertTrue(BotonAlojamiento.isDisplayed());  
BotonAlojamiento.click();
Thread.sleep(1000);
WebElement botonDestino = driver.findElement(By.cssSelector(".input-container .input-tag[placeholder='Ingresá una ciudad, alojamiento o punto de interés']")); 
botonDestino.click();
botonDestino.sendKeys("Córdoba, Córdoba");
Thread.sleep(1000);
botonDestino.sendKeys(Keys.CONTROL);
Thread.sleep(1000);
botonDestino.sendKeys(Keys.ENTER);
Thread.sleep(1000);
WebElement fechaEntrada = driver.findElement(By.cssSelector(".input-container .input-tag[placeholder='Entrada']"));
fechaEntrada.click();
Thread.sleep(2000);
WebElement flechaDerecha = driver.findElement(By.xpath("//div[contains(@class, \"sbox5-floating-tooltip-opened\")] //*[@data-component='datepicker'] //*[@class='calendar-container '] //a[@class='calendar-arrow-right']"));
flechaDerecha.click();
Thread.sleep(3000);
WebElement botonFechaEntrada = driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@data-month='2022-06'] //div[@class='sbox5-monthgrid-datenumber']//div [text()='21']")); 
botonFechaEntrada.click();
Thread.sleep(1000);
WebElement botonFechaSalida =  driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@data-month='2022-06'] //div[@class='sbox5-monthgrid-datenumber sbox5-monthgrid-datenumber-29']"));  
botonFechaSalida.click();
Thread.sleep(1000);
WebElement botonApply =  driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='calendar-footer'] //button[@class='sbox5-3-btn -primary -md'] "));  
botonApply.click();
Thread.sleep(1000);
WebElement botonHabitaciones =  driver.findElement(By.xpath("//div[@class='home-ui-searchbox-container default-container ']//input[@class='sbox5-3-first-input'] "));  
botonHabitaciones.click();
Thread.sleep(1000);
WebElement botonAumentarAdulto =  driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened'] //div[@class='stepper__room__row'] [1]//button[@class='steppers-icon-right stepper__icon']"));  
botonAumentarAdulto.click();
Thread.sleep(1000);
WebElement botonAumentarMenor =  driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened'] //div[@class='stepper__room__row'] [2]//button[@class='steppers-icon-right stepper__icon']"));  
botonAumentarMenor.click();
Thread.sleep(1000);
WebElement botonSeleccionarEdad =  driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened'] //div[@class='stepper__room__row'] [3]//select[@class='select'] //option[@value='8'] "));  
botonSeleccionarEdad.click();
Thread.sleep(2000);
WebElement botonBusqueda =  driver.findElement(By.xpath("//button[@class='sbox5-box-button-ovr sbox5-3-btn -secondary -icon -lg']"));  
botonBusqueda.click();
Thread.sleep(1000);
//WebElement BotonVerDetalleprimerResultado = driver.findElement(By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div/div[2]/aloha-list-view-container/div[2]/div[1]/aloha-cluster-container/div/div/div[2]/aloha-cluster-pricebox-container/div/div[2]/div[2]/aloha-button/button")); 
WebElement BotonVerDetalleprimerResultado =  driver.findElement(By.xpath(" //div[@class='results-cluster-container'] [1] //div[@class='cluster-pricebox-container'] //button[@class='eva-3-btn -md -primary -eva-3-fwidth'] [1]"));
System.out.println("Texto encontrado "+ BotonVerDetalleprimerResultado.getText());  Assert.assertTrue(BotonVerDetalleprimerResultado.isDisplayed());
driver.close();
}
}