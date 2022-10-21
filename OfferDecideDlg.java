package ptbs;

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
			setSize(316, 186);
			setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		jLabel1.setText("Offering File Name");
		jLabel1.setBounds(new Rectangle(23, 30, 121, 18));
		this.getContentPane().setLayout(null);
		ttDecide.setBounds(new Rectangle(25, 66, 100, 22));
		buttonOK.setText("OK");
		buttonOK.setBounds(new Rectangle(217, 67, 79, 29));
		buttonOK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonOK_actionPerformed(e);
			}
		});
		labelOfferingFileName.setBounds(new Rectangle(212, 34, 163, 18));
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