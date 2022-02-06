package site.metacoding.ex13.enumerate;

//interface 변수는 public  static final이 생략되어있다.
interface Direction { 
	String LEFT = "Left";
	String RIGHt = "Right";
}

public class EnumEx01 {
	public static void add(String direction) {
		// "Left", "Right"
		if(direction.equals("Left") || direction.equals("Right")) {
			System.out.println("잘들어왔군");
		} else {
			System.out.println("잘못입력했어");
		}
	}
	
	public static void main(String[] args) {
		add(Direction.LEFT);
		add(Direction.RIGHt);
	}
}
