package returncustomerhk;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import selectdriver.DriverTools;
import createfile.CreateFile;

public class Test_women_ReturnCustomer_HK {
	// static WebDriver driver;
	DriverTools dTools = new DriverTools();
	WebDriver driver;
	Actions action;
	int sleepTime;
	String price_shoes1; // 先定为String类型
	String price_shoes2; // 先定为String类型
	Map<Integer, String> map = new HashMap<Integer, String>(); // 截图名称
	static CreateFile cf;
	static String imgName = null;
	static String imgName2 = null;

	public Test_women_ReturnCustomer_HK() throws InterruptedException {
		driver = dTools.getDriver();
		cf = new CreateFile();
		imgName = cf.ImageName("ReturnCustomerHK");
		// driver = new FirefoxDriver();
		driver.manage().window().maximize();
		action = new Actions(driver);
		price_shoes1 = null;
		price_shoes2 = null;
		sleepTime = 3000; // 休眠时间
		// 截图名称
		map.put(1, "Error_openURL.png");
		map.put(2, "Error_localAllSports.png");
		map.put(6, "Error_localSportPractice.png");
		map.put(7, "Error_localGender.png");
		map.put(8, "Error_inputPrice.png");
		map.put(9, "Error_clickConfirm.png");
		map.put(11, "Error_choiceWomanShoes.png");
		map.put(12, "Error_skip.png");
		map.put(14, "Error_clickWhiteShoes.png");
		map.put(15, "Error_clickShoesSize.png");
		map.put(16, "Error_clickAdd.png");
		map.put(17, "Error_addToCart.png");
		map.put(18, "Error_addToCart.png");
		map.put(19, "Error_typeSearchBar.png");
		map.put(20, "Error_clickSearchBar.png");
		map.put(21, "Error_ChoiceTshirt.png");
		map.put(22, "Error_skip.png");
		map.put(23, "Error_clickShirtSize.png");
		map.put(24, "Error_addToCart.png");
		map.put(25, "Error_outofStore.png");
		map.put(26, "Error_moveCartButton.png");
		map.put(28, "Error_findPrice.png");
		map.put(29, "The_Price.png");
		map.put(30, "Error_addShoes.png");
		map.put(31, "Error_removeTshirt.png");
		map.put(32, "Error_inputCounpon.png");
		map.put(34, "Error_Payment.png");
		map.put(35, "Error_inputName.png");
		map.put(36, "Error_inputPassword.png");
		map.put(37, "Error_clickLogin.png");
		map.put(39, "Error_alertExpress.png");
		map.put(41, "Error_clickNextStep.png");
		map.put(42, "Error_clickOnCash.png");
		map.put(43, "Error_clickPlaceOrder.png");
		//
		map.put(101, "Page_Openurl.png");
		map.put(102, "Page_SelectNvShiPaoBuXie1.png");
		map.put(103, "Page_SelectNvShiPaoBuXie2.png");
		map.put(104, "Page_SelectTshirt1.png");
		map.put(105, "Page_SelectTshirt2.png");
		map.put(106, "Page_Checkcart1.png");
		map.put(107, "Page_Userlogin.png");
		map.put(108, "Page_Checkcart1.png");
		map.put(109, "Page_Paymentinformation.png");
	}

	// 截图
	public static void snapShot2(TakesScreenshot drivername, String filename,
			int count) {
		String currentPath = System.getProperty("user.dir"); // 获取用户当前路径
		File scrFile = (File) drivername.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String time = sdf.format(new Date());
		try {
			FileUtils.copyFile(scrFile, new File(currentPath + "\\image" + "\\"
					+ imgName + "\\" + time + "_" + count + filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 截图2
	public static void snapShot(TakesScreenshot drivername, String filename,
			int count) {
		imgName2 = cf.ImageName("ReturnCustomerHK_Error");
		String currentPath = System.getProperty("user.dir"); // 获取用户当前路径
		File scrFile = (File) drivername.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String time = sdf.format(new Date());
		try {
			FileUtils.copyFile(scrFile, new File(currentPath + "\\image" + "\\"
					+ imgName2 + "\\" + time + "_" + count + filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 跳转窗口
	public void switchToWin() throws InterruptedException { // 页面跳转
		String currentWindow = driver.getWindowHandle(); // 获取当前窗口句柄
		Set<String> handles = driver.getWindowHandles(); // 获取所有窗口句柄
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			if (currentWindow == it.next()) {
				continue;
			}
			driver.switchTo().window(it.next()); // 切换到新窗口
		}
	}

	public void openURL(String url, int count) throws Exception { // 1.打开网站-----HK
		try {
			driver.get(url);
			System.out.println("2.open url");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(1), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void moveOnSYYDFL(int count) throws Exception { // 2.鼠标滑动运动分类->跑步运动->点击女装跑步鞋-----HK
		Thread.sleep(sleepTime);
		snapShot2((TakesScreenshot) driver, // 打开页面---截图101
				map.get(101), count);
		try {
			WebElement webElement;
			WebElement webElement2;
			WebElement webElement3;
			Thread.sleep(sleepTime);
			boolean flag = true;
			int count_c = 1;
			while (flag) { // 循环--->直到点击到“女装跑步鞋”为止
				webElement = driver.findElement(By
						.xpath("//a[@class='nav-sports']"));
				for (int i = 0; i < 111; i++) {
					action.moveToElement(webElement).build().perform();
					System.out.println("out" + i);
				}
				webElement2 = driver
						.findElement(By
								.xpath("//nav[@id='nav-sub-items']/div[1]/ul[1]/li[4]/a"));
				for (int i = 1; i < 111; i++) {
					action.moveToElement(webElement2).build().perform();
					System.out.println("int" + i);
				}
				webElement3 = driver.findElement(By
						.xpath("//a/span[contains(text(),'女裝跑步鞋')]"));
				flag = !webElement3.isDisplayed();
				if (!flag) {
					webElement3.click();
				}
				count_c++;
				if (count_c == 9) {
					System.out.println("3.women shoes");
					break;
				}
			}
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(2), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void clickYDFW(int count) throws Exception { // 6.选择运动范围-----HK
		Thread.sleep(sleepTime);
		snapShot2((TakesScreenshot) driver, // 点击女士跑步鞋---截图2
				map.get(102), count);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement webElement = wait
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By
									.xpath("//a[contains(text(),'10 公里以下')]"));
						}
					});
			action.moveToElement(webElement).build().perform();
			action.moveToElement(webElement).click().perform();
			System.out.println("4.sport range");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(6), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void clickXB(int count) throws Exception { // 7.选择性别-----HK
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement webElement = wait
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By
									.xpath("//a[contains(text(),'女款')]"));
						}
					});
			action.moveToElement(webElement).build().perform();
			action.moveToElement(webElement).click().perform();
			System.out.println("5.gender");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(7), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void inputPriceFrom(int count) throws Exception { // 8.输入价格范围——从-----HK
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement webElement = wait
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By.id("price-from"));
						}
					});
			action.moveToElement(webElement).build().perform();
			webElement.clear();
			driver.findElement(By.id("price-from")).sendKeys("0");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(8), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void inputPriceTo(int count) throws Exception { // 9.输入价格范围——到-----Hk
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement webElement = wait
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By.id("price-to"));
						}
					});
			action.moveToElement(webElement).build().perform();
			webElement.clear();
			driver.findElement(By.id("price-to")).sendKeys("300");
			System.out.println("6.price range");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(8), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void clickJGQJQD(int count) throws Exception { // 10.点击价格区间确定-----HK
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement webElement = wait
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By.id("btn-range"));
						}
					});
			action.moveToElement(webElement).build().perform();
			action.moveToElement(webElement).click().perform();
			Thread.sleep(sleepTime);
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(9), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void choiceNSPBX(int count) throws Exception { // 12.选择女士跑步鞋-----HK
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement webElement = wait
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By
									.xpath("//img[@alt='EKIDEN 100 女款跑步鞋 - 白/粉紅']"));
						}
					});
			action.moveToElement(webElement).build().perform();
			action.moveToElement(webElement).click().perform();
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(11), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void windowSkip(int count) throws Exception { // 13.窗口跳转-----HK
		try {
			switchToWin();
			snapShot2((TakesScreenshot) driver, // 点击女士跑步鞋---截图3
					map.get(103), count);
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(12), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void choiceYellow(int count) throws Exception { // 15.选择淡蓝色的鞋子-----HK
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//img[@title='白色']"));
				}
			}).click();
			System.out.println("7.black");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(14), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void choice36Size(int count) throws Exception { // 16.选择40码-----HK
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By
							.xpath("//a[contains(text(),'38碼 ')]"));
				}
			}).click();
			System.out.println("8.38 size");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(15), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void increaseNum(int count) throws Exception { // 17.增加鞋子的数量-----HK
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By
							.xpath("//button[@title='Increase']"));
				}
			}).click();
			System.out.println("9.add 1");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(16), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void joinCart(int count) throws Exception { // 18.加入购物车-----HK
		try {
			Thread.sleep(sleepTime);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement webElement = wait
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By
									.xpath("//button[@title='加入購物車']"));
						}
					});
			action.moveToElement(webElement).build().perform();
			action.moveToElement(webElement).click().perform();
			System.out.println("10.add to cart");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(17), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void product_view(int count) throws Exception { // 19.判断是否缺货-----HK
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement webElement = wait
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By
									.xpath("//div[@id='messages_product_view']/ul/li/ul/li/span"));
						}
					});
			if (webElement.getText().trim().substring(0, 2).equals("訂購")) {
				snapShot((TakesScreenshot) driver, map.get(25), count);
				System.out.println("10.1.out of store");
				driver.quit();
				throw new Exception();
			}
			Thread.sleep(sleepTime);
			System.out.println("10.1.store");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(18), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void selectT_shirt(int count) throws Exception { // 20.搜索商品-----HK
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.id("search"));
				}
			}).clear();
			driver.findElement(By.id("search")).sendKeys("T-shirt");
			System.out.println("10.2.select t-shirt");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(19), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void clickSelect(int count) throws Exception { // 21.点击搜索按钮-----HK
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//button[@title='搜尋']"));
				}
			}).click();
			System.out.println("11.search t-shirt");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(20), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void choiceT_shirt(int count) throws Exception { // 22.选择一件-----HK
		Thread.sleep(sleepTime);
		snapShot2((TakesScreenshot) driver, // 选择T-shirt---截图4
				map.get(104), count);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement webElement = wait
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By
									.xpath("//img[@alt='長袖男裝T-shirt']"));
						}
					});
			action.moveToElement(webElement).build().perform();
			action.moveToElement(webElement).click().perform();
			Thread.sleep(sleepTime);
			System.out.println("12.choice a t-shirt");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(21), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void windowSkip2(int count) throws Exception { // 23.窗口跳转-----HK
		try {
			String currentWindow = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> it = handles.iterator();
			while (it.hasNext()) {
				it.next();
				if (currentWindow == it.next()) {
					continue;
				}
				driver.switchTo().window(it.next());
			}
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(22), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void choiceT_shirt_Size(int count) throws Exception { // 23.2.选择尺码-----HK
		Thread.sleep(sleepTime);
		snapShot2((TakesScreenshot) driver, // 选择T-shirt---截图5
				map.get(105), count);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//a[@title='S ']"));
				}
			}).click();
			System.out.println("13.M size");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(23), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void joinCart_Tshirt(int count) throws Exception { // 24.加入购物车-----HK
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement webElement = wait
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By
									.xpath("//button[@title='加入購物車']"));
						}
					});
			action.moveToElement(webElement).build().perform();
			action.moveToElement(webElement).click().perform();
			Thread.sleep(sleepTime);
			System.out.println("14.add to cart");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(24), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void product_view_tshirt(int count) throws Exception { // 25.判断是否缺货-----HK
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement webElement = wait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				return d.findElement(By
						.xpath("//div[@id='messages_product_view']/ul/li/ul/li/span"));
			}
		});
		if (webElement.getText().trim().substring(0, 2).equals("訂購")) {
			snapShot((TakesScreenshot) driver, map.get(25), count);
			System.out.println("15.out of store");
			driver.quit();
			throw new Exception();
		}
		Thread.sleep(sleepTime);
		System.out.println("15.goods normal");
	}

	public void moveOnCart(int count) throws Exception { // 26.鼠标移动到购物车上-----HK
		try {
			WebElement webElementin = driver.findElement(By
					.className("top-cart"));
			WebElement webElement2 = driver.findElement(By
					.id("topcart-checkout"));
			while (true) {
				action.moveToElement(webElementin).build().perform();
				WebDriverWait wait = new WebDriverWait(driver, 10);
				Boolean flag2 = wait.until(new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver d) {
						return d.findElement(By.id("topcart-checkout"))
								.isDisplayed();
					}
				});
				if (flag2) {
					webElement2.click();// 点击去购物车结算
					break;
				}
			}
			Thread.sleep(sleepTime);
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(26), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void countPrice_One(int count) throws Exception { // 28.查看价格-----HK
		String shoesPrice = null;
		String shirtPrice = null;
		String totalSPrice = null;
		String totalBPrice = null;
		try {
			shoesPrice = driver.findElement(
					By.xpath("//table[1]/tbody/tr/td[6]/span/span")).getText();
			shirtPrice = driver.findElement(
					By.xpath("//table[2]/tbody/tr/td[6]/span/span")).getText();
			totalSPrice = driver
					.findElement(
							By.xpath("//table[@id='shopping-cart-totals-table']/tbody/tr/td[2]/span"))
					.getText();
			totalBPrice = driver
					.findElement(
							By.xpath("//table[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/span"))
					.getText();
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(28), count);
			driver.quit();
			throw new Exception();
		}
		//
		shoesPrice = shoesPrice.replaceAll(",", "");
		shirtPrice = shirtPrice.replaceAll(",", "");
		totalSPrice = totalSPrice.replaceAll(",", "");
		totalBPrice = totalBPrice.replaceAll(",", "");
		//
		double shoesPriced = Double.parseDouble(shoesPrice.substring(3,
				shoesPrice.length()));
		double shirtPriced = Double.parseDouble(shirtPrice.substring(3,
				shirtPrice.length()));
		double totalSPriced = Double.parseDouble(totalSPrice.substring(3,
				totalSPrice.length()));
		double totalBPriced = Double.parseDouble(totalBPrice.substring(3,
				totalBPrice.length()));
		if (shoesPriced + shirtPriced == totalSPriced
				&& totalSPriced == totalBPriced) {
			System.out.println(shoesPriced + "+" + shirtPriced + "="
					+ totalSPriced + "=" + totalBPriced);
			System.out.println("The price is normal");
		} else {
			System.out.println("The price is error");
			snapShot((TakesScreenshot) driver, map.get(29), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void addShoesQuanity(int count) throws Exception { // 29.增加鞋子的数量-----HK
		snapShot2((TakesScreenshot) driver, // 查看购物车---截图6
				map.get(106), count);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By
							.xpath("//table[1]/tbody/tr/td[5]/div/button[2]"));
				}
			}).click();
			System.out.println("17.add shoes quantity");
			Thread.sleep(sleepTime);
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(30), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void removeT_shirt(int count) throws Exception { // 30.删除T-shirt-----HK
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By
							.xpath("//table[4]/tbody/tr/td[7]/button"));
				}
			}).click();
			System.out.println("18.delete t-shirt");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(31), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void countPrice_Two(int count) throws Exception { // 31.鞋子的价格-----HK
		String shoesPrice = null;
		String totalSPrice = null;
		String totalBPrice = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			shoesPrice = wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By
							.xpath("//table[1]/tbody/tr/td[6]/span/span"));
				}
			}).getText();
			WebDriverWait wait2 = new WebDriverWait(driver, 10);
			totalSPrice = wait2.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By
							.xpath("//table[@id='shopping-cart-totals-table']/tbody/tr/td[2]/span"));
				}
			}).getText();
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			totalBPrice = wait3.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By
							.xpath("//table[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/span"));
				}
			}).getText();
			//
			shoesPrice = shoesPrice.replaceAll(",", "");
			totalSPrice = totalSPrice.replaceAll(",", "");
			totalBPrice = totalBPrice.replaceAll(",", "");
			//
			shoesPrice = shoesPrice.substring(3, shoesPrice.length());
			totalSPrice = totalSPrice.substring(3, totalSPrice.length());
			totalBPrice = totalBPrice.substring(3, totalBPrice.length());
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(28), count);
			driver.quit();
			throw new Exception();
		}
		double shoesPriced = Double.parseDouble(shoesPrice);
		double totalSPriced = Double.parseDouble(totalSPrice);
		double totalBPriced = Double.parseDouble(totalBPrice);
		if (shoesPriced == totalSPriced && totalSPriced == totalBPriced) {
			System.out.println(shoesPriced + "=" + totalSPriced + "="
					+ totalBPriced);
			System.out.println("The price is normal");
		} else {
			System.out.println("The price is error");
			snapShot((TakesScreenshot) driver, map.get(29), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void clickPayment(int count) throws Exception { // 35.点击去结算-----HK
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			wait3.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//button[@title='結帳']"));
				}
			}).click();
			System.out.println("21.payment");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(34), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void inputUserName(String username, int count) throws Exception { // 36.输入用户名-----HK
		snapShot2((TakesScreenshot) driver, // 用户登录---截图7
				map.get(107), count);
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			wait3.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.id("email"));
				}
			}).clear();
			driver.findElement(By.id("email")).sendKeys(username);
			System.out.println("22.input username");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(35), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void inputPasswd(String passwd, int count) throws Exception { // 37.输入密码-----HK
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			wait3.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.id("pass"));
				}
			}).clear();
			driver.findElement(By.id("pass")).sendKeys(passwd);
			System.out.println("23.input password");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(36), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void clickLogin(int count) throws Exception { // 38.点击登录按钮-----HK
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			wait3.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.id("send2"));
				}
			}).click();
			System.out.println("24.login");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(37), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void clickPaymentFinal(int count) throws Exception { // 40.点击去结算-----HK
		snapShot2((TakesScreenshot) driver, // 登录之后的购物车显示---截图8
				map.get(108), count);
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			wait3.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//button[@title='結帳']"));
				}
			}).click();
			System.out.println("25.payment");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(34), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void checkAddress(int count) throws Exception { // 41.账单地址-----HK
		Thread.sleep(sleepTime);
		snapShot2((TakesScreenshot) driver, // 去结账支付信息---截图9
				map.get(109), count);
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			WebElement webElement = wait3
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By
									.xpath("//button[@id='checkout-save-shipping']"));
						}
					});
			Thread.sleep(sleepTime);
			action.moveToElement(webElement).build().perform();
			action.moveToElement(webElement).click().perform();
			System.out.println("26.ckeck address");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(39), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void deliveryMethods(int count) throws Exception { // 41.配送方式-----HK
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			WebElement webElement = wait3
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By
									.xpath("//div[@id='shipping-method-buttons-container']/button"));
						}
					});
			Thread.sleep(sleepTime);
			action.moveToElement(webElement).build().perform();
			action.moveToElement(webElement).click().perform();
			System.out.println("27.delivery");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(39), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void paymentMessage(int count) throws Exception { // 41.付费资讯-----HK
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			WebElement webElement = wait3
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By
									.xpath("//div[@id='payment-buttons-container']/button"));
						}
					});
			Thread.sleep(sleepTime);
			action.moveToElement(webElement).build().perform();
			action.moveToElement(webElement).click().perform();
			System.out.println("28.payment message");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(39), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void countPrice_Final(int count) throws Exception { // 45.计算的价格-----HK
		Thread.sleep(sleepTime);
		String Price1 = null;
		String Price3 = null;
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			WebElement webElement = wait3
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By
									.xpath("//table[@id='checkout-totals']/tbody/tr[1]/td/span[1]/span"));
						}
					});
			action.moveToElement(webElement).build().perform();
			Thread.sleep(sleepTime);
			Price1 = webElement.getText();
			Price3 = driver
					.findElement(
							By.xpath("//table[@id='checkout-totals']/tbody/tr[3]/td[2]/div[2]/span"))// 1:
																										// ￥5,908.00
					.getText();
			Price1 = Price1.replaceAll(" ", "");
			Price3 = Price3.replaceAll(" ", "");
			Price1 = Price1.replaceAll(",", "");
			Price3 = Price3.replaceAll(",", "");
			Price1 = Price1.substring(3, Price1.length());
			Price3 = Price3.substring(3, Price3.length());
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(28), count);
			driver.quit();
			throw new Exception();
		}
		double Price1d = Double.parseDouble(Price1);
		double Price3d = Double.parseDouble(Price3);
		System.out.println(Price1 + "=" + Price3);
		if (Price1d == Price3d) {
			System.out.println(Price1 + "=" + Price3);
			System.out.println("The price is normal");
		} else {
			System.out.println("The price is error");
			snapShot((TakesScreenshot) driver, map.get(29), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void checkoutOrder(int count) throws Exception { // 46.提交订单-----HK
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			WebElement webElement = wait3
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By.id("checkout-place-order"));
						}
					});
			action.moveToElement(webElement).build().perform();
			action.moveToElement(webElement).click().perform();
			System.out.println("29.payment");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(43), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void quitDriver(int count) throws Exception { // 47.结束-----HK
		Thread.sleep(5000);
		try {
			driver.quit();
			System.out.println("30.end");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, "quitDriver.png", count);
			driver.quit();
			throw new Exception();
		}
	}
}
