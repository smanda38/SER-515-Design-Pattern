public class ProduceProductMenu extends ProductMenu {

	@Override
	public void ShowAddButton() {
		System.out.println();
	}

	@Override
	public void ShowMenu() {
		System.out.println();
	}

	@Override
	public void ShowViewButton() {
		System.out.println();

	}

	@Override
	public void ShowRadioButton() {
		System.out.println();

	}

	@Override
	public void showComboxes() {
		System.out.println();

	}

	@Override
	public void ShowLabels() {
		System.out.println();

	}

	public void selectProduct(int USerType) {
		System.out.println("Produce Product Selected ...\n Bridge Pattern for connection used ");
		Person person;
		if (UserType == 0) {
			person = PersonFactory.createObject("Seller");

		} else
		{
			person = PersonFactory.createObject("Buyer");

		}
		person.ShowMenu();
	}
}
