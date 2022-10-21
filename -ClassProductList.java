import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class ProductList extends Reminder {

	ArrayList<String> sol = new ArrayList<>();

	ProductList() {
		sol.add("Product for tutu");
		sol.add("Product for mimi");
		sol.add("Product for pepe");
	}


	public Iterator createIterator() {
		return this.sol.iterator();
	}

	public Reminder accept(NodeVisitor nodeVisitor) {
		System.out.println("Product List Reminder ...");
		return nodeVisitor.visitProduct(this);
	}

}
