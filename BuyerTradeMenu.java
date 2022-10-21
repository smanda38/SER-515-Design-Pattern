package ptbs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;

public class BuyerTradeMenu extends TradingMenu
{
////  class TradingMenu
  private boolean bSubmit=false;
  private Offering theOffering;
  private Trading theTrading;
  JComboBox CombOfferingList = new JComboBox();
////////////////////////


  JTextField tbTradingName = new JTextField();
  JTextField tbDueDate = new JTextField();
  JTextField tbSuggestedOffering = new JTextField();

  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JButton buttonDecide = new JButton();
  JButton buttonDiscuss = new JButton();
  JButton buttonClose = new JButton();

  public BuyerTradingMenu()
  {
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception
  {
    jLabel1.setText("Trading Name");
    jLabel1.setBounds(new Rectangle(25, 31, 118, 18));
    this.getContentPane().setLayout(null);
    tbTradingName.setText("jTextField1");
    tbTradingName.setBounds(new Rectangle(192, 31, 341, 22));
    jLabel2.setText("Due Date");
    jLabel2.setBounds(new Rectangle(28, 90, 113, 18));
    tbDueDate.setText("tbDueDate");
    tbDueDate.setBounds(new Rectangle(195, 87, 337, 22));
    jLabel3.setText("Suggested Offering");
    jLabel3.setBounds(new Rectangle(28, 151, 118, 18));
    tbSuggestedOffering.setText("jTextField2");
    tbSuggestedOffering.setBounds(new Rectangle(197, 149, 339, 22));
    buttonDecide.setText("Decide");
    buttonDecide.setBounds(new Rectangle(458, 199, 79, 29));
    buttonDecide.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        buttonDecide_actionPerformed(e);
      }
    });
    buttonDiscuss.setText("Discuss");
    buttonDiscuss.setBounds(new Rectangle(365, 249, 79, 29));
    buttonDiscuss.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        buttonDiscuss_actionPerformed(e);
      }
    });
    buttonClose.setText("Close");
    buttonClose.setBounds(new Rectangle(86, 253, 79, 29));
    buttonClose.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        buttonClose_actionPerformed(e);
      }
    });
    CombOfferingList.setBounds(new Rectangle(32, 204, 413, 22));
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(tbTradingName, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(tbDueDate, null);
    this.getContentPane().add(jLabel3, null);
    this.getContentPane().add(tbSuggestedOffering, null);
    this.getContentPane().add(buttonClose, null);
    this.getContentPane().add(CombOfferingList, null);
    this.getContentPane().add(buttonDecide, null);
    this.getContentPane().add(buttonDiscuss, null);
  }
  public void ShowMenu(Trading Trading, Person person)
  {
    theTrading=Trading;
    Offering theOffering;
    tbTradingName.setText(theTrading.AssName );

    DateFormat theDateFormat=DateFormat.getDateInstance(DateFormat.SHORT );
    tbDueDate.setText(theDateFormat.format(theTrading.DueDate));
    tbSuggestedOffering.setText(theTrading.SuggestOffering.OfferingFileName );
    refreshOfferingList();
    show();
  }

  void buttonClose_actionPerformed(ActionEvent e)
  {
    theTrading.AssName = tbTradingName.getText() ;
    DateFormat tempDateFormat=DateFormat.getDateInstance(DateFormat.SHORT );
    try
    {
      theTrading.DueDate=tempDateFormat.parse(tbDueDate.getText() );
    }catch (Exception ee){};
    theTrading.SuggestOffering.OfferingFileName =tbSuggestedOffering.getText() ;
    hide();
  }

  void buttonDecide_actionPerformed(ActionEvent e)
  {
    Offering theOffering=(Offering)CombOfferingList.getSelectedItem() ;
    if (theOffering==null)
       return;
    OfferingDecidingDlg dlg=new OfferingDecidingDlg();
    dlg.show(theOffering);
    refreshOfferingList();
  }

  void buttonDiscuss_actionPerformed(ActionEvent e)
  {
    OfferingIterator iter=new OfferingIterator(theTrading.theOfferingList );
    while(iter.hasNext() )
    {
      Offering aOffering=(Offering)iter.next();
      aOffering.setDiscussed(true);
    }
    refreshOfferingList();
  }
  private void refreshOfferingList()
  {
    CombOfferingList.removeAllItems() ;
    OfferingIterator SolIter=new OfferingIterator(theTrading.theOfferingList );
    while(SolIter.hasNext() )
    {
      theOffering=(Offering)SolIter.next();
      CombOfferingList.addItem(theOffering);
    }
  }
}
