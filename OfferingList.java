import java.util.ArrayList;
import java.util.Iterator;
public class OfferingList {

	ArrayList<String> sol = new ArrayList<>();

	OfferingList() {
		sol.add("Offering for tutu");
		sol.add("Offering for mimi");
		sol.add("Offering for pepe");

	}

	@SuppressWarnings("rawtypes")
	public Iterator createIterator() {
		return this.sol.iterator();
	}
}
