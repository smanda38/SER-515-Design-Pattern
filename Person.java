public abstract class Person {
	protected static ProductMenu theProductMenu;

	public abstract void ShowMenu();

	public abstract ProductMenu CreateProductMenu();

	@SuppressWarnings("static-access")
	Person(ProductMenu theProductMenu) {
		this.theProductMenu = theProductMenu;
	}

	public void showAddButton() {
		theProductMenu.showAddButton();
	}

	public void showViewButton() {

		theProductMenu.showViewButton();
	}

	public void showRadioButton() {
		theProductMenu.showRadioButton();
	}

	public void showMenu() {
		theProductMenu.showMenu();
	}

	public void showLabels() {
		theProductMenu.showLabels();
	}
}
