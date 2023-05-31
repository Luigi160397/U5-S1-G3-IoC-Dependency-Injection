package epicode.u5s1g3.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Consumation extends Prodotto {
	private long calorie;
}
