package heignamerican.eto;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class JapaneseEtoTest {
    @Test
    public void test() {
        assertThat(JapaneseEto.fromYear(2017), is(JapaneseEto.丁酉));
        assertThat(JapaneseEto.Jikkan.fromYear(2017), is(JapaneseEto.Jikkan.丁));
        assertThat(JapaneseEto.Juunishi.fromYear(2017), is(JapaneseEto.Juunishi.酉));
        assertThat(JapaneseEto.fromYear(2017).getYomigana(), is("ひのととり"));
    }
}
