public class  Trading extends Reminder{

	public Reminder accept(NodeVisitor visitor) {
		System.out.println("Trading Reminder ...");
		return nodeVisitor.visitTrading(this);

	}
}
