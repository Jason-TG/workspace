
package ex1;

import java.sql.SQLException;

import com.newlecture.app.console.NoticeConsole;
import com.newlecture.app.service.NoticeService;

public class JavaViewPage {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		NoticeConsole console = new NoticeConsole();

		EXIT: while (true) {

			console.printNoticeList();
			int menu = console.inputNoticeMenu();

			switch (menu) {
			case 1: // 상세조회
				break;
			case 2: // 이전
				console.movePrevList();
				break;
			case 3: // 다음
				console.moveNextList();
				break;
			case 4: // 글쓰기
				break;
			case 5: // 종료
				System.out.println("Bye~~");
				break EXIT;
//				라벨을 붙이고 break를 하면 라벨이 있는 곳까지 break
			default:
				System.out.println("< 사용방법> 메뉴는 1~4까지만 입력 가능합니다");
				break;

			} // s-c{}

		} // while{}

	} // main()

}// JavaViewPage{}
