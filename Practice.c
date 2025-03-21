#include <stdio.h>

const int Ax1 = 50, Ay1 = 50, Ax2 = 100, Ay2 = 100;

int main() {

	int i;
	for (i = 0; i < 3; i++) {

		int Bx1, By1, Bx2, By2;
		printf("임의의 두점(x1, y1), (x2, y2)를 입력해주세요 :");
		scanf_s("%d %d %d %d", &Bx1, &By1, &Bx2, &By2);

		//좌하단 좌표(Bx1,By1), 우상단 좌표(Bx2,By2) Swap
		int temp;
		if (Bx1 > Bx2) { temp = Bx1; Bx1 = Bx2; Bx2 = temp; }
		if (By1 > By2) { temp = By1; By1 = By2; By2 = temp; }

		if (Ax1 <= Bx1 && Ay1 <= By1 && Bx2 <= Ax2 && By2 <= Ay2) {
			printf("사각형A가 사각형 B를 포함합니다.\n");
		}
		else if (Bx1 <= Ax1 && By1 <= Ay1 && Ax2 <= Bx2 && Ay2 <= By2) {
			printf("사각형B가 사각형 A를 포함합니다.\n");
		}
		else if ((Bx1 < Ax2 && Bx2 > Ax1) && (By1 < Ay2 && By2 > Ay1)) {
			printf("사각형 A와 B는 부분적으로 겹칩니다.\n");

		}
		else printf("사각형 A와 B는 겹치지 않습니다.\n");
	}
}