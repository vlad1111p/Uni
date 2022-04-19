

public class Vec2 {
    final double x;
    final double y;

    public Vec2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }

    public double lengthSquared() {
        return x * x + y * y;
    }

    public Vec2 mult(double factor) {
        return new Vec2(x * factor, y * factor);
    }

    public Vec2 plus(Vec2 other) {
        return new Vec2(x + other.x, y + other.y);
    }

    public Vec2 minus(Vec2 other) {
        return new Vec2(x - other.x, y - other.y);
    }

    public double skalarProdukt(Vec2 other) {
        return x * other.x + y * other.y;
    }

    public double distanceTo(Vec2 position) {
        return this.minus(position).length();
    }

    public Vec2 normalized(double newLength) {
        double len = length();
        if (len > 0) {
            return new Vec2(x * newLength / len, y * newLength / len);
        } else {
            return this;
        }
    }

    public double distanceToLine(Vec2 start, Vec2 ende) {
        Vec2 direction = ende.minus(start).normalized(1);
        Vec2 delta = this.minus(start);
        double closest = delta.skalarProdukt(direction);
        if (closest < 0) {
            return distanceTo(start);
        } else if (closest > start.distanceTo(ende)) {
            return distanceTo(ende);
        } else {
            return Math.sqrt(delta.length() * delta.length() - closest * closest);
        }
    }

}
