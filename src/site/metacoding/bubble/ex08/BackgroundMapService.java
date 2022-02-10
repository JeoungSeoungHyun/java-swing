package site.metacoding.bubble.ex08;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// 백그라운드 서비스 (독립적인 스레드로 돌려야 한다.) -> 메인스레드로 돌리면 이것밖에 못하니까
public class BackgroundMapService implements Runnable {
	private Player player;
	private BufferedImage image;

	public BackgroundMapService(Player player) {
		this.player = player;

		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			// 색상 확인
			try {
				Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
				Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
//				System.out.println(image.getRGB(player.getX(), player.getY()));

				// 하얀색이면 -1 아니면 다른 값
				int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) // -1
						+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5); // -1
//				System.out.println("leftColor : " + leftColor);
//				System.out.println("rightColor : " + rightColor);

//				System.out.println(bottomColor);
				if (bottomColor != -2) { // 바텀 충돌
					player.setDown(false);
				} else {
					if (player.isUp() == false && player.isDown() == false) {
						player.down();
					}
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
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
