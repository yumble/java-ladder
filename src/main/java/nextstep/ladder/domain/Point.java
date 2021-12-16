package nextstep.ladder.domain;

/**
 * @author han
 */
public class Point {
    private final boolean left;
    private final boolean current;

    private Point(boolean left, boolean current) {
        valid(left, current);
        this.left = left;
        this.current = current;
    }

    public static Point init(boolean current) {
        return new Point(false, current);
    }

    public Point next(LineStrategy lineStrategy) {
        if (hasLineBefore()) {
            return new Point(this.current, false);
        }

        return new Point(this.current, lineStrategy.random());
    }

    public boolean hasLineBefore() {
        return !left && current;
    }

    private void valid(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return hasLineBefore() ? "-----|" : "     |";
    }
}
