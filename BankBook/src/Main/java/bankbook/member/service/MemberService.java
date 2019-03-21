package Main.java.bankbook.member.service;

import Main.java.bankbook.common.util.ScannerService;
import Main.java.bankbook.common.view.consoleView;
import Main.java.bankbook.member.model.Member;
import Main.java.bankbook.member.repository.MemberRepository;

public class MemberService {
    private MemberRepository memberRepository;

    public MemberService() {
        memberRepository = new MemberRepository();
    }

    public Member getMember(String id, String password){
        return memberRepository.selectMember(id,password);
    }

    public Member insertMemberTxt2Database(Member member){
        return memberRepository.insertMember(member);
    }

    public boolean existId(String id) {
        return memberRepository.exist(id);
    }




      //아이디 비밀번호가 맞는지?
    public void memberLogin(String id, String password){
       for(Member member : memberRepository.getAllMembersInFile()){
           if(id.equals(member.getId())&&password.equals(member.getPassword())){
               System.out.println("로그인 되셨습니다.");
               consoleView.startMainMenu();
           }
           if(id.equals(member.getId())&&!password.equals(member.getPassword())){
               System.out.println("아디 또는 비번틀림");
            continue;
           }

       }


    }
}
