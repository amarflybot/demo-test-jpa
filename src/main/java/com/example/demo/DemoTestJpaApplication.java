package com.example.demo;

import org.hibernate.Hibernate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class DemoTestJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTestJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(final PersonRepository personRepository,
										final AddressRepository addressRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(final String... strings) throws Exception {
				Arrays.asList("Chicago","Delhi","NewYork","Kolkata")
						.forEach(name -> {
							addressRepository.save(new Address(name));
						});
                System.out.println("Done with Addresses");
                List<String> address = new ArrayList<>();
                addressRepository.findAll().forEach( address1 -> {
                    address.add(address1.getName());
                });
                AtomicInteger i = new AtomicInteger(0);
                Arrays.asList("Amar","Alka","Vicky")
						.forEach( name -> {
							final Address addressByName = addressRepository.findAddressByName(address.get(i.getAndIncrement()));
                            final Person person = new Person(name,name);
                            personRepository.save(person);

                            person.getAddress().add(addressByName);
                            final Set<Person> personSet = addressByName.getPersonSet();
                            personSet.add(person);

                            personRepository.save(person);
                            addressRepository.save(addressByName);
						});
                System.out.println("Done with Persons");

                final Person person = personRepository.findOne(1l);
                final Address kolkata = addressRepository.findAddressByName("Kolkata");
                person.getAddress().add(kolkata);
                personRepository.save(person);

                personRepository.save(new Person("Deepak","Kumar"));
                personRepository.save(new Person("Deepak","Singh"));
                personRepository.save(new Person("Amar", "Alka"));

                AtomicInteger integer = new AtomicInteger(1000);
                personRepository.findAll()
                        .forEach( person1 -> {
                            final int salary = integer.get();
                            person1.setSalary(salary);
                            integer.set(salary + 1000);
                            personRepository.save(person1);
                        });



			}
		};
	}
}
