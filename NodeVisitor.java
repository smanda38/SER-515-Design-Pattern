 public abstract class NodeVisitor {

	public abstract void visitFacade(PtbsFacade PF);

	public abstract Reminder visitTrading(Trading T);

	public abstract Reminder visitProduct(ProductList PL);

}
