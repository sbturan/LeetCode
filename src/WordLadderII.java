import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadderII {
	public static void main(String[] args) {
		WordLadderII w = new WordLadderII();
//		 String[] array = new String[] {"hot","dot","dog","lot","log","cog"};
//		 System.out.println(w.findLadders("hit", "cog", Arrays.asList(array)));
		String[] array = new String[] { "kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip",
				"kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub",
				"lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won",
				"dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads",
				"max", "jaw", "out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat",
				"cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too",
				"tax", "jim", "san", "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct",
				"old", "fin", "feb", "chi", "sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan",
				"age", "fax", "hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot",
				"tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte",
				"ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo",
				"nam", "ave", "buy", "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod",
				"yam", "pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub",
				"ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye",
				"ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog",
				"nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe",
				"ion", "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop",
				"may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den",
				"fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog",
				"ram", "let", "see", "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo",
				"any", "dow", "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe",
				"bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy",
				"kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix",
				"sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito",
				"woe", "our", "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak",
				"bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly",
				"rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon",
				"dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc",
				"moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun",
				"ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get",
				"gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap",
				"two", "ins", "con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow",
				"sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err",
				"him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was",
				"cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob", "hot", "ora",
				"tia", "kip", "han", "met", "hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut",
				"ala", "ape", "rig", "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha",
				"fib", "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man",
				"pit", "guy", "foe", "hid", "mai", "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft",
				"alb", "len", "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun",
				"pat", "ten", "mob" };
		System.out.println(w.findLadders("cet", "ism", Arrays.asList(array)));

	}

	private void fillGraph(Set<String> wordList,HashMap<String,Set<String>> graph) {
		for(String s:wordList) {
			char[] charArray = s.toCharArray();
			for(int i=0;i<charArray.length;i++) {
				for(char j='a';j<'z';j++) {
					char temp=charArray[i];
					charArray[i]=j;
					String string = new String(charArray);
					if(j!=temp&&wordList.contains(string)) {
						Set<String> orDefault = graph.getOrDefault(s, new HashSet<String>());
						orDefault.add(string);
						graph.put(s, orDefault);
					}
					charArray[i]=temp;
				}
			}
		}
	}
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

		HashMap<String,Set<String>> graph=new HashMap<>();
		HashSet<String> wordListSet = new HashSet<>(wordList);
		wordListSet.add(beginWord);
		fillGraph(wordListSet, graph);
		ArrayList<List<String>> result=new ArrayList<>(),resultMin=new ArrayList<>();
		ArrayList<String> current = new ArrayList<>();
		current.add(beginWord);
		helper(current, result, beginWord, endWord, new HashSet<>(), graph);
		for(List<String> list:result) {
			if(list.size()==minCount)
			resultMin.add(list);
		}
		
		return resultMin;
	}

	int minCount = Integer.MAX_VALUE;

	private void helper(List<String> current, List<List<String>> result, String beginWord, String endWord,
			Set<String> visiteds,HashMap<String,Set<String>> graph) {
		if (beginWord.equals(endWord)) {
			minCount = Math.min(minCount, current.size());
			result.add(new ArrayList<>(current));
			return;
		}
		if (current.size() > minCount)
			return;
		Set<String> toList = graph.get(beginWord);
		if(toList==null) return;
			for(String s:toList) {
				if(!visiteds.contains(s)) {
					visiteds.add(s);
					current.add(s);
					helper(current, result, s, endWord, visiteds, graph);
					visiteds.remove(s);
					current.remove(current.size()-1);
				}
			}
		
	}
}

/*
 * Given: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log","cog"] Return [
 * ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"] ]
 */