public class Planet{
    double x;
    double y;
    double mass;

    public Planet(double x, double y, double mass){
        this.x = x;
        this.y = y;
        this.mass = mass;
    }

    double distanceTo(Planet other){
        double distance1 = other.x - this.x;
        double distance2 = other.y - this.y;

        return Math.sqrt(Math.pow(distance1, 2) + Math.pow(distance2, 2));
    }

    public static double totalMass(Planet[] planets){
        double total = 0;
        for(Planet p : planets){
            total += p.mass;
        }


        return total;
    }
}

void main() {
    Planet p1 = new Planet(5, 10, 100);
    Planet p2 = new Planet(1, 2, 200);
    IO.println(p1.distance_to(p2));
    IO.println(Planet.total_mass(new Planet[] {p1,p2}));
}

