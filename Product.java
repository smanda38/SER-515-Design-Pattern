package hacs;

import java.util.*;

public class Product {
  String ProductName;
  public ArrayList<trading> tradingList=new ArrayList<Trading>();
  int NumOfAss;
  int ProductLevel;


  public Product(String strProduct, int theLevel) {
    this.ProductName = strProduct;

   //0 HighLeve presentation    1  Meat Experiment
    this.ProductLevel = theLevel;
   // this.AssList = NULL;
    this.NumOfAss = 0;
  }
  
  public void Addtrading(trading newAss)
  {
    tradingList.add(newAss);
  }
  
  public String toString()
  {
    return ProductName;
  }
  
  void accept(NodeVisitor visitor)
  {
    visitor.visitProduct(this);
  }

}
