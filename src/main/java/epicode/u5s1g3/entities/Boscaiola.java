package epicode.u5s1g3.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Boscaiola extends Decorator {

	public Boscaiola(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getNome() {

		return "Boscaiola";
	}

	@Override
	public double getPrezzo() {

		return pizza.getPrezzo() + 1.0;
	}

	@Override
	public long getCalorie() {

		return pizza.getCalorie() + 500;
	}

	@Override
	public String getIngredienti() {

		return pizza.getIngredienti() + ", funghi e salsiccia";
	}

	@Override
	public String toString() {
		return "Pizza con Extra [Nome Pizza= " + getNome() + ", Prezzo= " + getPrezzo() + ", Calorie= " + getCalorie()
				+ ", Ingredienti= " + getIngredienti() + "]";
	}

}
