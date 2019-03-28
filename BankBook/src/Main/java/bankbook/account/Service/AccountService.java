package Main.java.bankbook.account.Service;

import Main.java.bankbook.LinkSystem.LinkSystem;
import Main.java.bankbook.account.model.Account;
import Main.java.bankbook.account.repositoryOfAccount.AccountRepository;
import Main.java.bankbook.common.util.ScannerService;
import Main.java.bankbook.common.view.ConsoleView;
import Main.java.bankbook.member.model.Member;

import java.util.*;

public class AccountService {


    Account account;

    LinkSystem linkSystem = new LinkSystem();

    private AccountRepository accountRepository;

    public AccountService() {
        accountRepository = new AccountRepository();
    }


    public void AccountLookInto(Member member) {
        List<Account> accountList = accountRepository.getAllAccountOfAccountDataFile();
        List<Account> accountOfMember = new ArrayList<>();

        account = linkSystem.MemberLinkAccount(member);
        int selectNumber = 0;
        do {
            if (!account.existAccount()) {
                System.out.println("계좌가 존재하지 않습니다.");
                break;
            }
            /**
             계좌가 있으면 그 계좌정보를 accountList에 담기
             계좌가 없으면 위의 account.existAccount에서 break; 됨.
             */

            for (Account accountCheckData : accountList) {
                if (member.getName().equals(accountCheckData.getName())) {
                    accountOfMember.add(accountCheckData);
                }
            }


            /**
             member의 모든 계좌를 출력창에 띄어줌
             */
            System.out.println("조회하고싶은 계좌의 계좌번호를 입력해주세요" + " 뒤로가기를 원하시면 -1을 입력해주세요");
            for (int i = 0; i < accountOfMember.size(); i++) {
                System.out.print(i + 1 + ". 계좌번호 = " + accountOfMember.get(i).getAccountNumber() + " " + "\n");
            }

            int choiceNumber = ScannerService.getScanner().nextInt();


            /**
             해당 계좌번호를 입력하면 그 계좌의 정보를 띄어준다
             */
            for (Account accountCheckData : accountList) {
                if (choiceNumber == accountCheckData.getAccountNumber()) {
                    System.out.println("계좌번호 = " + accountCheckData.getAccountNumber());
                    System.out.println("이름 = " + accountCheckData.getName());
                    System.out.println("잔고 = " + accountCheckData.getBalance());
                    System.out.println();
                    selectNumber = -1;
                }
            }


        } while (selectNumber > 0);
    }

    public void produceAccount(Member member) {

        int accountNumber;
        Random rand = new Random();
        do {
            accountNumber = rand.nextInt();

        } while (accountNumber < 0);
        account = new Account(accountNumber, member.getName());

        accountRepository.insertAccount(account);
        System.out.println("생성된 계좌의 계좌번호는 = " + accountNumber + " 입니다.");
    }


    public void AccountManagement(Member member) {

        ConsoleView.startAccountManagementMenu();

        int selectNumber = ScannerService.getScanner().nextInt();
        if (selectNumber == 1) {
            System.out.println("수취인의 계좌번호를 입력해주세요");
            int toAccountNumber = ScannerService.getScanner().nextInt();
            if (!accountRepository.existAccountNumber(toAccountNumber)) {
                System.out.println("존재하지 않는 계좌번호입니다.");
            } else {
                account = accountRepository.getAccount(toAccountNumber);
                System.out.println("얼마를 입금하시겠습니까?");
                double amount = ScannerService.getScanner().nextDouble();
                if (amount < 0) {
                    System.out.println("0원 미만의 돈은 입금할 수 없습니다.");
                }
                deposit(account, amount);
                accountRepository.insertUpdatedAccount(account);
            }

        }
        if (selectNumber == 2) {
            //withdraw();

            System.out.println("출금하고자 하는 계좌번호를 입력해주세요");
            int accountNumber = ScannerService.getScanner().nextInt();

            account = accountRepository.getAccount(accountNumber);
            if (!account.existAccount()) {
                System.out.println("존재하지 않는 계좌입니다.");
            }

            if (member.getName().equals(account.getName())) {
                System.out.println("얼마를 출금하시겠습니까?");
                System.out.print("출금금액 = ");
                double amount = ScannerService.getScanner().nextDouble();
                if (amount > account.getBalance()) {
                    System.out.println("돈이 부족합니다.");
                } else {
                    account.setBalance(account.getBalance() - amount);
                    System.out.println("출금에 성공하였습니다.");
                    accountRepository.insertUpdatedAccount(account);
                }
            }

        }
    }

    public void deposit(Account toAccount, double amount) {

        toAccount.setBalance(toAccount.getBalance() + amount);
        System.out.println("입금에 성공하였습니다");

    }

    public void withdraw(Account toAccount, double amount) {
        toAccount.setBalance(toAccount.getBalance() - amount);
        System.out.println("출금에 성공하였습니다.");
    }

}
