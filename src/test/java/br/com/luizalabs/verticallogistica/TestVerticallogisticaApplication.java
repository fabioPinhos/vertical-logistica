package br.com.luizalabs.verticallogistica;

import org.springframework.boot.SpringApplication;

public class TestVerticallogisticaApplication {

	public static void main(String[] args) {
		SpringApplication.from(VerticallogisticaApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
