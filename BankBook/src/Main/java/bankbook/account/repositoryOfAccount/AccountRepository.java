package Main.java.bankbook.account.repositoryOfAccount;

import Main.java.bankbook.account.model.Account;
import Main.java.bankbook.common.util.ScannerService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountRepository {
    Account account;
    /**
     * 파일의 경로를 선언하고, 그파일을 읽어오는 함수를 짜기.
     **/
    public static final String ACCOUNT_DATA_FILE = "C:\\Users\\82102\\Desktop\\dev\\learningJava\\BankBook\\src\\Main\\java\\bankbook\\account\\resource\\AccountdataFile";
    public static final String SAPERATE = "  ";
    private BufferedWriter bufferedWriter;

    public void openWriter() {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File(ACCOUNT_DATA_FILE),true));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     텍스트파일에 있는 데이터를 자바 객체에 담아주기
     텍스트파일은 배열형식이기때문에 돌려줄때 배열,
     배열안에 값은 account
     파일을 읽어서 통에 담아두는것이기때문에 파라미터는 필요없다.
     */

    public List<Account> getAllAccountOfAccountDataFile() {
        Scanner scanner = ScannerService.getFileScanner(ACCOUNT_DATA_FILE);
        List<Account> accountList = new ArrayList<>(); // Account 정보를 담을 통

        while(scanner.hasNext()){
            String readData = scanner.nextLine(); //한줄의 데이터를 읽어서 readData에 저장
            String[] data2AccountShape = readData.split(SAPERATE); //데이터를 SAPERATE 단위로 끊어서 "data" "data" "data"형태로 배열선언

            int String2IntData = Integer.parseInt(data2AccountShape[0]);
            double String2DoubleData = Double.parseDouble(data2AccountShape[2]);


            account = new Account(String2IntData, data2AccountShape[1], String2DoubleData);
            accountList.add(account);
        }
        return accountList;
    }


}
