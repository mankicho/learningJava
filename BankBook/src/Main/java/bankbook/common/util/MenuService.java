package Main.java.bankbook.common.util;


import Main.java.bankbook.account.Service.AccountService;
import Main.java.bankbook.common.view.ConsoleView;
import Main.java.bankbook.member.model.Member;
import Main.java.bankbook.member.repository.MemberRepository;
import Main.java.bankbook.member.service.MemberService;

import java.util.Scanner;


public class MenuService {

    private MemberService memberService;

    public MenuService() {
        memberService = new MemberService();
    }

    public Member startLoginMenu() {
        Member loginMember = new Member(); // 이거 썼어?

        int selectedMenu;

        do { // continue 여기로 돌아옴

            ConsoleView.startLoginMenu(); // 로그인시작메뉴화면출력

            selectedMenu = ScannerService.getScanner().nextInt(); // 사용자의 콘솔입력으로부터 정수값을 받음

            if (selectedMenu == -1) { // 종료
                System.out.println("Bye Bye");
                return new Member();
            }

            /** 여기가 과제 **/
            if (selectedMenu == 1) { // 로그인

                System.out.println("아이디를 입력하세요");
                String id = ScannerService.getScanner().next();
                System.out.println("비밀번호를 입력하세요");
                String password = ScannerService.getScanner().next();

                // step3. 입력받은 값이 올바른 입력값인지 검증

                // step4. 존재하는 회원인지 확인(id 존재 && password도 맞음)
                loginMember = memberService.getMember(id, password);


                // step5. 에러메세지를 띄워야하기때문에 조건검사를 한번 더 하고 continue 시킴
                // step5. 구현


                if (!loginMember.existMember()) {
                    System.out.println("정보가 정상적으로 조회되지 않았습니다. 다시 시도해 주세요\n");
                    continue;
                }
                System.out.println("로그인 되었습니다.");
            }

            if (selectedMenu == 2) { // 회원가입

                MemberRepository memberRepository = new MemberRepository();
                // step1. 유저뷰를 보여줌
                System.out.println("회원가입 하실 아이디를 입력해주세요");
                String id = ScannerService.getScanner().next();
                System.out.println("비밀번호를 설정해주세요");
                String password = ScannerService.getScanner().next();
                System.out.println("이름을 설정해주세요");
                String name = ScannerService.getScanner().next();


                if (!memberService.existId(id)) {
                    loginMember = new Member(id, password, name);
                    memberService.registerOnTextFile(loginMember);
                    loginMember = new Member();
                    continue;
                }


                // step3. 존재하면 다시시도 & 존재하지 않으면 회원가입

                System.out.println("이미 존재하는 아이디입니다. 다시 시도해주세요\n");
                continue;
            }

        } while (selectedMenu > 0 && !loginMember.existMember()); // <<<< 여기 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        // 이 조건의 의미 1.정상적인 메뉴를 입력했으면서 loginMember가 존재하는회원이 아닐때까지
        // 이 조건이 거짓이 되어서 loop이 끝나는 시점은
        // 1. 정상적인 메뉴를 입력하지 않은경우 또는 2. loginMember존재하는회원일 경우(정상적으로 로그인 된 경우)

        return loginMember;
    }

    public Member startBankBookManagementMenu(Member member) {

        AccountService accountService = new AccountService();
        int selectMenu = 0;
        do {
            ConsoleView.startAccountMenu();
            selectMenu = ScannerService.getScanner().nextInt();
            switch (selectMenu) {
                case 1:
                    System.out.println("계좌를 조회합니다");
                    accountService.AccountLookInto(member);
                    break;
                case 2:
                    System.out.println("계좌를 생성합니다");
                    accountService.produceAccount(member);
                    break;
                case 3:
                    System.out.println("계좌를 관리합니다.");
                    accountService.AccountManagement(member);
                    break;
                default:
                    selectMenu = -1;
                    break;
            }
        } while (selectMenu > 0);
        return new Member();
    }

}

