package epicode.u5s1g3.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Pizza extends Consumation {
	private String ingredienti;

	public Pizza() {
		super();
		setNome("Margherita");
		setPrezzo(2.50);
		setIngredienti("Pomodoro, mozzarella");
		setCalorie(1000);
	}

	@Override
	public String toString() {
		return "Pizza [Nome Pizza= " + getNome() + ", Prezzo= " + getPrezzo() + ", Calorie= " + getCalorie()
				+ ", Ingredienti= " + getIngredienti() + "]";
	}
}
