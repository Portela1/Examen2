
import java.lang.reflect.Array;
import java.util.ArrayList;

public class DNASequence {

	private String alphabet; // One of the String's "dna", "rna", "protein"
	private String sequence; // Sequence of letters representing nuclotides or aminoacids

	/*
	 * Constructs a new DNASequence with the given parameters
	 */
	public DNASequence(String sequence, String alphabet)  {
		this.sequence = sequence;
		this.alphabet = alphabet;
	}
	
	/*
	 * Constructs a new DNASequence with the same properties as parameter sequence s
	 */
	public DNASequence(DNASequence s)  {
		this.sequence = s.sequence;
		this.alphabet = s.alphabet;
	}

	// Getters
	public String getAlphabet() {
		return alphabet;
	}

	public String getSequence() {
		return sequence;
	}
	
	// Instance Methods

	public boolean equals(Object o) {
		if (o instanceof DNASequence) {
			DNASequence s = (DNASequence) o;
			return (s.getAlphabet().equals(this.getAlphabet()) && (s.getSequence().equals(this.getSequence())));
		}
		return false;
	}
	
	/*
	 * Returns true iff the target DNASequence is a protein, that is if its
	 * alphabet is the String "protein".
	 */
	public boolean isProtein() {
		return (this.alphabet.equals("protein"));
	}
	
	/*
	 * Returns true iff the target DNASequence contains at least one 
	 * copy of the parameter DNASequence s2
	 */
	public boolean contains(DNASequence s2) {
		return (this.sequence.indexOf(s2.sequence) >= 0);
	}
	
	/*
	 * Returns a NEW DNASequence consisting of the concatenation of the target DNASequence
	 * with the parameter DNASequence s2.  The alphabet of the result is the same as the
	 * alphabet of the target sequence.
	 * You may assume that both DNASequences have the same alphabets.
	 */
	public DNASequence append(DNASequence s2) {
		return new DNASequence(this.sequence + s2.sequence, this.alphabet);
	}
	
	/*
	 * Returns a new DNASequence representing the first ORF (Open Reading Frame) in the sequence, 
	 * that is the first subsequence that appears between the start and end String's.
	 * Example:
	 * ORF(New DNASequence("AAAATGGGGCCCTTTTAGAAA", "dna"), "ATG", "TAG") yields 
	 * DNASequence("ATGGGGCCCTTTTAG", "dna")
	 * See the JUnit test cases for another example.
	 */
	public DNASequence ORF(String startCodon, String stopCodon) {
		int startPosition = this.sequence.indexOf(startCodon);
		if (startPosition < 0) return new DNASequence("", this.alphabet);
		int endPosition = this.sequence.indexOf(stopCodon, startPosition);
		if (endPosition < 0) return new DNASequence("", this.alphabet);
		return new DNASequence(this.sequence.substring(startPosition, endPosition + stopCodon.length()), this.alphabet);
	}
	
	/* 
	 * Returns the longest DNASequence in the give list of sequences
	 * If the list contains two or more sequences with the same longest length
	 * the method should return the first such sequence in the array.
	 * If the list is empty returns null
	 */
	public static DNASequence longestSequence(ArrayList<DNASequence> sequences) {
		int max =0;
		for(int i =0;i<sequences.size();i++) {
			if(sequences.get(i).sequence.length() > max);
			max = sequences.get(i).sequence.length();
		}
		
		for(int l = 0; l<sequences.size();l++) {
			if(sequences.get(l).sequence.length() == max) {
				return sequences.get(l);
			}
		}
		
		return null;
		
		
		
		}
	
	
	/*
	 * Returns a new DNASequence containing the concatenation of all the
	 * DNASequences in the given list.
	 * Returns a DNASequence object with an empty sequence if the list is empty
	 * or all sequences are empty
	 * HINT: You may find the append method useful for this problem
	 */
	public static DNASequence concatenate(ArrayList<DNASequence> list) {
		DNASequence r = new DNASequence("","dna");
		
			for(DNASequence i:list) {
				r.append(i);
			
		}
		
		
		
		return r;
	}
	
	
	/*
	 * Returns true if and only if the target sequence exists in the given list of sequences
	 * Stops searching as soon as the target sequence if found.
	 */
	public boolean exists(ArrayList<DNASequence> list) {
		for(DNASequence i: list) {
			if(this.sequence == i.sequence) {
				return true;
			}
		}
		return false; //Dummy return
	}
	
	/*
	 * Inserts the target DNASequence at the beginning of the given 
	 * list of DNASequences
	 * Returns the modified list of DNASequence's
	 */
	public ArrayList<DNASequence> prepend(ArrayList<DNASequence> list) {
		ArrayList<DNASequence> r = new ArrayList<>();
		r.addAll(list);
		list.clear();
		list.add(this);
		list.addAll(r);
		return list;
	}
	
	/*
	 * Returns true if and only iff some DNAsequence in the list is completely contained
	 * within another of the DNASequence's in the list.
	 * HINT: Instance method contains could be useful
	 */ 
	public static boolean someCompletelyContained(ArrayList<DNASequence> list) {
		for(int i = 0 ; i<list.size();i++) {
			for(int l = 0; l<list.size();l++) {
				if(list.get(i).contains(list.get(l)) && i!=l) {
					return true;
				}
				
			}
		}
		return false; // Dummy return
	}
} 