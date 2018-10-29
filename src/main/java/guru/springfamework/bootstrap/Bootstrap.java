package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 9/24/17.
 */
@Component
public class Bootstrap implements CommandLineRunner{

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //loadCategroyRepository();
        //loadCustomerRepository();

    }

    private void loadCustomerRepository() {

        Customer john = new Customer();
        //john.setId(1L);
        john.setFirstname("John");
        john.setLastname("Martinez");


        Customer mercedes = new Customer();
        //mercedes.setId(2L);
        mercedes.setFirstname("Mercedes");
        mercedes.setLastname("Martinez");

        Customer adrian = new Customer();
        //adrian.setId(3L);
        adrian.setFirstname("Adrian");
        adrian.setLastname("Zapater");

        customerRepository.save(john);
        customerRepository.save(mercedes);
        customerRepository.save(adrian);

        System.out.println("Customer Data Loaded = " + customerRepository.count());

    }

    private void loadCategroyRepository() {
        Category fruits = new Category();
        fruits.setName("Fruits");
        fruits.getId();

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Category Data Loaded = " + categoryRepository.count());
    }
}
