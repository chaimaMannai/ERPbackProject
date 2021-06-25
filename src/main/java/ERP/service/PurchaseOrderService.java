package ERP.service;

import java.util.List;

import ERP.dto.LineBuyDto;
import ERP.dto.LineSaleDto;
import ERP.dto.PurchaseOrderDto;

public interface PurchaseOrderService {
	PurchaseOrderDto createPurchaseOrder(PurchaseOrderDto purchaseOrder,int id);
	List<PurchaseOrderDto> getAllPurchaseOrder();
	PurchaseOrderDto getPurchaseOrderById(int id);
	PurchaseOrderDto modifyPurchaseOrder(int id, PurchaseOrderDto purchaseOrder);
	PurchaseOrderDto deletePurchaseOrderById(int id);
	public float calculOrder(int num);
    List<LineBuyDto> getLinesSalesForPurchaseOrder(int numero);
    
    // 
    
    void getValidPurchaseSale(int id);

}
