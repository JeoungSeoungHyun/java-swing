package site.metacoding.bubble.ex06;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// 백그라운드 서비스 (독립적인 스레드로 돌려야 한다.) -> 메인스레드로 돌리면 이것밖에 못하니까
public class BackgroundMapService implements Runnable {

	// 컴포지션
	private Player player;
	private BufferedImage image;

	// 컴포지션을 위한 기술 => 의존성 주입( 생성자를 통해서 주입) - DI(Dependency Injection)
	public BackgroundMapService(Player player) {
		this.player = player;
		try {
			// raw 하게 읽는다는 뜻 : 날것 그대로 읽는 것
			image = ImageIO.read(new File("image/test.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		while (true) {
			try {
				Color color = new Color(image.getRGB(player.getX() + 50, player.getY()));
//				System.out.println("Red     : " + color.getRed());
//				System.out.println("Blue    : " + color.getBlue());
//				System.out.println("Green : " + color.getGreen());
//				System.out.println("==================");
				Thread.sleep(10); // 충돌 감지를 미세하게 하는 조절법
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
