package heignamerican.eto;

public enum JapaneseEto {
    ;

    public static enum Juunishi {
        子("ね"), //
        丑("うし"), //
        寅("とら"), //
        卯("う"), //
        辰("たつ"), //
        巳("み"), //
        午("うま"), //
        未("ひつじ"), //
        申("さる"), //
        酉("とり"), //
        戌("いぬ"), //
        亥("い"), //
        ;
        private final String yomi;

        private Juunishi(final String yomi) {
            this.yomi = yomi;
        }

        public String getYomigana() {
            return this.yomi;
        }

        public static Juunishi fromYear(final int year) {
            return Juunishi.values()[(year + 8) % 12];
        }
    }

    public static enum Jikkan {
        甲("きのえ"), //
        乙("きのと"), //
        丙("ひのえ"), //
        丁("ひのと"), //
        戊("つちのえ"), //
        己("つちのと"), //
        庚("かのえ"), //
        辛("かのと"), //
        壬("みずのえ"), //
        癸("みずのと"), //
        ;
        public final String yomi;

        private Jikkan(final String yomi) {
            this.yomi = yomi;
        }

        public String getYomigana() {
            return this.yomi;
        }

        public static Jikkan fromYear(final int year) {
            return Jikkan.values()[(year + 6) % 10];
        }
    }
}
