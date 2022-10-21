package ptbs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class SellerTradingMenu extends TradingMenu {

////  class TradingMenu
	private boolean boolSubmit = false;
	private Offering theOffering;
	private Trading theTrading;

	JLabel lTradingName = new JLabel();
	JLabel lDueDate = new JLabel();
	JTextField tbOffering = new JTextField();
	JLabel lSuggestedOffering = new JLabel();
	JLabel lDecide = new JLabel();
	JButton bSubmit = new JButton();
	JButton bCancel = new JButton();

	JLabel jLabel1 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JLabel jLabel6 = new JLabel();
	JLabel jLabel7 = new JLabel();

	public SellerTradingMenu() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		jLabel1.setText("Trading : ");
		jLabel1.setBounds(new Rectangle(20, 36, 91, 18));
		this.getContentPane().setLayout(null);
		lTradingName.setText("jLabel2");
		lTradingName.setBounds(new Rectangle(258, 35, 282, 18));
		jLabel3.setText("Due Date");
		jLabel3.setBounds(new Rectangle(21, 81, 92, 18));
		lDueDate.setText("jLabel4");
		lDueDate.setBounds(new Rectangle(254, 82, 294, 18));
		jLabel5.setText("Offering");
		jLabel5.setBounds(new Rectangle(24, 128, 93, 18));
		tbOffering.setText("jTextField1");
		tbOffering.setBounds(new Rectangle(251, 127, 211, 22));
		jLabel6.setText("Suggested Offering");
		jLabel6.setBounds(new Rectangle(24, 174, 117, 18));
		jLabel7.setText("Decide");
		jLabel7.setBounds(new Rectangle(23, 224, 41, 18));
		lSuggestedOffering.setText("jLabel8");
		lSuggestedOffering.setBounds(new Rectangle(259, 169, 201, 18));
		lDecide.setText("jLabel9");
		lDecide.setBounds(new Rectangle(258, 226, 41, 18));
		bSubmit.setText("Submit");
		bSubmit.setBounds(new Rectangle(476, 124, 79, 29));
		bSubmit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bSubmit_actionPerformed(e);
			}
		});
		bCancel.setText("Cancel");
		bCancel.setBounds(new Rectangle(475, 164, 79, 29));
		bCancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bCancel_actionPerformed(e);
			}
		});
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel3, null);
		this.getContentPane().add(jLabel5, null);
		this.getContentPane().add(jLabel6, null);
		this.getContentPane().add(lTradingName, null);
		this.getContentPane().add(lDueDate, null);
		this.getContentPane().add(tbOffering, null);
		this.getContentPane().add(jLabel7, null);
		this.getContentPane().add(lSuggestedOffering, null);
		this.getContentPane().add(lDecide, null);
		this.getContentPane().add(bSubmit, null);
		this.getContentPane().add(bCancel, null);
	}

	/*
	 * check if the Seller has already had a Offering or not. if not , create a new
	 * Offering for the Seller. after showing the Offering attatch the soluiton;
	 */
	public void ShowMenu(Trading Trading, Person thePerson) {
		theTrading = Trading;
		OfferingIterator theIter = theTrading.GetOfferingIterator();
		theOffering = (Offering) theIter.next(thePerson.UserName);
		if (theOffering == null) {
			tbOffering.setText("");
			lDecide.setText("-1");
		} else {
			tbOffering.setText(theOffering.OfferingFileName);
			lDecide.setText(theOffering.getDecideString());

		}

		lTradingName.setText(theTrading.AssName);
		lDueDate.setText(theTrading.DueDate.toString());
		lSuggestedOffering.setText(theTrading.SuggestOffering.OfferingFileName);

		show();

		if (boolSubmit == true) {
			if (theOffering == null) {
				theOffering = new Offering();
				theTrading.AddOffering(theOffering);
			}
			theOffering.theAuthor = thePerson.UserName;
			theOffering.OfferingFileName = tbOffering.getText();
			theOffering.theSubmitData = new Date();
		}
	}

	void bSubmit_actionPerformed(ActionEvent e) {
		boolSubmit = true;
		hide();
	}

	void bCancel_actionPerformed(ActionEvent e) {
		boolSubmit = false;
		hide();
	}

}