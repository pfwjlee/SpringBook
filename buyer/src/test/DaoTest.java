package test;

import com.fruit.dao.fruitDAO;
import com.fruit.vo.BuyerVO;

public class DaoTest {

	public static void main(String[] args) {
		String id = "b01";
		fruitDAO dao = null;
		BuyerVO bvo = null;
				
		dao = new fruitDAO();
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
