package site.metacoding.ex13;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import site.metacoding.ex13.constant.BorderConstant;

enum Constant {
	North, EAST, WEST, SOUTH, CENTER
}

public class BorderLayoutEx01 extends MyFrame {

	public BorderLayoutEx01() {
		super(500, 500); // 사이즈 변경원하면

		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(new BorderLayout()); // 생략가능!! 디폴트가 BorderLayout 이니까

		JButton btnNorth = new JButton("북쪽");
		JButton btnEast = new JButton("동쪽");
		JButton btnWest = new JButton("서쪽");
		JButton btnSouth = new JButton("남쪽");
		JButton btnCenter = new JButton("가운데");

		// Border레이아웃은 방향을 버튼 add시 방향을 정해주어야 하는데 방향을 적는 과정에서 실수가 발생할 수 있기 때문에
		// 상수로 만들어 실수를 하지 않도록 한다. 이렇게 해도 실수가 나올수있으므로 enum을 사용한다.
		panel.add(btnNorth, BorderConstant.NORTH);
		panel.add(btnEast, BorderConstant.EAST);
		panel.add(btnWest, BorderConstant.WEST);
		panel.add(btnSouth, BorderConstant.SOUTH);
		panel.add(btnCenter, BorderConstant.CENTER);

		setVisible(true); // paint 메서드 //제일 마지막에 setVisible해주어야됨
	}

	public static void main(String[] args) {
		new BorderLayoutEx01();
	}

}
