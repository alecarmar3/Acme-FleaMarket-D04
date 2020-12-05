
package acme.features.buyer.itemRequest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ItemRequest;
import acme.entities.roles.Buyer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class BuyerItemRequestListMineService implements AbstractListService<Buyer, ItemRequest> {

	@Autowired
	BuyerItemRequestRepository repository;


	@Override
	public boolean authorise(final Request<ItemRequest> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<ItemRequest> request, final ItemRequest entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "item.title", "quantity");
	}

	@Override
	public Collection<ItemRequest> findMany(final Request<ItemRequest> request) {
		assert request != null;
		Collection<ItemRequest> result;

		int buyerId = request.getPrincipal().getActiveRoleId();

		result = this.repository.findMyItemRequests(buyerId);

		return result;
	}

}
