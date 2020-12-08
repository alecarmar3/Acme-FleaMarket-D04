
package acme.features.buyer.acmeItemRequest;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.AcmeItemRequest;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface BuyerAcmeItemRequestRepository extends AbstractRepository {

	@Query("select air from AcmeItemRequest air where air.id = ?1")
	AcmeItemRequest findOneById(int id);

	@Query("select air from AcmeItemRequest air where air.buyer.id = ?1")
	Collection<AcmeItemRequest> findMyAcmeItemRequests(int id);

}
