package ptbs;

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
/////////////////////////
//functions for ProductMenu
	/*
	 * When click the add button of the ProductMenu , call this function this
	 * function will new a Trading fill the required infomation this function
	 * will call BuyerTradingMenu or SellerTradingMenu according to the
	 * type of the user it will not update the Product menu. the productmenu need to
	 * refreshed outside the function
	 */

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
	/*
	 * When click the view button of the ProductMenu , call this function and pass
	 * the pointer of the Trading and the person pointer to this function this
	 * function will new a Trading fill the required infomation this function
	 * will call BuyerTradingMenu or SellerTradingMenu according to the
	 * type of the user 
	 */

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
////////////////////

//functions for SellerTradingMenu
	void submitBidding(Trading theTrading, Offering theOffering) {
		theTrading.AddOffering(theOffering);

	}
//////////

	void remind() {
		Reminder theReminder = new Reminder();
		theReminder.showReminder(thePerson.GetProductList());
	}
	void CreateUser(UserInfoItem userinfoitem) {
		if (userinfoitem.UserType == UserInfoItem.USER_TYPE.Seller) 
/// seller
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
	/*
	 * call this function after create user, create productlist read the
	 * UserProduct.txt file match the Productname with theCouresList attach the
	 * Matched Product object to the new create user Facade.thePerson.ProductList
	 */
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

	/*
	 * show the Product selection dlg, show the Product attatched to theperson and
	 * return the selected Product and assign the Product to the class member
	 * theSelecteProduct, the Product Level to ProductLevel ProductLeve=0 High,
	 * ProductLeve=1 Low
	 */
	public boolean SelectProduct() {
		ProductSelectDlg theDlg = new ProductSelectDlg();
		theSelecteProduct = theDlg.ShowDlg(thePerson.ProductList);
		thePerson.CurrentProduct = theSelecteProduct;
		nProductLevel = theDlg.nProductLevel;
		return theDlg.isLogout();
	}

	/*
	 * call the thePerson.CreateProductMenu according to the really object(student or
	 * instructor) and the nProductLevel it will call different menu creater and show
	 * the menu;
	 */

	public boolean ProductOperation() {
		thePerson.CreateProductMenu(theSelecteProduct, nProductLevel);
		return thePerson.ShowMenu();//// 0: logout 1 select an other Product
	}

	/*
	 * find the Product in theProductList that matches strProductName 1 create a
	 * ProductIterator for the List 2 Find the Product with the Iterator return the
	 * pointer of the Product if not fine, return null;
	 */
	private Product FindProductByProductName(String strProductName) {
		ProductIterator Iterator = new ProductIterator(theProductList);
		return (Product) Iterator.next(strProductName);
	}

}
