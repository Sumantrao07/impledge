import java.io.*;
import java.util.*;
public class impledge{
    static Set<String> wordSet =new HashSet<>();
    public static void main(String[] args)throws  IOException{
        String inputFile= "Input_01.txt";
        List<String> words= readWordsFromFile(inputFile);
        long startTime = System.currentTimeMillis();
        String[] longestWords = findLongestCompoundWords(words);
        long endTime =System.currentTimeMillis();
        System.out.println("longest compound word:"+longestWords[0]);
        System.out.println("Second longest compound word:"+ longestWords[1]);
        System.out.println("time taken to process file" +inputFile+":"+(endTime - startTime)+"milliseconds");
    }
    private static List<String> readWordsFromFile(String filename) throws IOException{
        List<String> words = new ArrayList<>();
        try(BufferedReader br= new BufferedReader(new FileReader(filename))){
            String line;
            while((line =br.readLine())!=null){
                words.add(line.trim());
                wordSet.add(line.trim());
           }
        }
        return words;
    }
    private static String[] findLongestCompoundWords(List<String> words){
        words.sort((a,b) -> b.length()-a.length());
        String longest="";
        String secondLongest = "";
        for(String word:words){
            wordSet.remove(word);
            if(canBeFormed(word)){
                if(longest.isEmpty()){
                    longest=word;
                } else{
                    secondLongest=word;
                    break;
                }
            }
            wordSet.add(word);
        }
        return new String[]{longest, secondLongest};
    }
    private static boolean canBeFormed(String word){
        int length=word.length();
        if(length==0)return false;
        boolean[]dp=new boolean[length+1];
        dp[0]=true;
        for (int i =1;i<=length;i++){
            for(int j=0;j<i;j++){
                if(dp[j]&& wordSet.contains(word.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[length];
            
        }
    }