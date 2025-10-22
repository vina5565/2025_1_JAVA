import java.util.Scanner;

class Student {
    int studentcode;
    String name;
    String major;
    long phonenumber;

    // 생성자, 객체의 초기 상태 설정
    Student(int studentcode, String name, String major, long phonenumber) {
        this.studentcode = studentcode;
        this.name = name;
        this.major = major;
        this.phonenumber = phonenumber;
    }

    // get() = 필드(변수)값을 읽어오는 매서드
    // set() = 갹체의 속성값을 변경
    int getStudentCode() { return studentcode; }
    void setStudentCode(int studentcode) { this.studentcode = studentcode; }
    String getName() { return name; }
    void setName(String name) { this.name = name; }
    String getMajor() { return major; }
    void setMajor(String major) { this.major = major; }
    long getPhoneNumber() { return phonenumber; }
    void setPhoneNumber(long phonenumber) { this.phonenumber = phonenumber; }

    String getFormattedPhoneNumber() {
        String pnStr = Long.toString(phonenumber);

        if(pnStr.length() < 11) {
            pnStr = "0" + pnStr;
        }

        String first = pnStr.substring(0, 3);
        String middle = pnStr.substring(3, 7);
        String last = pnStr.substring(7);

        return first + "-" + middle + "-" + last;
    }
}

public class homework2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // 사용자 입력 초기화
        Student[] students = new Student[3]; // 정보 입력할 배열 생성

        for (int i = 0; i < 3; i++) {
            System.out.print("학생의 학번, 이름, 전공, 전화번호를 입력하세요 : "); // 멘트
            int stc = sc.nextInt();
            String na = sc.next();
            String ma = sc.next();
            long pn = sc.nextLong(); // 입력을 stc, na, ma, pn에 저장

            students[i] = new Student(stc, na, ma, pn); // 생성자 호출, 클래스안의 필드 초기화, 입력을 배열에 쌓음
        }
        System.out.println("입력된 학생들의 정보는 다음과 같습니다.");

        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + "번째 학생 : "
                    + students[i].getStudentCode() + " "
                    + students[i].getName() + " "
                    + students[i].getMajor() + " "
                    + students[i].getFormattedPhoneNumber());

        }
    }
}
