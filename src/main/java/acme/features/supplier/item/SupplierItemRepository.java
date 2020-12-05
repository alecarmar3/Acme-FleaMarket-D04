
package acme.features.supplier.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface SupplierItemRepository extends AbstractRepository {

	@Query("select i from Item i where i.id = ?1")
	Item findOneById(int id);

	@Query("select i from Item i where i.supplier.id = ?1")
	Collection<Item> findMyItems(int id);

}
