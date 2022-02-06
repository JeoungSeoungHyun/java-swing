package site.metacoding.ex13;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GridLayoutEx01 extends MyFrame {

	public GridLayoutEx01 () {
		super(500,100);
		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(new GridLayout(0,3));
		
		JButton btn11 = new JButton("버튼1");
		JButton btn12 = new JButton("버튼2");
		JButton btn13 = new JButton("버튼3");
		JButton btn14 = new JButton("버튼4");
		JButton btn15 = new JButton("버튼5");
		
		panel.add(btn11);
		panel.add(btn12);
		panel.add(btn13);
		panel.add(btn14);
		panel.add(btn15);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new GridLayoutEx01();
	}

}
