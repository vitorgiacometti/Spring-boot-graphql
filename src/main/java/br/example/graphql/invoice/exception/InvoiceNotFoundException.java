package br.example.graphql.invoice.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class InvoiceNotFoundException extends RuntimeException implements GraphQLError {
    public InvoiceNotFoundException(long id) {
    }

    private Long invoiceId;

    public InvoiceNotFoundException(Long id) {
        this.invoiceId = invoiceId;
    }

    @Override
    public String getMessage() {
        return "Invoice Id " + invoiceId + " could not be found";
    }

    @Override
    @JsonIgnore
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.ValidationError;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return Collections.singletonMap("invoiceId", invoiceId);
    }

}
