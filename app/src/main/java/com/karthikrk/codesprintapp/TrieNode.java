package com.karthikrk.codesprintapp;

import java.util.Arrays;
import java.util.HashMap;



public class TrieNode {
    private HashMap<Character, TrieNode> children;
    private boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }

    public void add(String s) {
        HashMap<Character, TrieNode> ch = children;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            TrieNode t;
            if(ch.containsKey(c)){
                t=ch.get(c);
            }
            else {
                t = new TrieNode();
                ch.put(c,t);
            }

            ch  = t.children;

            if(i==s.length()-1){
                t.isWord = true;
            }
        }
    }

    public boolean isWord(String s) {
        TrieNode t = search(s);

        if(t!=null && t.isWord==true){
            return true;
        }
        else {
            return false;
        }
    }

    public TrieNode search(String s) {
        HashMap<Character, TrieNode> ch = children;
        TrieNode t=null;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(ch.containsKey(c)){
                t=ch.get(c);
                ch = t.children;
            }
            else {
                return null;
            }
        }
        return t;
    }

    public String getAnyWordStartingWith(String s) {
        TrieNode t = search(s);
        HashMap<Character, TrieNode> ch = children;
        String output = s + "";
        if(t==null){
            return null;
        }
        else {
            while(!t.isWord){
                ch = t.children;
                Character nKey = (Character) ch.keySet().toArray()[0];
                output = output + nKey;
                t=ch.get(nKey);
            }
        }
        return output;
    }

    public String getGoodWordStartingWith(String s) {
        return null;
    }

    /**
     * Method to get the longest word starting with the prefix
     * @param s
     * @return
     *          : Returns a string of the longest length with the prefix
     */
    public String getLongestWordStartingWith(String s){
        TrieNode t = search(s);
        String result="";
        int length=0;
        HashMap<Character, TrieNode> ch = children;
        ch=t.children;
        Object[] nKeyArray = ch.keySet().toArray();
        Character[] nKey = Arrays.copyOf(nKeyArray, nKeyArray.length, Character[].class);
        if(t==null){
            return null;
        }
        else {
            String out=null;
            HashMap<Character, TrieNode> child;
            for(char c: nKey){
                TrieNode temp = search(s+c);
                out=s+"";
                if(temp==null){
                    out=s+"";
                }
                else{
                    while(!temp.isWord && temp.children!=null){
                        child = temp.children;
                        Character nK = (Character) child.keySet().toArray()[0];
                        out = out + nK;
                        t=ch.get(nK);
                    }
                }
                if(result.length()<out.length())
                    result=out;
            }

        }
        return result;
    }

    /**
     * Method to get the Length of the longest word starting with the prefix entered.
     * @param s
     * @return
     *          : Retuns the length of the longest word starting with the prefix.
     */
    public int getLengthOfLongestWordStartingWith(String s){
        String o=getLongestWordStartingWith(s);
        if(o==null)
            return -1;
        else
            return o.length();

    }
}
