package site.metacoding.ex13;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GridLayoutEx01 extends MyFrame {

	public GridLayoutEx01 () {
		super(500,100);
		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(new GridLayout(0,3));
		
		JButton btn11 = new JButton("��ư1");
		JButton btn12 = new JButton("��ư2");
		JButton btn13 = new JButton("��ư3");
		JButton btn14 = new JButton("��ư4");
		JButton btn15 = new JButton("��ư5");
		
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
