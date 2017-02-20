package br.com.fisiofit.vendas.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.com.fisiofit.vendas.spring.entity.Person;
import br.com.fisiofit.vendas.spring.service.interfaces.IPersonService;

@SpringBootApplication
@ComponentScan({ "br.com.fisiofit.vendas.spring.service", "br.com.fisiofit.vendas.spring.dao",
		"br.com.fisiofit.vendas.spring.config" })
@EntityScan({ "br.com.fisiofit.vendas.spring.entity" })
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Component
	public class PersonTest implements ApplicationRunner {

		private IPersonService service;

		public PersonTest(IPersonService personService) {
			this.service = personService;
		}

		@Override
		public void run(ApplicationArguments arg0) throws Exception {
			// TODO Auto-generated method stub
			Person person1 = new Person("jefferson pereira", "jp.nascimento@gmail.com");

			service.save(person1);
		}

	}
}
