package com.selenium.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DespegarHomePage {
	//Inicializo el driver.
	private WebDriver driver;
	//Acá llamo a todos los elementos html con su correspondiente path.
	
	@FindBy(css = "a.lgpd-banner--button.eva-3-btn.-white.-md")
    private WebElement buttonEntendiCookies;
	
	@FindBy(css = ".header-products-container [href='//www.despegar.com.ar/hoteles/']" )
	private WebElement BotonAlojamiento;

	@FindBy(css = ".input-container .input-tag[placeholder='Ingresá una ciudad, alojamiento o punto de interés']")
    private WebElement botonDestino;
	
	@FindBy(css = ".input-container .input-tag[placeholder='Entrada']")
	private WebElement fechaEntrada;
	
	@FindBy(xpath = "//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened'] //*[@data-component='datepicker'] //*[@class='calendar-container '] //a[@class='calendar-arrow-right']")
	private WebElement flechaDerecha;
	
	@FindBy(xpath = "//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@data-month='2022-07'] //div[@class='sbox5-monthgrid-datenumber']//div [text()='21']")
	private WebElement botonFechaEntrada;
	
	@FindBy(xpath = "//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@data-month='2022-07'] //div[@class='sbox5-monthgrid-datenumber']//div [text()='26']")
	private WebElement botonFechaSalida; 
	
	@FindBy(xpath = "//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='calendar-footer'] //button[@class='sbox5-3-btn -primary -md'] //em [text()='Aplicar']")
	private WebElement botonApply;  
	
	@FindBy(xpath = "//*[@id=\"searchbox-sbox-box-hotels\"]/div/div/div[2]/div[3]/div/div/div[1]")
	private WebElement botonHabitaciones; 
	
	@FindBy(xpath = "//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened'] //div[@class='stepper__room__row'] [1]//button[@class='steppers-icon-right stepper__icon']")
	private WebElement botonAumentarAdulto;
	
	@FindBy(xpath = "//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened'] //div[@class='stepper__room__row'] [2]//button[@class='steppers-icon-right stepper__icon']")
	private WebElement botonAumentarMenor;
  
	@FindBy(css = "div.select__row__options__container select option.select-option")
	private WebElement edades;
	
	@FindBy(xpath = "//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened'] //div[@class='stepper__room__row'] [3]//select[@class='select'] //option[@value='8'] ")
	private WebElement botonSeleccionarEdad;  
	@FindBy(xpath = "//button[@class='sbox5-box-button-ovr sbox5-3-btn -secondary -icon -lg']")
	private WebElement botonBusqueda; 
	WebDriverWait wait = null;
	
	public DespegarHomePage(WebDriver driver)
	{
		this.driver = driver;
		//Inicializa todos los elementos declarados arriba
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 30);
	}
	public void IngresaraAlojamientos() {
		BotonAlojamiento.click();
	}
	public void SeleccionarUnDestino(String ciudad) throws InterruptedException {
		botonDestino.click();
		botonDestino.sendKeys(ciudad);
		Thread.sleep(1000);
		botonDestino.sendKeys(Keys.CONTROL);
		Thread.sleep(1000);
		botonDestino.sendKeys(Keys.ENTER);
	}
	public void SeleccionarFechas() {
		wait.until(ExpectedConditions.visibilityOf(buttonEntendiCookies));
		buttonEntendiCookies.click();
		wait.until(ExpectedConditions.visibilityOf(fechaEntrada));
		fechaEntrada.click();
		wait.until(ExpectedConditions.visibilityOf(flechaDerecha));
		flechaDerecha.click();
		wait.until(ExpectedConditions.visibilityOf(botonFechaEntrada));
		botonFechaEntrada.click();
		wait.until(ExpectedConditions.visibilityOf(botonFechaSalida));
		botonFechaSalida.click();
		wait.until(ExpectedConditions.visibilityOf(botonApply));
		botonApply.click();
		
	}
	public void SeleccionarHabitaciones() {
		wait.until(ExpectedConditions.visibilityOf(botonHabitaciones));
		botonHabitaciones.click();
		wait.until(ExpectedConditions.visibilityOf(botonAumentarAdulto));
		botonAumentarAdulto.click();
		wait.until(ExpectedConditions.visibilityOf(botonAumentarMenor));
		botonAumentarMenor.click();

	}
	public void Lista() {
		List<WebElement> listaEdades = driver.findElements(By.cssSelector("div.select__row__options__container select option.select-option"));
		for(WebElement elemento : listaEdades) {
			Assert.assertTrue(elemento.isDisplayed(), "El elemento no es visible.");
		}
		wait.until(ExpectedConditions.visibilityOf(botonSeleccionarEdad));
		botonSeleccionarEdad.click();
	}
	public DespegarResultPage DespegarResultPage() {
		wait.until(ExpectedConditions.visibilityOf(botonBusqueda));
		botonBusqueda.click();
		return new DespegarResultPage(this.driver);
	}
}
