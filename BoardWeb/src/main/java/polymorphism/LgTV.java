package polymorphism;

public class LgTV implements TV{
	
	public LgTV() {
		System.out.println("===> LgTV 객체생성(1)");
	}
	public void powerOn() {
		System.out.println("Lg TV --- 전원켠다.");
	}
	public void powerOff() {
		System.out.println("Lg TV --- 전원끈다.");
	}
	public void volumeUp() {
		System.out.println("Lg TV --- 소리를 LG처럼 올린다.");
	}
	public void volumeDown() {
		System.out.println("Lg TV --- 소리를 LG처럼 내린다.");
	}
}
