import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    private boolean isWordExist(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[len] = true;
        for(int i=len-1;i>=0;i--) {
            for(String word: wordDict) {
                if(word.length()+i<=len && word.equals(s.substring(i, i+word.length()))) {
                    dp[i] = dp[i+word.length()];
                }
                if (dp[i]) break;
            }
        }
        return dp[0];
    }
    public static void main(String... args) {
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.isWordExist("leetcode", new ArrayList<>(Arrays.asList(new String[]{"leet", "code", "neet"}))));
    }
}