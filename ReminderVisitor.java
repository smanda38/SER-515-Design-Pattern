public class ReminderVisitor extends NodeVisitor {
	String m_Reminder;

	@Override
	public void visitFAcade(PtbsFacade PF) {
		System.out.println("visiting Facade ....");

	}

	@Override
	public Reminder visitTrading(Trading T) {
		System.out.println("visiting Trading ....");
		return A;
	}

	@Override
	public Reminder visitProduct(ProductList PL) {
		System.out.println("visiting Product ....");
		return CL;

	}
}
