import java.util.ArrayList;
import java.util.List;

public class Line {
	public List<String> line;
	
	public Line() {
		line = new ArrayList<String>();
	}
	
	public int length() {
		if (line.isEmpty())
			return 0;
		return line.stream().mapToInt(x -> x.length()).sum() + line.size() - 1;
	}
}
