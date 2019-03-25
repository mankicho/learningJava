package Main.java.bankbook.account.Service;

import Main.java.bankbook.LinkSystem.LinkSystem;
import Main.java.bankbook.account.model.Account;
import Main.java.bankbook.account.repositoryOfAccount.AccountRepository;
import Main.java.bankbook.member.model.Member;

public class AccountService {

    Account account;

    LinkSystem linkSystem = new LinkSystem();

    private AccountRepository accountRepository;

    public AccountService(){
        accountRepository = new AccountRepository();
    }

    public void AccountLookInto(Member member){
        account = linkSystem.MemberLinkAccount(member);
        if(!account.existAccount()) {
            System.out.println("계좌가 존재하지 않습니다.");
        }
        System.out.println("계좌번호 = " + account.getAccountNumber());
        System.out.println("계좌소유자 = " + account.getName());
        System.out.println("잔고 = " + account.getBalance());
        System.out.println();
    }
}
