package ERP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ERP.model.ProviderEntity;

public interface ProviderRepository extends JpaRepository<ProviderEntity, Integer> {

}
