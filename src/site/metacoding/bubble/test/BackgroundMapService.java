package site.metacoding.bubble.test;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundMapService implements Runnable {

	// 2. 생성자가 플레이어의 참조값을 알아야하기때문에 플레이어 변수 만들고 생성자에서 매개변수로 받기
	private Player player;

	// 3. 이미지를 붙이는 것이 아닌 활용하기 위한것이기 때문에 BufferedImage로 받는다. -> BufferedImage변수 필요
	private BufferedImage image;

	// 1. 생성자 만들어주기
	public BackgroundMapService(Player player) {
		this.player = player;

		// 4. 이미지 연결 -> 버퍼로 받는거라서 try/catch
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// 9. 계속 돌아가도록 while을 걸어준다.
		while (true) {
			// 8. 색깔 확인을 위해 Color 변수 생성
			try {
				Color color = new Color(image.getRGB(player.getX(), player.getY()));
				System.out.println("Red : " + color.getRed());
				System.out.println("Green : " + color.getGreen());
				System.out.println("Blue : " + color.getBlue());
				System.out.println("====================================");
				// 9. 스레드 슬립
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
