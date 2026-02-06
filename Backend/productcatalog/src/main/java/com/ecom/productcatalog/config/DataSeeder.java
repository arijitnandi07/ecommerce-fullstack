package com.ecom.productcatalog.config;

import com.ecom.productcatalog.Repository.CategoryRepository;
import com.ecom.productcatalog.Repository.ProductRepository;
import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.imageio.spi.ServiceRegistry;
import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository,
                      CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }



    @Override
    public void run(String... args) throws Exception {
//clear all existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        //create catagories
        Category electronics=new Category();
        electronics.setName("Electronics");

        Category clothing=new Category();
        clothing.setName("clothing");

        Category home=new Category();
        home.setName("Home & kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics,home,clothing));

   //create products
        Product phone=new Product();
        phone.setName("SmartPhone");
        phone.setDescription("Latest model smartPhone");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(7999.00);
        phone.setCategory(electronics);

        Product laptop=new Product();
        laptop.setName("Laptop");
        laptop.setDescription("Latest model laptop");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(9999.00);
        laptop.setCategory(electronics);

        Product jacket=new Product();
        jacket.setName("winter jacket");
        jacket.setDescription("war jacket for winter");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice(99.00);
        jacket.setCategory(clothing);

        Product blender=new Product();
        blender.setName("Blender");
        blender.setDescription("high speed blender");
        blender.setImageUrl("https://placehold.co/600x400");
        blender.setPrice(199.00);
        blender.setCategory(home);

productRepository.saveAll(Arrays.asList(phone,laptop,blender,jacket));
    }
}
