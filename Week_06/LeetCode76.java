import java.util.*;
import java.util.stream.Collectors;

public class LeetCode76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        Map<Character, Integer> tMap = new HashMap();
        for (int m=0; m < t.length(); m++) {
            tMap.put(t.charAt(m), tMap.get(t.charAt(m)) == null ? 1 : tMap.get(t.charAt(m))+1);
        }
        Deque<Character> deque = new ArrayDeque<>(s.length());
        int cnt = t.length();
        int minWindowLength = s.length()+1;
        String ret="";
        for (int n=0; n<s.length(); n++) {
            deque.add(s.charAt(n));
            if (tMap.containsKey(s.charAt(n))) {
                int charCnt = tMap.get(s.charAt(n))-1;
                if (charCnt >= 0) cnt--;
                tMap.put(s.charAt(n), charCnt);
            }
            while (cnt==0) {
                if (minWindowLength > deque.size()) {
                    minWindowLength = deque.size();
                    StringBuilder sb = new StringBuilder();
                    deque.forEach(sb::append);
                    ret = sb.toString();
                }
                Character c = deque.poll();
                if (tMap.containsKey(c)) {
                    int charCnt = tMap.get(c)+1;
                    if (charCnt > 0) cnt++;
                    tMap.put(c, charCnt);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";
//        String S = "abbcad";
//        String T = "abc";
//        String S = "aa";
//        String T = "aa";

        System.out.println(new LeetCode76().minWindow(S, T));
    }
}
