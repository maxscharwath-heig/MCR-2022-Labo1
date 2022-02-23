public class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Vector2D fromAngleLength(double angle, double length) {
        return new Vector2D(Math.cos(angle) * length, Math.sin(angle) * length);
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void add(Vector2D v) {
        this.x += v.getX();
        this.y += v.getY();
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void sub(Vector2D v) {
        this.x -= v.getX();
        this.y -= v.getY();
    }

    public void sub(double x, double y) {
        this.x -= x;
        this.y -= y;
    }

    public void mul(double d) {
        this.x *= d;
        this.y *= d;
    }

    public void div(double d) {
        this.x /= d;
        this.y /= d;
    }

    public double dot(Vector2D v) {
        return this.x * v.getX() + this.y * v.getY();
    }

    public double cross(Vector2D v) {
        return this.x * v.getY() - this.y * v.getX();
    }

    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public void setLength(double length) {
        double l = length / this.length();
        this.x *= l;
        this.y *= l;
    }

    public double getAngle() {
        return Math.atan2(this.y, this.x);
    }

    public void setAngle(double angle) {
        double l = this.length();
        this.x = Math.cos(angle) * l;
        this.y = Math.sin(angle) * l;
    }

    public void normalize() {
        double d = this.length();
        this.x /= d;
        this.y /= d;
    }

    public Vector2D copy() {
        return new Vector2D(this.x, this.y);
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
