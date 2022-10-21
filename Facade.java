package ProductTradingBiddingSystem;

import java.io.*;

public class Facade {

	private int UserType;

	private Product theselectedProduct = null;

	private int nProductCategory = 0;

	ClassProductList theProductList;

    Person thePerson;
    public Facade() {
	}

	static public boolean login(UserInfoItem userinfoItem) {
		Login login = new Login();
 		login.setModal(true);
 		login.show();
 		userinfoItem.strUserName = login.GetUserName();
		userinfoItem.UserType = login.GetUserType();
     
        return login.isExit();
	}

	void addTrading(Product theProduct) {
         TradingMenu theTradingMenu;
         if (thePerson.type == 0)/// customers
		{
			theTradingMenu = new SellerTradingMenu();
		} else {
			theTradingMenu = new BuyerTradingMenu();
		}
		Trading theTrading = new Trading();
		theTradingMenu.ShowMenu(theTrading, thePerson);
		theProduct.AddATrading(theTrading);
	}

	void viewTrading(Trading theTrading) {
         TradingMenu theTradingMenu;
         if (thePerson.type == 0)/// customers
		{
			theTradingMenu = new SellerTradingMenu();
		} else {
			theTradingMenu = new BuyerTradingMenu();
		}
		theTradingMenu.ShowMenu(theTrading, thePerson);

	}

	void decideBidding(Offering theOffering) {
		OfferingMenu OfferingMenu = new OfferingMenu();
		OfferingMenu.ShowMenu(theOffering);


	}

	void discussBidding(Trading theTrading) {
		Offering theOffering;
		OfferingIterator theOfferingIterator;
		theOfferingIterator = theAssignment.GetOfferingIterator();
		theOffering = (Offering) theOfferingIterator.next();
		while (theOffering != null) {
			theOffering.setReported(true);
			theOffering = (Offering) theOfferingIterator.next();

	}
	void submitBidding(Trading theTrading, Offering theOffering) {
		theTrading.AddOffering(theOffering);

	}


	void remind() {
		Reminder theReminder = new Reminder();
		theReminder.showReminder(thePerson.GetProductList());
	}
	void CreateUser(UserInfoItem userinfoitem) {
		if (userinfoitem.UserType == UserInfoItem.USER_TYPE.Seller) 
		{
			thePerson = new Seller();
		} else /// buyer
		{
			thePerson = new Buyer();
		}
		thePerson.UserName = userinfoitem.strUserName;
	}
	/*
	 * create a Product list and intitialize it with the file ProductInfo.txt
	 */
	void CreateProductList() {
		theProductList = new ClassProductList();
		theProductList.InitializeFromFile("ProductInfo.txt");
	}
}
	void AttachProductToUser() {
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("UserProduct.txt"));
			String aline, strUserName, strProductName;
			while ((aline = file.readLine()) != null) // not the EOF
			{
				strUserName = GetUserName(aline);
				strProductName = GetProductName(aline);
				if (strUserName.compareTo(thePerson.UserName) == 0) /// the UserName mateches
				{
					theSelecteProduct = FindProductByProductName(strProductName);
					if (theSelecteProduct != null) /// Find the Product in the ProductList--->attach
					{
						thePerson.AddProduct(theSelecteProduct);
					}
				}
			}
		} catch (Exception ee) {
			;
		}
	}

	/*
	 * get the user name from aline UserName:ProductName
	 */
	private String GetUserName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(0, Sep);
	}

	/*
	 * get the ProductName from aline UserName:ProductName
	 */
	private String GetProductName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(Sep + 1, aline.length());
	}
	public boolean SelectProduct() {
		ProductSelectDlg theDlg = new ProductSelectDlg();
		theSelecteProduct = theDlg.ShowDlg(thePerson.ProductList);
		thePerson.CurrentProduct = theSelecteProduct;
		nProductLevel = theDlg.nProductLevel;
		return theDlg.isLogout();
	}
	public boolean ProductOperation() {
		thePerson.CreateProductMenu(theSelecteProduct, nProductLevel);
		return thePerson.ShowMenu();//// 0: logout 1 select an other Product
	}
	private Product FindProductByProductName(String strProductName) {
		ProductIterator Iterator = new ProductIterator(theProductList);
		return (Product) Iterator.next(strProductName);
	}

}
