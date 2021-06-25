package ERP.service;

import java.util.List;

import ERP.dto.PaymentDto;

public interface PaymentService {

	PaymentDto createPayment(PaymentDto payment,int id);
	List<PaymentDto> getAllPayments();
	PaymentDto getPaymentById(int id);
	PaymentDto modifyPayment(int id, PaymentDto payment);
	void deletePaymentyById(int id);
}
