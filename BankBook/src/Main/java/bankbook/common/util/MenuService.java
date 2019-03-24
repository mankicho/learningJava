package Main.java.bankbook.common.util;


import Main.java.bankbook.account.AccountService;
import Main.java.bankbook.common.view.consoleView;
import Main.java.bankbook.member.model.Member;

import Main.java.bankbook.member.repository.MemberRepository;
import Main.java.bankbook.member.service.MemberService;


public class MenuService {

    private Member loginMember = new Member();


    public Member getLoginMember() {
        return loginMember;
    }

    private MemberService memberService;

    public MenuService() {
        memberService = new MemberService();

    }


    public Member startLoginMenu() {


        int selectedMenu;


        do { // continue 여기로 돌아옴

            consoleView.startLoginMenu(); // 로그인시작메뉴화면출력

            selectedMenu = ScannerService.getScanner().nextInt(); // 사용자의 콘솔입력으로부터 정수값을 받음

            if (selectedMenu == -1) { // 종료
                System.out.println("Bye Bye");
                return new Member();
            }

            /** 여기가 과제 **/
            if (selectedMenu == 1) { // 로그인

                // ID,PASSWORD 입력
                System.out.println("아이디를 입력해주세요");
                String idInput = ScannerService.getScanner().next();
                System.out.println("비밀번호를 입력해주세요");
                String passInput = ScannerService.getScanner().next();

                //입력한 값을 loginMember 에 대입

                loginMember = memberService.getMember(idInput, passInput);
                //로그인 되었을 때


                if (memberService.loginSuccess(idInput, passInput)) {

                    System.out.println("로그인 되었습니다.");
                }

                //로그인 실패 시
                if (!memberService.loginSuccess(idInput, passInput)) {
                    if (memberService.existId(idInput)) {
                        System.out.println("아이디 또는 비밀번호가 틀렸습니다");
                    }
                    if (!memberService.existId(idInput)) {
                        System.out.println("존재하지 않는 아이디입니다");
                    }
                }
            }

            if (selectedMenu == 2) { // 회원가입
                Member member = new Member();
                System.out.println("아이디를 입력하세요");
                String id = getIdFromConsole();
                System.out.println("비번 입력");
                String password = getIdFromConsole();
                System.out.println("이름 입력");
                String name = getIdFromConsole();
                // step1. 유저뷰를 보여줌

                // step2. 입력받은 아이디가 이미 존재하는 아이디인지 확인
                if (memberService.existId(id)) {
                    System.out.println("이미 존재하는 아이디야 다시 시도해");
                    System.out.println();

                }
                if (!memberService.existId(id)) {
                    member.setId(id);
                    member.setPassword(password);
                    member.setName(name);

                    member.convert2TextData();//멤버를 텍스트파일 형식으로 변환

                    memberService.insertMemberTxt2Database(member);

                }

                // if (memberService.existId(id)) { // 존재하는 아이디면
                //   System.out.println("이미 존재하는 아이디입니다. 다시 시도해주세요\n");
                //   continue;
                // }
                // step3. 존재하면 다시시도 & 존재하지 않으면 회원가입

            }
        } while (selectedMenu > 0 && !memberService.loginSuccess(loginMember.getId(), loginMember.getPassword()));
        // <<<< 여기 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        // 이 조건의 의미 1.정상적인 메뉴를 입력했으면서 loginMember가 존재하는회원이 아닐때까지
        // 이 조건이 거이 되어서 loop이 끝나는 점은
        // 1. 정상적인 메뉴를 입력하지 않은경우 또는 2. loginMember존재하는회원일 경우(정상적으로 로그인 된 경우)시

        return loginMember;
    }


    //여기 매소드에서 스타드메뉴 매소드의 멤버변수에 접근하는법/
    public void startBankBookManagementMenu() {
        AccountService accountService = new AccountService();
        int selectedMenuLogin = 0;


        do {
            consoleView.startMainMenu();
            selectedMenuLogin = ScannerService.getScanner().nextInt();
            switch (selectedMenuLogin) {
                case 1:
                    accountService.checkAccount(loginMember);
                    break;
                case 2:
                    accountService.deposit();
                    break;
                case 3:
                    break;
                case 4:
                    accountService.AccountProduce(loginMember);
                    break;
            }
        } while (selectedMenuLogin > 0);
    }


    public String getIdFromConsole() {
        String inputValue = ScannerService.getScanner().next();
        return inputValue;
    }
}
//}
