
package com.newlecture.app.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.newlecture.app.service.NoticeService;
import com.newlecture.app.service.entity.Notice;

public class NoticeConsole {

	private NoticeService service;
	private int page;
	private int count;

	public NoticeConsole() {
		service = new NoticeService();
		page = 1;
	}

	public int inputNoticeMenu() {

		Scanner scan = new Scanner(System.in);

		System.out.printf("1. 상세조회 / 2. 이전 / 3. 다음 / 4. 글쓰기 / 5. 종료 >> ");

		String menu_ = scan.nextLine();
		int menu = Integer.parseInt(menu_);

		return menu;
	}

	public void printNoticeList() throws ClassNotFoundException, SQLException {

		List<Notice> list = service.getList(page);
		int count = service.getCount();
		int lastPage = count / 10;
		lastPage = count % 10 == 0 ? lastPage : lastPage + 1;

		System.out.println("───────────────────");
		System.out.printf("<공지사항> 총 %d개의 게시글\n", count);
		System.out.println("───────────────────");
		for (Notice notice : list) {
			System.out.printf("%d. %s / %s / %s \n", notice.getId(), notice.getTitle(), notice.getWriterId(),
					notice.getRegDate());
		}
		System.out.println("───────────────────");
		System.out.printf("               %d / %d pages \n", page, lastPage);
		System.out.println();

	} // printNoticeList()

	public void movePrevList() {
		if (page == 1) {
			System.out.println("====================");
			System.out.println("이전 페이지가 없습니다.");
			System.out.println("====================");
			return;
		} // if
		page--;
	} // movePrevList()

	public void moveNextList() throws ClassNotFoundException, SQLException {
		int count = service.getCount();
		int lastPage = count / 10;
		lastPage = count % 10 == 0 ? lastPage : lastPage + 1;
		
		if (page == lastPage) {
			System.out.println("====================");
			System.out.println("다음 페이지가 없습니다.");
			System.out.println("====================");
			return;
		} // if

		page++;
	} // moveNextList()

} // NoticeConsole {}
