package com.nopcommerce.admin;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManagernopcommerce;
import pageObject.nopCommerce.admin.AdminDashBoardPageObject;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObject.nopCommerce.admin.AdminProductDetailsPageObject;
import pageObject.nopCommerce.admin.AdminProductSearchPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountPageObject;
import pageObjects.nopCommerce.user.UserOdersPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardpointsPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_10_Admin_Upload_Files extends BaseTest {

	private WebDriver driver;
	String productName = "Build your own computer";
	String product2png = "2.png";
	String productAlt = "Compter Atl";
	String productTitle = "Computer Title";
	String productOder = "1";
	private String emailAdmin, passwordAdmin;
	AdminLoginPageObject loginPage;
	AdminDashBoardPageObject dashboardPage;
	AdminProductDetailsPageObject productDetailsPage;
	AdminProductSearchPageObject productSearchPage;

	private String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		loginPage = PageGeneratorManagernopcommerce.getAdminLoginPageObject(driver);

		emailAdmin = "admin@yourstore.com";
		passwordAdmin = "admin";

	}

	//@Test
	public void Admin_01_Login() {
		loginPage = PageGeneratorManagernopcommerce.getAdminLoginPageObject(driver);

		// login at Admin role
		dashboardPage = loginPage.LoginAsAdmin(emailAdmin, passwordAdmin);

		Assert.assertTrue(dashboardPage.isDashBoardHeaderDisplayed());

		dashboardPage.openSubMenuPageByName(driver, "Catalog", " Products");
		productSearchPage = PageGeneratorManagernopcommerce.getAdminProductSearchPageObject(driver);
		// productSearchPage.clickToSearch();

		productSearchPage.enterToProductNameTextbox(productName);

		productSearchPage.clickToSeachButton();
		productDetailsPage = productSearchPage.clickToEditButtonByProductName(productName);
	}

	//@Test
	public void Admin_02_Upload_Files() {

		productDetailsPage.clickToExpanPanelByName("Pictures");

		productDetailsPage.upLoadFileAtCardName(driver, "pictures", product2png);
		Assert.assertTrue(productDetailsPage.isPictureUploadSuccessByFilename("2_100."));
		productDetailsPage.enterToAltTextbox(productAlt);
		productDetailsPage.enterToTitleTextbox(productTitle);
		productDetailsPage.enterToDisplayedOderTextbox("Increase");

		productDetailsPage.clickToAddProductPictureButton();

		Assert.assertTrue(productDetailsPage.isPictureImageDisplayed(productName, productOder, productAlt, productTitle));

		productSearchPage = productDetailsPage.clickToSaveButton();

		Assert.assertTrue(productSearchPage.isSuccessMessageDisplayed("The product has been updated successfully."));

		productSearchPage.enterToProductNameTextbox(productName);

		productSearchPage.clickToSeachButton();
		Assert.assertTrue(productSearchPage.isPictureImageUpdated(productName, productName));

		productDetailsPage = productSearchPage.clickToEditButtonByProductName(productName);

		productDetailsPage.clickToExpanPanelByName("Pictures");
		productDetailsPage.clickToDeleteButtonAtPictureName(productTitle); // accepct alert

		Assert.assertTrue(productDetailsPage.isMesageDisplayedInEmptyTable(driver, "productpictures"));

		productSearchPage = productDetailsPage.clickToSaveButton();

		Assert.assertTrue(productSearchPage.isPictureImageUpdated("default-image", productName));

	}

	
		
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
