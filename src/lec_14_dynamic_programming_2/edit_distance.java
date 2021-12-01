package lec_14_dynamic_programming_2;
/*Code: Edit Distance
        Send Feedback
        Given two strings s and t of lengths m and n respectively, find the edit distance between the strings.
        Edit Distance
        Edit Distance of two strings is minimum number of operations required to make one string equal to other. In order to do so you can perform any of the following three operations only :
        1. Delete a character
        2. Replace a character with another one
        3. Insert a character
        Note
        Strings don't contain spaces
        Input Format :
        The first line of input contains a string, that denotes the value of s. The following line contains a string, that denotes the value of t.
        Output Format :
        The first and only line of output contains the edit distance value between the given strings.
        Constraints :
        1<= m,n <= 10
        Time Limit: 1 second
        Sample Input 1 :
        abc
        dc
        Sample Output 1 :
        2*/
public class edit_distance {
    public static int editDistance(String s1, String s2){

        if(s1.length()==0){
            return s2.length();
        }
        if(s2.length()==0){
            return s1.length();
        }
        if(s1.charAt(0)==s2.charAt(0)){
            return editDistance(s1.substring(1) , s2.substring(1));
        }else{
            int a = editDistance(s1 , s2.substring(1));
            int b = editDistance(s1.substring(1) , s2);
            int c = editDistance(s1.substring(1) , s2.substring(1));
            return 1 +  Math.min(a , Math.min(b,c));
        }

    }
}
