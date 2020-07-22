package br.example.graphql.invoice;

import br.example.graphql.invoice.domain.Invoice;
import br.example.graphql.invoice.exception.InvoiceNotFoundException;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class InvoiceMutation implements GraphQLMutationResolver {

    private InvoiceRespository invoiceRespository;

    public InvoiceMutation(InvoiceRespository invoiceRespository) {
        this.invoiceRespository = invoiceRespository;
    }

    @Transactional
    public Invoice createInvoice(Invoice input) {
        final Invoice invoice = invoiceRespository.saveAndFlush(input);
        return invoice;
    }

    @Transactional
    public Invoice updateInvoice(final Invoice input) {
        invoiceRespository
                .findById(input.getId())
                .orElseThrow(() -> new InvoiceNotFoundException(input.getId()));
        return invoiceRespository.saveAndFlush(input);
    }


    @Transactional
    public void deleteInvoice(Long id) {
        invoiceRespository.deleteById(id);
    }



}
