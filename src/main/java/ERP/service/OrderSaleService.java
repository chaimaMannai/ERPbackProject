package ERP.service;


import java.util.List;

import ERP.dto.LineSaleDto;
import ERP.dto.OrderSaleDto;

public interface OrderSaleService {
	
	OrderSaleDto createOrderSale(OrderSaleDto OrderSale, int id );
    List<OrderSaleDto> getAllOrderSales();
    OrderSaleDto getOrderSaleById(int id);
    OrderSaleDto modifyOrderSale(int id, OrderSaleDto OrderSale);
    void deleteOrderSaleById(int id);
    
    // methode de calcul de commande 
    float calculCommande(int numero);
    
    // le revenu les ventes des produits dans le stock 
    float getRevenuParMois(String mois);
    
    // le revenue des ventes des produits dans le stock par periode
   // float getRevenuParPeriode(LocalDate dateBegin, LocalDate dateEnd);
    
    List<LineSaleDto> getLinesSalesForOrderSale(int numero);
    
    // 
    
    void getValidOrderSale(int id);
    
    

}