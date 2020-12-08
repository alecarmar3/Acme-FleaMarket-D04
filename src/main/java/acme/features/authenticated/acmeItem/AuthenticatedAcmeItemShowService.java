
package acme.features.authenticated.acmeItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.AcmeItem;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedAcmeItemShowService implements AbstractShowService<Authenticated, AcmeItem> {

	@Autowired
	private AuthenticatedAcmeItemRepository repository;


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

		int AcmeItemId = request.getModel().getInteger("id");
		model.setAttribute("AcmeItemId", AcmeItemId);

		request.unbind(entity, model, "ticker", "creationDate", "title", "category", "description", "price", "photo", "additionalInformation");
	}

	@Override
	public AcmeItem findOne(final Request<AcmeItem> request) {
		assert request != null;

		AcmeItem result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

}
