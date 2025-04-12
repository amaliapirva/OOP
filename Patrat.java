/*Un patrat este caracterizat de latura sa. Scrieti o clasa Patrat ce are doi constructori,
un constructor fara nici un parametru care seteaza latura patratului ca fiind 10
iar altul care seteaza latura cu o valoare egala cu cea a unui parametru transmis
constructorului. Atasati clasei o metoda potrivita pentru tiparirea unui patrat sub
forma ”Patrat” l ”Aria” a, unde l este valoarea laturii iar a este valoarea ariei
patratului. Creati ıntr-o metoda main diferite obiecte de tip Patrat si tipariti-le.*/

public class Patrat {

    private int latura;

    public Patrat(){
        this.latura=10;
    }
    public Patrat(int l){
        this.latura=l;
    }
    public String toString(){
        int a=latura*latura;
        return "Patrat:"+latura+"Aria:"+a;
    }

    public static void main(String[] args)
    {
        Patrat p1=new Patrat();
        Patrat p2=new Patrat(5);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
}
