/*O carte este caracterizata printr-un numar de pagini. Spunem ca doua carti sunt
identice daca acestea au acelasi numar de pagini. Creati clasa Carte si atasati-i o
metoda potrivita pentru compararea a doua carti. Apelati metoda care realizeaza
compararea a doua carti ıntr-o metoda main.*/

public class Carte {

    private int numar_pagini;

    public Carte(int nr_pagini){
        this.numar_pagini=nr_pagini;
    }
    public boolean equals(Object o)
    {
        if(o instanceof Carte)
            return (((Carte)o).numar_pagini==numar_pagini);
        else
            return false;
    }

    public static void main(String[] args){
        Carte c1=new Carte(120);
        Carte c2=new Carte(150);

        if(c1.equals(c2))
            System.out.println("Numarul de pagini ale cartiilor e egal");
        else
            System.out.println("Numarul de pagini al cartiilor nu e egal");    
    }
}
