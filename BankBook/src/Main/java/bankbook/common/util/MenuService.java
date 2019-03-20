package Main.java.bankbook.common.util;

import Main.java.bankbook.common.view.consoleView;
import Main.java.bankbook.member.model.Member;

import Main.java.bankbook.member.repository.MemberRepository;
import Main.java.bankbook.member.service.MemberService;




public class MenuService {


    private MemberService memberService;

    public MenuService() {
        memberService = new MemberService();

    }



    public Member startLoginMenu() {
        Member loginMember = new Member();
        MemberRepository memberRepository = new MemberRepository();
        for(int i=0;i<memberRepository.getAllMembersInFile().size();i++){
            loginMember = memberRepository.getAllMembersInFile().get(i);
        }
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


                // step1. 아이디와 비밀번호를 입력하라는 유저뷰를 보여줌
                // step2. 아이디와 비밀번호를 입력받음

                System.out.println("아이디를 입력하세요");
                String idInput = ScannerService.getScanner().next();
                System.out.println("비밀번호를 입력하세요");
                String passwordInput = ScannerService.getScanner().next();
                loginMember = memberService.getMember(idInput,passwordInput);
                // step3. 입력받은 값이 올바른 입력값인지 검증

                // 파일의 첫번째, 두번째 입력값도
                memberService.memberLogin(idInput,passwordInput);



                //로그인 멤버에 파일정보가 들어가려면.

                // step5. 에러메세지를 띄워야하기때문에 조건검사를 한번 더 하고 continue 시킴

                // step5. 구현
                if (!loginMember.existMember()) {
                    System.out.println("정보가 정상적으로 조회되지 않았습니다. 다시 시도해 주세요\n");
                    continue;
                }
            }

            if (selectedMenu == 2) { // 회원가입
                // step1. 유저뷰를 보여줌
                // step2. 입력받은 아이디가 이미 존재하는 아이디인지 확인
                // String id = getIdFromConsole();
                // if (memberService.existId(id)) { // 존재하는 아이디면
                //   System.out.println("이미 존재하는 아이디입니다. 다시 시도해주세요\n");
                //   continue;
                // }
                // step3. 존재하면 다시시도 & 존재하지 않으면 회원가입

            }
        }
            while (selectedMenu > 0 && !loginMember.existMember())
                ; // <<<< 여기 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            // 이 조건의 의미 1.정상적인 메뉴를 입력했으면서 loginMember가 존재하는회원이 아닐때까지
            // 이 조건이 거짓이 되어서 loop이 끝나는 시점은
            // 1. 정상적인 메뉴를 입력하지 않은경우 또는 2. loginMember존재하는회원일 경우(정상적으로 로그인 된 경우)

            return loginMember;
        }
    }
