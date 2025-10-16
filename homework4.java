import java.util.Scanner;

public class homework4 {

    // 재귀호출 버전의 gcd 함수
    static int gcdRecursive(int m, int n) {
        if (n == 0) return m;           // 종료 조건
        return gcdRecursive(n, m % n);  // 나머지를 이용한 재귀 호출
    }

    // 반복문 버전의 gcd 함수
    static int gcdIterative(int m, int n) {
        while (n != 0) {    // n이 0이 될 때까지 반복
            int temp = n;
            n = m % n;      // m을 n으로 나눈 나머지를 n에 저장
            m = temp;       // n의 이전 값을 m에 저장
        }
        return m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("두 수를 입력하세요: ");
        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println("두 수의 최대공약수는 " + gcdRecursive(m, n) + "입니다.");

        sc.close();
    }
}

