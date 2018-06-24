package com.roi.testframeworks.assertj;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.JUnitSoftAssertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Rule;
import org.junit.Test;

public class ExampleAssertJTests {
	@Rule
	public final JUnitSoftAssertions softlyGlobal = new JUnitSoftAssertions();
	
	@Test
	public void exampleMultipleAssertTest(){
		assertThat(true).isEqualTo(false);
		assertThat("Hello").isEqualTo("World");
	}
	
	@Test
	public void exampleMultipleAssertTestWithSoftAssert(){
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(true).isEqualTo(false);
		softly.assertThat("Hello").isEqualTo("World");
		softly.assertAll();
	}
	

	@Test
	public void exampleMultipleAssertTestWithSoftAssertUsingRule(){
		softlyGlobal.assertThat(true).isEqualTo(false);
		softlyGlobal.assertThat("Hello").isEqualTo("World");
	}

}
