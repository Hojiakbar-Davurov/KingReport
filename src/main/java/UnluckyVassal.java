import java.util.ArrayList;
import java.util.List;

public class UnluckyVassal {
    private static List<String> pollResults = List.of(
            "служанка Аня",
            "управляющий Семен Семеныч: крестьянин Федя, доярка Нюра",
            "дворянин Кузькин: управляющий Семен Семеныч, жена Кузькина, экономка Лидия Федоровна",
            "экономка Лидия Федоровна: дворник Гена, служанка Аня",
            "доярка Нюра",
            "кот Василий: человеческая особь Катя",
            "дворник Гена: посыльный Тошка",
            "киллер Гена",
            "зажиточный холоп: крестьянка Таня",
            "секретарь короля: зажиточный холоп, шпион Т",
            "шпион Т: кучер Д",
            "посыльный Тошка: кот Василий",
            "аристократ Клаус",
            "просветленный Антон"
    );

    List<String> result = new ArrayList<>();


    public void printReportForKing(List<String> pollResults) {

        //find assistantKing
        int i = 0;
        for (String pollResult : pollResults) {
            String kingAssistant = pollResult.contains(":") ? pollResult.substring(0, pollResult.indexOf(":")) : pollResult;
            for (String result : pollResults) {
                if (result.contains(kingAssistant)) {
                    i++;
                }
            }
            if (i == 1) result.add(kingAssistant);
            i = 0;
        }

        

        for (String s : result) {
            System.out.println(s);
        }
    }
}
