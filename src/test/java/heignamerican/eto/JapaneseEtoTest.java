package heignamerican.eto;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.time.chrono.JapaneseDate;
import java.time.chrono.JapaneseEra;

import org.junit.Test;

public class JapaneseEtoTest {
    @Test
    public void test() {
        assertThat(JapaneseEto.fromYear(2017), is(JapaneseEto.丁酉));
        assertThat(JapaneseEto.Jikkan.fromYear(2017), is(JapaneseEto.Jikkan.丁));
        assertThat(JapaneseEto.Juunishi.fromYear(2017), is(JapaneseEto.Juunishi.酉));
        assertThat(JapaneseEto.fromYear(2017).getYomigana(), is("ひのととり"));

        final JapaneseDate date = JapaneseDate.of(JapaneseEra.HEISEI, 29, 1, 1);
        assertThat(JapaneseEto.from(date), is(JapaneseEto.丁酉));
        assertThat(JapaneseEto.Jikkan.from(date), is(JapaneseEto.Jikkan.丁));
        assertThat(JapaneseEto.Juunishi.from(date), is(JapaneseEto.Juunishi.酉));
    }
}
