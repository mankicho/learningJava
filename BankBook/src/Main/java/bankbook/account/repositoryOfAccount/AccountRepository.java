package Main.java.bankbook.account.repositoryOfAccount;

import Main.java.bankbook.account.Account;
import Main.java.bankbook.common.util.ScannerService;


import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountRepository {
    private BufferedWriter bufferedWriter; // BufferedWriter
    private static final String ACCOUNT_FILE_PATH = "C:\\Users\\82102\\Desktop\\dev\\learningJava\\BankBook\\src\\Main\\java\\bankbook\\account\\dataFile";
    private static final String SEPARATOR = " ";
    private Scanner scanner;

    private FileWriter filewriter;



    public void openWriter() {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File(ACCOUNT_FILE_PATH), true)); // 여기
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // data파일에서 계좌정보 읽어와서  AccountList라는 통에 담기.
    public List<Account> getAllAccountsInFile() {
        scanner = ScannerService.getFileScanner(ACCOUNT_FILE_PATH);
        List<Account> AccountList = new ArrayList<>(); // 돌려줄 회원데이터 모음집

        while (scanner.hasNext()) { // 파일에 정보가 있을때까지 조회
            String readLine = scanner.nextLine(); // 첫번째 줄 조회 > "kiuisu 1234 김의석"
            String[] AccountDataStringArray = readLine.split(SEPARATOR); // 읽어온 데이터 분해 String[] "kiuisu" "1234" "김의석"

            if (AccountDataStringArray.length != 3) { // 데이터 이상 있는지 체크
                // DB에 이상한 값이 있는거임
                continue;
            }

            // 이상한거 없으면 DB에서 읽어온 한 줄의 회원정보로 회원데이터생성 (parsing)
            Account readAccount = new Account(AccountDataStringArray[0], AccountDataStringArray[1], AccountDataStringArray[2]); //변환
            // txt 1줄 -> 자바 객체로 >>>>>>> 데이터베이스에서 한줄 읽은 데이터를 -> 자바 객체로
            AccountList.add(readAccount);
        }

        return AccountList;
    }

    //입력한 값을 datafile에 맞는 형식으로 쓰고 실제로 파일에 입력 후 닫기.
    public Account insertAccount(Account account) {
    try{
        openWriter();
        bufferedWriter.write(account.convertToDataFile());
        bufferedWriter.flush();
        bufferedWriter.close();
    }catch(IOException e){
        e.printStackTrace();
    }
 return account;
    }
}

