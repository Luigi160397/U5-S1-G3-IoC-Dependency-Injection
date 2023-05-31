package epicode.u5s1g3.entities;

public class ExtraSalame extends Decorator {
	public ExtraSalame(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getNome() {

		return pizza.getNome() + " + Extra Salame";
	}

	@Override
	public double getPrezzo() {

		return pizza.getPrezzo() + 0.30;
	}

	@Override
	public long getCalorie() {

		return pizza.getCalorie() + 200;
	}

	@Override
	public String getIngredienti() {

		return pizza.getIngredienti() + " , salame extra";
	}

	@Override
	public String toString() {
		return "Pizza con Extra [Nome Pizza= " + getNome() + ", Prezzo= " + getPrezzo() + ", Calorie= " + getCalorie()
				+ ", Ingredienti= " + getIngredienti() + "]";
	}
}
