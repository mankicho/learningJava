package Main.java.bankbook.member.repository;

import Main.java.bankbook.common.util.ScannerService;
import Main.java.bankbook.member.model.Member;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberRepository {
    private static final String MEMBER_FILE_PATH = "C:\\Users\\82102\\Desktop\\dev\\learningJava\\BankBook\\src\\Main\\resource\\member "; // 절대경로 주소 바뀌지 않음 > 상수
    private static final String SEPARATOR = " "; // 값을 구분하는 구분자 안바뀜 > 상수
    BufferedWriter bufferedWriter;
    private Scanner scanner;
    private FileWriter fileWriter;

    public MemberRepository() {
        scanner = ScannerService.getFileScanner(MEMBER_FILE_PATH);
    }

    public void openWrite() {
        try {
            // 여기 어디에 선언이 있어 왜 위에 선언하고 여기서 초기화하냐
            // 왜냐면 이걸 쓰는건 이 메소드가 아니고 밖이니까
            fileWriter = new FileWriter(new File(MEMBER_FILE_PATH), true); // appendMode라는건 이어쓰기 할거냐 라는거

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 멤버 DB에서는 같은 아이디 비번이 있으면 그 멤버객체를 뺴줘, 없으면 빈값을 내보내
    public Member selectMember(String id, String password) {
        List<Member> memberList = getAllMembersInFile();
        for (Member member : memberList) {
            if (member.getId().equals(id) && member.getPassword().equals(password)) {

                return member;
            }
        }
        return new Member();
    }

    public List<Member> getAllMembersInFile() {
        List<Member> memberList = new ArrayList<>(); // 돌려줄 회원데이터 모음집

        while (scanner.hasNext()) { // 파일에 정보가 있을때까지 조회
            String readLine = scanner.nextLine(); // 첫번째 줄 조회 > "kiuisu 1234 김의석"
            String[] memberDataStringArray = readLine.split(SEPARATOR); // 읽어온 데이터 분해 String[] "kiuisu" "1234" "김의석"

            if (memberDataStringArray.length != 3) { // 데이터 이상 있는지 체크
                // DB에 이상한 값이 있는거임
                continue;
            }

            // 이상한거 없으면 DB에서 읽어온 한 줄의 회원정보로 회원데이터생성 (parsing)
            Member readMember = new Member(memberDataStringArray[0], memberDataStringArray[1], memberDataStringArray[2]); //변환
            // txt 1줄 -> 자바 객체로 >>>>>>> 데이터베이스에서 한줄 읽은 데이터를 -> 자바 객체로
            memberList.add(readMember);
        }

        return memberList;
    }
    public Member insertMember(Member member) {
        try {
            openWrite();              //파일에 write 하려는게 빈값이다.
            bufferedWriter.write(member.convert2TextData()+"\n");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return member;
    }


    /**
     * 회원이 존재하는지 여부 확인
     **/
    public boolean exist(String id) {
        List<Member> memberList = getAllMembersInFile(); // txt파일에 있는 가입멤버정보를 전부다 돌려줌

        for (Member member : memberList) {
            if (id.equals(member.getId())) {
                return true;
            }
        }

        return false;
    }
}

// TODO 1. 회원정보 조회(단건) Member selectMember(String id, String password);
// TODO 2. 회원 가입(insert)는 같이 할거임