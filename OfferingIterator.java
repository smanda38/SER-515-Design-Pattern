import java.util.Iterator;
	
public class OfferingIterator extends OfferingList {
	@SuppressWarnings("rawtypes")
	@Override
	public boolean HasNext(Iterator iterator) {
		return iterator.hasNext();
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void MoveToHead(Iterator iterator) {
		System.out.println("Head Moved ");
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public String Next(Iterator iterator) {
		if (this.HasNext(iterator)) {
			return (String) iterator.next();
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void Remove(Iterator iterator) {
		if (this.HasNext(iterator)) {
			iterator.next();
		}
	
	}
	
}
