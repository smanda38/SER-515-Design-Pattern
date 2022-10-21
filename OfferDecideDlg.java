package ProductTradingBiddingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OfferDecideDlg extends JDialog {
	Offering theOffering;
	JLabel jLabel1 = new JLabel();
	JTextField ttDecide = new JTextField();
	JButton buttonOK = new JButton();
	JLabel labelOfferingFileName = new JLabel();

	public OfferDecideDlg() {
		try {
			jbInit();
			setSize(323, 199);
			setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		jLabel1.setText("Offering File Name");
		jLabel1.setBounds(new Rectangle(21, 34, 119, 25));
		this.getContentPane().setLayout(null);
		ttDecide.setBounds(new Rectangle(30, 69, 100, 29));
		buttonOK.setText("OK");
		buttonOK.setBounds(new Rectangle(220, 72, 84, 33));
		buttonOK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonOK_actionPerformed(e);
			}
		});
		labelOfferingFileName.setBounds(new Rectangle(200, 30, 165, 22));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(tDecide, null);
		this.getContentPane().add(labelOfferingFileName, null);
		this.getContentPane().add(buttonOK, null);
	}

	void show(Offering Offering) {
		theOffering = Offering;
		ttDecide.setText("" + theOffering.getDecideInt());
		labelOfferingFileName.setText(theOffering.OfferingFileName);
		show();
	}

	void buttonOK_actionPerformed(ActionEvent e) {
		theOffering.theDecide = Integer.parseInt(ttDecide.getText());
		hide();
	}

}
