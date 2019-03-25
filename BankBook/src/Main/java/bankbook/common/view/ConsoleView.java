package Main.java.bankbook.common.view;

public class ConsoleView {
    public static void startLoginMenu() {
        System.out.println("통장관리시스템");
        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("종료하려면 -1을 입력하세요");
    }

    public static void startManagementMenu(){
        System.out.println("계좌관리시스템");
        System.out.println("1. 계좌조회");
        System.out.println("2. 계좌생성");
        System.out.println("3. 계좌관리");
        System.out.println("종료를 원하시면 -1을 입력하세요");
    }
}
