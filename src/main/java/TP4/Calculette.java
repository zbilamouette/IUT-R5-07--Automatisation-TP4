import java.util.Stack;

public class Calculette {


    public static void main(String[] args) {

        Calculette calc = new Calculette();
        calc.push(1.0);
        // calc.push(3.0);

        try {
            System.out.println(calc.getResultat());
            calc.soustraction();
            System.out.println(calc.getResultat());
        } catch (Exception e) {
            System.out.println("error");
        }


    }

    private Stack<Double> pile;

    public Calculette() {
        pile = new Stack<>();
    }

    // Méthode pour ajouter un nombre à la pile
    public void push(double nombre) {
        pile.push(nombre);
    }

    // Méthode pour effectuer l'addition
    public void addition() throws Exception {
        if (pile.size() < 2) {
            throw new Exception("Pas assez d'opérandes pour l'addition");
        }
        double b = pile.pop();
        double a = pile.pop();
        pile.push(a + b);
    }

    // Méthode pour effectuer la soustraction
    public void soustraction() throws Exception {
        if (pile.size() < 2) {
            throw new Exception("Pas assez d'opérandes pour la soustraction");
        }
        double b = pile.pop();
        double a = pile.pop();
        pile.push(a - b);
    }

    // Méthode pour effectuer la multiplication
    public void multiplication() throws Exception {
        if (pile.size() < 2) {
            throw new Exception("Pas assez d'opérandes pour la multiplication");
        }
        double b = pile.pop();
        double a = pile.pop();
        pile.push(a * b);
    }

    // Méthode pour effectuer la division
    public void division() throws Exception {
        if (pile.size() < 2) {
            throw new Exception("Pas assez d'opérandes pour la division");
        }
        double b = pile.pop();
        if (b == 0) {
            throw new Exception("Division par zéro impossible");
        }
        double a = pile.pop();
        pile.push(a / b);
    }

    // Méthode pour obtenir le résultat
    public double getResultat() throws Exception {
        if (pile.isEmpty()) {
            throw new Exception("La pile est vide, aucun résultat disponible");
        }
        return pile.peek();
    }

    // Méthode pour traiter une chaîne en Notation Polonaise Inverse (NPI)
    public void calculerNPI(String expression) throws Exception {
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            switch (token) {
                case "+":
                    addition();
                    break;
                case "-":
                    soustraction();
                    break;
                case "*":
                    multiplication();
                    break;
                case "/":
                    division();
                    break;
                default:
                    // Si le token est un nombre, on l'ajoute à la pile
                    try {
                        double nombre = Double.parseDouble(token);
                        push(nombre);
                    } catch (NumberFormatException e) {
                        throw new Exception("Opérateur ou nombre invalide : " + token);
                    }
                    break;
            }
        }
    }
}
