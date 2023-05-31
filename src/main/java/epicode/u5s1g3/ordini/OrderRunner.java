package epicode.u5s1g3.ordini;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import epicode.u5s1g3.config.BeansConfiguration;
import epicode.u5s1g3.entities.Boscaiola;
import epicode.u5s1g3.entities.Cappellino;
import epicode.u5s1g3.entities.CocaCola;
import epicode.u5s1g3.entities.ExtraSalame;
import epicode.u5s1g3.entities.Pizza;
import epicode.u5s1g3.entities.PizzaXL;
import epicode.u5s1g3.entities.Prodotto;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderRunner implements CommandLineRunner {

	@Value("${application.costoCoperto}")
	public double costoCoperto;

	@Override
	public void run(String... args) throws Exception {
		menuPizze(costoCoperto);
	}

	public static void menuPizze(double costoCoperto) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeansConfiguration.class);
		Pizza margherita = (Pizza) ctx.getBean("margherita");
		Boscaiola boscaiola = (Boscaiola) ctx.getBean("boscaiola");
		PizzaXL prosciuttoXL = (PizzaXL) ctx.getBean("prosciuttoXL");
		ExtraSalame diavola = (ExtraSalame) ctx.getBean("extraSalame");
		CocaCola cocaCola = (CocaCola) ctx.getBean("cocaCola");
		Cappellino cappellino = (Cappellino) ctx.getBean("cappello");

		Tavolo tavolo2 = new Tavolo(2, 5, StatoTavolo.LIBERO);

		List<Prodotto> listaOrd1 = new ArrayList<>(Arrays.asList(boscaiola, cocaCola));

		Ordine ordine2 = new Ordine(1, tavolo2, listaOrd1, StatoOrdine.IN_CORSO, 1,
				LocalDateTime.of(2023, 06, 30, 11, 0), costoCoperto);

		Ordine ordine1 = (Ordine) ctx.getBean("getOrdine");

		// Ordine personalizzato;

		Tavolo tavolo3 = (Tavolo) ctx.getBean("tavoloPersonalizzabile");
		tavolo3.setNumero(3);
		tavolo3.setNCopertiMax(2);
		tavolo3.setStato(StatoTavolo.LIBERO);

		List<Prodotto> comanda3 = (List<Prodotto>) ctx.getBean("comandaPersonalizzabile");
		comanda3.add(cappellino);

		Ordine ordine3 = (Ordine) ctx.getBean("ordinePersonalizzabile");
		ordine3.setNumeroOrdine(7);
		ordine3.setTavolo(tavolo3);
		ordine3.setStatoOrdine(StatoOrdine.PRONTO);
		ordine3.setNumeroCoperti(1);
		ordine3.setOraAcquisizione(LocalDateTime.of(2023, 06, 30, 21, 0));
		ordine3.setComanda(comanda3);
		ordine3.setCostoCoperto(costoCoperto);
		ordine3.setImportoTotale(ordine3.totOrdine(comanda3, costoCoperto, 1));

		log.info("-------------------- Menù --------------------");
		log.info("");
		log.info("-------------------- Pizze --------------------");
		log.info(prosciuttoXL.toString());
		log.info(diavola.toString());
		log.info(margherita.toString());
		log.info(boscaiola.toString());
		log.info("-------------------- Drinks --------------------");
		log.info(cocaCola.toString());
		log.info("-------------------- Accessori --------------------");
		log.info(cappellino.toString());
		log.info("");
		log.info("-------------------- Ordine 1 --------------------");
		log.info(ordine1.toString());
		log.info("");
		log.info("-------------------- Ordine 2 --------------------");
		log.info(ordine2.toString());
		log.info("");
		log.info("-------------------- Ordine 3 --------------------");
		log.info(ordine3.toString());
		ctx.close();

	}
}
