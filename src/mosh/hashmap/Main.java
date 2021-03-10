package mosh.hashmap;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String text = "a green apple";
        var result = findFirstNonRepeatedCharacter(text);
        System.out.println("findFirstNonRepeatedCharacter=> " + result);

        result = findFirstNonRepeatedCharacter2(text);
        System.out.println("findFirstNonRepeatedCharacter=> " + result);

        result = firstRepeatedCharacter(text);
        System.out.println("findFirstNonRepeatedCharacter=> " + result);

        result = firstNonRepeatedCharacterTwo(text);
        System.out.println("firstNonRepeatedCharacterTwo=> " + result);

        HashTable hashTable=new HashTable();
        hashTable.put(6,"Test");
        hashTable.put(8,"Test1");
        hashTable.put(11,"Test2");
        hashTable.put(6,"Testsdfsdf");
        System.out.println(hashTable);
        System.out.println(hashTable.get(4));


        int[] array =new int[]{1,2, 2,2, 3, 3, 3,4};
        System.out.println( "findMostRepeated => " +findMostRepeated(array));


        int[] array2 =new int[]{1, 7, 5, 9, 2, 12, 3};
        int resulttt =countPairsWithDiff(array2,2);
        System.out.println("countPairsWithDiff=> " + resulttt);


        System.out.println("countPairsWithDiff2 => " + countPairsWithDiff2(array2,2));

        int[] countSums= twoSum(new int[]{2, 7, 11, 15},9);
        System.out.println("countSums=> " + Arrays.toString(countSums));

    }

    private static int countPairsWithDiff2(int[] array2, int k) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int count = 0;
        for (int i : array2) {
            hashMap.put(i,0);
        }
        for (int i : array2) {
            if (hashMap.containsKey(i+k))
                count++;
//            if (hashMap.containsKey(i-k))
//                count++;
        }
        return count;
    }

    private static int[] twoSum(int[] ints, int k) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int[] array =new int[]{};
        for (int anInt : ints) {
            hashMap.put(anInt,0);
        }

        return  array;
    }

    private static int countPairsWithDiff(int[] array, int k) {
        int count = 0;
        for (int value : array) {
            for (int j = 0; j < array.length; j++) {
                var diff = value - array[j];
                if (diff == k)
                    count++;
            }
        }
        return count;
    }

    private static int findMostRepeated(int[] array) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i : array) {
            var count = hashMap.containsKey(i)?hashMap.get(i):0;
            hashMap.put(i,count+1);
        }
        int maxKey= 0;
        int repeatCount = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : hashMap.entrySet()) {
            if (integerIntegerEntry.getValue()>repeatCount){
                repeatCount= integerIntegerEntry.getValue();
                maxKey = integerIntegerEntry.getKey();
            }

        }
        return maxKey;
    }


    public  static  char firstNonRepeatedCharacterTwo(String s){
        Set<Character> hashSet = new HashSet<>();
        for (char a: s.toCharArray()){
            if (hashSet.contains(a)){
                return  a;
            }else{
                hashSet.add(a);
            }
        }
        return Character.MIN_VALUE;
    }









    public static char firstRepeatedCharacter(String s) {
        Set<Character> characterSet = new HashSet<>();
        var charArray = s.toCharArray();
        for (char ch : charArray) {
            if (!characterSet.add(ch))
                return ch;
        }
        return Character.MIN_VALUE;
    }

    public static char findFirstNonRepeatedCharacter2(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        var charArray = s.toCharArray();
        for (Character ch : charArray) {
            var count = hashMap.containsKey(ch) ? hashMap.get(ch) : 0;
            hashMap.put(ch, count + 1);
        }
        for (Character ch : charArray) {
            if (hashMap.get(ch) == 1)
                return ch;
        }
        return Character.MIN_VALUE;
    }

    public static Character findFirstNonRepeatedCharacter(String s) {


        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            var charr = s.charAt(i);
            var rank = hashMap.containsKey(charr) ? i * 100 : i;
            hashMap.put(charr, rank);
        }

        Character character = null;
        int index = hashMap.size() * 100;
        for (Map.Entry<Character, Integer> characterIntegerEntry : hashMap.entrySet()) {
            if (characterIntegerEntry.getValue() < index) {
                character = characterIntegerEntry.getKey();
                index = characterIntegerEntry.getValue();
            }
        }
        return character;
    }
}
