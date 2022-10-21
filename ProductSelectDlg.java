package ptbs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProductSelectDlg extends JDialog {
	// 0 Meat presentation 1 Produce Experiment
	ClassProductList theProductList;
	Product SelectedProduct;
	int nProductLevel = 0;
	boolean m_bLogout = false;
	JComboBox ProductNameCom = new JComboBox();
	JRadioButton MeatRadio = new JRadioButton();
	JRadioButton ProduceRadio = new JRadioButton();
	JLabel jLabel1 = new JLabel();
	JButton OKButton = new JButton();
	ButtonGroup buttonGroup1 = new ButtonGroup();
	JButton buttonLogout = new JButton();

	public ProductSelectDlg() {
		try {
			jbInit();
			setSize(420, 238);
			setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.getContentPane().setLayout(null);
		ProductNameCom.setBounds(new Rectangle(155, 41, 203, 22));
		MeatRadio.setText("Meat");
		MeatRadio.setBounds(new Rectangle(50, 87, 103, 26));
		ProduceRadio.setToolTipText("");
		ProduceRadio.setSelected(true);
		ProduceRadio.setText("Produce");
		ProduceRadio.setBounds(new Rectangle(236, 88, 103, 26));
		jLabel1.setText("ProductName");
		jLabel1.setBounds(new Rectangle(39, 44, 85, 18));
		OKButton.setText("OK");
		OKButton.setBounds(new Rectangle(78, 139, 79, 29));
		OKButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OKButton_actionPerformed(e);
			}
		});
		buttonLogout.setText("Logout");
		buttonLogout.setBounds(new Rectangle(224, 140, 73, 31));
		buttonLogout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonLogout_actionPerformed(e);
			}
		});
		this.getContentPane().add(ProductNameCom, null);
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(MeatRadio, null);
		this.getContentPane().add(ProduceRadio, null);
		this.getContentPane().add(OKButton, null);
		this.getContentPane().add(buttonLogout, null);
		buttonGroup1.add(MeatRadio);
		buttonGroup1.add(ProduceRadio);
	}

	/*
	 * show the theProductList in a combox Show the Product type selection button
	 * return the pointer pointing to the Product object return the Product Type
	 */

	public Product ShowDlg(ClassProductList ProductList) {

		theProductList = ProductList;
		ProductIterator theIterator = new ProductIterator(theProductList);
		Product theProduct;
		while ((theProduct = (Product) theIterator.next()) != null) /// end of the list
		{
			ProductNameCom.addItem(theProduct);
		}
		show();
		return SelectedProduct;
	}

	void OKButton_actionPerformed(ActionEvent e) {
		SelectedProduct = (Product) ProductNameCom.getSelectedItem();
		if (MeatRadio.isSelected())
			nProductLevel = 0; // Meat Product: 0
		else
			nProductLevel = 1; // Produce Product: 1
		hide();
	}

	public boolean isLogout() {
		return m_bLogout;
	}

	void buttonLogout_actionPerformed(ActionEvent e) {
		m_bLogout = true;
		hide();
	}
}