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
		PizzaXL prosciuttoXL = (PizzaXL) ctx.getBean("prosciuttoXL");
		ExtraSalame diavola = (ExtraSalame) ctx.getBean("extraSalame");
		CocaCola cocaCola = (CocaCola) ctx.getBean("cocaCola");
		Cappellino cappellino = (Cappellino) ctx.getBean("cappello");

		Tavolo tavolo2 = new Tavolo(2, 5, StatoTavolo.LIBERO);

		List<Prodotto> listaOrd1 = new ArrayList<>(Arrays.asList(diavola, cocaCola));

		Ordine ordine2 = new Ordine(1, tavolo2, listaOrd1, StatoOrdine.IN_CORSO, 2,
				LocalDateTime.of(2023, 06, 30, 11, 0), costoCoperto);

		Ordine ordine1 = (Ordine) ctx.getBean("getOrdine");

		log.info("-------------------- Menù --------------------");
		log.info("");
		log.info("-------------------- Pizze --------------------");
		log.info(prosciuttoXL.toString());
		log.info(diavola.toString());
		log.info(margherita.toString());
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
		ctx.close();

	}
}
