package epicode.u5s1g3.ordini;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tavolo {
	private int numero;
	private int nCopertiMax;
	private StatoTavolo stato;

	@Override
	public String toString() {
		return "numero tavolo=" + numero + ", numero massimo coperti=" + nCopertiMax + ", stato tavolo=" + stato + "]";
	}

}
