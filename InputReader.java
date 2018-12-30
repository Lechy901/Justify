
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputReader {
	
	Scanner scan;
	
	public InputReader() {
		scan = new Scanner(System.in);
		//scan.useDelimiter("\\s+");
	}
	
	public int readLineLength() {
		try {
			return scan.nextInt();
		} catch(NoSuchElementException e) {
			return -1;
		}
	}
	
	public Word readWord() {
		try {
			try {
				scan = scan.skip("\n\\s*\n");
				return new Word(true, true, null);
			} catch(NoSuchElementException e) {
				return new Word(true, false, scan.next("\\S+"));
			}
		} catch (NoSuchElementException e) {
			return new Word(false, false, null);
		}
	}
}
