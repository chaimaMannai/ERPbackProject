package ERP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ERP.model.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {

}
