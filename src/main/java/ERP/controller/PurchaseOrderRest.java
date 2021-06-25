package ERP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ERP.dto.LineBuyDto;
import ERP.dto.LineSaleDto;
import ERP.dto.PurchaseOrderDto;
import ERP.service.PurchaseOrderService;

@RestController
@RequestMapping("/api/purchaseOrders")
public class PurchaseOrderRest {
	private PurchaseOrderService service;
	
	@Autowired
	public PurchaseOrderRest(PurchaseOrderService service)
	{
		super();
		this.service=service;
		
	}
	@PostMapping("/{id}")
	public PurchaseOrderDto createPurchaseOrder(@RequestBody PurchaseOrderDto purchaseOrder,
			@PathVariable("id") int id) {
		return service.createPurchaseOrder(purchaseOrder, id);
	}
	@GetMapping
	public List<PurchaseOrderDto> getAllPurchaseOdders()
	{
		return service.getAllPurchaseOrder();		
	}
	@GetMapping("/{id}")
	public PurchaseOrderDto getPurchaseOrderById(@PathVariable("id") int id) {
		return service.getPurchaseOrderById(id);
	}
	@PutMapping("/{id}")
	public PurchaseOrderDto modifyPurchaseOrder(@PathVariable("id")int id,
			@RequestBody PurchaseOrderDto purchaseOrder) {	
		return service.modifyPurchaseOrder(id, purchaseOrder);
	}
	@DeleteMapping("/{id}")
	public PurchaseOrderDto deletePurchaseById(@PathVariable("id") int id) {
		return service.deletePurchaseOrderById(id);
	}
	
	@GetMapping("/totalPricePurchaseOrder/{num}")
	public float calculOrder(@PathVariable("num") int num)
	{
		return service.calculOrder(num);
	}
	
	@GetMapping("/linesByus/{id}")
    public List<LineBuyDto> getLinesSalesForPurchaseOrder(@PathVariable("id") int id) {
   	 return service.getLinesSalesForPurchaseOrder(id);
   	 
    }
    
    @GetMapping("/validPurchaseOrder/{id}")
    public void getValidPurchaseSale(@PathVariable("id") int id) {
   	  service.getValidPurchaseSale(id);;
   	 
    }
	

}