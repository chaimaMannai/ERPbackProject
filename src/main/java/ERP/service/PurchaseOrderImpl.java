package ERP.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ERP.dto.LineBuyDto;
import ERP.dto.LineSaleDto;
import ERP.dto.ProviderDto;
import ERP.dto.PurchaseOrderDto;
import ERP.model.BuyLineEntity;
import ERP.model.InvoiceEntiy;
import ERP.model.LineSaleEntity;
import ERP.model.OrderSaleEntity;
import ERP.model.ProviderEntity;
import ERP.model.PurchaseOrderEntity;
import ERP.repository.InvoiceRepository;
import ERP.repository.LineBuyRepository;
import ERP.repository.ProviderRepository;
import ERP.repository.PurchaseOrderRepository;
@Service
public class PurchaseOrderImpl implements PurchaseOrderService {
	private PurchaseOrderRepository repoPurchaseOrder;
	private ProviderRepository repoProvider;
	private InvoiceRepository repoInvoice;
	private LineBuyRepository repoLineBuy;
	
	private ModelMapper mapper;
	
	
	@Autowired
	public PurchaseOrderImpl (PurchaseOrderRepository repoPurchaseOrder,ProviderRepository repoProvider,
			InvoiceRepository repoInvoice, LineBuyRepository repoLineBuy,ModelMapper mapper)
	{
		this.repoPurchaseOrder=repoPurchaseOrder;
		this.repoProvider=repoProvider;
		this.repoInvoice=repoInvoice;
		this.repoLineBuy=repoLineBuy;
		this.mapper=mapper;
	}
	@Override
	public PurchaseOrderDto createPurchaseOrder(PurchaseOrderDto purchaseOrder,int id) {
		// TODO Auto-generated method stub
		PurchaseOrderEntity entity=mapper.map(purchaseOrder, PurchaseOrderEntity.class);
		ProviderEntity provider = repoProvider.findById(id).get();
		ProviderEntity providerEntityinBd = repoProvider.save(provider);
		entity.setProvider(providerEntityinBd);
		InvoiceEntiy invoice=entity.getInvoice();
		
        InvoiceEntiy invoiceEntityinBd = repoInvoice.save(invoice);
		entity.setInvoice(invoiceEntityinBd);
		PurchaseOrderEntity  newEntity = repoPurchaseOrder.save(entity);

		
		
		return mapper.map(newEntity, PurchaseOrderDto.class);
	}

	@Override
	public List<PurchaseOrderDto> getAllPurchaseOrder() {
		// TODO Auto-generated method stub
		List<PurchaseOrderDto> purchaseOrderDto = new ArrayList<>();
		List<PurchaseOrderEntity> purchaseOrder=repoPurchaseOrder.findAll();
		for(PurchaseOrderEntity purchaseOrderEntity:purchaseOrder)
		{
			purchaseOrderDto.add(mapper.map(purchaseOrderEntity, PurchaseOrderDto.class));
			
		}
		return purchaseOrderDto;
	}

	@Override
	public PurchaseOrderDto getPurchaseOrderById(int id) {
		PurchaseOrderEntity entity = mapper.map(PurchaseOrderDto.class,PurchaseOrderEntity.class);
		Optional<PurchaseOrderEntity> newEntity = repoPurchaseOrder.findById(id);
		if(newEntity.isPresent())
		{
			entity = newEntity.get();
		}
		else 
			throw new NoSuchElementException("This purchase order is not fount");
		/*PurchaseOrderDto purchaseOrdr = new PurchaseOrderDto(entity.getNumber(),
				entity.getDate(),entity.getTotalPrice(),entity.getProvider(),entity.getInvoice());*/

		

		return mapper.map(entity, PurchaseOrderDto.class);
	}

	@Override
	public PurchaseOrderDto modifyPurchaseOrder(int id, PurchaseOrderDto newPurchaseOrder) {
		// TODO Auto-generated method stub
		PurchaseOrderEntity entity = mapper.map(newPurchaseOrder,PurchaseOrderEntity.class);
		PurchaseOrderEntity oldPurchaseOrder = repoPurchaseOrder.findById(id).get();
		
		if(newPurchaseOrder.getTotalPrice()!=0)
			oldPurchaseOrder.setTotalPrice(newPurchaseOrder.getTotalPrice());
		
		
		return mapper.map(repoPurchaseOrder.save(oldPurchaseOrder),PurchaseOrderDto.class);
	}

	@Override
	public PurchaseOrderDto deletePurchaseOrderById(int id) {
		// TODO Auto-generated method stub
		PurchaseOrderDto entity = this.getPurchaseOrderById(id);
		repoPurchaseOrder.deleteById(id);
		return entity;

	}
	@Override
	public float calculOrder(int num) {
		float sumOrder= 0;
		
		PurchaseOrderEntity orderEntity = repoPurchaseOrder.findById(num).get();
		
		for(BuyLineEntity line : orderEntity.getLineBuys())
		{
			if(line.getProduct().getQuantite() > line.getQt())
			{
				sumOrder += line.getProduct().getPriceAchat()*line.getQt();
				
				int newQt = line.getProduct().getQuantite()+line.getQt();
				
				line.getProduct().setQuantite(newQt);
				
				repoLineBuy.save(line);
				
			}
			
			else
			{
				throw new ArithmeticException("unable to place an order");
			}
		}
		
		orderEntity.setTotalPrice(sumOrder);
		return sumOrder;
	}
	@Override
	public List<LineBuyDto> getLinesSalesForPurchaseOrder(int numero) {
		PurchaseOrderEntity entity=repoPurchaseOrder.findById(numero).get();
		List<LineBuyDto>ListLineBuyDto =new ArrayList<>();
		for (BuyLineEntity e : entity.getLineBuys()) {
			ListLineBuyDto.add(mapper.map(e, LineBuyDto.class));
			
		}
		
		return ListLineBuyDto;
	}

	@Override
	public void getValidPurchaseSale(int id) {
		PurchaseOrderEntity entity=repoPurchaseOrder.findById(id).get();
		entity.setValid(true);
		repoPurchaseOrder.save(entity);
		
	}

}
