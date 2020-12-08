
package acme.features.supplier.acmeItemRequest;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.AcmeItemRequest;
import acme.entities.roles.Supplier;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/supplier/acme-item-request/")
public class SupplierAcmeItemRequestController extends AbstractController<Supplier, AcmeItemRequest> {

	@Autowired
	private SupplierAcmeItemRequestListToMineService	listToMineService;

	@Autowired
	private SupplierAcmeItemRequestShowService			showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_TO_MINE, BasicCommand.LIST, this.listToMineService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
}
