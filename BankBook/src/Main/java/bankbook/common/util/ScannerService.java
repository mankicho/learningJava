package Main.java.bankbook.common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerService {
    public static Scanner getScanner() {
        return new Scanner(System.in); // 매번 새로 생성
    }

    public static Scanner getFileScanner(String filePath) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return scanner;
    }
}