package com.selenium.test1;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import javax.swing.GroupLayout.Group;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import com.selenium.driver.DriverFactory;
import com.selenium.pages.DespegarHomePage;
import com.selenium.pages.DespegarResultPage;

public class DespegarTest extends DriverFactory 
{
	DespegarHomePage home;
	WebDriver driver;
				
	@BeforeMethod(alwaysRun = true)
	
	public void setUp(ITestContext context) {
		String url = context.getCurrentXmlTest().getParameter("URLDespegar");
		WebDriver driver = DriverFactory.LevantarBrowser(url);
		home = new DespegarHomePage(driver);
	}

	@DataProvider (name = "DataProviderDespegar")
	public Object[][] dpMethod(){
		return new Object[][] {{"Córdoba"},{"Mendoza"},{"Salta"}};
	}
	
	@Test (groups = {"despegarTest"} ,dataProvider = "DataProviderDespegar")
	public void testHome(String DataProviderDespegar) throws InterruptedException {
		home.IngresaraAlojamientos();
		home.SeleccionarUnDestino(DataProviderDespegar);
		home.SeleccionarFechas();
		home.SeleccionarHabitaciones();	
		home.Lista();
		DespegarResultPage resultPage = home.DespegarResultPage();
		resultPage.ValidacionResultPage();
	}
	
	@AfterMethod(alwaysRun = true)
	public void FinishTest() {
		DriverFactory.CloseBrowser();
	}
}
