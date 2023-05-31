package epicode.u5s1g3;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import epicode.u5s1g3.entities.CocaCola;
import epicode.u5s1g3.entities.Pizza;
import epicode.u5s1g3.entities.Prodotto;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class U5S1G3ApplicationTests {

	@Test
	void contextLoads() {
	}

	@BeforeAll
	static void beforeAll() {
		log.info("Inizio test");
	}

	@Test
	void testTotOrdine() {
		List<Prodotto> prodotti = new ArrayList<>();
		prodotti.add(new Pizza());
		prodotti.add(new CocaCola());

		double totale = totOrdine(prodotti);
		double totaleAtteso = 4.0;
		Assertions.assertEquals(totaleAtteso, totale, 0.001);
	}

	public double totOrdine(List<Prodotto> p) {
		double somma = p.stream().mapToDouble(Prodotto::getPrezzo).sum();
		return somma;
	}

	@AfterAll
	static void afterAll() {
		log.info("Fine test!");
	}
}
