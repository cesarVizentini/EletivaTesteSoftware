package testeDeSistema;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class REQ01MantemLivroTests {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "browserDriver/geckodriver.exe"); 
		driver = new FirefoxDriver();
		driver.get("https://ts-scel-web.herokuapp.com/login");
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void ct01cadastrarlivrocomsucesso() {
		// entrando no sistema
		driver.findElement(By.name("username")).click(); 
		driver.findElement(By.name("username")).sendKeys("jose"); 
		driver.findElement(By.name("password")).sendKeys("123"); 
		driver.findElement(By.cssSelector("button")).click(); 
		driver.findElement(By.linkText("Livros")).click();
		
		// cadastrando livro
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("7777");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("catarina");
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).sendKeys("c++");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		// editando titulo
		driver.findElement(By.cssSelector("tr:nth-child(2) .btn-primary")).click();
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).sendKeys("python");
		driver.findElement(By.cssSelector(".btn")).click();
		// editando autor
		driver.findElement(By.cssSelector("tr:nth-child(2) .btn-primary")).click();
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("rinald");
		driver.findElement(By.cssSelector(".btn")).click();
		// excluindo livro
		driver.findElement(By.cssSelector("tr:nth-child(2) .delete")).click();
	}
}
