import java.util.Scanner;

public class homework3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("몇 개의 수를 입력할 예정인가요? ");
        int size = sc.nextInt();
        int[] arr = new int[size]; // 배열의 사이즈를 입력받아 배열 생성

        sc.nextLine(); // 버퍼비우기
        System.out.print("수를 입력하세요 ");
        String num = sc.nextLine(); // 숫자 입력
        String[] tokenNum = num.split("\\s+"); // split으로 나누어 배열 생성
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(tokenNum[i]);
        }

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < size; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        for (int i = 1; i < size; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("최대값 : " + max);
        System.out.println("최소값 : " + min);
    }
}
