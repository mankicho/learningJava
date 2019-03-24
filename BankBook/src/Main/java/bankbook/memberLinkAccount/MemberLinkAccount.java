package Main.java.bankbook.memberLinkAccount;

import Main.java.bankbook.account.Account;
import Main.java.bankbook.account.repositoryOfAccount.AccountRepository;
import Main.java.bankbook.member.model.Member;
import Main.java.bankbook.member.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

public class MemberLinkAccount {
    AccountRepository accountRepository = new AccountRepository();

    //ACcount의 정보와 Member의 정보 Name이 같으면 계좌정보 돌려주기
    List<Account> accountListOfMember = accountRepository.getAllAccountsInFile();

    // 계좌 txt파일을 쭉읽어서 같은이름이 있으면 그 계좌정보를 리턴.
    public Account memberLinkAccount(Member AccountOwner) {

        for (Account account : accountListOfMember) {
            if (AccountOwner.getName().equals(account.getName())) {
                return account;
            }
        }
        return new Account();
    }
}
