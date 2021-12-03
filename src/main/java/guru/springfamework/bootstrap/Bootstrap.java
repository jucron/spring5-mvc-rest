package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        populateCategoryData();
        populateCustomerData();


        System.out.println("Data Loaded in Categories = " + categoryRepository.count()+
                "\n Data Loaded in Customer = " + customerRepository.count());

    }

    private void populateCustomerData() {
        Customer john = new Customer();
        john.setFirstname("John");
        john.setLastname("Master");
        Customer larry = new Customer();
        larry.setFirstname("Larry");
        larry.setLastname("Bettencourt");
        Customer jinx = new Customer();
        jinx.setFirstname("Jinx");
        jinx.setLastname("Underworld");
        Customer vi = new Customer();
        vi.setFirstname("Vi");
        vi.setLastname("Underworld");


        customerRepository.save(john);
        customerRepository.save(larry);
        customerRepository.save(jinx);
        customerRepository.save(vi);

    }

    private void populateCategoryData() {
        Category fruits = new Category();
        fruits.setName("Fruits");

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
    }
}
