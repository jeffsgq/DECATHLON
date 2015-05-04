package testhk;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

import returncustomerhk.Test_women_ReturnCustomer_HK;
import circulation.Loop;


public class TestCase_women_ReturnCustomer_HK {
	Test_women_ReturnCustomer_HK demo;
	static int count; // 记录第几次循环
	Map<Integer, String> map = new HashMap<Integer, String>(); // 错误信息
	Map<String, String> map2 = new HashMap<String, String>(); // 用户信息
	Map<String, String> map3 = new HashMap<String, String>(); // 优惠券号码

	public TestCase_women_ReturnCustomer_HK() {
		// 错误信息
		map.put(1, "1.Unable to open the Decathlon website");
		map.put(2, "2.Unable to local the woman shoes");
		map.put(6, "6.Unable to local the sport range");
		map.put(7, "7.Unable to local the gender");
		map.put(8, "8.Unable to input price");
		map.put(10, "10.Unable to click the button of confirm");
		map.put(12, "12.Unable to choice the woman shoes");
		map.put(13, "13.Window can not skip");
		map.put(15, "15.Unable to click the yellow shoes");
		map.put(16, "16.Unable to click the shoes's size");
		map.put(17, "17.Unable to click the button of increase quantity");
		map.put(18, "18.Unable to add to Cart");
		map.put(19, "19.The goods out of store");
		map.put(20, "20.The search box unable to input");
		map.put(21, "21.Unable to click the search button");
		map.put(22, "22.Unable to choice the T-shirt");
		map.put(23, "23.The window skip failure");
		map.put(24, "24.Unable to add to cart");
		map.put(241, "241.Choice the size");
		map.put(26, "26.The mouse unable move on the cart-button");
		map.put(27, "27.Unable to click the button of payment");
		map.put(28, "28.The goods total price error");
		map.put(29, "29.Ubable to add the shoes's quantity");
		map.put(30, "30.Unable to remove the T-shirt");
		map.put(31, "31.The goods total price error");
		map.put(35, "35.Unable to click the button of payment");
		map.put(36, "38.Unable to input user name");
		map.put(37, "37.Unable to input the password");
		map.put(38, "38.Unable to click the button of Login");
		map.put(40, "40.Unable to click the button of payment");
		map.put(43, "43.Unable to click the next-button");
		map.put(45, "45.The payment price error");
		map.put(46, "46.Unable to click the button of confirm");
		map.put(47, "47.Unable to quit driver");
		// 用户信息
		map2.put("name", "gezq99@163.com");
		map2.put("password", "Gezq100");
		// 优惠券号码
		map3.put("coupon1", "M47U0O0HUIAS");
	}

	@Test(invocationCount = Loop.Times)
	public void TestReturnCustomerHK() throws Exception {
		++count;
		System.out.println("Loop " + count);
		demo = new Test_women_ReturnCustomer_HK(); // 实例化
		try {// 1
			demo.openURL("http://hk-des-p0.dkn.ext.bluecomdev.net/hkcntrad", count);//http://www.decathlon.com.hk/hkcntrad/http://hklive.dkn.ext.bluecomdev.net
		} catch (Exception e) {
			throw new Exception(map.get(1));
		}
		
		try {// 2
			demo.moveOnSYYDFL(count);
		} catch (Exception e) {
			throw new Exception(map.get(2));
		}
		
		try {// 6
			demo.clickYDFW(count);
		} catch (Exception e) {
			throw new Exception(map.get(6));
		}
		try {// 7
			demo.clickXB(count);
		} catch (Exception e) {
			throw new Exception(map.get(7));
		}
		try {// 8
			demo.inputPriceFrom(count);
		} catch (Exception e) {
			throw new Exception(map.get(8));
		}
		try {// 9
			demo.inputPriceTo(count);
		} catch (Exception e) {
			throw new Exception(map.get(8));
		}
		try {// 10
			demo.clickJGQJQD(count);
		} catch (Exception e) {
			throw new Exception(map.get(10));
		}
	 
		try {// 12
			demo.choiceNSPBX(count);
		} catch (Exception e) {
			throw new Exception(map.get(12));
		}
		try {// 13
			demo.windowSkip(count);
		} catch (Exception e) {
			throw new Exception(map.get(13));
		}

		try {// 15
			demo.choiceYellow(count);
		} catch (Exception e) {
			throw new Exception(map.get(15));
		}
		try {// 16
			demo.choice36Size(count);
		} catch (Exception e) {
			throw new Exception(map.get(16));
		}
		try {// 17
			demo.increaseNum(count);
		} catch (Exception e) {
			throw new Exception(map.get(17));
		}
		try {// 18
			demo.joinCart(count);
		} catch (Exception e) {
			throw new Exception(map.get(18));
		}

		try {// 19
			demo.product_view(count);
		} catch (Exception e) {
			throw new Exception(map.get(19));
		}

		try {// 20
			demo.selectT_shirt(count);
		} catch (Exception e) {
			throw new Exception(map.get(20));
		}
		try {// 21
			demo.clickSelect(count);
		} catch (Exception e) {
			throw new Exception(map.get(21));
		}
		try {// 22
			demo.choiceT_shirt(count);
		} catch (Exception e) {
			throw new Exception(map.get(22));
		}
		try {// 23
			demo.windowSkip2(count);
		} catch (Exception e) {
			throw new Exception(map.get(23));
		}
		try {// 241
			demo.choiceT_shirt_Size(count);
		} catch (Exception e) {
			throw new Exception(map.get(241));
		}
		try {// 24
			demo.joinCart_Tshirt(count);
		} catch (Exception e) {
			throw new Exception(map.get(24));
		}
		
		try {// 24
			demo.product_view_tshirt(count);
		} catch (Exception e) {
			throw new Exception(map.get(19));
		}
		
		try {// 26
			demo.moveOnCart(count);
		} catch (Exception e) {
			throw new Exception(map.get(26));
		}
		
		try {// 28
			demo.countPrice_One(count);
		} catch (Exception e) {
			throw new Exception(map.get(28));
		}
		try {// 29
			demo.addShoesQuanity(count);
		} catch (Exception e) {
			throw new Exception(map.get(29));
		}
		try {// 30
			demo.removeT_shirt(count);
		} catch (Exception e) {
			throw new Exception(map.get(30));
		}
		try {// 31
			demo.countPrice_Two(count);
		} catch (Exception e) {
			throw new Exception(map.get(31));
		}
		try {// 35
			demo.clickPayment(count);
		} catch (Exception e) {
			throw new Exception(map.get(35));
		}
		try {// 36
			demo.inputUserName(map2.get("name"), count);
		} catch (Exception e) {
			throw new Exception(map.get(36));
		}
		try {// 37
			demo.inputPasswd(map2.get("password"), count);
		} catch (Exception e) {
			throw new Exception(map.get(37));
		}
		try {// 38
			demo.clickLogin(count);
		} catch (Exception e) {
			throw new Exception(map.get(38));
		}
		try {// 40
			demo.clickPaymentFinal(count);
		} catch (Exception e) {
			throw new Exception(map.get(40));
		}
		try {// 41
			demo.checkAddress(count);
		} catch (Exception e) {
			throw new Exception(map.get(43));
		}
		try {// 42
			demo.deliveryMethods(count);
		} catch (Exception e) {
			throw new Exception(map.get(43));
		}
		try {// 43
			demo.paymentMessage(count);
		} catch (Exception e) {
			throw new Exception(map.get(43));
		}
		try {// 45
			demo.countPrice_Final(count);
		} catch (Exception e) {
			throw new Exception(map.get(45));
		}
		try {// 46
			demo.checkoutOrder(count);
		} catch (Exception e) {
			throw new Exception(map.get(46));
		}
		try {// final 47
			demo.quitDriver(count);
		} catch (Exception e) {
			throw new Exception(map.get(47));
		}
		System.out.println("Loop " + count + " end");
	}
}
