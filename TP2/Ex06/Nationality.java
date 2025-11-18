package Ex06;

import java.util.Arrays;
import java.util.List;

public interface Nationality {
	List<Color> getFlagColor();
}

public class Dutch implements Nationality {

	@Override
	public List<Color> getFlagColor() {
		return Arrays.asList(Color.RED, Color.WHITE, Color.BLUE);
	}
	
}

public class Germany implements Nationality {

	@Override
	public List<Color> getFlagColor() {
		return Arrays.asList(Color.BLACK, Color.RED, Color.YELLOW);
	}
	
}
public class Belgiam implements Nationality {

	@Override
	public List<Color> getFlagColor() {
		return Arrays.asList(Color.BLACK, Color.YELLOW, Color.RED);
	}
	
}
public class French implements Nationality {

	@Override
	public List<Color> getFlagColor() {
		return Arrays.asList(Color.BLUE, Color.WHITE, Color.RED);
	}
	
}
public class Italian implements Nationality {

	@Override
	public List<Color> getFlagColor() {
		return Arrays.asList(Color.GREEN, Color.WHITE, Color.RED);
	}
	
}
public class Unclassified implements Nationality {

	@Override
	public List<Color> getFlagColor() {
		return Arrays.asList(Color.GRAY);
	}
	
}