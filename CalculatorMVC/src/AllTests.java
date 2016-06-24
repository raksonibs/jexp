
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

// Within the {} in the following use a comma separated list of *.class

@Suite.SuiteClasses({ 
	CalcViewTest.class, 
	CalcModelTest.class })

public class AllTests { } 