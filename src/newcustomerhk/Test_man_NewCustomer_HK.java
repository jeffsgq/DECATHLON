package newcustomerhk;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import selectdriver.DriverTools;
import createfile.CreateFile;
public class Test_man_NewCustomer_HK {
	static DriverTools dTools= new DriverTools();
	public static WebDriver driver;
	static CreateFile cf ;
	static String imgName ;
	static String imgName2 ;
	static int count = 1;
	static Actions action ;
	//构造方法
	public Test_man_NewCustomer_HK(){
		cf = new CreateFile();
		imgName = cf.ImageName("NewCustomerHK");
	}
	// 截图
	public static void screenshot2(TakesScreenshot drivername, String filename) {
//		if(count == 1){
//			cf = new CreateFile();
//			imgName = cf.ImageName("NewCustomerHK");
//			++ count;
//		}
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		String currentPath = System.getProperty("user.dir"); // 获取用户当前路径
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String time = sdf.format(new Date());
		// Now you can do whatever you need to do with it, for example copy
		// somewhere
		try {
			System.out.println("save snapshot path is:" + currentPath
					+ "\\image" + "\\" + imgName + "\\" + filename);
			FileUtils.copyFile(scrFile, new File(currentPath + "\\image" + "\\"
					+ imgName + "\\" + time + filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't save screenshot");
			e.printStackTrace();
		} finally {

			System.out.println("screen shot finished");
		}
	}
	// 截图
		public static void screenshot(TakesScreenshot drivername, String filename) {
				cf = new CreateFile();
				imgName2 = cf.ImageName("NewCustomerHK_Error");
			// this method will take screen shot ,require two parameters ,one is
			// driver name, another is file name
			File scrFile = drivername.getScreenshotAs(OutputType.FILE);
			String currentPath = System.getProperty("user.dir"); // 获取用户当前路径
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
			String time = sdf.format(new Date());
			// Now you can do whatever you need to do with it, for example copy
			// somewhere
			try {
				System.out.println("save snapshot path is:" + currentPath
						+ "\\image" + "\\" + imgName2 + "\\" + filename);
				FileUtils.copyFile(scrFile, new File(currentPath + "\\image" + "\\"
						+ imgName2 + "\\" + time + filename));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Can't save screenshot");
				e.printStackTrace();
			} finally {

				System.out.println("screen shot finished");
			}
		}
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
			driver = dTools.getDriver();
			action = new Actions(driver);
			driver.manage().window().maximize(); // 窗口最大化
			driver.get(url); // 打开网页
			// 跳转页面截图
			Thread.sleep(2000);
			screenshot2((TakesScreenshot) driver, "Page_OpenUrl.png");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// 设置超时时间
		} catch (Exception e) {
			screenshot((TakesScreenshot) driver, "Error_OpenBrowser.png");
			driver.quit();
			throw new Exception();
		}
	}

	// 在首页搜索框搜索，如果出现异常截图
	public static void typesearchbar() throws Exception {
		try {
			driver.findElement(By.id("search")).clear();// 清除搜索框
			driver.findElement(By.id("search")).sendKeys("跑步鞋");// 在搜索框输入“跑步鞋”
			driver.findElement(By.xpath("//button[@type='submit']")).click();// 点击搜索按钮
			// 跳转页面截图
			Thread.sleep(2000);
			screenshot2((TakesScreenshot) driver, "Page_TypeSearchBar.png");
		} catch (Exception e) {
			screenshot((TakesScreenshot) driver, "Error_TypeSearchBar.png");
			driver.quit();
			throw new Exception();
		}
	}

	// 按条件筛选，如果出现异常截图
	public static void searchshoe() throws Exception {
		try {
			driver.findElement(By.xpath("//a[contains(text(),'跑步')]")).click();// 点击運動分类中的跑步
			driver.findElement(By.xpath("//a[contains(text(),'男款')]")).click();// 点击性别分类中的男款
			driver.findElement(By.xpath("//a[contains(text(),'鞋')]")).click();// 点击產品類型分类中的鞋
			driver.findElement(By.id("price-from")).click();// 价格区间--从
			driver.findElement(By.id("price-from")).clear();// 清除价格区间--从
			driver.findElement(By.id("price-from")).sendKeys("500");// 价格区间--从的值
			driver.findElement(By.id("price-to")).clear();// 价格区间--至
			driver.findElement(By.id("price-to")).sendKeys("800");// 价格区间--至得值
			driver.findElement(By.id("btn-range")).click();// 点击確認
			Thread.sleep(2000);
		} catch (Exception e) {
			screenshot((TakesScreenshot) driver, "Error_SearchShoe.png");
			driver.quit();
			throw new Exception();
		}
	}

	// 选择男士跑步鞋，并跳转至新的窗口，如果出现异常截图
	public static void selectshoe() throws Exception {
		try {
			// 跳转页面截图
			screenshot2((TakesScreenshot) driver, "Page_SearchShoes.png");
			driver.findElement(
					By.cssSelector("img[alt=\"EKIDEN COMFORT 男裝跑步鞋 - 灰/藍\"]"))
					.click();
			String handle = driver.getWindowHandle(); // 跳转窗口
			for (String handles : driver.getWindowHandles()) {
				if (handles.equals(handle))
					continue;
				driver.switchTo().window(handles);
			}
			// 选择颜色，尺码
			driver.findElement(By.xpath("//a[@id='value13633']")).click();// 选择蓝色
			driver.findElement(By.id("value13672")).click();// 选择尺码 41码
			Thread.sleep(2000);
			WebElement webElement = driver.findElement(By.className("add-to-cart"));
			action.moveToElement(webElement).build().perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//form[@id='product_addtocart_form']/div[4]/div[2]/button")).click();
			// 跳转页面截图
			screenshot2((TakesScreenshot) driver, "Page_SelectShoes.png");
		} catch (Exception e) {
			screenshot((TakesScreenshot) driver, "Error_SelectShoe.png");
			driver.quit();
			throw new Exception();
		}
		
	}

	// 判断鞋子是否缺货
	public static void isoutofstock_shoe() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.xpath("//div[@id='messages_product_view']/ul[@class='messages']/li/ul/li/span")).isDisplayed();
			}
		});
		String message = driver
				.findElement(
						By.xpath("//div[@id='messages_product_view']/ul[@class='messages']/li/ul/li/span"))
				.getText().trim();
		String newmessage = message.substring(0, 2);
		if (newmessage.equals("訂購")) {
			screenshot((TakesScreenshot) driver, "OutOfStock_shoes.png");
			System.out.println("shoe is out of stock");
			driver.quit();
			throw new Exception();
		}
	}

	// 搜索T-shirt，如果出现异常截图
	public static void searchtshirt() throws Exception {
		try {
			driver.findElement(By.id("search")).clear();// 清除搜索框的值
			driver.findElement(By.id("search")).sendKeys("T-shirt");// 输入搜索框的值为“T-shirt”
			driver.findElement(By.xpath("//button[@type='submit']")).click();// 点击搜索
			Thread.sleep(3000);// 休眠3秒
		} catch (Exception e) {
			screenshot((TakesScreenshot) driver, "Error_SearchTshirt.png");
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
				// 跳转页面截图
				Thread.sleep(2000);
				screenshot2((TakesScreenshot) driver, "Page_SelectT-Shirt.png");
				WebElement webElement = driver.findElement(By.xpath("//img[@alt='長袖男裝T-shirt']"));
				action.moveToElement(webElement).build().perform();
				Thread.sleep(2000);
				window.findElement(By.xpath("//img[@alt='長袖男裝T-shirt']"))
						.click();
				//Thread.sleep(3000);// 休眠3秒
			}
		} catch (Exception e) {
			screenshot((TakesScreenshot) driver, "Error_SelectTshirt.png");
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
			driver.findElement(By.id("value13692")).click(); // 选择M號
			Thread.sleep(2000);
			WebElement webElement = driver.findElement(By.className("add-to-cart"));
			action.moveToElement(webElement).build().perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//form[@id='product_addtocart_form']/div[4]/div[2]/button")).click();// 加入购物车
			// 跳转页面截图
			screenshot2((TakesScreenshot) driver, "Page_AddInToShippingCart.png");
		} catch (Exception e) {
			screenshot((TakesScreenshot) driver,
					"Error_AddInToShippingCart.png");
			driver.quit();
			throw new Exception();
		}
	}

	// 判断T-shirt是否缺货
	public static void isoutofstock_tshirt() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.xpath("//div[@id='messages_product_view']/ul[@class='messages']/li/ul/li/span")).isDisplayed();
			}
		});
		String messages = driver
				.findElement(
						By.xpath("//div[@id='messages_product_view']/ul[@class='messages']/li/ul/li/span"))
				.getText().trim();
		String newmessages = messages.substring(0, 2);
		if (newmessages.equals("訂購")) {
			screenshot((TakesScreenshot) driver, "OutOfStock_T-shirt.png");
			System.out.println("T-shirt is out of stock");
			driver.quit();
			throw new Exception();
		}
	}

	// 进入购物车页面,修改购物车内容,出现异常截图
	public static void editshoppingcart() throws Exception {
		try {
			WebElement webElementin = driver.findElement(By.xpath("//div[@class='nav-cart']"));
			WebElement webElement2 = driver.findElement(By.xpath("//button[@id='topcart-checkout']"));
			while (true) {
				action.moveToElement(webElementin).build().perform();
				WebDriverWait wait = new WebDriverWait(driver, 10);
				Boolean flag2 = wait.until(new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver d) {
						return d.findElement(By.xpath("//button[@id='topcart-checkout']")).isDisplayed();
					}
				});
				if(flag2){
					webElement2.click();// 点击去购物车结算
					break;
				}
			}
			driver.findElement(By.cssSelector("button.button.btn-increase"))
					.click();// 增加鞋子数量到2
			driver.findElement(By.xpath("//div[@id='shopping-cart-list']/table[4]/tbody/tr/td[7]/button"))
					.click();// 删除T-shirt
			// --------------------------应用优惠券前比较价格--------------------------//
			String subtotalprice = driver
					.findElement(
							By.xpath("//table[@id='shopping-cart-totals-table']/tbody/tr[1]/td[2]/span"))
					.getText();// =应用优惠券前小计价格
			System.out.println("subtotalprice is:" + subtotalprice);
			String beforetotalprice = driver
					.findElement(
							By.xpath("//table[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/span"))
					.getText(); // 应用优惠券前总计（含运费）价格
			System.out.println("beforetotalprice is:" + beforetotalprice);
			// 截取
			Double newsubtotalprice = Double.parseDouble(subtotalprice
					.substring(3, subtotalprice.length() - 3).replace(",", ""));
			System.out.println("newsubtotalprice is:" + newsubtotalprice);
			Double newbeforetotalprice = Double.parseDouble(beforetotalprice
					.substring(3, beforetotalprice.length() - 3).replace(",",
							""));
			System.out.println("newbeforetotalprice is:" + newbeforetotalprice);
			// 判断小计价格是否与总计价格相等，出现异常截图
			if (newsubtotalprice.equals(newbeforetotalprice)) {
				System.out.println("the sub total price is right");
			} else {
				screenshot((TakesScreenshot) driver, "Error_Price.png");
				driver.quit();
			}
			// Thread.sleep(3000);// 休眠3秒
			// driver.findElement(By.id("coupon_code")).sendKeys("M47U0O0HUIAS");//输入优惠代码
			// Thread.sleep(3000);// 休眠3秒
			// driver.findElement(By.cssSelector("div.discount-form > div.actions > button.button")).click();//
			// 点击应用优惠券
			// Thread.sleep(3000);// 休眠3秒
			// //
			// --------------------------比较应用优惠券后的价格--------------------------//
			// String couponprice =
			// driver.findElement(By.xpath("//table[@id='shopping-cart-totals-table']/tbody/tr[2]/td/span")).getText();//
			// 优惠券价格
			// System.out.println("couponprice is :" + couponprice);
			// String totalprice =
			// driver.findElement(By.xpath("//table[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/span")).getText();//
			// 应用优惠券后总计（不含运费）价格
			// System.out.println("totalprice is :" + totalprice);
			// //将string类型转化为double类型
			// double newsubtotalprice =
			// Double.parseDouble(subtotalprice.substring(1,
			// subtotalprice.length() - 1));
			// System.out.println("newsubtotalprice is :" + newsubtotalprice);
			// double newcouponprice =
			// Double.parseDouble(couponprice.substring(2,couponprice.length() -
			// 2));
			// System.out.println("newcouponprice is :" + newcouponprice);
			// double newtotalsprice =
			// Double.parseDouble(totalprice.substring(1,totalprice.length() -
			// 1));
			// System.out.println("newtotalsprice is :" + newtotalsprice);
			// //判断应用优惠券后价格是否正确，出现异常截图
			// if ((newsubtotalprice - newcouponprice) == newtotalsprice) {
			// System.out.println("the totals price is right");
			// } else {
			// screenshot((TakesScreenshot)
			// driver,"NewCustomer_EditShippingCart_totalsprice.png");
			// driver.quit();
			// }
			Thread.sleep(3000);// 休眠3秒
			// 跳转页面截图
			screenshot2((TakesScreenshot) driver, "Page_EditShippingCart.png");
			driver.findElement(By.xpath("(//li/button)")).click();// 点击去结算
		} catch (Exception e) {
			screenshot((TakesScreenshot) driver, "Error_EditShippingCart.png");
			driver.quit();
			throw new Exception();
		}
	}

	// 注册新用户 ，取消优惠券，出现异常截图
	public static void registernewcustomer(String useradd, String userpassword)
			throws Exception {
		try {
			// 跳转页面截图
			Thread.sleep(2000);
			screenshot2((TakesScreenshot) driver,
					"Page_RegisterNewCustomer1.png");
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
			// 跳转页面截图
			Thread.sleep(2000);
			screenshot2((TakesScreenshot) driver,
					"Page_RegisterNewCustomer2.png");
			// 同意條款並註冊
			driver.findElement(By.cssSelector("button.button.btn-blue"))
					.click();
			// 跳转页面截图
			Thread.sleep(2000);
			screenshot2((TakesScreenshot) driver,
					"Page_RegisterNewCustomer3.png");
			// // 点击取消优惠券
			// driver.findElement(By.xpath("//button[@value='取消优惠券']")).click();
			// 点击去结算
			//driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
			driver.findElement(By.xpath("(//li/button)")).click();// 点击去结算
		} catch (Exception e) {
			screenshot((TakesScreenshot) driver,
					"Error_RegisterNewCustomer.png");
			driver.quit();
			throw new Exception();
		}
		Thread.sleep(2000);
	}

	// 新用户填写收件地址，出现异常截图
	public static void fillinformation() throws Exception {
		try {
			driver.findElement(By.id("billing:firstname")).sendKeys("张");// 填寫姓
			driver.findElement(By.id("billing:lastname")).sendKeys("三");// 填寫名
			new Select(driver.findElement(By.id("billing:country_id")))
					.selectByVisibleText("香港");// 选择國家
			new Select(driver.findElement(By.id("billing:region_id")))
					.selectByVisibleText("香港島");// 选择地區
			new Select(driver.findElement(By.id("billing:city_id")))
					.selectByVisibleText("香港");// 选择鄉鎮市區
			// driver.findElement(By.id("billing:postcode")).sendKeys("200000");//
			// 邮件编码
			driver.findElement(By.id("billing:street1")).sendKeys("人民路1弄1号");// 填寫地址
			driver.findElement(By.id("billing:telephone")).sendKeys(
					"13988988998");// 填寫手提電話
			driver.findElement(By.id("checkout-save-addr")).click();// 儲存地址
			// 跳转页面截图
			Thread.sleep(2000);
			screenshot2((TakesScreenshot) driver, "Page_FillInformation.png");
			Thread.sleep(3000);// 休眠3秒
			// 收货信息填写完成功，下一步
			Actions newaction = new Actions(driver);
			newaction.click(
					driver.findElement(By
							.xpath("//button[@id='checkout-save-shipping']")))
					.perform();// 点击下一步
		} catch (Exception e) {
			screenshot((TakesScreenshot) driver, "Error_FillInformation.png");
			driver.quit();
			throw new Exception();
		}
		Thread.sleep(3000);// 休眠3秒
	}

	// 两次下一步，出現異常截圖
	public static void clicknextbutton() throws Exception {
		try {
			// 配送方式中的下一步
			driver.findElement(
					By.cssSelector("#shipping-method-buttons-container > button.button"))
					.click();
			// 跳转页面截图
			screenshot2((TakesScreenshot) driver, "Page_ClickNextButton1.png");
			Thread.sleep(3000);
			// 付款資訊中的下一步
			driver.findElement(
					By.cssSelector("#payment-buttons-container > button.button"))
					.click();
			// 跳转页面截图
			screenshot2((TakesScreenshot) driver, "Page_ClickNextButton2.png");
			Thread.sleep(3000);
		} catch (Exception e) {
			screenshot((TakesScreenshot) driver, "Error_ClickNextButton.png");
			driver.quit();
			throw new Exception();
		}
	}

	// 最后核对价格，点击提交订单，出现异常截图
	public static void checkout() throws Exception {
		try {
			// 跳转页面截图
			screenshot2((TakesScreenshot) driver, "Page_CheckOut.png");
			// --------------------------核对应付总额的价格--------------------------//
			// 确认购物清单中的商品小计
			String finalsubtotalprice = driver
					.findElement(
							By.xpath("//table[@id='checkout-totals']/tbody/tr[1]/td/span[1]/span"))
					.getText();
			System.out.println("finalsubtotalprice is:" + finalsubtotalprice);
			// // 确认购物清单中的运费价格
			// String finaldeliveryprice =
			// driver.findElement(By.xpath("//table[@id='checkout-totals']/tbody/tr[1]/td/span[3]/span/span")).getText();
			// System.out.println("finaldeliveryprice:" + finaldeliveryprice);
			// 确认购物清单中的總金額
			String finaltotalprice = driver
					.findElement(
							By.xpath("//table[@id='checkout-totals']/tbody/tr[3]/td[2]/div[2]/span"))
					.getText();
			System.out.println("finaltotalprice is:" + finaltotalprice);
			// 将string类型转化为double类型
			Double newfinalsubtotalprice = Double
					.parseDouble(finalsubtotalprice.substring(3,
							finalsubtotalprice.length() - 3).replace(",", ""));
			System.out
					.println("newfinalsubtotalprice:" + newfinalsubtotalprice);
			// double newfinaldeliveryprice =
			// Double.parseDouble(finaldeliveryprice.substring(1,finaldeliveryprice.length()
			// - 1));
			// System.out.println("newfinaldeliveryprice:" +
			// newfinaldeliveryprice);
			Double newfinaltotalprice = Double.parseDouble(finaltotalprice
					.substring(3, finaltotalprice.length() - 3)
					.replace(",", ""));
			System.out.println("newfinaltotalprice:" + newfinaltotalprice);
			// 判断商品小计价格是否等于应付总额，出现异常截图
			if (newfinalsubtotalprice.equals(newfinaltotalprice)) {
				System.out.println("the final totals price is right");
			} else {
				screenshot((TakesScreenshot) driver, "Error_Price.png");
				driver.quit();
			}
			/*-------------------------以下是确认购物清单部分-------------------------*/
			// 点击提交订单
			Actions theaction = new Actions(driver);
			theaction.click(driver.findElement(By.id("checkout-place-order")))
					.perform();
			Thread.sleep(3000);// 休眠3秒
		} catch (Exception e) {
			screenshot((TakesScreenshot) driver, "Error_CheckOut.png");
			driver.quit();
			throw new Exception();
		}
	}
	// 退出浏览器
	public static void closebrowser() {
		driver.quit();
	}
}
