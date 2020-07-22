package br.example.graphql.product;

import br.example.graphql.product.domain.Product;
import br.example.graphql.product.exception.ProductNotFoundException;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProductMutation implements GraphQLMutationResolver {

    private ProductRepository productRepository;

    public ProductMutation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product createProduct(Product product) {
        final Product productNew = productRepository.saveAndFlush(product);
        return productNew;
    }

    @Transactional
    public Product updateProduct(final Product product) {
        Product productNew = productRepository
                .findById(product.getId())
                .orElseThrow(() -> new ProductNotFoundException(product.getId()));
        return productRepository.saveAndFlush(product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
