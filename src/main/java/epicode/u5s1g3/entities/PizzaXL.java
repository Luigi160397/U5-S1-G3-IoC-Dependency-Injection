package epicode.u5s1g3.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaXL extends Decorator {
	public PizzaXL(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getNome() {

		return pizza.getNome() + ", XL";
	}

	@Override
	public double getPrezzo() {

		return pizza.getPrezzo() * 2;
	}

	@Override
	public long getCalorie() {

		return pizza.getCalorie() * 2;
	}

	@Override
	public String getIngredienti() {

		return pizza.getIngredienti();
	}

	@Override
	public String toString() {
		return "Pizza EXTRA LARGE [Nome Pizza= " + getNome() + ", Prezzo= " + getPrezzo() + ", Calorie= " + getCalorie()
				+ ", Ingredienti= " + getIngredienti() + "]";
	}
}
