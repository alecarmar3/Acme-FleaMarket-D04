
package acme.features.authenticated.specificationSheet;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.SpecificationSheet;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedSpecificationSheetRepository extends AbstractRepository {

	@Query("select ss from SpecificationSheet ss where ss.id = ?1")
	SpecificationSheet findOneById(int id);

	@Query("select ss from SpecificationSheet ss where ss.acmeItem.id = ?1")
	Collection<SpecificationSheet> findSpecificationSheetsByAcmeItem(int acmeItemId);

}
