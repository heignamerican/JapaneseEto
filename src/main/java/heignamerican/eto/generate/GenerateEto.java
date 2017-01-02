package heignamerican.eto.generate;

import java.security.NoSuchAlgorithmException;

import heignamerican.eto.JapaneseEto.Jikkan;
import heignamerican.eto.JapaneseEto.Juunishi;

public class GenerateEto {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // JapaneseEto.Jikkan および JapaneseEto.Juunishi が定義されていることを前提に
        // 十干十二支の組み合わせを生成する。
        StreamUtils.zipProduct(Jikkan.values(), Juunishi.values())
                .forEach(tuple -> {
                    System.out.printf("%s%s(JapaneseEto.Jikkan.%s, JapaneseEto.Juunishi.%s), //%n",
                            tuple.value1, tuple.value2,
                            tuple.value1, tuple.value2);
                });
    }
}
