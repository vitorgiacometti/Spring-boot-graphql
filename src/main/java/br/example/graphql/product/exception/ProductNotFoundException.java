package br.example.graphql.product.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ProductNotFoundException extends RuntimeException implements GraphQLError {
    private Long productId;

    public ProductNotFoundException(Long productId) {
        this.productId = productId;
    }

    @Override
    public String getMessage() {
        return "Product  " + productId + " could not be found";
    }

    @Override
    @JsonIgnore
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @Override
    public Map<String, Object> getExtensions() {
        return Collections.singletonMap("Product", productId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.ValidationError;
   }
}