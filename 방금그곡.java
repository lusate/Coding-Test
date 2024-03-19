class Solution {
    public int getTime(String time){
        String[] tmp = time.split(":");
        int H = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);
        
        return H * 60 + M;
    }
    
    public String replace_code(String code) {
        code = code.replaceAll("C#", "c");
        code = code.replaceAll("D#", "d");
        code = code.replaceAll("F#", "f");
        code = code.replaceAll("G#", "g");
        code = code.replaceAll("A#", "a");

        return code;
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int max = 0;
        
        for(String musicinfo : musicinfos){
            String[] result = musicinfo.split(",");
            int start = getTime(result[0]);
            int end = getTime(result[1]);

            int dif = end - start;
            
            String replace = replace_code(result[3]);
            
            String code = "";
            int value = dif / replace.length();
            int remain = dif % replace.length();
            while(value > 0){
                code += replace;
                value--;
            }
            
            code += replace.substring(0, remain);
            // System.out.println(code);
            
            if(code.contains(replace_code(m))){
                if(max < dif){
                    max = dif;
                    answer = result[2];
                }
            }
        }
        
        
        return answer;
    }
}
