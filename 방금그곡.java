class Solution {
    public int getTime(String time){
        String[] tmp = time.split(":");
        int H = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);
        
        return H * 60 + M;
    }
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = 0;
        m = m.replace("C#", "c")
            .replace("D#", "d")
            .replace("F#", "f")
            .replace("G#", "g")
            .replace("A#", "a");
        System.out.println(m);
        
        for(int i = 0; i < musicinfos.length; i++) {
            String[] tmp = musicinfos[i].split(",");
            
            int start = getTime(tmp[0]);
            int end = getTime(tmp[1]);
            
            int dif = end - start;
            
            tmp[3] = tmp[3].replace("C#", "c")
                            .replace("D#", "d")
                            .replace("F#", "f")
                            .replace("G#", "g")
                            .replace("A#", "a");
            
            String result = tmp[3];
            
            int value = dif / tmp[3].length();
            int remain = dif % tmp[3].length();

            if(dif <= tmp[3].length()) {
                result = tmp[3].substring(0, dif);
            }
            else {
                while(value > 0){
                    result += tmp[3];
                    value--;
                }
                // for(int j = 0; j < value; j++) {
                //     result += tmp[3];
                // }
                result += tmp[3].substring(0, remain);
            }
            
            if(result.contains(m) && dif > maxTime) {
                maxTime = dif;
                answer = tmp[2];
            }
        }
        
        return answer;
    }
}
