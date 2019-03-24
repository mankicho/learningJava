package Main.java.bankbook.common.view;

import Main.java.bankbook.common.util.ScannerService;

public class consoleView {
    public static void startLoginMenu(){
        System.out.println("통장관리시스템");
        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("종료하려면 -1을 입력하세요");

    }

    public  static void startMainMenu(){
        System.out.println("1. 계좌조회"); //계좌번호 , 잔고 ,
        System.out.println("2. 입금");
        System.out.println("3. 출금");
        System.out.println("4. 계좌생성");
        System.out.print("입력해주세요 : ");

    }
}
