package ERP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ERP.model.BuyLineEntity;

public interface LineBuyRepository extends JpaRepository<BuyLineEntity, Integer> {
	

}
