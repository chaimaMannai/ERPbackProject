package ERP.service;

import java.util.List;

import ERP.dto.LineSaleDto;

public interface LineSaleService {

	LineSaleDto createLineSale(LineSaleDto linesale,int idProduct , int numberOrderSale);
	List<LineSaleDto> getAllLinesale();
	LineSaleDto getLinesaleById(int id);
	LineSaleDto modifyLinesale(int id, LineSaleDto category);
	void deleteLinesaleById(int id);
	void deleteAllLinesSales();
}