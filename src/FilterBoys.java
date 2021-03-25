import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterBoys {
    private static final int ADULT = 18;
    private static final int LIMIT = 4;

    private final ArrayList<Boy> boys = new ArrayList<>() {{
        add(new Boy("�������", 68));
        add(new Boy("ϸ��", 53));
        add(new Boy("�������", 25));
        add(new Boy("������", 19));
        add(new Boy("�������", 6));
        add(new Boy("�������", 86));
        add(new Boy("ϸ��", 35));
        add(new Boy("������", 111));
        add(new Boy("�������", 22));
        add(new Boy("������", 1));
        add(new Boy("����", 30));
    }};

    public final void filterBoys() {
        Map<String, Number> map = boys.stream()
                .filter(n -> n.getAge() >= ADULT).map(Boy::getName).
                        distinct().sorted(String::compareTo).limit(LIMIT).
                        collect(Collectors.toMap(
                                k -> k,
                                v -> boys.stream().filter((e) -> e.getName().equals(v)).count() - 1)
                        );
        System.out.println(map.toString());
    }

}