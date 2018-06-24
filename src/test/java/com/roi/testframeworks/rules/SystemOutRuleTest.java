package com.roi.testframeworks.rules;

import org.junit.Rule;
import org.junit.Test;

public class SystemOutRuleTest {

	@Rule
	public SystemOutRule systemOutRule = new SystemOutRule();



	@Test
	public void exampleToShowSystemOutRule(){
		System.out.printf("In example Test to show rules %n");
	}

	@Test
	public void exampleToShowSystemOutRule2(){
		System.out.printf("zzzzzz %n");
	}




}
