package Main.java.bankbook;


import Main.java.bankbook.common.util.MenuService;

//통장 프로그램의 실행A
public class BankBookRunner {
    public static void run() {
        MenuService menuService = new MenuService();
        menuService.startLoginMenu();

        /*// 존재하는 회원/로그인 완료된 회원이라면 계좌관리 시스템 시작
        if (loginMember.existMember()) {
            // 계좌관리시스템 시작
            // menuService.startBankBookManagementMenu(loginMember);
        }

        System.out.println("프로그램을 종료합니다.");*/
    }
    }



