package test;

import com.fruit.dao.FruitDAO;
import com.fruit.vo.BuyerVO;

public class DaoTest {

	public static void main(String[] args) {
		String id = "b01";
		FruitDAO dao = null;
		BuyerVO bvo = null;
				
		dao = new FruitDAO();
		bvo = dao.getBuyerInfo(id);
		System.out.println("id:" + bvo.getId());
		System.out.println("pass:" + bvo.getPass());
		System.out.println("money:" + bvo.getMoney());
		System.out.println("apple:" + bvo.getAppleCount());
		
		int money = 101010;
		dao.regBuyerMoney(id, money);
		bvo = dao.getBuyerInfo(id);
		System.out.println("id:" + bvo.getId());
		System.out.println("pass:" + bvo.getPass());
		System.out.println("money:" + bvo.getMoney());
		System.out.println("apple:" + bvo.getAppleCount());

	}

}
