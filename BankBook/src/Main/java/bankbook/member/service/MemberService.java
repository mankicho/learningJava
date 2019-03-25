package Main.java.bankbook.member.service;

import Main.java.bankbook.member.model.Member;
import Main.java.bankbook.member.repository.MemberRepository;

public class MemberService {
    private MemberRepository memberRepository;

    public MemberService() {
        memberRepository = new MemberRepository();
    }

    public Member registerOnTextFile(Member member){
        return memberRepository.insertMember(member);
    }

    public Member getMember(String id, String password) {
        return memberRepository.selectMember(id, password);
    }

    public boolean existId(String id) {
        return memberRepository.exist(id);
    }
}