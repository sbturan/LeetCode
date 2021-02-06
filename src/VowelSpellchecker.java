import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class VowelSpellchecker {
    public static void main(String[] args) {
        Arrays.stream(new VowelSpellchecker().spellchecker(
                new String[]{"KiTe","kite","hare","Hare"},
                new String[]{"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"}
        )).forEach(i-> System.out.print(i + " "));
    }
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet<String> original=new HashSet<>();
        HashMap<String, String> capitalization=new HashMap<>();
        HashMap<String, String> consonants=new HashMap<>();
        HashSet<Character> vowels=new HashSet<>(){{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};
        String[] result=new String[queries.length];
        for(String cur:wordlist){
            original.add(cur);
            String toLowerCase = cur.toLowerCase();
            String onlyConsonant=toConsonant(cur,vowels);
            if(!capitalization.containsKey(toLowerCase))
                capitalization.put(toLowerCase,cur);
            if(!consonants.containsKey(onlyConsonant)){
                consonants.put(onlyConsonant,cur);
            }
        }
        for(int i=0;i<queries.length;i++){
            String lowerCase = queries[i].toLowerCase();
            String consonant = toConsonant(queries[i],vowels);
            if (original.contains(queries[i])) {
                result[i] = queries[i];
            } else if (capitalization.containsKey(lowerCase)) {
                result[i] = capitalization.get(lowerCase);
            } else if(consonants.containsKey(consonant)){
                result[i]=consonants.get(consonant);
            }else{
                result[i]="";
            }

        }
        return result;
    }

    private String toConsonant(String s,HashSet<Character> vowels){
        StringBuilder sb=new StringBuilder();
        for(Character c:s.toCharArray()){
            char o = Character.toLowerCase(c);
            if(vowels.contains(o)){
               o='.';
            }
            sb.append(o);
        }
        return sb.toString();
    }
}
