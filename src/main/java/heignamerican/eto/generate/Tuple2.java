package heignamerican.eto.generate;

public class Tuple2<_T1, _T2> {
    public static <T1, T2> Tuple2<T1, T2> of(T1 t1, T2 t2) {
        return new Tuple2<T1, T2>(t1, t2);
    }

    public final _T1 value1;
    public final _T2 value2;

    public Tuple2(_T1 t1, _T2 t2) {
        this.value1 = t1;
        this.value2 = t2;
    }

    @Override
    public String toString() {
        return "Tuple2 (" + value1 + ", " + value2 + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value1 == null) ? 0 : value1.hashCode());
        result = prime * result + ((value2 == null) ? 0 : value2.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        @SuppressWarnings("rawtypes")
        Tuple2 other = (Tuple2) obj;
        if (value1 == null) {
            if (other.value1 != null)
                return false;
        } else if (!value1.equals(other.value1))
            return false;
        if (value2 == null) {
            if (other.value2 != null)
                return false;
        } else if (!value2.equals(other.value2))
            return false;
        return true;
    }
}
