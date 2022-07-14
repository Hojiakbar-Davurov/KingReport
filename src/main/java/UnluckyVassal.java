import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnluckyVassal {
    int countTab = 1;
    List<String> assistantsOnlyKing = new ArrayList<>();

    public void printReportForKing(List<String> pollResults) {

        //show king at first
        System.out.println("король");

        //find and show assistantKing
        int i = 0;
        for (String pollResult : pollResults) {
            String kingAssistant = pollResult.contains(":") ? pollResult.substring(0, pollResult.indexOf(":")) : pollResult;
            for (String result : pollResults) {
                if (result.contains(kingAssistant)) {
                    i++;
                }
            }
            if (i == 1) assistantsOnlyKing.add(kingAssistant);
            i = 0;
        }

        //show inner assistant
        Collections.sort(assistantsOnlyKing);
        for (String s : assistantsOnlyKing) {
            System.out.println("\t" + s);
            findAssistant(s, pollResults);
            countTab--;
        }
    }

    /**
     * this method to show assistant of somebody
     * @param somebody is assistant's boss
     * @param listPeople is all of country's people
     */
    public void findAssistant(String somebody, List<String> listPeople) {
        countTab++;

        //insert into array by ','
        String[] assistants = new String[0];
        for (String pupil : listPeople) {
            if (pupil.contains(somebody + ":")) {
                assistants = pupil.substring(pupil.indexOf(":") + 1).split(",");
                break;
            }
        }

        //show assistant
        Arrays.sort(assistants);
        for (String assistant : assistants) {
            assistant = assistant.trim();
            for (int i = 0; i < countTab; i++) {
                System.out.print("\t");
            }
            System.out.println(assistant);
            findAssistant(assistant, listPeople);
            countTab--;
        }
    }
}
