package testngfiles;

import org.testng.annotations.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utility.BrowserSetup;
import Utility.BrowserSetup.Browser;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class NewTesthreo1 {
	public BrowserSetup b;
	public WebDriver wd = null;

	@BeforeClass
	public void beforeClass() throws Exception {
		b = new BrowserSetup(Browser.CHROME, false);
		wd = b.navigateToURL("https://the-internet.herokuapp.com/tables");
		Assert.assertEquals(wd.getTitle(), "The Internet");
	}

	@AfterClass
	public void afterClass() {
		wd.quit();
	}

	@Test(priority = 1)
	public void SortTest() {
		wd.findElement(By.xpath("//table[1]/thead/tr/th[1]")).click();
		Assert.assertEquals(wd.findElement(By.xpath("//table[1]/thead/tr/th[1]")).getText(), "Last Name");
		List<WebElement> lastname = wd.findElements(By.xpath("//table[1]/tbody/tr/td[1]"));
		List<String> lastname1 = lastname.stream().map(element -> element.getText()).collect(Collectors.toList());
		lastname1.forEach(System.out::println);
		List<String> lastname2 = lastname1.stream().sorted().collect(Collectors.toList());
		lastname2.forEach(System.out::println);
		Assert.assertEquals(lastname1, lastname2);
	}

	@Test(priority = 2)
	public void getPriceTest() {
		List<WebElement> listlastname = wd.findElements(By.xpath("//table[2]/tbody/tr/td[4]"));
		List<String> list1 = listlastname.stream().map(element -> element.getText()).collect(Collectors.toList());
		list1.forEach(System.out::println);
		System.out.println();
		list1.stream().filter(due -> due.contains("$50")).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println();
		List<String> expectation = new ArrayList<>();
		expectation.add("Bach");
		List<String> result = listlastname.stream().filter(element -> element.getText().contains("$51"))
				.map(element -> element.findElement(By.xpath("preceding-sibling::*[last()]")))
				.map(element -> element.getText()).collect(Collectors.toList());
		Assert.assertEquals(result, expectation);
	}
}

