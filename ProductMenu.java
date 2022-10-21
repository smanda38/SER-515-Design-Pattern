public abstract class ProductMenu {
	public abstract void ShowMenu();

	public abstract void ShowAddButtons();

	public abstract void ShowViewButtons();

	public abstract void ShowRadios();

	public abstract void showComboxes();

	public abstract void ShowLabels();

	public abstract void selectProduct(int UserType);

	public void createProductList() {
		System.out.println("Product List created ...");
	}

	public void AttachProductToUser() {
		System.out.println("User Attached .... ");
	}

	public void ProductOperation() {
		System.out.println("Operation performed on the Product...");
	}

}
