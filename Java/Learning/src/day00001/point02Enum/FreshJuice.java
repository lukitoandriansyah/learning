package day00001.point02Enum;

public class FreshJuice {
    FreshJuiceSize freshJuiceSize;

    public FreshJuice() {
    }

    static enum FreshJuiceSize {
        SMALL,
        MEDIUM,
        LARGE;

        private FreshJuiceSize() {
        }
    }
}
