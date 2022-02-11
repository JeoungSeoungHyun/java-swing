package site.metacoding.practice;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BackgroundMap extends JLabel {

	private ImageIcon backgroundMap; // 눈에 보이는 용
	private BufferedImage image; // 눈에 안보이는 계산용

//	private int x, y;	//변하지 않으므로 쓸데없이 상태를 만들 필요가 없다.

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public BackgroundMap() {

		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		backgroundMap = new ImageIcon("image/backgroundMap.png");
		setIcon(backgroundMap); // Div 박스에 이미지 넣기
	}
}
