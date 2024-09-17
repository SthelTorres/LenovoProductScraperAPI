import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Main class for the Spring Boot application
// Classe principal da aplicação Spring Boot
@SpringBootApplication
public class LenovoLaptopApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(LenovoLaptopApiApplication.class, args);
    }
}

// Class representing a Lenovo laptop
// Classe que representa um laptop Lenovo
class Laptop {
    private String title;
    private double price;
    private String description;
    private String reviews;
    private int rating;

    // Constructor
    // Construtor
    public Laptop(String title, double price, String description, String reviews, int rating) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.reviews = reviews;
        this.rating = rating;
    }

    // Getters
    // Métodos Getters
    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getReviews() {
        return reviews;
    }

    public int getRating() {
        return rating;
    }
}

// Class that performs web scraping using Jsoup
// Classe que realiza o web scraping utilizando Jsoup
class WebScraper {
    public static List<Laptop> getLenovoLaptops() throws IOException {
        // URL of the laptops page
        // URL da página de laptops
        String url = "https://webscraper.io/test-sites/e-commerce/static/computers/laptops";
        
        // Fetching the HTML content from the website
        // Obtendo o conteúdo HTML do site
        Document document = Jsoup.connect(url).get();
        
        // Selecting all laptop items
        // Selecionando todos os itens de laptops
        Elements products = document.select(".thumbnail");
        List<Laptop> lenovoLaptops = new ArrayList<>();
        
        // Extracting information for Lenovo products
        // Extraindo informações dos produtos Lenovo
        for (Element product : products) {
            String title = product.select(".title").text();
            if (title.contains("Lenovo")) {
                double price = Double.parseDouble(product.select(".price").text().replace("$", ""));
                String description = product.select(".description").text();
                String reviews = product.select(".review-count").text();
                int rating = product.select("[data-rating]").size();

                // Adding the Lenovo product to the list
                // Adicionando o produto Lenovo à lista
                lenovoLaptops.add(new Laptop(title, price, description, reviews, rating));
            }
        }

        // Sorts Lenovo laptops from cheapest to most expensive
        // Ordena os laptops Lenovo do mais barato para o mais caro
        lenovoLaptops.sort(Comparator.comparingDouble(Laptop::getPrice));
        return lenovoLaptops;
    }
}

// REST controller to expose Lenovo laptop data via REST API
// Controlador REST para expor os dados dos laptops Lenovo via API REST
@RestController
class LenovoLaptopController {

    @GetMapping("/lenovo-laptops")
    public List<Laptop> getLenovoLaptops() throws IOException {
        return WebScraper.getLenovoLaptops();
    }
}
