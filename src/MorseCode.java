import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MorseCode {
	private final List<AbstractMap.SimpleImmutableEntry<String, Character>> morseAlphabet = new ArrayList<AbstractMap.SimpleImmutableEntry<String, Character>>(Arrays.asList(
			new AbstractMap.SimpleImmutableEntry<String, Character>(".-", 'a'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("-...", 'b'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("-.-.", 'c'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("-..", 'd'),
			new AbstractMap.SimpleImmutableEntry<String, Character>(".", 'e'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("..-.", 'f'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("--.", 'g'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("....", 'h'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("..", 'i'),
			new AbstractMap.SimpleImmutableEntry<String, Character>(".---", 'j'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("-.-", 'k'),
			new AbstractMap.SimpleImmutableEntry<String, Character>(".-..", 'l'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("--", 'm'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("-.", 'n'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("---", 'o'),
			new AbstractMap.SimpleImmutableEntry<String, Character>(".--.", 'p'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("--.-", 'q'),
			new AbstractMap.SimpleImmutableEntry<String, Character>(".-.", 'r'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("...", 's'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("-", 't'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("..-", 'u'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("...-", 'v'),
			new AbstractMap.SimpleImmutableEntry<String, Character>(".--", 'w'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("-..-", 'x'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("-.--", 'y'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("--..", 'z'),
			new AbstractMap.SimpleImmutableEntry<String, Character>(".----", '1'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("..---", '2'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("...--", '3'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("....-", '4'),
			new AbstractMap.SimpleImmutableEntry<String, Character>(".....", '5'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("-....", '6'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("--...", '7'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("---..", '8'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("----.", '9'),
			new AbstractMap.SimpleImmutableEntry<String, Character>("-----", '0')
			));
	private final List<AbstractMap.SimpleImmutableEntry<String, String>> frequencyList = new ArrayList<AbstractMap.SimpleImmutableEntry<String, String>>(Arrays.asList(
			new AbstractMap.SimpleImmutableEntry<String, String>("shell","3.505 MHz"),
			new AbstractMap.SimpleImmutableEntry<String, String>("halls","3.515 MHz"),
			new AbstractMap.SimpleImmutableEntry<String, String>("slick","3.522 MHz"),
			new AbstractMap.SimpleImmutableEntry<String, String>("trick","3.532 MHz"),
			new AbstractMap.SimpleImmutableEntry<String, String>("boxes","3.535 MHz"),
			new AbstractMap.SimpleImmutableEntry<String, String>("leaks","3.542 MHz"),
			new AbstractMap.SimpleImmutableEntry<String, String>("strobe","3.545 MHz"),
			new AbstractMap.SimpleImmutableEntry<String, String>("bistro","3.552 MHz"),
			new AbstractMap.SimpleImmutableEntry<String, String>("flick","3.555 MHz"),
			new AbstractMap.SimpleImmutableEntry<String, String>("bombs","3.565 MHz"),
			new AbstractMap.SimpleImmutableEntry<String, String>("break","3.572 MHz"),
			new AbstractMap.SimpleImmutableEntry<String, String>("brick","3.575 MHz"),
			new AbstractMap.SimpleImmutableEntry<String, String>("steak","3.582 MHz"),
			new AbstractMap.SimpleImmutableEntry<String, String>("sting","3.592 MHz"),
			new AbstractMap.SimpleImmutableEntry<String, String>("vector","3.595 MHz"),
			new AbstractMap.SimpleImmutableEntry<String, String>("beats","3.600 MHz")
			));
	
	public String getFrequency(String morseString){
		String[] morseCodes = morseString.split(" ");
		String word = "";
		for(int i = 0; i < morseCodes.length; i++){
			word += parseMorseSign(morseCodes[i]);
		}
		if(!word.isEmpty()){
			final String fWord = word;
			try {
				List<AbstractMap.SimpleImmutableEntry<String, String>> foundFrequencies = frequencyList.stream().filter(x -> x.getKey().contains(fWord)).collect(Collectors.toList());
				String returnString = "";
				for(int i = 0; i < foundFrequencies.size(); i++){
					returnString += foundFrequencies.get(i).getValue() + ", ";
				}
				return returnString.substring(0, returnString.length() - 2);
			} catch (Exception e) {
				return "Couldn't find any frequency matching the morse code.";
			}
		}
		return "Couldn't find any frequency matching the morse code.";
	}
	
	public Character parseMorseSign(String morseSign){
		try {
			return morseAlphabet.stream().filter(x -> x.getKey().equalsIgnoreCase(morseSign)).findFirst().get().getValue();
		} catch (Exception e) {
			return null;
		}
	}
}