package ptbs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

abstract public class TradingMenu extends JDialog
{
  abstract void ShowMenu(Trading ass,Person per);
  public TradingMenu()
  {
    setModal(true);
    setSize(575,330);
  }
}
