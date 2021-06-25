package ERP.service;

import java.util.List;

import ERP.dto.LineBuyDto;

public interface LineBuyService {
	LineBuyDto createLineBuy(LineBuyDto lineBuy,int idProduct , int purchaseNumber);
	List<LineBuyDto> getAllLineBuy();
	LineBuyDto getLineById(int id);
	LineBuyDto modifyLineBuy(int id, LineBuyDto lineBuy);
	LineBuyDto deleteLineBuyById(int id);

}
