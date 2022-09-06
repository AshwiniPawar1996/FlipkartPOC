package com.flipkart.action;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.flipkart.base.BaseClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActionClass extends BaseClass {
	


		@SuppressWarnings("deprecation")
		public static void implicitWait(WebDriver driver, int timeOut) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}

		@SuppressWarnings("deprecation")
		public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
			driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
			
		}

		public static void click(WebDriver driver, WebElement ele) {
			Actions act = new Actions(driver);
			act.moveToElement(ele).click().build().perform();
			
		}

		public static boolean isDisplayed(WebDriver driver, WebElement ele) {
			// TODO Auto-generated method stub
			boolean flag = false;
			flag = findElement(driver, ele);
			if (flag) {
				flag = ele.isDisplayed();
				if (flag) {
					System.out.println("The element is Displayed");
				} else {
					System.out.println("The element is not Displayed");
				}
			} else {
				System.out.println("Not displayed ");
			}
			return flag;
		}

		private static boolean findElement(WebDriver driver, WebElement ele) {
			// TODO Auto-generated method stub
			boolean flag = false;
			try {
				ele.isDisplayed();
				flag = true;
			} catch (Exception e) {
				// System.out.println("Location not found: "+locatorName);
				flag = false;
			} finally {
				if (flag) {
					System.out.println("Successfully Found Element");

				} else {
					System.out.println("Unable to locate Element");
				}
			}
			return flag;
		}
		
		public static boolean type(WebElement ele, String text) {
			boolean flag = false;
			try {
				flag = ele.isDisplayed();
				ele.clear();
				ele.sendKeys(text);
				// logger.info("Entered text :"+text);
				flag = true;
			} catch (Exception e) {
				System.out.println("Location Not found");
				flag = false;
			} finally {
				if (flag) {
					System.out.println("Successfully entered value");
				} else {
					System.out.println("Unable to enter value");
				}

			}
			return flag;
		}
		
		public static boolean selectByVisibleText(String i, WebElement ele) {
			boolean flag = false;
			try {
				Select s = new Select(ele);
				s.selectByVisibleText(i);
				flag = true;
				return true;
			} catch (Exception e) {
				return false;
			} finally {
				if (flag) {
					System.out.println("Option selected by VisibleText");
				} else {
					System.out.println("Option not selected by VisibleText");
				}
			}
		}
		
		public static String screenShot(WebDriver driver, String filename) {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "\\Screenshots\\" + filename + "_" + dateName + ".png";

			try {
				FileUtils.copyFile(source, new File(destination));
			} catch (Exception e) {
				e.getMessage();
			}
			return destination;
		
		}
			
			
			public String getTitle(WebDriver driver) {
				boolean flag = false;

				String text = driver.getTitle();
				if (flag) {
					System.out.println("Title of the page is: \""+text+"\"");
				}
				return text;
			}
			
			}



