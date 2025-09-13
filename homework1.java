import java.util.Scanner;

public class honework1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = new int[5];

        int sum = 0;

        for (int i = 0; i < 5; i ++)  {
            System.out.printf("정수를 입력하세요 : ");
            arr[i] = sc.nextInt();  // int arr[i] (x)
            sum += arr[i];
            System.out.printf("현재까지 입력된 정수의 합은 %d입니다.\n", sum);

        }

    }
}
