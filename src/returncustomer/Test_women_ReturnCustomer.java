package returncustomer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

public class Test_women_ReturnCustomer {
	static WebDriver driver;
	Actions action;
	int sleepTime;
	String price_shoes1; // 先定为String类型
	String price_shoes2; // 先定为String类型
	Map<Integer, String> map = new HashMap<Integer, String>(); // 截图名称
	static CreateFile cf = new CreateFile();
	static String imgName = null;

	public Test_women_ReturnCustomer() throws InterruptedException {
//		driver = new FirefoxDriver();
//		driver.manage().window().maximize();
		DriverTools d=new DriverTools();
		driver=d.getDriver();
		driver.manage().window().maximize();
		action = new Actions(driver);
		price_shoes1 = null;
		price_shoes2 = null;
		sleepTime = 3000; // 休眠时间
		// 截图名称
		map.put(1, "Error_openURL.png");
		map.put(2, "Error_localAllSports.png");
		map.put(3, "Error_localRunning.png");
		map.put(4, "Error_localWomenShoes.png");
		map.put(5, "Error_clickWomanShoes.png");
		map.put(6, "Error_localSportPractice.png");
		map.put(7, "Error_localGender.png");
		map.put(8, "Error_inputPrice.png");
		map.put(9, "Error_clickConfirm.png");
		map.put(10, "Error_shoesPrice.png");
		map.put(11, "Error_choiceWomanShoes.png");
		map.put(12, "Error_skip.png");
		map.put(13, "Error_shoesPrice.png");
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
		map.put(27, "Error_Payment.png");
		map.put(28, "Error_findPrice.png");
		map.put(29, "The_Price.png");
		map.put(30, "Error_addShoes.png");
		map.put(31, "Error_removeTshirt.png");
		map.put(32, "Error_inputCounpon.png");
		map.put(33, "Error_clickCounpon.png");
		map.put(34, "Error_Payment.png");
		map.put(35, "Error_inputName.png");
		map.put(36, "Error_inputPassword.png");
		map.put(37, "Error_clickLogin.png");
		map.put(38, "Error_clickCancelCounpon.png");
		map.put(39, "Error_alertExpress.png");
		map.put(40, "Error_choiceShunFengDelivery.png");
		map.put(41, "Error_clickNextStep.png");
		map.put(42, "Error_clickOnCash.png");
		map.put(43, "Error_clickPlaceOrder.png");
	}

	// 截图
	public static void snapShot(TakesScreenshot drivername, String filename,
			int count) {
		imgName = cf.ImageName("ReturnCustomer");
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

	public void openURL(String url, int count) throws Exception { // 1.打开网站
		
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
			
//			if ( DriverTools.Judge1()==1){
//				 driver.get("https://gateway.zscaler.net/auT?origurl=http%3A%2F%2Fwww%2egoogle%2ecom%2f");
//				 Thread.sleep(5000);
//				 WebDriverWait wait = new WebDriverWait(driver, 10);
//					wait.until(new ExpectedCondition<Boolean>() {
//						public Boolean apply(WebDriver d) {
//							return d.findElement(
//									By.xpath("//*[@id='username']"))
//									.isDisplayed();
//						}
//					});
//				 driver.findElement(By.xpath("//*[@id='username']")).sendKeys("jshi02"); 
//				 driver.findElement(By.xpath("//*[@id='password']")).sendKeys("12171002");
//				 driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button")).click();
//				 Thread.sleep(5000);
//				 driver.get(url);
//			}
		 if (DriverTools.Judge1()==2 ) {
			 driver.get(url);	 
//			 driver.get("https://gateway.zscaler.net/auT?origurl=http%3A%2F%2Fwww%2egoogle%2ecom%2f");
				 Thread.sleep(6000);
				 driver.findElement(By.xpath("//*[@id='username']")).sendKeys("jshi02");   
				 driver.findElement(By.xpath("//*[@id='password']")).sendKeys("12171002");
				 driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button")).click();
				 driver.get(url);
			}else {
				 driver.get(url);
			}
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(1), count);
//			driver.quit();
			throw new Exception();
		}
	}

	public void test1() throws InterruptedException{
		Thread.sleep(3000);
		WebElement menu1 = driver.findElement(By.xpath("//a[@id='nav-sports']"));
		
		if (DriverTools.Judge1()==1){
		action.clickAndHold(menu1);//IE
		}
		else if (DriverTools.Judge1()==2){
        action.clickAndHold(menu1);//chrome
        }
		else {
			action.moveToElement(menu1); //firefox
		}
        
        action.perform();
        WebElement menu2 = driver.findElement(By.xpath("//*[@id='nav-content-sports']/li[4]/a"));
		
        if (DriverTools.Judge1()==1){
		action.clickAndHold(menu2);//IE
		}
        else if (DriverTools.Judge1()==2){
        action.clickAndHold(menu2);//chrome 
        }
        else{
        	action.moveToElement(menu2);//firefox
        }
        action.perform();
        Thread.sleep(1000);
//       driver.findElement(By.xpath("//a/span[contains(text(),'女式跑步鞋']")).findElement(By.xpath("..")).click();
        action.moveToElement(driver.findElement(By.xpath("//a/span[contains(text(),'女式跑步鞋')]"))).click().perform();
	}
	
	
//	public void moveOnSYYDFL(int count) throws Exception { // 2.鼠标滑动到所有运动分类
//		try {
////			WebDriverWait wait = new WebDriverWait(driver, 10);
////			WebElement webElement = wait
////					.until(new ExpectedCondition<WebElement>() {
////						public WebElement apply(WebDriver d) {
////							return d.findElement(By
////									.xpath("//a[@id='nav-sports']")); //
////						}
////					});
//			action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-sports']"))).build().perform();
//			

//			
//			Thread.sleep(sleepTime);
//			System.out.println("1.all sports");
//		} catch (Exception e) {
//			snapShot((TakesScreenshot) driver, map.get(2), count);
//			driver.quit();
//			throw new Exception();
//		}
//	}
//
//	public void moveOnPB(int count) throws Exception { // 3.鼠标滑动到跑步
//		try {
////			WebDriverWait wait = new WebDriverWait(driver, 10);
////			WebElement webElement = wait
////					.until(new ExpectedCondition<WebElement>() {
////						public WebElement apply(WebDriver d) {
////							return d.findElement(By
////									.xpath("//*[@id='nav-content-sports']/li[4]/a"));  //a[@class='level-top item item-running']
////						} 
////					});
//			action.moveToElement(driver.findElement(By.xpath("//*[@id='nav-content-sports']/li[4]/a"))).build().perform();
////			JavascriptExecutor js = (JavascriptExecutor) driver;
////			js.executeScript("return arguments[0].clickandhold;" ,driver.findElement(By.xpath("//*[@id='nav-content-sports']/li[4]/a")));
//			
//			Thread.sleep(sleepTime);
//			System.out.println("2.run");
//		} catch (Exception e) {
//			snapShot((TakesScreenshot) driver, map.get(3), count);
//			driver.quit();
//			throw new Exception();
//		}
//	}
//
//	public void moveOnNSPBX(int count) throws Exception { // 4.鼠标滑动到女士跑步鞋
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, 10);
//			WebElement webElement = wait
//					.until(new ExpectedCondition<WebElement>() {
//						public WebElement apply(WebDriver d) {
//							return d.findElement(By
//									.xpath("//a/span[contains(text(),'女式跑步鞋')]"));
//						}
//					});
//			action.moveToElement(webElement).build().perform();
//			// Thread.sleep(sleepTime);
//			System.out.println("3.girl shoes");
//		} catch (Exception e) {
//			snapShot((TakesScreenshot) driver, map.get(4), count);
//			driver.quit();
//			throw new Exception();
//		}
//	}
//
//	public void clickNSPBX(int count) throws Exception { // 5.击女士跑步鞋
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, 10);
//			WebElement webElement = wait
//					.until(new ExpectedCondition<WebElement>() {
//						public WebElement apply(WebDriver d) {
//							return d.findElement(By
//									.xpath("//a/span[contains(text(),'女式跑步鞋')]"));
//						}
//					});
//			action.moveToElement(webElement).click().perform();
//		} catch (Exception e) {
//			snapShot((TakesScreenshot) driver, map.get(5), count);
//			driver.quit();
//			throw new Exception();
//		}
//	}

	public void clickYDFW(int count) throws Exception { // 6.选择运动范围
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By
							.xpath("//a[contains(text(),'10公里以内')]"));
				}
			}).click();
			System.out.println("4.sport range");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(6), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void clickXB(int count) throws Exception { // 7.选择性别
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//a[contains(text(),'女士')]"));
				}
			}).click();
			System.out.println("5.gender");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(7), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void inputPriceFrom(int count) throws Exception { // 8.输入价格范围——从
		try {
//			WebDriverWait wait = new WebDriverWait(driver, 10);
//			wait.until(new ExpectedCondition<WebElement>() {
//				public WebElement apply(WebDriver d) {
//					return d.findElement(By.id("price-from"));
//				}
//			}).clear();
			driver.findElement(By.id("price-from")).sendKeys("0");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(8), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void inputPriceTo(int count) throws Exception { // 9.输入价格范围——到
		try {
//			WebDriverWait wait = new WebDriverWait(driver, 10);
//			wait.until(new ExpectedCondition<WebElement>() {
//				public WebElement apply(WebDriver d) {
//					return d.findElement(By.id("price-to"));
//				}
//			}).clear();
			driver.findElement(By.id("price-to")).sendKeys("150");
			System.out.println("6.price range");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(8), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void clickJGQJQD(int count) throws Exception { // 10.点击价格区间确定
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.id("btn-range"));
				}
			}).click();
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(9), count);
			driver.quit();
			throw new Exception();
		}
	}

//	public void choiceNSPBXPrice_One(int count) throws Exception { // 11.选择女士跑步鞋的价格
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, 10);
//			price_shoes1 = wait.until(new ExpectedCondition<WebElement>() {
//				public WebElement apply(WebDriver d) {
//					return d.findElement(By
//							.xpath("//span[@id='product-price-55820']/span[@class='price']"));
//				}
//			}).getText();
//			System.out.println("1.shoes price" + price_shoes1);
//		} catch (Exception e) {
//			snapShot((TakesScreenshot) driver, map.get(10), count);
//			driver.quit();
//			throw new Exception();
//		}
//	}

	public void choiceNSPBX(int count) throws Exception { // 12.选择女士跑步鞋
		try {
//			WebDriverWait wait = new WebDriverWait(driver, 10);
//			WebElement webElement = wait
//					.until(new ExpectedCondition<WebElement>() {
//						public WebElement apply(WebDriver d) {
//							return d.findElement(By
//									.xpath("//img[@alt='EKIDEN ONE 女式跑步鞋']"));
//						}
//					});
//			action.moveToElement(webElement).build().perform();
			driver.findElement(By.xpath("//img[@alt='EKIDEN ONE 女式跑步鞋']")).click();
			Thread.sleep(sleepTime);
//			action.moveToElement(webElement).click().perform();
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(11), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void windowSkip(int count) throws Exception { // 13.窗口跳转
		try {
			Thread.sleep(sleepTime);
			switchToWin();
			Thread.sleep(sleepTime);
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(12), count);
			driver.quit();
			throw new Exception();
		}
	}

//	public void choiceNSPBXPrice_Two(int count) throws Exception { // 14.第二次选择白色鞋子的价格
//		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		price_shoes2 = wait.until(new ExpectedCondition<WebElement>() {
//			public WebElement apply(WebDriver d) {
//				return d.findElement(By
//						.xpath("//span[@id='product-price-55820']"));
//			}
//		}).getText();
//		price_shoes1 = price_shoes1.replaceAll(" ", "");
//		price_shoes2 = price_shoes2.replaceAll(" ", "");
//		System.out.println("2.shoes price" + price_shoes2);
//		//
//		price_shoes1 = price_shoes1.substring(1, price_shoes1.length());
//		price_shoes2 = price_shoes2.substring(1, price_shoes2.length());
//		System.out.println(price_shoes1 + " and " + price_shoes2);
//		if (price_shoes1.equals(price_shoes2)) {
//			System.out.println("The shoes's price is normal");
//		} else {
//			System.out.println("The shoes's price is error");
//			snapShot((TakesScreenshot) driver, map.get(13), count);
//			driver.quit();
//			throw new Exception();
//		}
//	}

	public void choiceWhite(int count) throws Exception { // 15.选择白色的鞋子
		try {
			//判断如果浏览器为IE=1,执行窗口最大化
			if (DriverTools.Judge1()==1){
				driver.manage().window().maximize();
			}
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//img[@title='白色']"));
				}
			}).click();
			System.out.println("7.white");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(14), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void choice36Size(int count) throws Exception { // 16.选择36码
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By
							.xpath("//a[contains(text(),'36码 ')]"));
				}
			}).click();
			System.out.println("8.36 size");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(15), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void increaseNum(int count) throws Exception { // 17.增加鞋子的数量
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//button[@title='再多点']"));
				}
			}).click();
			System.out.println("9.add 1");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(16), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void joinCart(int count) throws Exception { // 18.加入购物车
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//button[@title='加入购物车']"));
				}
			}).click();
			System.out.println("10.add to cart");

		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(17), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void product_view(int count) throws Exception { // 19.判断是否缺货
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return d.findElement(
							By.xpath("//div[@id='messages_product_view']/ul/li/ul/li/span"))
							.isDisplayed();
				}
			});
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(18), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void selectT_shirt(int count) throws Exception { // 20.搜索商品
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.id("search"));
				}
			}).clear();
			driver.findElement(By.id("search")).sendKeys("T-shirt");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(19), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void clickSelect(int count) throws Exception { // 21.点击搜索按钮
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.id("btn-search"));
				}
			}).click();
			System.out.println("11.search t-shirt");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(20), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void choiceT_shirt(int count) throws Exception { // 22.选择一件
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.cssSelector("img[alt=\"男式篮球T恤 FAST NEW YORK T-SHIRT\"]"));
				}
			}).click();
//			driver.findElement(By.cssSelector("img[alt=\"男式篮球T恤 FAST NEW YORK T-SHIRT\"]")).click();
			Thread.sleep(sleepTime);
//			action.moveToElement(webElement).click().perform();
			System.out.println("12.choice a t-shirt");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(21), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void windowSkip2(int count) throws Exception { // 23.窗口跳转
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

	public void choiceT_shirt_Size(int count) throws Exception { // 23.2.选择尺码
		try {
			Thread.sleep(sleepTime);
			//判断如果浏览器为IE=1,执行窗口最大化
			if (DriverTools.Judge1()==1){
				driver.manage().window().maximize();
			}
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//a[@title='M ']"));
				}
			}).click();
			System.out.println("13.M size");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(23), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void joinCart_Tshirt(int count) throws Exception { // 24.加入购物车
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//button[@title='加入购物车']"));
				}
			}).click();
			Thread.sleep(sleepTime);
			System.out.println("14.add to cart");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(24), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void product_view_tshirt(int count) throws Exception { // 25.判断是否缺货
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement webElement = wait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				return d.findElement(By
						.xpath("//div[@id='messages_product_view']/ul/li/ul/li/span"));
			}
		});
		Thread.sleep(sleepTime);
		if (webElement.getText().trim().equals("该产品目前缺货。")) {
			snapShot((TakesScreenshot) driver, map.get(25), count);
			System.out.println("15.out of store");
			driver.quit();
			throw new Exception();
		}
		System.out.println("15.goods normal");
	}

	public void moveOnCart(int count) throws Exception { // 26.鼠标移动到购物车上
		try {
			Thread.sleep(sleepTime);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement webElement = wait
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By.className("top-cart"));
						}
					});
			action.moveToElement(webElement).build().perform();
			Thread.sleep(sleepTime);
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(26), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void clickCart(int count) throws Exception { // 27.鼠标点击购物车
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.id("topcart-checkout"));
				}
			}).click();
			System.out.println("16.view shopping cart");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(27), count);
			driver.quit();
			throw new Exception();
		}
	}

//	public void countPrice_One(int count) throws Exception { // 28.鞋子的价格
//		String shoesPrice = null;
//		String shirtPrice = null;
//		String totalSPrice = null;
//		String totalBPrice = null;
//		try {
//			shoesPrice = driver.findElement(
//					By.xpath("//table[1]/tbody/tr/td[6]/span/span")).getText();
//			shirtPrice = driver.findElement(
//					By.xpath("//table[2]/tbody/tr/td[6]/span/span")).getText();
//			totalSPrice = driver
//					.findElement(
//							By.xpath("//table[@id='shopping-cart-totals-table']/tbody/tr/td[2]/span"))
//					.getText();
//			totalBPrice = driver
//					.findElement(
//							By.xpath("//table[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/span"))
//					.getText();
//		} catch (Exception e) {
//			snapShot((TakesScreenshot) driver, map.get(28), count);
//			driver.quit();
//			throw new Exception();
//		}
//		//
//		double shoesPriced = Double.parseDouble(shoesPrice.substring(1,
//				shoesPrice.length()));
//		double shirtPriced = Double.parseDouble(shirtPrice.substring(1,
//				shirtPrice.length()));
//		double totalSPriced = Double.parseDouble(totalSPrice.substring(1,
//				totalSPrice.length()));
//		double totalBPriced = Double.parseDouble(totalBPrice.substring(1,
//				totalBPrice.length()));
//		if (shoesPriced + shirtPriced == totalSPriced
//				&& totalSPriced == totalBPriced) {
//			System.out.println(shoesPriced + "+" + shirtPriced + "="
//					+ totalSPriced + "=" + totalBPriced);
//			System.out.println("The price is normal");
//		} else {
//			System.out.println("The price is error");
//			snapShot((TakesScreenshot) driver, map.get(29), count);
//			driver.quit();
//			throw new Exception();
//		}
//	}

	public void addShoesQuanity(int count) throws Exception { // 29.增加鞋子的数量
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

	public void removeT_shirt(int count) throws Exception { // 30.删除T-shirt
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

	public void countPrice_Two(int count) throws Exception { // 31.鞋子的价格
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
			shoesPrice = shoesPrice.substring(1, shoesPrice.length());
			totalSPrice = totalSPrice.substring(1, totalSPrice.length());
			totalBPrice = totalBPrice.substring(1, totalBPrice.length());
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

	public void useCoupon(String num, int count) throws Exception { // 32.输入优惠券
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.id("coupon_code"));
				}
			}).clear();
			driver.findElement(By.id("coupon_code")).sendKeys(num);
			System.out.println("19.input coupon");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(32), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void clickuseCoupon(int count) throws Exception { // 33.点击应用优惠券
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//button[@value='应用优惠券']"));
				}
			}).click();
			System.out.println("20.use coupon");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(33), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void countPrice_Two_One(int count) throws Exception { // 34.使用优惠券
		String Price1 = null;
		String Price2 = null;
		String Price3 = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			Price1 = wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By
							.xpath("//table[@id='shopping-cart-totals-table']/tbody/tr[1]/td[2]/span"));
				}
			}).getText();
			WebDriverWait wait2 = new WebDriverWait(driver, 10);
			Price2 = wait2.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By
							.xpath("//table[@id='shopping-cart-totals-table']/tbody/tr[2]/td/span"));
				}
			}).getText();
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			Price3 = wait3.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By
							.xpath("//table[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/span"));
				}
			}).getText();
			Price1 = Price1.substring(1, Price1.length());
			Price2 = Price2.substring(2, Price2.length());
			Price3 = Price3.substring(1, Price3.length());
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(28), count);
			driver.quit();
			throw new Exception();
		}
		double Price1d = Double.parseDouble(Price1);
		double Price2d = Double.parseDouble(Price2);
		double Price3d = Double.parseDouble(Price3);
		if (Price2d + Price3d == Price1d) {
			System.out.println(Price2d + "+" + Price3d + "=" + Price1d);
			System.out.println("The price is normal");
		} else {
			snapShot((TakesScreenshot) driver, map.get(29), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void clickPayment(int count) throws Exception { // 35.点击去结算
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			wait3.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//button[@title='去结算']"));
				}
			}).click();
			System.out.println("21.payment");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(34), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void inputUserName(String username, int count) throws Exception { // 36.输入用户名
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

	public void inputPasswd(String passwd, int count) throws Exception { // 37.输入密码
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

	public void clickLogin(int count) throws Exception { // 38.点击登录按钮
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

	public void clickCancelCounpon(int count) throws Exception { // 39.点击取消使用优惠券
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			wait3.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//button[@value='取消优惠券']"));
				}
			}).click();
			System.out.println("25.cancel coupon");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(38), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void clickPaymentFinal(int count) throws Exception { // 40.点击去结算
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			wait3.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//button[@title='去结算']"));
				}
			}).click();
			System.out.println("26.payment");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(34), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void alertExpress(int count) throws Exception { // 41.修改快递
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			wait3.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By
							.xpath("//div[@id='checkout-step-shipping_method']/div/a[contains(text(),'修改')]"));
				}
			}).click();
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(39), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void selectXFKD(int count) throws Exception { // 42.选择顺丰快递
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			wait3.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.id("s_method_shunfeng_shunfeng"));
				}
			}).click();
			System.out.println("27.express");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(40), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void shippingMethodNext(int count) throws Exception { // 43.快递下一步
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			wait3.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By
							.xpath("//div[@id='shipping-method-buttons-container']/button"));
				}
			}).click();
			Thread.sleep(sleepTime);
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(41), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void payment_cashondelivery(int count) throws Exception { // 43.2.货到付款
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			WebElement webElement = wait3
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By
									.xpath("//input[@id='p_method_cashondelivery']"));
						}
					});
			action.moveToElement(webElement).build().perform();
			// Thread.sleep(sleepTime);
			action.moveToElement(webElement).click().perform();
			System.out.println("28.cash on delivery");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(42), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void paymentNext(int count) throws Exception { // 44.付款方式下一步
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			WebElement webElement = wait3
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By
									.xpath("//div[@id='payment-buttons-container']/button"));
						}
					});
			action.moveToElement(webElement).build().perform();
			Thread.sleep(sleepTime);
			action.moveToElement(webElement).click().perform();
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(41), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void countPrice_Three(int count) throws Exception { // 45.鞋子的价格
		Thread.sleep(sleepTime);
		String Price1 = null;
		String Price2 = null;
		String Price3 = null;
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			WebElement webElement = wait3
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By
									.xpath("//table[@id='checkout-totals']/tbody/tr[1]/td/span[1]/span"));// 1:
																											// ￥5,518.00
						}
					});
			action.moveToElement(webElement).build().perform();
			Thread.sleep(sleepTime);
			Price1 = webElement.getText();
			Price2 = driver
					.findElement(
							By.xpath("//table[@id='checkout-totals']/tbody/tr[1]/td/span[3]/span/span[1]"))// 1:
																											// ￥390.00
					.getText();
			Price3 = driver
					.findElement(
							By.xpath("//table[@id='checkout-totals']/tbody/tr[3]/td[2]/div[2]/span"))// 1:
																										// ￥5,908.00
					.getText();
			Price1 = Price1.replaceAll(" ", "");
			Price2 = Price2.replaceAll(" ", "");
			Price3 = Price3.replaceAll(" ", "");
			Price1 = Price1.replaceAll(",", "");
			Price2 = Price2.replaceAll(",", "");
			Price3 = Price3.replaceAll(",", "");
			Price1 = Price1.substring(1, Price1.length());
			Price2 = Price2.substring(1, Price2.length());
			Price3 = Price3.substring(1, Price3.length());
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(28), count);
			driver.quit();
			throw new Exception();
		}
		double Price1d = Double.parseDouble(Price1);
		double Price2d = Double.parseDouble(Price2);
		double Price3d = Double.parseDouble(Price3);
		if (Price1d + Price2d == Price3d) {
			System.out.println(Price1 + "+" + Price2 + "=" + Price3);
			System.out.println("The price is normal");
		} else {
			System.out.println("The price is error");
			snapShot((TakesScreenshot) driver, map.get(29), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void checkoutOrder(int count) throws Exception { // 46.提交订单
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			wait3.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.id("checkout-place-order"));
				}
			}).click();
			System.out.println("29.payment");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(43), count);
			driver.quit();
			throw new Exception();
		}
	}

	public void quitDriver(int count) throws Exception { // 47.结束
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
