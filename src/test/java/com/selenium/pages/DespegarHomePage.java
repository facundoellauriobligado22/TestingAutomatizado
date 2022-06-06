package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespegarHomePage {
	//Inicializo el driver.
	private WebDriver driver;
	//Acá llamo a todos los elementos html con su correspondiente path.
	
	@FindBy(css = "a.lgpd-banner--button")
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
	public void SeleccionarUnDestino() throws InterruptedException {
		botonDestino.click();
		botonDestino.sendKeys("Córdoba, Córdoba");
		Thread.sleep(1000);
		botonDestino.sendKeys(Keys.CONTROL);
		Thread.sleep(1000);
		botonDestino.sendKeys(Keys.ENTER);
	}
	public void SeleccionarFechas() {
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
		wait.until(ExpectedConditions.visibilityOf(botonSeleccionarEdad));
		botonSeleccionarEdad.click();
		wait.until(ExpectedConditions.visibilityOf(botonBusqueda));
		botonBusqueda.click();
	}
	public DespegarResultPage DespegarResultPage() {
		return new DespegarResultPage(this.driver);
	}
}
