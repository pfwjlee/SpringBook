package polymorphism;

public class SamsungTV implements TV {
	
	public SamsungTV() {
		System.out.println("===> SamsungTV 객체생성");
	}
	
	public void powerOn() {
		System.out.println("Samsung TV --- 전원을 켠다.");
	}
	public void powerOff() {
		System.out.println("Samsung TV --- 전원을 끈다.");
	}
	public void volumeUp() {
		System.out.println("Samsung TV --- 소리를 높인다.");
	}
	public void volumeDown() {
		System.out.println("Samsung TV --- 소리를 낮춘다.");
	}
	
	public void initMethod() {
		System.out.println("Samsung TV --- 초기화.");
	}
	public void destroyMethod() {
		System.out.println("Samsung TV --- 정리.");
	}
}
