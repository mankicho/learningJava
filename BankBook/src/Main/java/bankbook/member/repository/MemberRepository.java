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

    private BufferedWriter bufferedWriter; // BufferedWriter
    private static final String MEMBER_FILE_PATH = "C:\\Users\\82102\\IdeaProjects\\untitled6\\src\\Main\\resource\\member";
    private static final String SEPARATOR = " ";
    private Scanner scanner;

    private FileWriter fileWriter;

    public MemberRepository() {

    }

    public void openWriter() {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File(MEMBER_FILE_PATH), true)); // 여기
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public Member insertMember(Member member) {

        try {
            openWriter(); // 파일에 쓸 툴을 오픈
            bufferedWriter.write(member.convert2TextData()); // 데이터를 씀
            bufferedWriter.flush(); // 파일에 실제로 씀
            bufferedWriter.close(); // 파일 툴 닫음
        } catch (IOException e) {
            e.printStackTrace();
        }

        return member;
    }


    public List<Member> getAllMembersInFile() {
        scanner = ScannerService.getFileScanner(MEMBER_FILE_PATH);
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

        //DB에서 꺼내오면 꺼내온거를 loginMember에 저장.
    // 파라미터 입력하는곳에 실제변수넣어도 의미없잖아.
    // Member member1 = new Member(idInput,passwordInput)
    public Member selectMember(String id, String password){
        //리스트로 해서 선언후 텍스트파일을 넣어주고
        //아이디와 패스워드가 같으면 그 부분만 빼준다.
    List<Member> memberList = getAllMembersInFile();
    for(Member member : memberList){
        if(id.equals(member.getId()) && password.equals(member.getPassword())){
        return member;
        }

      }
    return new Member();
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