
package acme.features.authenticated.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedItemRepository extends AbstractRepository {

	@Query("select i from Item i where i.id = ?1")
	Item findOneById(int id);

	@Query("select i from Item i")
	Collection<Item> findAllItem();

}
