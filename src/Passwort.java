import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Passwort {
	char[][] charArray = new char[5][];
	final String[] WordList = {"about", "after", "again", "below", "could", "every", "first", "found", "great", "house", "large", "learn", "never", "other", "place", "plant", "point", "right", "small", "sound", "spell", "still", "study", "their", "there", "these", "thing", "think", "three", "water", "where", "which", "world", "would", "write"};
	
	public void addCharArray(char[] c){
		if(charArray[0] == null){ charArray[0] = c;	}
		else if(charArray[1] == null){ charArray[1] = c; }
		else if(charArray[2] == null){ charArray[2] = c; }
		else if(charArray[3] == null){ charArray[3] = c; }
		else if(charArray[4] == null){ charArray[4] = c; }
		else return;
	}
	
	public Passwort(){
		
	}
	
	public String[] getWords(){
		String[] resultList = WordList;
		for(int i = 0; i < 5; i++){
			if(charArray[i] == null) continue;
			final int value = i;
			List<Character> charList = String.valueOf(charArray[i]).chars().mapToObj(c -> (char) c).collect(Collectors.toList());
			resultList = Arrays.stream(resultList).filter(x -> charList.contains(x.charAt(value))).toArray(String[]::new);
		}
		return resultList;
	}
}