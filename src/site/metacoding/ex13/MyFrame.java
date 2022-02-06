package site.metacoding.ex13;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// import는 ctrl + shift + o 단축키
// 자동정렬 ctrl +shift + f
public class MyFrame extends JFrame {

	// 사이즈를 기본으로 하던가 바꿔주던가 결정하기 위해 생성자를 두개 해주어서 오버로딩
    public MyFrame() {
    	super(); //생략되어 있음
    	System.out.println("MyFrame 디폴트");
        setSize(600, 400); // width, height
        setLocationRelativeTo(null); // 프레임 화면 중앙 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 메인종료

    }
    
    public MyFrame(int w, int h) {
    	super(); //생략되어 있음 super는 제일 위에 있어야 한다.
    	System.out.println("MyFrame 오버로딩된 생성자");
        setSize(w, h); // width, height
        setLocationRelativeTo(null); // 프레임 화면 중앙 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 메인종료

    }
}

