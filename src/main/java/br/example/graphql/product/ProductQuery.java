package br.example.graphql.product;

import br.example.graphql.invoice.InvoiceRespository;
import br.example.graphql.invoice.domain.Invoice;
import br.example.graphql.product.domain.Product;
import br.example.graphql.product.exception.ProductNotFoundException;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ProductQuery implements GraphQLQueryResolver {

    private ProductRepository productRepository;
    private InvoiceRespository invoiceRespository;

    public ProductQuery(ProductRepository productRepository, InvoiceRespository invoiceRespository) {
        this.productRepository = productRepository;
        this.invoiceRespository = invoiceRespository;
    }

    public List<Product> getProducts(){return productRepository.findAll();}

    public List<Product> getProductByInvoice(final Long Id){

        Optional<Invoice> invoice = invoiceRespository.findById(Id);
        if(invoice.isPresent()) {
            return invoice.get().getProducts();
        }
        else {
            return new ArrayList<>();
        }

    }

    public Product getProduct(final Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }



}
