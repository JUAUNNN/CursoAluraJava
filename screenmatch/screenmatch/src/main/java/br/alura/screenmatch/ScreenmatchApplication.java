package br.alura.screenmatch;

import br.alura.screenmatch.model.DadosSerie;
import br.alura.screenmatch.service.ConsumoAPI;
import br.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumo = new ConsumoAPI();
		consumo.buscaDados();
		var converteDados = new ConverteDados();
		consumo.dadosConvert();
		consumo.teste();
	}
}
