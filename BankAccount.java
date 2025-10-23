import java.util.Scanner;
import java.util.Random;

class BankSystem {
    String accountNum, owner;
    long balance;
    // 입력 저장할 필드 생성

    // 생성자
    public BankSystem(String owner, long balance, String accountNum) {
        this.owner = owner;
        this.balance = balance;
        this.accountNum = accountNum;
    }

    public void deposit(long amount) {
        if (amount <= 0) {
            System.out.println("입금액은 양수여야합니다.");
            return;
        }
        balance += amount;
        System.out.println(owner + "님의 계좌에 " + amount + "원 입금되었습니다.");
    }
    public void withdraw(long amount) {
            if (amount <= 0) {
                System.out.println("출금액은 양수여야합니다.");
                return;
            }
            if (balance < amount) {
                System.out.println("잔액이 부족합니다.");
                return;
            }
            balance -= amount;
            System.out.println(owner + "님의 계좌에서 " + amount + "원 출금되었습니다.");
    }

    public String getOwner() { return owner; }
    public long getBalance() {return balance; }
    public String getAccountNum() { return accountNum; }
}

class AccountSystem {
    String accountNumber;
    BankSystem[] accounts = new BankSystem[5];
    int size = 0;

    public AccountSystem() {
        this.accountNumber = generateAccountNumber();
    }

    // 계죄번호 생성 함수
    public String generateAccountNumber() {
        Random rand = new Random();
        while (true) {
            int num1 = rand.nextInt(999) + 1;
            int num2 = rand.nextInt(999) + 1;
            int num3 = rand.nextInt(999) + 1;
            String acc = String.format("%03d-%03d-%03d", num1, num2, num3);
            if (findAccount(acc) == null) return acc;
        }
    }

    // 계좌 생성함수
    public void createAccount(Scanner sc) {
        if (size >= accounts.length) {
            System.out.println("더 이상 계좌를 생성할 수 없습니다.");
            return;
        }
        System.out.print("소유자 이름 > ");
        String name = sc.nextLine().trim();
        System.out.print("초기 잔액(생략 = 0) > ");
        String balLine = sc.nextLine().trim();
        String cleaned = balLine.replaceAll("[,\\s]",""); // balLine의 콤마를 전부 없애는 메서드 + 그걸 저장하는 변수
        long balance = 0L; // 기본값 = 0원
        if (!cleaned.isEmpty()) {
            balance = Long.parseLong(cleaned);
            if (balance < 0) balance = 0L;
        }
        String accNum = generateAccountNumber(); // 계좌번호 생성 함수 호출, AccNum에 저장
        BankSystem newaccount = new BankSystem(name, balance, accNum); // 사용자 입력대로 이름, 잔액 생성
        accounts[size++] = newaccount; // 배열에 계좌 넣기
        System.out.println("'" + name + "'" + "님의 계좌번호는 " + accNum + " 입니다.");
        // 객체의 계좌번호 사용
    }
    public BankSystem findAccount(String accountNum) {
        for (int i = 0; i < size; i++) {
            if (accounts[i] != null && accounts[i].getAccountNum().equals(accountNum)) {
                return accounts[i];
            }
        }
        return null;
    }
    public void showTotalAssets() {
        long total = 0L;
        for (int i = 0; i < size; i++) {
            if (accounts[i] != null) total += accounts[i].getBalance();
        }
        System.out.println("현재 은행 총 자산: " + total + "원");
    }
    public void showAllAccounts() {
        if (size == 0) {
            System.out.println("등록된 계좌가 없습니다.");
            return;
        }
        System.out.println("=== 전체 계좌 목록 ===");
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + accounts[i]);
        }
    }

    public String getAccountNumber() { return accountNumber; }

}

public class BankAccount {
    public static void main(String[] args) {
        // 객체 인스턴스 생성
        AccountSystem accountSystem = new AccountSystem();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 메뉴 ===\n" +
                "1. 계좌 생성\n" +
                "2. 입금\n" +
                "3. 출금\n" +
                "4. 계좌 조회\n" +
                "5. 전체 은행 자산\n" +
                "6. 종료\n");

        while (true) {
            System.out.print("선택 > ");
            String choice = sc.next();

            if (choice.equals("1")) {
                sc.nextLine(); // 버퍼 비우기
                accountSystem.createAccount(sc); // 계좌 생성 멤버 함수 호출
            }
            else if (choice.equals(("2"))) {
                sc.nextLine(); // 버퍼 비우기
            }
            else if (choice.equals(("3"))) {
                sc.nextLine(); // 버퍼 비우기
            }
            else if (choice.equals(("4"))) {
                sc.nextLine(); // 버퍼 비우기
            }
            else if (choice.equals(("5"))) {
                sc.nextLine(); // 버퍼 비우기
                accountSystem.showAllAccounts();
            }
            else if (choice.equals("6")) {
                System.out.print("종료합니다.");
                break;
            } else {
                System.out.print("잘못된 선택입니다.\n");
            }
        }
    }
}

