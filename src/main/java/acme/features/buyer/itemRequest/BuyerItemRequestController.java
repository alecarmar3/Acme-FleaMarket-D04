
package acme.features.buyer.itemRequest;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.ItemRequest;
import acme.entities.roles.Buyer;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/buyer/item-request/")
public class BuyerItemRequestController extends AbstractController<Buyer, ItemRequest> {

	@Autowired
	private BuyerItemRequestListMineService	listMineService;

	@Autowired
	private BuyerItemRequestShowService		showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
}
