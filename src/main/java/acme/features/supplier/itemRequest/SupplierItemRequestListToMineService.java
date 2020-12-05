
package acme.features.supplier.itemRequest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ItemRequest;
import acme.entities.roles.Supplier;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class SupplierItemRequestListToMineService implements AbstractListService<Supplier, ItemRequest> {

	@Autowired
	SupplierItemRequestRepository repository;


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

		request.unbind(entity, model, "ticker", "item.title", "quantity", "buyer.userAccount.username");
	}

	@Override
	public Collection<ItemRequest> findMany(final Request<ItemRequest> request) {
		assert request != null;
		Collection<ItemRequest> result;

		int supplierId = request.getPrincipal().getActiveRoleId();

		result = this.repository.findItemRequestsToMine(supplierId);

		return result;
	}

}
