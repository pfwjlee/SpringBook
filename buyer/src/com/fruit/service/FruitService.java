package com.fruit.service;

import com.fruit.dao.FruitDAO;
import com.fruit.vo.BuyerVO;
import com.fruit.vo.SellerVO;

public class FruitService {
	private FruitDAO fruitDAO;

	// Transaction 처리는 어떻게?
	public void tradeFruit(String bid, String sid, int appleCount) {
		int applePrice = fruitDAO.getApplePrice(sid);
		fruitDAO.buyerBuyFruit(bid, appleCount, applePrice);
		fruitDAO.sellerSellFruit(bid, appleCount);
	}

	public SellerVO getSellerInfo(String id) {
		return fruitDAO.getSellerInfo(id);
	}
	
	public void regSellerApple(String id, int count, int money) {
		fruitDAO.regSellerApple(id, count, money);
	}
	
	public BuyerVO getBuyerInfo(String id) {
		return fruitDAO.getBuyerInfo(id);
	}

	public void regBuyerMoney(String id, int money) {
		fruitDAO.regBuyerMoney(id, money);
	}
}
