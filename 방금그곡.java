class Solution {
    public int getTime(String time){
        String[] tmp = time.split(":");
        int H = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);
        
        return H * 60 + M;
    }
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = -1;
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
            
            // 실제로 재생된 result에 기억한 멜로디인 m이 포함되고 dif 차이가 0보다 크면
            if(result.contains(m) && dif > maxTime) {
                maxTime = dif; // 조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환
                answer = tmp[2];
            }
        }
        
        return answer;
    }
}
