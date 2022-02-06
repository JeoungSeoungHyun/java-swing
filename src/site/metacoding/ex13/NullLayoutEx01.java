package site.metacoding.ex13;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NullLayoutEx01 extends MyFrame {

	int x = 0; // 람다식 안에서 로컬변수 변경 불가능(로컬변수와 파라미터 변수 구분 못해서?)
	int y = 0; // 클래스에서 변수를 초기화해준다.
	boolean isActive = true;

	public NullLayoutEx01() {
		super(300, 300);

		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(null);

		JButton btn1 = new JButton("버튼1");
		panel.add(btn1);
		btn1.setSize(100, 50); // 버튼크기 정해주기
		btn1.setLocation(x, y); // 버튼 위치 잡아주기

		Thread t1 = new Thread(() -> {

			while (isActive) {
				try {
					if (x < 200) {
//						System.out.println("x+1");
						x = x + 10;
						btn1.setLocation(x, y);
						Thread.sleep(10);
					} else if (x >= 200) {
//						System.out.println("끝에 도달");
						x = 0;
						y = y + 10;
						btn1.setLocation(x, y);
						Thread.sleep(10);
					} else if (y > 250) {
						System.out.println("이동종료");
						isActive = false;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
		t1.start();

		setVisible(true);
	}

	public static void main(String[] args) {
		new NullLayoutEx01();
		System.out.println("메인종료");
	}

}
