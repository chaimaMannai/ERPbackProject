package ERP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ERP.model.PurchaseOrderEntity;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrderEntity, Integer> {

}
