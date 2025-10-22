import java.util.Scanner;

class InputText {
    String text; // 입력 저장할 필드 생성
    String[] words;
    // 생성자
    public InputText(String text) {
        this.text = text;
        this.words = text.split(" ");
    }
    // getter
    public String getText() {
        return text;
    }
    public String[] getWords() { return words; }

    public void printText() {
        System.out.println("현재 문자열 : " + text);
    }

    public int getStrCount() {
        return text.length();

    }
    public int getWordCount() {
        return words.length;
    }

    public void updateText() {
        if (words == null || words.length == 0) { this.text = ""; return; }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i] == null) continue;
            String w = words[i].trim();
            if (w.isEmpty()) continue;
            if (sb.length() > 0) sb.append(' ');
            sb.append(w);
        }
        this.text = sb.toString();
    }

}

public class Project1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InputText text = null; // 바깥에서 선언, 외부 블록 접근 허용

        System.out.println("=== 메뉴 ====\n" +
                "i : 문자열 입력\n" +
                "o : 문자열 출력(글자 수, 단어 수 포함)\n" +
                "s : 문자열 찾기\n" +
                "r : 문자열 바꾸기\n" +
                "h : 도움말\n" +
                "e : 종료");
        while (true) {
            System.out.print("선택 : ");
            String input = sc.next().toLowerCase();

            if (input.equals("i")) {
                sc.nextLine(); // 버퍼 비우기
                System.out.print("문자열을 입력하세요 : ");
                String txt = sc.nextLine(); // 사용자의 입력받기
                text = new InputText(txt); // 사용자가 입력한대로 객체 생성
            }
            else if (input.equals("o")) {
                if (text == null) {
                   System.out.println("현재 입력된 문자열이 없습니다. 먼저 문자열을 입력해주세요.");
                }
                else { text.printText();
                System.out.println("글자 수 : " + text.getStrCount());
                System.out.println("단어 수 : " + text.getWordCount());
                }
            }
            else if (input.equals("s")) {
                sc.nextLine(); // 버퍼 비우기
                if (text == null) {
                    System.out.println("현재 입력된 문자열이 없습니다. 먼저 문자열을 입력해주세요.");
                } else {
                    System.out.print("찾을 문자열을 입력하세요 : ");
                    String findstr = sc.next();

                    int count = 0;
                    for (int i = 0; i < text.getWords().length; i++) {
                        if (text.getWords()[i].equals(findstr)) {
                            count++;
                        }
                    }

                    if (count > 0) {
                        System.out.println("'" + findstr + "'" + "이/가 " + count + "회 존재합니다.");
                    } else {
                        System.out.println("문자열을 찾을 수 없습니다.");
                    }
                }
            }
            else if (input.equals("r")) {
                sc.nextLine(); // 버퍼 비우기
                if (text == null) {
                    System.out.println("현재 입력된 문자열이 없습니다. 먼저 문자열을 입력해주세요.");
                }
                else {
                    System.out.print("찾을 문자열을 입력하세요 : ");
                    String changedstr = sc.next();
                    System.out.print("바꿀 문자열을 입력하세요 : ");
                    String changestr = sc.next();
                    for (int i = 0; i < text.getWords().length; i++) {
                        if (text.getWords()[i].equals(changedstr)) {
                            text.getWords()[i] = changestr;
                        }
                    }
                    text.updateText();
                    System.out.print("변경된 문자열 : ");
                    text.printText();
                }
            }
            else if (input.equals("h")) {
                System.out.println("=== 메뉴 ====\n" +
                        "i : 문자열 입력\n" +
                        "o : 문자열 출력(글자 수, 단어 수 포함)\n" +
                        "s : 문자열 찾기\n" +
                        "r : 문자열 바꾸기\n" +
                        "h : 도움말\n" +
                        "e : 종료");
            }
            else if (input.equals("e")) {
                break;
            }
            else { System.out.print("잘못된 선택입니다.\n");
            }
        }

    }
}