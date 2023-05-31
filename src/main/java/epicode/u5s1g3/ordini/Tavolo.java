package epicode.u5s1g3.ordini;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class Tavolo {
	private int numero;
	private int nCopertiMax;
	private StatoTavolo stato;

}
