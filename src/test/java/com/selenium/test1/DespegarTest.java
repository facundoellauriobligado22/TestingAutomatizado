package com.selenium.test1;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import com.selenium.driver.DriverFactory;
import com.selenium.pages.DespegarHomePage;

public class DespegarTest extends DriverFactory 
{
	DespegarHomePage home;
	String url = "https://www.despegar.com.ar";
	WebDriver driver;
				
	@BeforeMethod
	
	public void setUp() {
		WebDriver driver = DriverFactory.LevantarBrowser(url);
		home = new DespegarHomePage(driver);
	}

	@Test
	public void testHome() throws InterruptedException {
		home.IngresaraAlojamientos();
		home.SeleccionarUnDestino();
		home.SeleccionarFechas();
		home.SeleccionarHabitaciones();
		home.DespegarResultPage();
		//Llamamos al result page y utilizamos su metodo para validar.
		home.DespegarResultPage().ValidacionResultPage();
	}
	
	@AfterMethod
	public void FinishTest() {
		//DriverFactory.CloseBrowser();
	}
}
