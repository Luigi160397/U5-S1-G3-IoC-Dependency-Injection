package epicode.u5s1g3.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProsciuttoExtra extends Decorator {
	public ProsciuttoExtra(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getNome() {

		return pizza.getNome() + " + Extra Prosciutto";
	}

	@Override
	public double getPrezzo() {

		return pizza.getPrezzo() + 0.70;
	}

	@Override
	public long getCalorie() {

		return pizza.getCalorie() + 450;
	}

	@Override
	public String getIngredienti() {

		return pizza.getIngredienti() + " , prosciutto extra";
	}

	@Override
	public String toString() {
		return "Pizza con Extra [Nome Pizza= " + getNome() + ", Prezzo= " + getPrezzo() + ", Calorie= " + getCalorie()
				+ ", Ingredienti= " + getIngredienti() + "]";
	}
}
