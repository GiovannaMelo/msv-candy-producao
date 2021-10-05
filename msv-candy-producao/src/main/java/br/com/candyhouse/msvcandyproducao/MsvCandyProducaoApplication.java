package br.com.candyhouse.msvcandyproducao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsvCandyProducaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvCandyProducaoApplication.class, args);
	}

}
