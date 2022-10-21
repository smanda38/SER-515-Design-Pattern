package ProductTradingBiddingSystem;

import javax.swing.*;

import ProductTradingBiddingSystem.UserInfoItem.USER_TYPE;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Login extends JDialog {

	boolean m_bExit = false;
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JButton loginButton = new JButton();
	JButton buttonExit = new JButton();
	JTextField UserNameText = new JTextField();
	JPasswordField PasswordText = new JPasswordField();
	JRadioButton SellerRadio = new JRadioButton();
	JRadioButton BuyerRadio = new JRadioButton();
	ButtonGroup buttonGroup1 = new ButtonGroup();
////// Attributes Added By me
	private String UserBox = null;
	private USER_TYPE UserType = USER_TYPE.Seller; // default to Seller

	public Login() {
		try {
			jbInit();
			setSize(300, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.getContentPane().setLayout(null);
		jLabel1.setText("UserName");
		jLabel1.setBounds(new Rectangle(26, 52, 80, 18));
		jLabel2.setText("Password");
		jLabel2.setBounds(new Rectangle(23, 119, 80, 18));
		loginButton.setText("Login");
		loginButton.setBounds(new Rectangle(31, 212, 85, 28));
		loginButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginButton_actionPerformed(e);
			}
		});
		buttonExit.setText("Exit");
		buttonExit.setBounds(new Rectangle(180, 211, 97, 28));
		buttonExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonExit_actionPerformed(e);
			}
		});
		UserNameText.setBounds(new Rectangle(119, 52, 144, 22));
		PasswordText.setBounds(new Rectangle(118, 119, 147, 22));
		SellerRadio.setSelected(true);
		SellerRadio.setText("Seller");
		SellerRadio.setBounds(new Rectangle(37, 164, 103, 26));
		BuyerRadio.setText("Buyer");
		BuyerRadio.setBounds(new Rectangle(177, 162, 103, 26));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(loginButton, null);
		this.getContentPane().add(buttonExit, null);
		this.getContentPane().add(UserNameText, null);
		this.getContentPane().add(PasswordText, null);
		this.getContentPane().add(SellerRadio, null);
		this.getContentPane().add(BuyerRadio, null);
		buttonGroup1.add(SellerRadio);
		buttonGroup1.add(BuyerRadio);
	}

	void loginButton_actionPerformed(ActionEvent e) {
		BufferedReader file;
		m_bExit = false;
		System.out.println("login clicked");
		try {
			if (SellerRadio.isSelected() == true)//// Seller
			{
				UserType = USER_TYPE.Seller; /// 0 for Seller
				file = new BufferedReader(new FileReader("SellInfo.txt"));
			} else// Buyer
			{
				UserType = USER_TYPE.Buyer; // 1 for Buyer
				file = new BufferedReader(new FileReader("BuyInfor.txt"));
			}
			UserBox = UserNameText.getText();
			String PasswordBox = new String(PasswordText.getPassword());
			String LoginName = null;
			String aline = null, UserName = null, Password = null;
			while ((aline = file.readLine()) != null) {
				UserName = GetUserName(aline);
				Password = GetPassword(aline);
				if (UserName.compareTo(UserBox) == 0 && Password.compareTo(PasswordBox) == 0)
					LoginName = UserName;
			}
			if (LoginName != null) {
				this.hide();
			}
		} catch (Exception ee) {
			;
		}

	}

	/*
	 * get the user name from aline UserName:Password
	 */
	private String GetUserName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(0, Sep);
	}

	/*
	 * get the password from aline UserName:Password
	 */
	private String GetPassword(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(Sep + 1, aline.length());
	}

	/* after login get the UserName of the login interface */
	public String GetUserName() {
		return UserBox;
	}

	/* after login get the userType of the login interface */
	public USER_TYPE GetUserType() {
		return UserType;
	}

	public boolean isExit() {
		return m_bExit;
	}

	void buttonExit_actionPerformed(ActionEvent e) {
		m_bExit = true;
		hide();
	}
}
