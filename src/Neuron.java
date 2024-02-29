public class Neuron {
    private double[] W = new double[4]; //Вектор вагових коефіцієнтів
    private double o;  //порогове значення
    private double n;  //коефіцієнт швидкості навчання
    public Neuron(){
        this.o=0.5;
        this.n=0.1;
        for (double w : this.W){
            w=0.4;
        }
    }
    public Neuron(double o, double n, double[] W){
        this.o=o;
        this.n=n;
        this.W=W;
    }
    public double getO(){return o;}
    public void setA(double a){this.o = o;}
    public double getN(){return n;}
    public void setN(double n){this.n = n;}
    public double[] getW(){return W;}
    public void setW(double[] w){W = w;}
    public double function(int[] X){     //Скалярний добуток вектору компонент та вагових коефіцієнтів.
        double a=W[3];
        for (int i=0; i<3; i++){
            a+=X[i]*W[i];
        }
        return a;
    }
    public int result(int[] X){          //Значення активаційної функції
        double a=function(X);
        if (a<o) return 0;
        else return 1;
    }
    public  void train(){               //Тренування нейрона (Перебираються всі можливі випадки)
        int[] X={1, 1, 1};
        double[] bW=new double[4];
        double T, Y, bo, a;
        boolean run = true;
        for (int iter = 1; run; iter++){
            System.out.println("\n" + iter + " iteration:");
            run = false;
            System.out.printf("%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s\n",
                    "w1", "w2", "w3", "w4", "o", "x1", "x2", "x3", "a", "Y", "T",
                    "n(T-Y)", "bw1", "bw2", "bw3", "bw4", "bo");
            for (int i = 0; i < 2; i++) {
                X[0] = 1 - X[0];
                for (int j = 0; j < 2; j++) {
                    X[1] = 1 - X[1];
                    for (int k = 0; k < 2; k++) {
                        X[2] = 1 - X[2];
                        if (X[0] == 1 || X[1] == 1 || X[2] == 1) T = 1;
                        else T = 0;
                        Y = result(X);
                        if (T!=Y) run = true;
                        a = function(X);
                        bW[3] = n * (T - Y);
                        for (int l = 0; l < 3; l++) {
                            bW[l] = bW[3] * X[l];
                        }
                        bo = o * bW[3];
                        System.out.printf("%10f%10f%10f%10f%10f%10s%10s%10s%10f%10f%10f%10f%10f%10f%10f%10f%10f\n",
                                W[0], W[1], W[2], W[3], o, X[0], X[1], X[2], a, Y, T, bW[3], bW[0], bW[1], bW[2], bW[3], bo);
                        for (int l = 0; l < 4; l++) {
                            W[l] += bW[l];
                        }
                        o += bo;
                    }
                }
            }
        }
    }
}
