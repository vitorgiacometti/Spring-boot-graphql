package br.example.graphql.invoice;

import br.example.graphql.invoice.domain.Invoice;
import br.example.graphql.invoice.exception.InvoiceNotFoundException;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceQuery implements GraphQLQueryResolver {

    private InvoiceRespository invoiceRespository;

    public InvoiceQuery(InvoiceRespository invoiceRespository) {
        this.invoiceRespository = invoiceRespository;
    }

    public List<Invoice> getInvoices(){
        return invoiceRespository.findAll();
    }

    public Invoice getInvoice(Long id){
        return invoiceRespository.findById(id)
                .orElseThrow(() -> new InvoiceNotFoundException(id));
    }

}
