package demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @RequestMapping("/products")
    public List<Product> greeting() {

        List<Product> productList = new ArrayList<>();

        Product product1 = new Product(1, "Wooden chair", "This is a oak hand made chair.");
        productList.add(product1);
        Product product2 = new Product(2, "Suede poof", "Original maroccan poof.");
        productList.add(product2);

        return productList;
    }
}
