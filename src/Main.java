import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double o, n;
        double[] W = new double[4];
        System.out.println("Input threshold value:");          //Користувач уводить початкові властивості нейрона
        o=scan.nextDouble();
        System.out.println("Input learning rate factor:");
        n=scan.nextDouble();
        System.out.println("Input four initial weighting factors:");
        for(int i=0; i<4; i++){W[i]=scan.nextDouble();}
        Neuron myNeuron = new Neuron(o, n, W);
        boolean run=true;
        int choice;
        int[] X = new int[3];
        while(run){
            System.out.println("\nChoose option:\n1 - Training\n2 - Calculating\nOther - Finish"); //Вибір режиму роботи
            choice=scan.nextInt();
            switch(choice){
                case (1):                                                   //Тренування нейрона
                    myNeuron.train();
                    break;
                case (2):                                                   //Використання нейрона
                    System.out.println("Enter the inputs:");
                    for(int i=0; i<3; i++){X[i]=scan.nextInt();}
                    System.out.println("Result:"+myNeuron.result(X));
                    break;
                default:                                                    //Закінчення роботи
                    run=false;
                    break;
            }
        }
    }
}