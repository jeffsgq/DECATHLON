package newcustomer;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import screenshot.Screenshot;
import selectdriver.DriverTools;

public class Test_man_NewCustomer {
	static WebDriver driver;

	// 随机生成数字0-100
	public static int getrandomnum() {
		final long l = System.currentTimeMillis();
		final int i = (int) (l % 100);
		return i;
	}

	// 随机生成26个英文字母
	public static char getrandomletter() {
		char paramChar = (char) (Math.random() * 26 + 'A');
		return paramChar;
	}

	// 打开网页，如果出现异常截图
	public static void openurl(String url) throws Exception {
		try {

			// driver = new FirefoxDriver();
			DriverTools d = new DriverTools();
			driver = d.getDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize(); // 窗口最大化
			
			//如果判断浏览器为2=chrome，则执行防火墙验证步骤
			if (DriverTools.Judge1() == 2) {
				// driver.get(url);
				driver.get(url);//https://gateway.zscaler.net/auT?origurl=http%3A%2F%2Fwww%2egoogle%2ecom%2f
				driver.findElement(By.xpath("//*[@id='uform']/table/tbody/tr[1]/td/table/tbody/tr[5]/td/table/tbody/tr[2]/td/input")).sendKeys("jeff.shi@decathlon.com");
				driver.findElement(By.xpath("//*[@id='uform']/table/tbody/tr[1]/td/table/tbody/tr[5]/td/table/tbody/tr[4]/td/input")).click();
				Thread.sleep(6000);
				
				driver.findElement(By.xpath("//*[@id='username']")).sendKeys(
						"jshi02");
				driver.findElement(By.xpath("//*[@id='password']")).sendKeys(
						"11111111");
				driver.findElement(
						By.xpath("/html/body/div[1]/div/div/form/button"))
						.click();
				driver.get(url);
			} 
			//
//			else if (DriverTools.Judge1()==1) {
//				driver.get(url);//https://gateway.zscaler.net/auT?origurl=http%3A%2F%2Fwww%2egoogle%2ecom%2f
//				Thread.sleep(6000);
//				driver.findElement(By.xpath("//*[@id='username']")).sendKeys(
//						"jshi02");
//				driver.findElement(By.xpath("//*[@id='password']")).sendKeys(
//						"12171002");
//				driver.findElement(
//						By.xpath("/html/body/div[1]/div/div/form/button"))
//						.click();
//				driver.get(url);
//			}
			else {
				driver.get(url);
			}
		} catch (Exception e) {
			Screenshot.snapshot((TakesScreenshot) driver,
					"Error_OpenBrowser.png");
			driver.quit();
			throw new Exception();
		}
	}

	// 在首页搜索框搜索，如果出现异常截图
	public static void typesearchbar() throws Exception {
		try {
			driver.findElement(
					By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/form/div/input[1]"))
					.clear();// 清除搜索框 By.id("search")
			driver.findElement(
					By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/form/div/input[1]"))
					.sendKeys("跑步鞋");// 在搜索框输入“跑步鞋” By.id("search")
			driver.findElement(By.id("btn-search")).sendKeys(Keys.ENTER);  //.click();// 点击搜索按钮 By.id("btn-search")
		} catch (Exception e) {
			Screenshot.snapshot((TakesScreenshot) driver,
					"Error_TypeSearchBar.png");
			driver.quit();
			throw new Exception();
		}

	}

	// 按条件筛选，如果出现异常截图
	public static void searchshoe() throws Exception {
		try {
			Thread.sleep(3000);
			driver.findElement(
					By.xpath("//*[@id='narrow-by-list']/li[1]/ul/li[5]/a"))
					.click();// 点击运动分类中的跑步//a[contains(text(),'跑步')]
			Thread.sleep(3000);
			driver.findElement(
					By.xpath("//*[@id='narrow-by-list']/li[2]/ul/li[4]/a"))
					.click();// 点击性别分类中的男士 //a[contains(text(),'男士')]
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[contains(text(),'鞋子')]")).click();// 点击产品类型分类中的鞋子
			Thread.sleep(3000);
			driver.findElement(By.id("price-from")).click();// 价格区间--从
			driver.findElement(By.id("price-from")).clear();// 清除价格区间--从
			driver.findElement(By.id("price-from")).sendKeys("0");// 价格区间--从的值
			driver.findElement(By.id("price-to")).clear();// 价格区间--至
			driver.findElement(By.id("price-to")).sendKeys("100");// 价格区间--至得值
			driver.findElement(By.id("btn-range")).click();// 点击确定
			
		} catch (Exception e) {
			Screenshot.snapshot((TakesScreenshot) driver,
					"Error_SearchShoe.png");
			driver.quit();
			throw new Exception();
		}

	}

	// 选择男士跑步鞋，并跳转至新的窗口，如果出现异常截图
	public static void selectshoe() throws Exception {
		try { 
			//  //img[@alt='EKIDEN ONE 男式健身跑步鞋']
			if (DriverTools.Judge1()==1){
			 WebDriverWait wait = new WebDriverWait(driver, 10);
			 wait.until(new ExpectedCondition<WebElement>() {
			 public WebElement apply(WebDriver d) {
			 return d.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[3]/div[1]/div[2]/ul/li[1]/div[1]/a/img"));
			 }
			 }).click();}
			else {
				driver.findElement(By.cssSelector("img[alt=\"EKIDEN ONE 男式健身跑步鞋\"]")).click(); // By.xpath("//img[@alt='EKIDEN ONE 男式健身跑步鞋']")).click()
			}		
			Thread.sleep(3000);
			String handle = driver.getWindowHandle(); // 跳转窗口
			for (String handles : driver.getWindowHandles()) {
				if (handles.equals(handle))
					continue;
				driver.switchTo().window(handles);
			}
			if (DriverTools.Judge1() == 1) {
				driver.manage().window().maximize();
				driver.findElement(By.id("value13694")).click(); // 选择颜色
				driver.findElement(By.id("value13673")).click();// 选择尺码 42码
				driver.findElement(By.cssSelector("button.button.btn-cart")).click();// 加入购物车
			} else {
				driver.findElement(By.id("value13694")).click(); // 选择颜色
				driver.findElement(By.id("value13673")).click();// 选择尺码 42码
				driver.findElement(By.cssSelector("button.button.btn-cart")).click();// 加入购物车
			}
		} catch (Exception e) {
			Screenshot.snapshot((TakesScreenshot) driver,
					"Error_SelectShoe.png");
			driver.quit();
			throw new Exception();
		}

	}

	// 判断鞋子是否缺货
	public static void isoutofstock_shoe() throws Exception {
		// if (driver
		// .findElement(
		// By.xpath("//div[@id='messages_product_view']/ul[@class='messages']/li/ul/li")).getText().trim().equals("该产品目前缺货。"))
		// {
		// Screenshot.snapshot((TakesScreenshot) driver,
		// "OutOfStock_shoes.png");
		// System.out.println("shoe is out of stock");
		// driver.quit();
		// throw new Exception();
		// }
//		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement webElement = wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//div[@id='messages_product_view']/ul[@class='messages']/li/ul/li"));
				}
			});
			if(webElement.getText().trim().equals("该产品目前缺货。")){
//			if (webElement.getText().trim().equals("该产品目前缺货。")) {
//			WebDriverWait wait = new WebDriverWait(driver, 10);
//			wait.until(new ExpectedCondition<Boolean>() {
//				public Boolean apply(WebDriver d) {
//					return d.findElement(
//							By.xpath("//div[@id='messages_product_view']/ul[@class='messages']/li/ul/li"))
//							.isDisplayed();
//				}
//			});
//		} catch (Exception e) {
			Screenshot.snapshot((TakesScreenshot) driver,
					"OutOfStock_shoes.png");
			System.out.println("shoe is out of stock");
			driver.quit();
			throw new Exception();
		}
	}

	// 搜索T-shirt，如果出现异常截图
	public static void searchtshirt() throws Exception {
		try {
			Thread.sleep(3000);
			driver.findElement(By.id("search")).clear();// 清除搜索框的值
			driver.findElement(By.id("search")).sendKeys("T-shirt");// 输入搜索框的值为“T-shirt”
			driver.findElement(By.id("btn-search")).sendKeys(Keys.ENTER); //.click();// 点击搜索
		} catch (Exception e) {
			Screenshot.snapshot((TakesScreenshot) driver,
					"Error_SearchTshirt.png");
			driver.quit();
			throw new Exception();
		}

	}

	// 选择T-shirt，如果出现异常截图
	public static void selecttshirt() throws Exception {
		try {
			String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
			Set<String> handles1 = driver.getWindowHandles();// 获取所有窗口句柄
			Iterator<String> it = handles1.iterator();
			while (it.hasNext()) {
				if (currentWindow == it.next()) {
					continue;
				}
				WebDriver window = driver.switchTo().window(it.next());// 切换到新窗口
				// window.manage().window().maximize();
				Thread.sleep(3000);
				if (DriverTools.Judge1() == 1) {
					window.manage().window().maximize();
				
				 WebDriverWait wait = new WebDriverWait(window, 30);
				 wait.until(new ExpectedCondition<WebElement>() {
				 public WebElement apply(WebDriver d) {
				 return d.findElement(By.xpath("//html/body/div[2]/div/div[2]/div[2]/div/div/div[3]/div[1]/div[2]/ul[1]/li[3]/div[1]/a/img"));
				 }
				 }).click(); }
				else {
					window.findElement(
							By.cssSelector("div.productimg>a.product-image>img[alt=\"户外运动 保暖 青少年T恤 QUECHUA T-SHIRT WARM JR 深灰色 14岁\"]"))
							.click(); // By.xpath("//img[@alt='户外运动 保暖 青少年T恤 QUECHUA T-SHIRT WARM JR 深灰色 14岁']"))
				}	
				
			}
			Thread.sleep(3000);
		} catch (Exception e) {
			Screenshot.snapshot((TakesScreenshot) driver,
					"Error_SelectTshirt.png");
			driver.quit();
			throw new Exception();
		}

	}

	// 将T-shirt加入购物车，出现异常截图
	public static void addintoshoppingcart() throws Exception {
		try {
			String handle1 = driver.getWindowHandle();
			for (String handles : driver.getWindowHandles()) {
				if (handles.equals(handle1))
					continue;
				driver.switchTo().window(handles);
			}
			
			if (DriverTools.Judge1() == 1) {
				driver.manage().window().maximize();
			}
			driver.findElement(By.xpath("//*[@id='value13632']")).click(); // 选择14岁
			driver.findElement(By.xpath("//button[@title='加入购物车']")).click();// 加入购物车
			Thread.sleep(3000); // //*[@id="product_addtocart_form"]/div[4]/div[2]/button/span/span
		} catch (Exception e) {
			Screenshot.snapshot((TakesScreenshot) driver,
					"Error_AddInToShippingCart.png");
			driver.quit();
			throw new Exception();
		}
	}

	// 判断T-shirt是否缺货
	public static void isoutofstock_tshirt() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement webElement = wait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				return d.findElement(By.xpath("//div[@id='messages_product_view']/ul[@class='messages']/li/ul/li"));
			}
		});
		if (webElement.getText().trim().equals("该产品目前缺货。")) {
			Screenshot.snapshot((TakesScreenshot) driver,
					"OutOfStock__T-shirt.png");
			System.out.println("T-shirt is out of stock");
			driver.quit();
			throw new Exception();
		}
	}

	// 进入购物车页面,修改购物车内容,出现异常截图
	public static void editshoppingcart() throws Exception {
		try {
			Thread.sleep(3000);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.className("top-cart"))).perform();// 移动到购物车按钮上方
			Thread.sleep(3000); 
			 WebDriverWait wait = new WebDriverWait(driver, 10);
			 wait.until(new ExpectedCondition<WebElement>() {
			 public WebElement apply(WebDriver d) {
			 return d.findElement(By.xpath("//*[@id='topcart-checkout']"));
			 }
			 }).click();
			 Thread.sleep(3000); 
//			driver.findElement(By.xpath("//*[@id='topcart-checkout']")).click();// 点击去购物车结算
			 if(DriverTools.Judge1()==1){
				 driver.findElement(By.xpath("//button[@type='button'])[3]")).click(); 
				 driver.findElement(By.xpath("//table[4]/tbody/tr/td[7]/button")).click();
			 }
			 else {
			driver.findElement(By.xpath("//*[@id='shopping-cart-list']/table[1]/tbody/tr/td[5]/div/button[2]"))
					.click();// 增加鞋子数量到2
			driver.findElement(By.xpath("//*[@id='shopping-cart-list']/table[2]/tbody/tr/td[7]/button/span/span"))
					.click();// 删除T-shirt
			}
			 Thread.sleep(5000);
			

			// --------------------------应用优惠券前比较价格--------------------------//
			String subtotalprice = driver
					.findElement(
							By.xpath("//table[@id='shopping-cart-totals-table']/tbody/tr[1]/td[2]/span"))
					.getText();// 小计价格
			System.out.println("subtotalprice is :" + subtotalprice);
			String beforetotalprice = driver
					.findElement(
							By.xpath("//table[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/span"))
					.getText(); // 应用优惠券前总计（不含运费）价格
			System.out.println("beforetotalprice is :" + beforetotalprice);
			// 判断小计价格是否与总计价格相等，出现异常截图
			if (beforetotalprice.equals(subtotalprice)) {
				System.out.println("the sub total price is right");
			} else {
				Screenshot
						.snapshot((TakesScreenshot) driver, "Error_Price.png");
				driver.quit();
			}
			
			driver.findElement(By.id("coupon_code")).sendKeys("M47U0O0HUIAS");// 输入优惠代码
				// By.cssSelector("div.discount-form > div.actions > button.button"))
			driver.findElement(By.xpath("//button[@value='应用优惠券']")).click();// 点击应用优惠券

			// --------------------------比较应用优惠券后的价格--------------------------//
			String couponprice = driver
					.findElement(
							By.xpath("//table[@id='shopping-cart-totals-table']/tbody/tr[2]/td/span"))
					.getText();// 优惠券价格
			System.out.println("couponprice is :" + couponprice);
			String totalprice = driver
					.findElement(
							By.xpath("//table[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/span"))
					.getText();// 应用优惠券后总计（不含运费）价格
			System.out.println("totalprice is :" + totalprice);
			// 将string类型转化为double类型
			double newsubtotalprice = Double.parseDouble(subtotalprice
					.substring(1, subtotalprice.length() - 1));
			System.out.println("newsubtotalprice is :" + newsubtotalprice);
			double newcouponprice = Double.parseDouble(couponprice.substring(2,
					couponprice.length() - 2));
			System.out.println("newcouponprice is :" + newcouponprice);
			double newtotalsprice = Double.parseDouble(totalprice.substring(1,
					totalprice.length() - 1));
			System.out.println("newtotalsprice is :" + newtotalsprice);
			// 判断应用优惠券后价格是否正确，出现异常截图
			if ((newsubtotalprice - newcouponprice) == newtotalsprice) {
				System.out.println("the totals price is right");
			} else {
				Screenshot
						.snapshot((TakesScreenshot) driver, "Error_Price.png");
				driver.quit();
			}

			driver.findElement(By.xpath("(//li/button)")).click();// 点击去结算
		} catch (Exception e) {
			Screenshot.snapshot((TakesScreenshot) driver,
					"Error_EditShippingCart.png");
			driver.quit();
			throw new Exception();
		}
	}

	// 注册新用户 ，取消优惠券，出现异常截图
	public static void registernewcustomer(String useradd, String userpassword)
			throws Exception {
		try {
			// 注册新用户
			driver.findElement(By.xpath("//button[@type='button']")).click();
			// 注册邮箱
			driver.findElement(By.id("email_address")).sendKeys(useradd);
			// 重复邮箱
			driver.findElement(By.id("confirmation-email")).sendKeys(useradd);
			// 输入密码
			driver.findElement(By.id("password")).sendKeys(userpassword);
			// 重复密码
			driver.findElement(By.id("confirmation")).sendKeys(userpassword);
			// 同意并注册
			driver.findElement(By.cssSelector("button.button.btn-blue"))
					.click();
			// 点击取消优惠券
			driver.findElement(By.xpath("//button[@value='取消优惠券']")).click();
			// 点击去结算
			driver.findElement(By.xpath("(//button[@type='button'])[8]"))
					.click();
		} catch (Exception e) {
			Screenshot.snapshot((TakesScreenshot) driver,
					"Error_RegisterNewCustomer.png");
			driver.quit();
			throw new Exception();
		}
		Thread.sleep(3000);

	}

	// 新用户填写收件地址，出现异常截图
	public static void fillinformation() throws Exception {
		try {
			driver.findElement(By.id("billing:nickname")).sendKeys("张三");// 填写姓名
			new Select(driver.findElement(By.id("billing:region_id")))
					.selectByVisibleText("北京");// 选择地区，州或省
			new Select(driver.findElement(By.id("billing:city_id")))
					.selectByVisibleText("北京");// 选择城市
			new Select(driver.findElement(By.id("billing:district_id")))
					.selectByVisibleText("东城区");// 选择区县
			driver.findElement(By.id("billing:postcode")).sendKeys("200000");// 邮件编码
			driver.findElement(By.id("alert-address")).sendKeys("人民路1弄1号");// 地址
			driver.findElement(By.id("billing:telephone")).sendKeys(
					"13988988998");// 手机号码
			driver.findElement(By.id("checkout-save-addr")).click();// 保存
			Thread.sleep(3000);// 休眠3秒
			// 收货信息填写完成功，下一步
			Actions newaction = new Actions(driver);
			newaction.click(driver.findElement(By.xpath("//button[@id='checkout-save-shipping']"))).perform();// 点击下一步
		} catch (Exception e) {
			Screenshot.snapshot((TakesScreenshot) driver,
					"Error_FillInformation.png");
			driver.quit();
			throw new Exception();
		}

	}

	// 选择物流方式，出现异常截图
	public static void shippingmethod() throws Exception {
		try {
			/*-------------------------以下是物流信息部分-------------------------*/
			Thread.sleep(5000);
			driver.findElement(
					By.xpath("//*[@id='s_method_yuantong_yuantong']")).click();// 选择圆通速递
			driver.findElement(
					By.xpath("//*[@id='shipping-method-buttons-container']/button"))
					.click();// 物流信息填写完成，下一步
		} catch (Exception e) {
			Screenshot.snapshot((TakesScreenshot) driver,
					"Error_ShippingMethod.png");
			driver.quit();
			throw new Exception();
		}
	}

	// 选择支付信息及发票 ，出现异常截图
	public static void fapiao() throws Exception {
		try {
			/*-------------------------以下是支付信息部分-------------------------*/
			Thread.sleep(3000);
			driver.findElement(By.id("input-radio-normal")).click();
			driver.findElement(
					By.xpath("//div[@id='fapiao-selection-wrapper']/ul/li[2]/label"))
					.click();// 选择普通发票
			new Select(driver.findElement(By.id("fapiao-normal")))
					.selectByVisibleText("服装");// 发票内容为服装
			// 支付信息填写完成，下一步
			driver.findElement(
					By.cssSelector("#payment-buttons-container > button.button"))
					.click();// 点击下一步
		} catch (Exception e) {
			Screenshot.snapshot((TakesScreenshot) driver, "Error_FaPiao.png");
			driver.quit();
			throw new Exception();
		}
		Thread.sleep(3000);
	}

	// 最后核对价格，点击提交订单，出现异常截图
	public static void checkout() throws InterruptedException {
		try {
			// --------------------------核对应付总额的价格--------------------------//
			// 确认购物清单中的商品小计
			String finaltotalprice = driver
					.findElement(
							By.xpath("//table[@id='checkout-totals']/tbody/tr[1]/td/span[1]/span"))
					.getText();
			System.out.println("finaltotalprice:" + finaltotalprice);
			// 确认购物清单中的运费价格
			String finaldeliveryprice = driver
					.findElement(
							By.xpath("//table[@id='checkout-totals']/tbody/tr[1]/td/span[3]/span/span"))
					.getText();
			System.out.println("finaldeliveryprice:" + finaldeliveryprice);
			// 确认购物清单中的应付总额
			String finalprice = driver
					.findElement(
							By.xpath("//table[@id='checkout-totals']/tbody/tr[3]/td[2]/div[2]/span"))
					.getText();
			System.out.println("finalprice:" + finalprice);
			// 将string类型转化为double类型
			double newfinaltotalprice = Double.parseDouble(finaltotalprice
					.substring(1, finaltotalprice.length() - 1));
			System.out.println("newfinaltotalprice:" + newfinaltotalprice);
			double newfinaldeliveryprice = Double
					.parseDouble(finaldeliveryprice.substring(1,
							finaldeliveryprice.length() - 1));
			System.out
					.println("newfinaldeliveryprice:" + newfinaldeliveryprice);
			double newfinalprice = Double.parseDouble(finalprice.substring(1,
					finalprice.length() - 1));
			System.out.println("newfinalprice:" + newfinalprice);
			// 判断商品小计加运费的价格是否等于应付总额，出现异常截图
			if ((newfinaltotalprice + newfinaldeliveryprice) == newfinalprice) {
				System.out.println("the final totals price is right");
			} else {
				Screenshot
						.snapshot((TakesScreenshot) driver, "Error_Price.png");
				driver.quit();
			}
			/*-------------------------以下是确认购物清单部分-------------------------*/
			Actions theaction = new Actions(driver);
			theaction.click(driver.findElement(By.id("checkout-place-order")))
					.perform();// 点击提交订单
		} catch (Exception e) {
			Screenshot.snapshot((TakesScreenshot) driver, "Error_CheckOut.png");
			driver.quit();
		}
		Thread.sleep(3000);// 休眠3秒
	}

	// 选择银联在线支付，出现异常截图
	public static void payment() throws Exception {
		try {
			driver.findElement(By.id("opt-chinapay")).click();// 选择在线支付
		} catch (Exception e) {
			Screenshot.snapshot((TakesScreenshot) driver, "Error_PayMent.png");
			driver.quit();
			throw new Exception();
		}
		Thread.sleep(3000);// 休眠3秒
	}

	// 退出浏览区
	public static void closebrowser() {
		driver.quit();
	}
}
