package Main.java.bankbook.account.repositoryOfAccount;


import Main.java.bankbook.common.util.ScannerService;

public class asd {

    public static void main(String[] args) {

        int count = 0;
        int rowCount = 0;
        String space = "       ";


        for (int i = 1; i <= 9; i=i+count) {

            for (int j = 1; j <= 9; j++) {
                if (i == 4) {
                    i++;
                }
                if(i==1){
                    System.out.println(i + " * " + j + " = " + i*j);
                }
                for (int k = 0; k <= count; k++) {
                    if ((i+k) * j < 10) {
                        System.out.print((i+k) + " * " + j + " = " +(i+k) * j + " ");
                        System.out.print(space);
//                        System.out.println((i + 1) + "*" + j + " = " + (i + 1) * j);
                    } else {
                        System.out.print((i+k) + " * " + j + " = " + (i+k) * j);
                        System.out.print(space);
                        // System.out.println((i + 1) + "*" + j + " = " + (i + 1) * j);
                    }
                }
                System.out.println();
            }
            count++;

            System.out.println();
        }


    }


}






