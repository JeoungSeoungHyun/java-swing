package site.metacoding.ex13;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// import�� ctrl + shift + o ����Ű
// �ڵ����� ctrl +shift + f
public class MyFrame extends JFrame {

	// ����� �⺻���� �ϴ��� �ٲ��ִ��� �����ϱ� ���� �����ڸ� �ΰ� ���־ �����ε�
    public MyFrame() {
    	super(); //�����Ǿ� ����
    	System.out.println("MyFrame ����Ʈ");
        setSize(600, 400); // width, height
        setLocationRelativeTo(null); // ������ ȭ�� �߾� ��ġ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� ��������

    }
    
    public MyFrame(int w, int h) {
    	super(); //�����Ǿ� ���� super�� ���� ���� �־�� �Ѵ�.
    	System.out.println("MyFrame �����ε��� ������");
        setSize(w, h); // width, height
        setLocationRelativeTo(null); // ������ ȭ�� �߾� ��ġ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� ��������

    }
}

