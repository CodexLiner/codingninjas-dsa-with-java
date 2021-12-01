package lec_10_hashmaps.assign;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/*Extract Unique characters
        Send Feedback
        Given a string S, you need to remove all the duplicates. That means, the output string should contain each character only once. The respective order of characters should remain same, as in the input string.
        Input format:
        The first and only line of input contains a string, that denotes the value of S.
        Output format :
        The first and only line of output contains the updated string, as described in the task.
        Constraints :
        0 <= Length of S <= 10^8
        Time Limit: 1 sec
        Sample Input 1 :
        ababacd
        Sample Output 1 :
        abcd
        Sample Input 2 :
        abcde
        Sample Output 2 :
        abcde*/
public class extract_unique {
    public static String uniqueChar(String str){
        Map<Character , Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i) , i);
            }
        }
        Set<Character> set  = map.keySet();
        StringBuilder ss = new StringBuilder();
        for (char c : set){
            ss.append(c);
        }
        return ss.toString();
    }
}
