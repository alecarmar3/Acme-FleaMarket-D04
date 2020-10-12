
package acme.features.supplier.itemRequest;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.ItemRequest;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface SupplierItemRequestRepository extends AbstractRepository {

	@Query("select ir from ItemRequest ir where ir.id = ?1")
	ItemRequest findOneById(int id);

	@Query("select ir from ItemRequest ir where ir.item.supplier.id = ?1")
	Collection<ItemRequest> findItemRequestsToMine(int id);

}
