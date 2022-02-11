package site.metacoding.practice;

/**
 * 
 * @author ������ initOBject ������ ������� ---------------------- 1�� ���� initSetting 2��
 *         ���� initListener 3�� ����(default)
 *
 */

// 5�� �������̽� ������ֱ�
public interface Init {

	void initObject();

	void initSetting();

	default void initListener() {

	}

	default void StartDocument() {
		initObject();
		initSetting();
		initListener();
	}
}
