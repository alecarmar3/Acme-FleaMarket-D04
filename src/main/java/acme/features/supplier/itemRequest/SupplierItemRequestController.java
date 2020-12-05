
package acme.features.supplier.itemRequest;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.ItemRequest;
import acme.entities.roles.Supplier;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/supplier/item-request/")
public class SupplierItemRequestController extends AbstractController<Supplier, ItemRequest> {

	@Autowired
	private SupplierItemRequestListToMineService	listToMineService;

	@Autowired
	private SupplierItemRequestShowService			showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_TO_MINE, BasicCommand.LIST, this.listToMineService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
}
