package epicode.u5s1g3.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cappellino extends Prodotto {

	public Cappellino() {
		super();
		setNome("Cappellino");
		setPrezzo(10.0);
	}

	@Override
	public String toString() {
		return "Accessorio [Nome=" + getNome() + ", Prezzo=" + getPrezzo() + "]";
	}

}
