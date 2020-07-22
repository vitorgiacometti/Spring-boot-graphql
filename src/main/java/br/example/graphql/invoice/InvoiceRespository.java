package br.example.graphql.invoice;

import br.example.graphql.invoice.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface InvoiceRespository extends JpaRepository<Invoice, Long> {
    Optional<Invoice> findById(Long id);
}
