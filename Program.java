
class Program {
	
	static int maxLineLength;

    public static void main(String[] args) {
    	
    	InputReader in = new InputReader();
    	maxLineLength = in.readLineLength();
    	if (maxLineLength < 0) {
    		System.out.println("Error");
    		return;
    	}
    	Word s;
    	Line l = new Line();
    	while (true) {
    		s = in.readWord();
    		if (!s.valid) {
    			outputLine(l, true);
    			break;
    		}
    		if (s.paragraph) {
    			outputLine(l, true);
    			l = new Line();
    			System.out.print("\n");
    		} else {
    			if (addToLine(l, s.word))
    				continue;
    			outputLine(l, false);
    			l = new Line();
    			addToLine(l, s.word);
    		}
    	}
    	
    }
    
    private static boolean addToLine(Line l, String w) {
    	if (l.length() + 1 + w.length() > maxLineLength)
    		return false;
    	
    	l.line.add(w);
    	return true;
    }
    
    private static void outputLine(Line l, boolean last) {
    	if (last) {
    		for(int i = 0; i < l.line.size(); i++) {
	    		System.out.print(l.line.get(i));
	    		if (i < l.line.size() - 1) {
    				System.out.print(' ');
	    		}
	    	}
	    	System.out.println();
    	} else {
	    	int extraSpaces = maxLineLength - l.length();
	    	int delimCount = l.line.size() - 1;
	    	
	    	if (delimCount == 0) {
	    		System.out.println(l.line.get(0));
	    		return;
	    	}
	    	
	    	int spacesBetweenWords = (extraSpaces / delimCount) + 1;
	    	int spacesRemainder = extraSpaces % delimCount;
	    	
	    	for(int i = 0; i < l.line.size(); i++) {
	    		System.out.print(l.line.get(i));
	    		if (i < l.line.size() - 1) {
	    			for(int j = 0; j < spacesBetweenWords; j++)
	    				System.out.print(' ');
	    			if (spacesRemainder-- > 0)
	    				System.out.print(' ');
	    		}
	    	}
	    	System.out.println();
    	}
    }
}




