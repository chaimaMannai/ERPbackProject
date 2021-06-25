package ERP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ERP.model.InvoiceEntiy;

public interface InvoiceRepository extends JpaRepository<InvoiceEntiy, Integer> {

}