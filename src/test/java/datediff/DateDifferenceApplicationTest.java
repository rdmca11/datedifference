package datediff;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DateDifferenceApplicationTest {

	@Test
	public void test_WithSampleValidFile() throws IOException {
		Path resourceDirectory = Paths.get("src", "test", "resources");
		String absolutePath = resourceDirectory.toFile().getAbsolutePath() + "/SampleCommands.txt";
		DateDifferenceApplication.main(new String[]{absolutePath});
	}
}
