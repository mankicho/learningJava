package Main.java.bankbook.member.service;

import Main.java.bankbook.common.util.ScannerService;
import Main.java.bankbook.common.view.consoleView;
import Main.java.bankbook.member.model.Member;
import Main.java.bankbook.member.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

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

    public boolean checkedIDPassword(String id, String password){
        List<Member> memberList = memberRepository.getAllMembersInFile();
        for(Member member : memberList){
            if(id.equals(member.getId())&&password.equals(member.getPassword())){
                return true;
            }
            if(id.equals(member.getId())&&!password.equals(member.getPassword())){
            }
        }
        return false;
    }

    public boolean loginSuccess(String id,String password){
        if(checkedIDPassword(id,password)){
            return true;
        }
        return false;
    }
}
