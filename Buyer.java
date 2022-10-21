public class Buyer extends Person {
	Buyer() {
		super(theProductMenu);
	}

	Buyer(ProductMenu theProductMenu) {
		super(theProductMenu);
	}

	@Override
	public void ShowMenu() {
		System.out.println("Buyer Menu items....");

	}

	@Override
	public ProductMenu CreateProductMenu() {
		String test = "Meat";
		if (test.equalsIgnoreCase("Meat")) {
			return new MeatProductMenu();
		} else {
			return new ProduceProductMenu();
		}
	}

}
