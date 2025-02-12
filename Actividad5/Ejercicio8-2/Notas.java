package Notas;

class Notas {
    double[] listaNotas;

    public Notas() {
        listaNotas = new double[5];
    }

    double calcularPromedio() {
        double suma = 0;
        for (double nota : listaNotas) {
            suma += nota;
        }
        return suma / listaNotas.length;
    }

    double calcularDesviacion() {
        double prom = calcularPromedio();
        double suma = 0;
        for (double nota : listaNotas) {
            suma += Math.pow(nota - prom, 2);
        }
        return Math.sqrt(suma / listaNotas.length);
    }

    double calcularMenor() {
        double menor = listaNotas[0];
        for (double nota : listaNotas) {
            if (nota < menor) {
                menor = nota;
            }
        }
        return menor;
    }

    double calcularMayor() {
        double mayor = listaNotas[0];
        for (double nota : listaNotas) {
            if (nota > mayor) {
                mayor = nota;
            }
        }
        return mayor;
    }
}
