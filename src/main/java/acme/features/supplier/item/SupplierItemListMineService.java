
package acme.features.supplier.item;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.roles.Supplier;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class SupplierItemListMineService implements AbstractListService<Supplier, Item> {

	@Autowired
	SupplierItemRepository repository;


	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "title", "category", "price");
	}

	@Override
	public Collection<Item> findMany(final Request<Item> request) {
		assert request != null;
		Collection<Item> result;

		int supplierId = request.getPrincipal().getActiveRoleId();

		result = this.repository.findMyItems(supplierId);

		return result;
	}

}
