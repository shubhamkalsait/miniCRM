package com.jgosh;

import com.jgosh.domain.Address;
import com.jgosh.domain.Client;
import com.jgosh.domain.PhoneNumber;
import com.jgosh.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class MiniCrmApplication {

    private static final Logger log = LoggerFactory.getLogger(MiniCrmApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MiniCrmApplication.class, args);
    }

    @Bean
    public CommandLineRunner addClients(ClientRepository repository) {
        return (args) -> {
            log.info("Adding new client");

            Client bob = new Client("Bob", "Builder", "bob.builder@gmail.com");
            Address address1 = new Address(bob, Address.AddressType.CORRESPONDENCE, "Street 1", "apartment 16", "Warsaw", "03-144");
            Address address2 = new Address(bob, Address.AddressType.REGISTERED, "Street 2", "apartment 3a", "Krakow", "01-123");
            PhoneNumber phoneNumber1 = new PhoneNumber(bob, PhoneNumber.PhoneNumberType.WORK, "500-123-456");
            PhoneNumber phoneNumber2 = new PhoneNumber(bob, PhoneNumber.PhoneNumberType.MOBILE, "505-666-777");
            PhoneNumber phoneNumber3 = new PhoneNumber(bob, PhoneNumber.PhoneNumberType.LANDLINE, "(22) 123-45-67");

            bob.setAddresses(new HashSet<Address>() {
                {
                    add(address1);
                    add(address2);
                }
            });
            bob.setPhoneNumbers(new HashSet<PhoneNumber>() {
                {
                    add(phoneNumber1);
                    add(phoneNumber2);
                    add(phoneNumber3);
                }
            });

            repository.save(bob);
            repository.save(new Client("Luke", "Skywalker", "lskywalker@deathstar.com"));

            List<Client> clients = (List<Client>) repository.findAll();

            for (Client cl : clients) {
                System.out.println(cl.getFirstName());
            }
        };
    }
}
