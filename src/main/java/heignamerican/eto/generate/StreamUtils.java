package heignamerican.eto.generate;

import java.util.Iterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamUtils {
    /**
     * 引数のソース配列要素を無限にループして返すような {@link Stream} を作成する。
     * 
     * <p>
     * 注意：要素数を制限せずに終端操作を行うと<b>終了しない</b>
     * 
     * @param <T>
     *            ソース配列の要素型
     * @param input
     *            {@code null} は不許可(実行時例外を投げる)。
     * @return
     */
    public static <T> Stream<T> createInfiniteLoop(final T[] input) {
        if (input.length == 0)
            return Stream.empty();

        return Stream.generate(new Supplier<T>() {
            int index = 0;

            @Override
            public T get() {
                return input[index++ % input.length];
            }
        });
    }

    /**
     * zip 化した {@link Stream} を作成する。
     * 
     * <p>
     * 引数の2つのソース {@code Stream} を結合し zip 化する。<br>
     * ソースのいずれかが有限の場合、短い方に合わせて打ち切って終了する。<br>
     * 
     * @param <T1>
     *            引数 s1 の要素型
     * @param <T2>
     *            引数 s2 の要素型
     * @param s1
     *            左側のソース
     * @param s2
     *            右側のソース
     * @return 作成された {@code Stream} の各要素の {@link Tuple2} は、引数の順(s1の要素、s2の要素)
     *         に各ソースの要素を詰める。
     */
    public static <T1, T2> Stream<Tuple2<T1, T2>> zip(final Stream<T1> s1, final Stream<T2> s2) {
        final Iterator<T1> iterator1 = s1.iterator();
        final Iterator<T2> iterator2 = s2.iterator();

        final Iterator<Tuple2<T1, T2>> iterator = new Iterator<Tuple2<T1, T2>>() {
            @Override
            public boolean hasNext() {
                return iterator1.hasNext() && iterator2.hasNext();
            }

            @Override
            public Tuple2<T1, T2> next() {
                return Tuple2.of(iterator1.next(), iterator2.next());
            }
        };

        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, 0), false);
    }

    /**
     * 全ての組み合わせを1つずつ含むような、zip化けした {@link Stream} を作成する。
     * 
     * @param s1
     * @param s2
     * @return
     */
    public static <T1, T2> Stream<Tuple2<T1, T2>> zipProduct(final T1[] s1, final T2[] s2) {
        return zip(createInfiniteLoop(s1), createInfiniteLoop(s2))
                .limit(MyMath.lcm(s1.length, s2.length));
    }
}
