package epicode.u5s1g3.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CocaCola extends Consumation {

	public CocaCola() {
		super();
		setNome("Coca-Cola");
		setPrezzo(1.50);
		setCalorie(1500);
	}

	@Override
	public String toString() {
		return "Drink [Nome=" + getNome() + ", calorie=" + getCalorie() + ", Prezzo=" + getPrezzo() + "]";
	}

}
