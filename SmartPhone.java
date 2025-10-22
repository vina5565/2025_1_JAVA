class SmartPhoneSet {
    // 상태(필드)
    String owner;
    int battery = 100;

    // 어플 배열로 관리
    final String[] apps = new String[5];
    int appCount = 0;

    // 클래스(정적) 상태
    static int deviceCount = 0;

    //생성자
    SmartPhoneSet(String owner) {
        this.owner = owner;
        deviceCount++;
    }

    // 행동(메서드)
    public void call (String phoneNumber) {
        if (battery < 5) {
            System.out.println("전화 실패. 배터리가 부족합니다.");
            return;
        }
        System.out.println(owner + "님이 " + phoneNumber + "에 전화 중...");
        battery -= 5;
    }
    public void install(String appName) {
        if (appCount >= apps.length) {
            System.out.println("[설치 실패] 앱 슬롯이 가득 찼습니다.");
            return;
        }
        apps[appCount++] = appName;
        System.out.println(owner + "님의 핸드폰에 " + appName + " 설치 완료 (" + appCount + "/" + apps.length + ")");
    }
    public void charge(int amount) {
        battery = Math.min(100, battery + amount);
        System.out.println("충전 후 배터리 : " + battery + "%");
    }
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }
    public int getBattery() { return battery; }
    public int getAppCount() { return appCount; }

    // 클래스(정적) 메서드/필드 - 객체 없이 호출
    public static int getDeviceCount() { return deviceCount; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SmartPhoneSet {owner = '").append(owner)
                .append("', battery = ").append(battery)
                .append(", apps = [");
        for (int i = 0; i < appCount; i++) {
            if (i > 0) sb.append(", ");
            sb.append(apps[i]);
        }
        sb.append("]}");
        return sb.toString();
    }

}

public class SmartPhone {
    public static void main(String[] args) {
        //객체(인스턴스) 생성
        SmartPhoneSet p1 = new SmartPhoneSet("수빈");
        SmartPhoneSet p2 = new SmartPhoneSet("민수");

        p1.install("KakaoTalk");
        p1.call("010-1234-5678");
        p1.charge(5);

        p2.install("YouTube");
        p2.call("02-000-0000");

        System.out.println(p1);
        System.out.println(p2);

        System.out.println("생성된 기기 수: " + SmartPhoneSet.getDeviceCount()); // static

    }
}


