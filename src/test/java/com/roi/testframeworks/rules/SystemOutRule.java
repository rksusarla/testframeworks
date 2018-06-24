package com.roi.testframeworks.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class SystemOutRule implements TestRule {

	public Statement apply(final Statement base, final Description description) {
		return new Statement(){

			@Override
			public void evaluate() throws Throwable {
				System.out.println("Before " + description.getClassName() + ": " + description.getMethodName());
				base.evaluate();
				System.out.println("After " + description.getClassName() + ": " + description.getMethodName());
			}
			
		};
	}
}
