package org.lg.rules;

import org.junit.Test;
import org.lg.ce.model.InRule;
import org.lg.suit.cv.RuleConfig;

public class RuleTest {
	
	@Test
	public void testRule(){
		final InRule rule = new InRule(RuleConfig.loadRule("test-api"));
		System.out.println(rule.getSource());
	}
}
