package br.banco.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAutomatizado {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"/Users/fibbauru-15/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();	
		driver.get("http://www.google.com.br");
		WebElement campoDeTexto = driver.findElement(By.name("q"));
		campoDeTexto.sendKeys("javali");
		campoDeTexto.submit();
		driver.close();
		
	}
}
