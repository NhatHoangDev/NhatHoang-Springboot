package com.example.demo;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@Component
class BookingCommandLineRunner implements CommandLineRunner {

	@Autowired
	BookingReposirory bookingReposirory;

	@Override
	public void run(String... args) throws Exception {
		Booking b1 = new Booking("a");
		Booking b3 = new Booking("c");
		Booking b2 = new Booking("b");
		Booking b4 = new Booking("d");
		bookingReposirory.save(b1);
		bookingReposirory.save(b4);
		bookingReposirory.save(b2);
		bookingReposirory.save(b3);

		for (Booking b : this.bookingReposirory.findAll()) {
			System.out.println(b.toString());
		}

	}

}

@RestController
class BookingRestController{
	
	@Autowired
	BookingReposirory bookingReposirory;
	
	@RequestMapping("/bookings")
	Collection<Booking> booking(){
		return this.bookingReposirory.findAll();
	}
}

@Repository
interface BookingReposirory extends JpaRepository<Booking, Long> {

	Collection<Booking> findByBookingName(String bookingName);
}

@Entity
class Booking {

	@Id
	@GeneratedValue
	private Long id;
	private String bookingName;

	public Booking() {
	}

	public Booking(String bookingName) {
		super();
		this.bookingName = bookingName;
	}

	public String getBookingName() {
		return bookingName;
	}

	public void setBookingName(String bookingName) {
		this.bookingName = bookingName;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookingName=" + bookingName + "]";
	}
}