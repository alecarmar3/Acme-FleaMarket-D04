
package acme.features.authenticated.acmeItem;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.AcmeItem;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedAcmeItemListService implements AbstractListService<Authenticated, AcmeItem> {

	@Autowired
	AuthenticatedAcmeItemRepository repository;


	@Override
	public boolean authorise(final Request<AcmeItem> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<AcmeItem> request, final AcmeItem entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "title", "category", "price");
	}

	@Override
	public Collection<AcmeItem> findMany(final Request<AcmeItem> request) {
		assert request != null;
		Collection<AcmeItem> result;

		result = this.repository.findAllAcmeItem();

		return result;
	}

}
