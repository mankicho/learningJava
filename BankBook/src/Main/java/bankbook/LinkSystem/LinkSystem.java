package Main.java.bankbook.LinkSystem;

import Main.java.bankbook.account.model.Account;
import Main.java.bankbook.account.repositoryOfAccount.AccountRepository;
import Main.java.bankbook.member.model.Member;
import Main.java.bankbook.member.repository.MemberRepository;

import java.util.List;

public class LinkSystem {
    AccountRepository accountRepository = new AccountRepository();
    MemberRepository memberRepository = new MemberRepository();

    public Account MemberLinkAccount(Member member) {
        List<Account> accountList = accountRepository.getAllAccountOfAccountDataFile();
        List<Member> memberList = memberRepository.getAllMembersInFile();


        for (Account account : accountList) {
            if (member.getName().equals(account.getName())){
                return account;
            }
        }
        return new Account();
    }

}
