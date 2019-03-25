package Main.java.bankbook;


import Main.java.bankbook.common.util.MenuService;
import Main.java.bankbook.member.model.Member;

public class BankBookRunner {
    public static void run() { // 여기다잉
        MenuService menuService = new MenuService();
        Member loginMember = menuService.startLoginMenu();

        // 존재하는 회원/로그인 완료된 회원이라면 계좌관리 시스템 시작
        if (loginMember.existMember()) {

             menuService.startBankBookManagementMenu(loginMember);
        }

        System.out.println("프로그램을 종료합니다.");
    }
}
