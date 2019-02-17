package example.rcp.unit.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import example.plugin1.dummy.DummyEcho;

/**
 * Proof that the unit test project sees the host's packages.
 * @author vodorok
 *
 */
public class ExampleTest {

	/**
	 * Testcase to test the functionality
	 */
    @Test
    public void dummyTest() {
    	String testString = "DummyTest";
    	DummyEcho d = new DummyEcho(testString);
    	assertTrue(testString.equals(d.getText()));
    }

}