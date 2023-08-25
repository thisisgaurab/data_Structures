public class EdgeNode implements Comparable<EdgeNode> {
    private int vertex1;
    private int vertex2;
    private int weight;

    public EdgeNode(int vertex1, int vertex2, int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    // Setter and getter methods for vertex1
    public void setVertex1(int vertex1) {
        this.vertex1 = vertex1;
    }

    public int getVertex1() {
        return vertex1;
    }

    // Setter and getter methods for vertex2
    public void setVertex2(int vertex2) {
        this.vertex2 = vertex2;
    }

    public int getVertex2() {
        return vertex2;
    }

    // Setter and getter methods for weight
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    // compareTo() method to implement the Comparable interface
    public int compareTo(EdgeNode n) {
        if (this.weight < n.weight) {
            return -1;
        } else if (this.weight > n.weight) {
            return 1;
        } else {
            return 0;
        }
    }
}