package Main.java.bankbook;


import Main.java.bankbook.common.util.MenuService;
import Main.java.bankbook.member.model.Member;
import Main.java.bankbook.member.service.MemberService;

//통장 프로그램의 실행A
public class BankBookRunner {
    public static void run() {
        MemberService memberService = new MemberService();
        MenuService menuService = new MenuService();
        menuService.getLoginMember();
        menuService.startLoginMenu(); // loginMenber가 리턴되는데 어떻게 접근하냐


//        // 존재하는 회원/로그인 완료된 회원이라면 계좌관리 시스템 시작
//        if (memberService.loginSuccess(menuService.getLoginMember().getId(),menuService.getLoginMember().getPassword())) {
//
//            menuService.startBankBookManagementMenu();
//
//        }
//
//        System.out.println("프로그램을 종료합니다.");
//    }
    }

}



