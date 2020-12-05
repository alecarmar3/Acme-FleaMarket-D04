
package acme.features.supplier.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.roles.Supplier;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class SupplierItemShowService implements AbstractShowService<Supplier, Item> {

	@Autowired
	private SupplierItemRepository repository;


	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;

		Boolean isMine = this.repository.findMyItems(request.getPrincipal().getActiveRoleId()).contains(this.repository.findOneById(request.getModel().getInteger("id")));

		return isMine;
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "creationDate", "title", "category", "description", "price", "photo", "additionalInformation");
	}

	@Override
	public Item findOne(final Request<Item> request) {
		assert request != null;

		Item result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

}
