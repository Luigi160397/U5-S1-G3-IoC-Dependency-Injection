package epicode.u5s1g3.config;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

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
	Pizza margherita() {
		return new Pizza();
	}

	@Bean
	ProsciuttoExtra prosciutto() {
		return new ProsciuttoExtra(new Pizza());
	}

	@Bean
	PizzaXL prosciuttoXL() {
		return new PizzaXL(new ProsciuttoExtra(new Pizza()));
	}

	@Bean
	ExtraSalame extraSalame() {
		return new ExtraSalame(new Pizza());
	}

	@Bean
	CocaCola cocaCola() {
		return new CocaCola();
	}

	@Bean
	Cappellino cappello() {
		return new Cappellino();
	}

	@Bean
	@Scope("prototype")
	Tavolo getTavolo() {
		return new Tavolo(1, 4, StatoTavolo.OCCUPATO);
	}

	@Bean
	List<Prodotto> getComanda() {
		List<Prodotto> comanda = new ArrayList<>();
		comanda.add(prosciuttoXL());
		comanda.add(cappello());
		comanda.add(cocaCola());
		return comanda;
	}

	@Bean
	Ordine getOrdine() {

		return new Ordine(3, getTavolo(), getComanda(), StatoOrdine.PRONTO, 2, LocalDateTime.of(2023, 05, 30, 12, 30),
				costoCoperto);
	}

}
