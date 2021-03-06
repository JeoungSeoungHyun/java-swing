package site.metacoding.bubble.test;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class BackgroundMapService implements Runnable {

	// 생성자가 플레이어의 참조값을 알아야하기때문에 플레이어 변수 만들고 생성자에서 매개변수로 받기
	private Player player;

	// 이미지를 붙이는 것이 아닌 활용하기 위한것이기 때문에 BufferedImage로 받는다. -> BufferedImage변수 필요
	private BufferedImage image;

	// 생성자 만들어주기
	public BackgroundMapService(Player player) {
		this.player = player;

		// 이미지 연결 -> 버퍼로 받는거라서 try/catch
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		// 계속 돌아가도록 while을 걸어준다.
		while (true) {

			// 색깔 확인을 위해 Color 변수 생성
			try {

				// 방향별 확인할 Color 변수 생성
				Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
				Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));

				// 하얀색이면 -1 아니면 다른 값
				int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) // -1
						+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5); // -1

				if (bottomColor != -2) {
					player.setDown(false);
				} else {
					if (player.isUp() != true && player.isDown() != true)
						player.down();
				}

				if (leftColor.getRed() == 255 && leftColor.getBlue() == 0 && leftColor.getGreen() == 0) {
//					System.out.println("왼쪽 벽에 충돌함");
					player.setLeftWallCrash(true);
					player.setLeft(false);
				} else if (rightColor.getRed() == 255 && rightColor.getBlue() == 0 && rightColor.getGreen() == 0) {
//					System.out.println("오른쪽 벽에 충돌함");
					player.setRightWallCrash(true);
					player.setRight(false);
				} else {
					player.setLeftWallCrash(false);
					player.setRightWallCrash(false);
				}

				// 스레드 슬립
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
