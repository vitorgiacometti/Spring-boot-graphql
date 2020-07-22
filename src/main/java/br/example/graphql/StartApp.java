package br.example.graphql;


import br.example.graphql.invoice.InvoiceRespository;
import br.example.graphql.invoice.domain.Invoice;
import br.example.graphql.product.ProductRepository;
import br.example.graphql.product.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class StartApp implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(StartApp.class);


    private InvoiceRespository invoiceRespository;
    private ProductRepository productRepository;

    public StartApp(InvoiceRespository invoiceRespository) {
        this.invoiceRespository = invoiceRespository;
    }

    @Override
    @Transactional
    public void run(String ... strings){
        logger.info("------------------------");

        Invoice invoice = new Invoice("Jose lopes", 23L, 02L);
        List<Product> products = new ArrayList<>();
        //products.add(productRepository.saveAndFlush(new Product("Caixa de bombom", "Caixa de bombom 200 Grms", 200L)));

        //products.add(productRepository.saveAndFlush(new Product("Biscoito", "Biscoito de polvilho", 40L)));
        //products.add(productRepository.saveAndFlush(new Product("Pão", "Pães frances", 10L)));
        invoice.setProducts(products);
        logger.info("Save the invoice" + invoice.getCustomer());
        invoiceRespository.save(invoice);

    }


}
