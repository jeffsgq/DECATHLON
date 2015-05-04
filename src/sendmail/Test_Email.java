package sendmail;

public class Test_Email {

	public static void main(String[] args) throws Exception{
			nc_desktop.screenshot("Regression_Report.jpg");
			nc_email.realmail(nc_desktop.getName1(),nc_desktop.getName2(),nc_desktop.getName3(),nc_desktop.getName4(),nc_desktop.getException1(),nc_desktop.getException2(),
					nc_desktop.getException3(),nc_desktop.getException4());
		}
}
