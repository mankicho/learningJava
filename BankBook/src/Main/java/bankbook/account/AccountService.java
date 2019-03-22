package Main.java.bankbook.account;

import Main.java.bankbook.account.repositoryOfAccount.AccountRepository;
import Main.java.bankbook.common.util.ScannerService;
import Main.java.bankbook.common.view.AccountView;
import Main.java.bankbook.member.model.Member;
import Main.java.bankbook.member.repository.MemberRepository;
import Main.java.bankbook.memberLinkAccount.MemberLinkAccount;

public class AccountService {
    MemberLinkAccount memberLinkAccount = new MemberLinkAccount();
    AccountRepository accountRepository;
    public AccountService(){
        accountRepository = new AccountRepository();
    }

    MemberRepository memberRepository = new MemberRepository();

    Account account = new Account();
    int selectNumber;

    public void checkAccount(Member member){
       do {

           account = memberLinkAccount.memberLinkAccount(member);

           //멤버파일의 id와 account파일의 id가 같으면
           System.out.println("1.잔고확인  2.거래내역 3. 종료시 -1입력");
           selectNumber = ScannerService.getScanner().nextInt();
           if (selectNumber == 1) {
               System.out.println(member.getName() + " 통장에" + account.getBalance() + "원이 남아있어.");
           }
           if(selectNumber ==2){

           }
           if(selectNumber<0){
               System.out.println("종료되었습니다.");
           }
       }while(selectNumber > 0);
    }

    public void transactionDetails(){

    }

    // 입금 매소드
//    public boolean deposit(Account toAccount){
//        boolean success = true;
//        System.out.println("얼마 입금할래?");
//        double depositAmount = ScannerService.getScanner().nextDouble();
//        if(depositAmount >0) {
//            System.out.println(depositAmount + "원 입금하였습니다");
//            account.getBalance() = account.getBalance() - depositAmount;
//            toAccount.balance = toAccount.balance + depositAmount;
//            success = true;
//        }
//        else{
//            System.out.println("0원 이하로는 입금할 수 없습니다.");
//            success = false;
//        }
//        return success;
//    }
}


