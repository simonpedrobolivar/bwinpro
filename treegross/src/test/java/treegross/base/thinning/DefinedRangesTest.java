package treegross.base.thinning;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class DefinedRangesTest {
    
    @Test
    public void checkingCoverageWithoutRanges() {
        DefinedRanges<Double> ranges = new DefinedRanges<>();
        
        assertThat(ranges.cover(0, 5)).isFalse();
    }
    
    @Test
    public void checkingCoverageWithOneRange() {
        DefinedRanges<Double> ranges = new DefinedRanges<>(new ThinningValueRange(0, 99, 4.5));
        
        assertThat(ranges.cover(0, 99)).isTrue();
        assertThat(ranges.cover(0, 99.1)).isFalse();
    }
}
