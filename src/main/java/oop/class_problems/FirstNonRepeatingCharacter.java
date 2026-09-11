package oop.class_problems;

import java.util.HashMap;

class FirstNonRepeatingCharacter {

    static char findFirstNonRepeatingChar(String text){

        HashMap<Character,Integer> map=new HashMap<>();

        for(char ch:text.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);

        for(char ch:text.toCharArray())
            if(map.get(ch)==1)
                return ch;

        return '\0';
    }

    public static void main(String[] args){

        char result=findFirstNonRepeatingChar("swiss");

        if(result!='\0')
            System.out.println("First Non-Repeating Character: '"+result+"'");
        else
            System.out.println("No Non-Repeating Character Found");
    }
}