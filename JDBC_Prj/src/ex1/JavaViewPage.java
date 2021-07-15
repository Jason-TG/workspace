
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
			case 1: // ����ȸ
				break;
			case 2: // ����
				console.movePrevList();
				break;
			case 3: // ����
				console.moveNextList();
				break;
			case 4: // �۾���
				break;
			case 5: // ����
				System.out.println("Bye~~");
				break EXIT;
//				���� ���̰� break�� �ϸ� ���� �ִ� ������ break
			default:
				System.out.println("< �����> �޴��� 1~4������ �Է� �����մϴ�");
				break;

			} // s-c{}

		} // while{}

	} // main()

}// JavaViewPage{}
