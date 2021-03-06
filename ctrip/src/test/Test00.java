package test;

import java.util.*;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/10 19:20
 * @Version: 1.0
 */
public class Test00 {
    static HashMap<String, String> preMap;
    static HashMap<String, String> postMap;
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static String unwangdulize(String word) {
        preMap = new HashMap<>();
        preMap.put("anti", "against ");preMap.put("post", "after ");
        preMap.put("pre", "before ");preMap.put("re", " again");
        preMap.put("un", "not ");

        postMap = new HashMap<>();
        postMap.put("er", "one who ");
        postMap.put("ing", "to actively ");
        postMap.put("ize", "change into ");
        postMap.put("tion", "the process of");
        postMap.put("ful", "full of");

        /*Deque<String> preStack = new LinkedList<>();
        int curIndex = 0;
        int n = word.length();
        boolean flag = false;
        while (curIndex < n){
            for (int l = 2; l < 4; l++){
                if (preMap.containsKey(word.substring(curIndex, curIndex+l))){
                    preStack.push(word.substring(curIndex, curIndex+l));
                    curIndex += l;
                    flag = true;
                    break;
                }
            }
            if (flag == false){
                break;
            }
            flag = false;
        }
        int start = curIndex;
        //找后缀
        Deque<String> postStack = new LinkedList<>();
        curIndex = n;
        flag = false;
        while (curIndex >= 0){
            for (int i = 2; i <= 4; i++) {
                if (postMap.containsKey(word.substring(curIndex-i, curIndex))){
                    postStack.push(word.substring(curIndex-i, curIndex));
                    curIndex -= i;
                    flag = true;
                    break;
                }
            }
            if (flag == false){
                break;
            }
            flag = false;
        }
        int end = curIndex;
        StringBuffer post = new StringBuffer();
        StringBuffer pre = new StringBuffer();
        String w = word.substring(start, end);
        while (!postStack.isEmpty()){
            if (postStack.peek() == "er"){
                w += "s";
            }else if (postStack.peek() == "tion"){
                w += "ing";
            }
            post.append(postMap.get(postStack.peek()));
            postStack.poll();
        }
        while (!preStack.isEmpty()){
            if (preStack.peek() == "re") {
                w += " again";
            }else {
                pre.append(preMap.get(preStack.peek()));
            }
            preStack.poll();
        }

        String ans = new String();
        ans += pre.toString();
        ans += post.toString();
        ans += w;*/

        String ans = dealPre(word);

        return ans;
    }

    private static String dealPre(String word) {
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < word.length(); i++) {
            stringBuffer.append(word.charAt(i));
            if (!preMap.containsKey(stringBuffer.toString())){
                continue;
            }
            String w = word.substring(i+1, word.length());
            return deal(stringBuffer.toString(), dealPre(w));
        }
        return dealPost(word);
    }

    private static String dealPost(String word) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp;
        for (int i = 0; i < word.length(); i++) {
            temp = word.substring(i, word.length());
            if (postMap.containsKey(temp)){
                continue;
            }
            String w = word.substring(0, i);
            return deal(temp, dealPost(w));
        }
        return word;
    }


    private static String deal(String stringBuffer, String word) {
        String ans = new String();
        if (stringBuffer == "anti") {
            ans = "anti" + word;
        }else if (stringBuffer == "after"){
            ans = "after" + word;
        } else if (stringBuffer == "nu") {

            ans = "not" + word;
        }else if (stringBuffer == "ize"){
            ans = "change into" + word;
        }
        return ans;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _word;
        try {
            _word = in.nextLine();
        } catch (Exception e) {
            _word = null;
        }

        res = unwangdulize(_word);
        System.out.println(res);
    }
}
