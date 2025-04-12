/*Scrieti un program Java care afiseaza pe ecran numerele impare si suma numerelor
pare cuprinse ın intervalul 1-100 inclusiv. */
public class ex3 {
    
    public static void main(String[] args) {
        int suma=0;
     for (int i = 1; i < 100; i++) {
        if(i%2!=0)
        {
            System.out.println(i);
        }
        else
        {
            suma=suma+i;
        }  
        }
        System.out.println("Suma numerelor pare este "+suma);
    }
}
