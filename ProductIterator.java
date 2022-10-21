import java.util.Iterator;

public class ProductIterator extends ClassProductList {
	@SuppressWarnings("rawtypes")
	public boolean HasNext(Iterator iterator) {
		return iterator.hasNext();
	}

	@SuppressWarnings("rawtypes")
	public void MoveToHead(Iterator iterator) {
		System.out.println("Head Moved..");
	}

	@SuppressWarnings("rawtypes")
	public String Next(Iterator iterator) {
		if (this.HasNext(iterator)) {
			return (String) iterator.next();
		} else {
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	public void Remove(Iterator iterator) {
		if (this.HasNext(iterator)) {
			iterator.next();
		}

	}

}
