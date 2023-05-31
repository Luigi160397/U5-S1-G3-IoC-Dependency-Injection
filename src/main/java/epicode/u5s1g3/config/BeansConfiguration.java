package epicode.u5s1g3.config;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import epicode.u5s1g3.entities.Boscaiola;
import epicode.u5s1g3.entities.Cappellino;
import epicode.u5s1g3.entities.CocaCola;
import epicode.u5s1g3.entities.ExtraSalame;
import epicode.u5s1g3.entities.Pizza;
import epicode.u5s1g3.entities.PizzaXL;
import epicode.u5s1g3.entities.Prodotto;
import epicode.u5s1g3.entities.ProsciuttoExtra;
import epicode.u5s1g3.ordini.Ordine;
import epicode.u5s1g3.ordini.StatoOrdine;
import epicode.u5s1g3.ordini.StatoTavolo;
import epicode.u5s1g3.ordini.Tavolo;

@Configuration
@PropertySource("classpath:application.properties")
public class BeansConfiguration {
	@Value("${application.costoCoperto}")
	public double costoCoperto;

	@Bean
	@Scope("singleton")
	Pizza margherita() {
		return new Pizza();
	}

	@Bean
	@Scope("singleton")
	Boscaiola boscaiola() {
		return new Boscaiola(new Pizza());
	}

	@Bean
	@Scope("singleton")
	ProsciuttoExtra prosciutto() {
		return new ProsciuttoExtra(new Pizza());
	}

	@Bean
	@Scope("singleton")
	PizzaXL prosciuttoXL() {
		return new PizzaXL(new ProsciuttoExtra(new Pizza()));
	}

	@Bean
	@Scope("singleton")
	ExtraSalame extraSalame() {
		return new ExtraSalame(new Pizza());
	}

	@Bean
	@Scope("singleton")
	CocaCola cocaCola() {
		return new CocaCola();
	}

	@Bean
	@Scope("singleton")
	Cappellino cappello() {
		return new Cappellino();
	}

	@Bean
	@Scope("singleton")
	Tavolo getTavolo() {
		return new Tavolo(1, 4, StatoTavolo.OCCUPATO);
	}

	@Bean
	@Scope("singleton")
	List<Prodotto> getComanda() {
		List<Prodotto> comanda = new ArrayList<>();
		comanda.add(prosciuttoXL());
		comanda.add(cappello());
		comanda.add(cocaCola());
		return comanda;
	}

	@Bean
	@Scope("singleton")
	Ordine getOrdine() {

		return new Ordine(3, getTavolo(), getComanda(), StatoOrdine.PRONTO, 2, LocalDateTime.of(2023, 05, 30, 12, 30),
				costoCoperto);
	}

	@Bean
	@Scope("prototype")
	Tavolo tavoloPersonalizzabile() {
		return new Tavolo();
	}

	@Bean
	@Scope("prototype")
	List<Prodotto> comandaPersonalizzabile() {
		List<Prodotto> comanda = new ArrayList<>();
		return comanda;
	}

	@Bean
	@Scope("prototype")
	Ordine ordinePersonalizzabile() {
		return new Ordine();
	}

}
