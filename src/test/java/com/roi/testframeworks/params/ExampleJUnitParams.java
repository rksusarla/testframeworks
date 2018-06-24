package com.roi.testframeworks.params;

import junitparams.Parameters;
import junitparams.JUnitParamsRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class ExampleJUnitParams {
	
	  @Test
	  @Parameters({"10,20,30", 
	               "-10,20,10" })
	  public void addPerformsAdditionCorrectly(int valueOne, int valueTwo, long result) throws Exception {
	    assertThat(new Calculator().add(valueOne, valueTwo)).isEqualTo(result);
	  }

	  @Test
	  @Parameters({"10,20,-10", 
	               "300,10,290" })
	  public void subtractPerformsSubtractionCorrectly(int valueOne, int valueTwo, long result) throws Exception {
	    assertThat(new Calculator().subtract(valueOne, valueTwo)).isEqualTo(result);
	  }

}
