import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String max = "";
        String min = "";
        String subMax = ""; // 현재 M과 K가 어디까지 나왔는지를 확인하면서 숫자를 + 해주기위한 필드
        String subMin = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'M') {
                subMin += "M";
                subMax += "M";
            } else if (str.charAt(i) == 'K') {
                if (subMin.length() > 0) {
                    min += "1";
                    for (int j = 0; j < subMin.length() - 1; j++) {
                        min += "0";
                    }
                    subMin = "";
                }
                min += "5";
                max += "5";

                for (int j = 0; j < subMax.length(); j++) {
                    max += "0";
                }
                subMax = ""; // Max는 K를 만나면 초기화해버리기
            }
        }

        if (subMax != "") {
            for (int i = 0; i < subMax.length(); i++) {
                max += "1";
            }
        }

        if (subMin != "") {
            min += "1";
            for (int i = 0; i < subMin.length() - 1; i++) {
                min += "0";
            }
        }

        System.out.println(max);
        System.out.println(min);
    }
}
