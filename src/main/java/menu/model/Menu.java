package menu.model;

import java.util.Arrays;
import java.util.List;

public enum Menu {

    JAPANESE("일식", Arrays.asList("규동","우동","미소시루","스시","가츠동","오니기리","하이라이스","라멘","오코노미야끼")),
    KOREA("한식", Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINA("중식", Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIA("아시안", Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플", "볶음밥", "쌀국수", "똠얌꿍", "반미", "월날쌈", "분짜")),
    USA("양식", Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파나니"));
    private String name;
    private List<String> menu;

    Menu(String name, List<String> menu) {
        this.name = name;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public List<String> getMenu() {
        return menu;
    }
}
