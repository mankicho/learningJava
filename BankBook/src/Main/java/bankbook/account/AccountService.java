package Main.java.bankbook.account;

import Main.java.bankbook.account.repositoryOfAccount.AccountRepository;
import Main.java.bankbook.common.util.ScannerService;
import Main.java.bankbook.common.view.AccountView;
import Main.java.bankbook.member.model.Member;
import Main.java.bankbook.member.repository.MemberRepository;
import Main.java.bankbook.memberLinkAccount.MemberLinkAccount;

import java.util.List;

public class AccountService {
    MemberLinkAccount memberLinkAccount = new MemberLinkAccount();
    AccountRepository accountRepository;
    Account account = new Account();
    int accountNumber = 0;
    int selectNumber;

    public AccountService() {
        accountRepository = new AccountRepository();
    }

    MemberRepository memberRepository = new MemberRepository();


    public void checkAccount(Member member) {
        do {

            account = memberLinkAccount.memberLinkAccount(member);
            // sout 부분은 메뉴서비스가 담당할 부분이다.
            //멤버파일의 id와 account파일의 id가 같으면
            System.out.println("1.잔고확인  2.거래내역 3. 종료시 -1입력");
            selectNumber = ScannerService.getScanner().nextInt();
            if (selectNumber == 1) {
                System.out.println(member.getName() + " 통장에" + account.getBalance() + "원이 남아있어.");
            }
            if (selectNumber == 2) {

            }
            if (selectNumber < 0) {
                System.out.println("종료되었습니다.");
            }
        } while (selectNumber > 0);
    }

    public void transactionDetails() {

    }

    //멤버 치면 멤버의 id와 name을 Account 형식으로 바꿔주기
    public Account AccountProduce(Member member) {

        System.out.println("생성할 계좌의 번호를 설정해주세요");
        account.setAccountNumber(ScannerService.getScanner().nextInt());

        System.out.println("계좌가 생성되었습니다.");
        account = new Account(member.getId(), member.getName(), account.getAccountNumber());

        return accountRepository.insertAccount(account);

    }

    public void deposit() {

        System.out.println("입금하실 분의 이름과 계좌번호를 입력해주세요");
        System.out.print("받는사람 이름 : ");
        String name = ScannerService.getScanner().next();
        System.out.print("계좌번호 : ");
        accountNumber = ScannerService.getScanner().nextInt();

        List<Account> accountList = accountRepository.getAllAccountsInFile();

        for (Account account : accountList) {
            if (account.getName().equals(name) && account.getAccountNumber() == accountNumber) {
                System.out.println("얼마 입금하시겠습니까");
                double depositAmount = ScannerService.getScanner().nextDouble();
                System.out.println("입금 완료되었습니다.");
                account.setBalance(account.getBalance() + depositAmount);
                accountRepository.insertAccount(account);
                System.out.println(account.getAccountNumber());

            }
        }

    }
}


