package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DespegarResultPage {
	//Inicializo el driver.
	private WebDriver driver;
	WebDriverWait wait = null;
	//Acá llamo a todos los elementos html con su correspondiente path.
	@FindBy(xpath = " //div[@class='results-cluster-container'] [1] //div[@class='cluster-pricebox-container'] //button[@class='eva-3-btn -md -primary -eva-3-fwidth'] [1]")
	private WebElement BotonVerDetalleprimerResultado;
	
	public DespegarResultPage(WebDriver driver)
	{
		this.driver = driver;
		//Inicializa todos los elementos declarados arriba
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 30);
	}
	
	//Realizamos las validacions correspondientes.
	public void ValidacionResultPage() {
		System.out.println("Texto encontrado "+ BotonVerDetalleprimerResultado.getText());  Assert.assertTrue(BotonVerDetalleprimerResultado.isDisplayed()); 
	}
}
