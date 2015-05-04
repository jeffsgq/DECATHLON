package testhk;

import java.util.HashMap;
import java.util.Map;

import newcustomerhk.Test_man_NewCustomer_HK;

import org.testng.annotations.Test;

import circulation.Loop;


public class TestCase_man_NewCustomer_HK {
	Test_man_NewCustomer_HK demo;
	static int count;
	String url = "http://hk-des-p0.dkn.ext.bluecomdev.net/hkcntrad"; //http://www.decathlon.com.hk/hkcntrad 
	String useradd="newcustomers"+Test_man_NewCustomer_HK.getrandomletter()+Test_man_NewCustomer_HK.getrandomnum()+"@dec.com";
	String userpassword="111111";
	// 错误信息
	Map<String, String> map = new HashMap<String, String>();
	{
		map.put("1", "can not open url");
		map.put("2", "can not type in search bar");
		map.put("3", "can not find shoe");
		map.put("4", "can not select shoe");
		map.put("5", "shoe is out of stock");
		map.put("6", "can not type in search bar");
		map.put("7", "can not select T-shirt");
		map.put("8", "can not add into shipping cart");
		map.put("9", "T-shirt is out of stock");
		map.put("10", "can not edit shipping cart");
		map.put("11", "can not register a new customers");
		map.put("12", "can not fill information");
		map.put("13", "can not click next button");
		map.put("14", "can not check out");
	}

	@Test(invocationCount = Loop.Times)
	public void TestNewCustomerHK() throws Exception {
		 ++ count;
		 System.out.println("Loop "+count);
		 demo = new Test_man_NewCustomer_HK(); // 实例化
		try {
			Test_man_NewCustomer_HK.openurl(url);
			
		} catch (Exception e) {
			throw new Exception(map.get("1"));
		}
		System.out.println("newcustomer step one is ok");
		try {
			Test_man_NewCustomer_HK.typesearchbar();

		} catch (Exception e) {
			throw new Exception(map.get("2"));
		}
		System.out.println("newcustomer step two is ok");
		try {
			Test_man_NewCustomer_HK.searchshoe();
		} catch (Exception e) {
			throw new Exception(map.get("3"));

		}
		System.out.println("newcustomer step three is ok");
		try {
			Test_man_NewCustomer_HK.selectshoe();
		} catch (Exception e) {
			throw new Exception(map.get("4"));
		}
		System.out.println("newcustomer step four is ok");
		try {
			Test_man_NewCustomer_HK.isoutofstock_shoe();
		} catch (Exception e) {
			throw new Exception(map.get("5"));
		}
		System.out.println("newcustomer step five is ok");
		try {
			Test_man_NewCustomer_HK.searchtshirt();
		} catch (Exception e) {
			throw new Exception(map.get("6"));
		}
		System.out.println("newcustomer step six is ok");
		try {
			Test_man_NewCustomer_HK.selecttshirt();
		} catch (Exception e) {
			throw new Exception(map.get("7"));
		}
		System.out.println("newcustomer step seven is ok");
		try {
			Test_man_NewCustomer_HK.addintoshoppingcart();
		} catch (Exception e) {
			throw new Exception(map.get("8"));
		}
		System.out.println("newcustomer step eight is ok");
		try {
			Test_man_NewCustomer_HK.isoutofstock_tshirt();
		} catch (Exception e) {
			throw new Exception(map.get("9"));
		}
		System.out.println("newcustomer step nine is ok");
		try {
			Test_man_NewCustomer_HK.editshoppingcart();
		} catch (Exception e) {
			throw new Exception(map.get("10"));
		}
		System.out.println("newcustomer step ten is ok");
		try {
			Test_man_NewCustomer_HK.registernewcustomer(useradd,userpassword);
		} catch (Exception e) {
			throw new Exception(map.get("11"));
		}
		System.out.println("newcustomer step eleven is ok");
		try {
			Test_man_NewCustomer_HK.fillinformation();
		} catch (Exception e) {
			throw new Exception(map.get("12"));
		}
		System.out.println("newcustomer step twelve is ok");
		try {
			Test_man_NewCustomer_HK.clicknextbutton();
		} catch (Exception e) {
			throw new Exception(map.get("13"));
		}
		System.out.println("newcustomer step thirteen is ok");
		try {
			Test_man_NewCustomer_HK.checkout();
		} catch (Exception e) {
			throw new Exception(map.get("14"));
		}
		System.out.println("newcustomer step fourteen is ok");
		System.out.println("All passed");
		System.out.println("Loop "+count+" end");
		Test_man_NewCustomer_HK.closebrowser();
	}
	
}
