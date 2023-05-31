package epicode.u5s1g3.ordini;

import java.time.LocalDateTime;
import java.util.List;

import epicode.u5s1g3.entities.Prodotto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Ordine {
	private int numeroOrdine;
	private Tavolo tavolo;
	private List<Prodotto> comanda;
	private StatoOrdine statoOrdine;
	private int numeroCoperti;
	private LocalDateTime oraAcquisizione;
	private double importoTotale;
//	@Value("${application.costoCoperto}")
	private double costoCoperto;

	public Ordine(int numeroOrdine, Tavolo tavolo, List<Prodotto> comanda, StatoOrdine statoOrdine, int numeroCoperti,
			LocalDateTime oraAcquisizione, double costoCoperto) {
		super();
		this.numeroOrdine = numeroOrdine;
		this.tavolo = tavolo;
		this.comanda = comanda;
		this.statoOrdine = statoOrdine;
		this.numeroCoperti = numeroCoperti;
		this.oraAcquisizione = oraAcquisizione;
		this.costoCoperto = costoCoperto;
		this.importoTotale = totOrdine(comanda, costoCoperto, numeroCoperti);
	}

	public double totOrdine(List<Prodotto> prodotti, double costoCoperto, int nCoperti) {
		double somma = prodotti.stream().mapToDouble(Prodotto::getPrezzo).sum();
		return somma + (costoCoperto * nCoperti);
	}

	@Override
	public String toString() {
		return "\n Ordine [numero ordine=" + numeroOrdine + ", tavolo=" + tavolo + ", stato ordine=" + statoOrdine
				+ ", numero coperti=" + numeroCoperti + ", ora acquisizione=" + oraAcquisizione + ", importo totale="
				+ importoTotale + ", costo singolo coperto=" + costoCoperto + "\n comanda=" + comanda + "]";
	}

}
