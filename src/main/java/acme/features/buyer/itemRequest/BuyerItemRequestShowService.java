
package acme.features.buyer.itemRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ItemRequest;
import acme.entities.roles.Buyer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class BuyerItemRequestShowService implements AbstractShowService<Buyer, ItemRequest> {

	@Autowired
	private BuyerItemRequestRepository repository;


	@Override
	public boolean authorise(final Request<ItemRequest> request) {
		assert request != null;

		Boolean isMine = this.repository.findMyItemRequests(request.getPrincipal().getActiveRoleId()).contains(this.repository.findOneById(request.getModel().getInteger("id")));

		return isMine;
	}

	@Override
	public void unbind(final Request<ItemRequest> request, final ItemRequest entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "creationDate", "quantity", "notes", "item.title");
	}

	@Override
	public ItemRequest findOne(final Request<ItemRequest> request) {
		assert request != null;

		ItemRequest result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

}
