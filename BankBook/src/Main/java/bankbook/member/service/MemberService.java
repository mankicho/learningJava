package Main.java.bankbook.member.service;

import Main.java.bankbook.common.util.ScannerService;
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

    public boolean existId(String id) {
        return memberRepository.exist(id);
    }




      //아이디 비밀번호가 맞는지?
    public boolean memberLogin(String id, String password){
        boolean success = true;
        int memberExistCount = 0;
        for(int i=0;i<memberRepository.getAllMembersInFile().size();i++){

            if(memberRepository.exist(id)&&password.equals(memberRepository.getAllMembersInFile().get(i).getPassword())){
                System.out.println("로그인 되셨습니다.");
                memberExistCount++;
                success = true;

            }
            success = false;
        }
        if(memberExistCount ==0){
            System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
        }
        return success;
    }
}
