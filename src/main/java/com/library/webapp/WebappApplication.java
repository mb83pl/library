package com.library.webapp;

import com.library.webapp.model.Book;
import com.library.webapp.model.Person;
import com.library.webapp.model.Rental;
import com.library.webapp.repository.BookRepository;
import com.library.webapp.repository.PersonRepository;
import com.library.webapp.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class WebappApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private RentalRepository rentalRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Book book1 = new Book("Duchy", "Książka o duchach", "1234-5678");
		Book book2 = new Book("Kosmici", "Książka o kosmitach", "2345-6789");

		Person person1 = new Person("Stanisław", "Kowalski", "Międzyrzecze Górne", LocalDateTime.of(2021,10,21,10,20,00));
		Person person2 = new Person("Aleksandra", "Nowicka", "Zalesie", LocalDateTime.of(2021,10,22,15,22,45));

		Rental rental1 = new Rental(book1, person1, LocalDateTime.now());
		Rental rental2 = new Rental(book2, person2, LocalDateTime.now());

		bookRepository.saveAll(Arrays.asList(book1, book2));
		personRepository.saveAll(Arrays.asList(person1, person2));
		rentalRepository.saveAll(Arrays.asList(rental1, rental2));
	}


}
