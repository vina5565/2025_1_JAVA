#include <stdio.h>

// 최대값 판별
int largest_num(int x, int y, int z) {
	if (x >= y && x >= z)
		return x;
	else if (y >= x && y >= z)
		return y;
	else
		return z;
}

// 삼각형 판별
int can_triangle(int a, int b, int c) {
	int largest = largest_num(a, b, c);
	int sumoftwo = a + b + c - largest;

	return largest < sumoftwo;
}

int main(void) {

	for (int i = 0; i < 3; i++) {

		int one, two, three;

		printf("양의 정수 3개를 입력하세요 : ");
		scanf_s("%d %d %d", &one, &two, &three);

		if (!can_triangle(one, two, three)) {
			printf("삼각형이 될 수 없습니다.\n");
			continue;
		}

		// 최대값과 나머지 값 변수 저장
		int largest = largest_num(one, two, three);
		int side1, side2;

		if (largest == one) {
			side1 = two;
			side2 = three;
		}
		else if (largest == two) {
			side1 = one;
			side2 = three;
		}
		else {
			side1 = one;
			side2 = two;
		}

		if (one == two && two == three) {
			printf("정삼각형입니다.\n");
		}
		else if (largest * largest == side1 * side1 + side2 * side2) {
			printf("직각삼각형입니다.\n");
		}
		else if (one == two || two == three || one == three) {
			printf("이등변삼각형입니다.\n");
		}
		else {
			printf("일반 삼각형입니다.\n");
		}

	}

	return 0;
}