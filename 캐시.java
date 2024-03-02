import java.util.*;
public class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        ArrayList<String> cache = new ArrayList<>();
        for (int i = 0; i < cities.length; i++) {
            String s = cities[i].toUpperCase();
            if (cache.contains(s)) {
                cache.remove(s);
                cache.add(s);
                answer += 1;
            }
            else{
                if (cache.size() >= cacheSize) {
                    cache.remove(0);
                }
                cache.add(s);
                answer += 5;
            }
        }

        return answer;
    }
}
