package ERP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ERP.dto.PaymentDto;
import ERP.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentRest {
	
	private PaymentService service;
     
	@Autowired
	public PaymentRest(PaymentService service) {
		super();
		this.service = service;
	}
	
	
	@PostMapping("/{id}")
	public PaymentDto createPayment(@RequestBody PaymentDto payment,@PathVariable("id") int id) {
		return service.createPayment(payment, id);
	}
	
	@GetMapping
	public List<PaymentDto> getAllPayments() {
		return service.getAllPayments();
	}
	
    @GetMapping("/{id}")	
	public PaymentDto getPaymentById(@PathVariable("id") int id) {
		return service.getPaymentById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deletePaymentyById(@PathVariable("id") int id) {
		service.deletePaymentyById(id);
	}
	
		
	
	
	
}
