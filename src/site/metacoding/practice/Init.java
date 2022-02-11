package site.metacoding.practice;

/**
 * 
 * @author 정성현 initOBject 생성자 실행순서 ---------------------- 1번 실행 initSetting 2번
 *         실행 initListener 3번 실행(default)
 *
 */

// 5번 인터페이스 만들어주기
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
