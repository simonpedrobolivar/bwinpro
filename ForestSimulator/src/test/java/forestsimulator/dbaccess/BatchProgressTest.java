package forestsimulator.dbaccess;

import java.util.Arrays;
import java.util.Collections;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class BatchProgressTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void progressNeedsAtLeastOneRule() {
        new BatchProgress(Collections.emptyList(), new CalculationRule("id", 0, 0, 0), 0);
        fail("IllegalArgumentException not thrown with empty rule list.");
    }
    
    @Test
    public void currentRuleStartsWithOne() {
        CalculationRule rule = new CalculationRule("id", 0, 0, 0);
        BatchProgress progress = new BatchProgress(Arrays.asList(rule), rule, 0);
        assertThat(progress.ruleProgress().current, is(1));
    }
    
    @Test
    public void progressProvidesCorrectValuesGiven() {
        CalculationRule rule1 = new CalculationRule("id1", 0, 0, 5);
        CalculationRule rule2 = new CalculationRule("id2", 0, 0, 10);
        BatchProgress progress = new BatchProgress(Arrays.asList(rule1, rule2), rule2, 3);
        assertThat(progress.ruleProgress().total, is(2));
        assertThat(progress.ruleProgress().current, is(2));
        assertThat(progress.passProgress().current, is(3));
        assertThat(progress.passProgress().total, is(10));
        assertThat(progress.stepProgress().current, is(0));
        assertThat(progress.stepProgress().total, is(0));
    }
}