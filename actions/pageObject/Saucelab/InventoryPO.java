package pageObject.Saucelab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.Saucelab.InventoryPageUI;

public class InventoryPO extends BasePage {
	WebDriver driver;

	public InventoryPO(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInSortDropdown(String dropdownSort) {
		waitForElementClickable(driver, InventoryPageUI.SORT_DROPDOWN);
		selectDropdownByName(driver, InventoryPageUI.SORT_DROPDOWN, dropdownSort);
	}

	public boolean isProductNameSortAsceding() {
		List<WebElement> productNameElement = getListWebElement(driver, InventoryPageUI.PRODUCT_NAME_TEXT);

		List<String> productNameText = new ArrayList<String>();
		for (WebElement productName : productNameElement) {
			productNameText.add(productName.getText());
		}
		// chạy vòng lặp để thấy dữ liệu ntn
		System.out.println("before sort ascending:------------------");
		for (String product : productNameText) {
			System.out.println(product);
		}

		List<String> productNameTextClone = new ArrayList<String>();
		for (String product : productNameText) {
			productNameTextClone.add(product);
		}
		Collections.sort(productNameTextClone);

		System.out.println("after sort ascending:------------------");
		for (String product : productNameText) {
			System.out.println(product);
		}

		return productNameText.equals(productNameTextClone);
	}

	public boolean isProductNameSortDescending() {
		List<WebElement> productNameElement = getListWebElement(driver, InventoryPageUI.PRODUCT_NAME_TEXT);

		List<String> productNameText = new ArrayList<String>();
		for (WebElement productName : productNameElement) {
			productNameText.add(productName.getText());
		}
		// chạy vòng lặp để thấy dữ liệu ntn
		System.out.println("before sort desceding:------------------");
		for (String product : productNameText) {
			System.out.println(product);
		}

		List<String> productNameTextClone = new ArrayList<String>();
		for (String product : productNameText) {
			productNameTextClone.add(product);
		}
		Collections.sort(productNameTextClone);
		Collections.reverse(productNameTextClone);

		System.out.println("after sort desceding:------------------");
		for (String product : productNameTextClone) {
			System.out.println(product);
		}

		return productNameText.equals(productNameTextClone);
	}

	public boolean isProductPriceSortAsceding() {
		List<WebElement> productPriceElements = getListWebElement(driver, InventoryPageUI.PRODUCT_PRICE_TEXT);

		List<Float> productPriceValue = new ArrayList<Float>();
		for (WebElement productPrice : productPriceElements) {
			Float productPriceNumber = Float.parseFloat(productPrice.getText().replace("$", ""));
			productPriceValue.add(productPriceNumber);
		}
		// chạy vòng lặp để thấy dữ liệu ntn
		System.out.println("before sort ascending:------------------");
		for (Float productPrice : productPriceValue) {
			System.out.println(productPrice);
		}

		List<Float> productPriceTextClone = new ArrayList<Float>();
		for (Float productPrice : productPriceValue) {
			productPriceTextClone.add(productPrice);
		}
		Collections.sort(productPriceTextClone);

		System.out.println("after sort ascending:------------------");
		for (Float productPrice : productPriceValue) {
			System.out.println(productPrice);
		}

		return productPriceValue.equals(productPriceTextClone);
	}

	public boolean isProductPriceSortDesceding() {
		List<WebElement> productPriceElements = getListWebElement(driver, InventoryPageUI.PRODUCT_PRICE_TEXT);

		List<Float> productPriceValue = new ArrayList<Float>();
		for (WebElement productPrice : productPriceElements) {
			Float productPriceNumber = Float.parseFloat(productPrice.getText().replace("$", ""));
			productPriceValue.add(productPriceNumber);
		}
		// chạy vòng lặp để thấy dữ liệu ntn
		System.out.println("before sort ascending:------------------");
		for (Float productPrice : productPriceValue) {
			System.out.println(productPrice);
		}

		List<Float> productPriceTextClone = new ArrayList<Float>();
		for (Float productPrice : productPriceValue) {
			productPriceTextClone.add(productPrice);
		}
		Collections.sort(productPriceTextClone);
		Collections.reverse(productPriceTextClone);

		System.out.println("after sort ascending:------------------");
		for (Float productPrice : productPriceValue) {
			System.out.println(productPrice);
		}

		return productPriceValue.equals(productPriceTextClone);
	}

}
