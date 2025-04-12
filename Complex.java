/*Definiti o clasa Complex care modeleza lucrul cu numere complexe. Membrii acestei
clase sunt:
• doua atribute de tip double pentru partile reala, respectiv imaginara ale numarului
complex
• un constructor cu doi parametri de tip double, pentru setarea celor doua parti
ale numarului(reala si imaginara)
• o metoda de calcul a modulului numarului complex. Se precizeaza ca modulul
unui numar complex este egal cu radical din (re*re+img*img) unde re este
partea reala, iar img este partea imaginara. Pentru calculul radicalului se va
folosi metoda statica predefinita Math.sqrt care necesita un parametru de tip
double ¸si returneaza tot un double
• o metoda de afisare pe ecran a valorii numarului complex, sub forma re + i *im
• o metoda care returneaza suma dintre doua obiecte complexe. Aceasta metoda
are un parametru de tip Complex si returneaza suma dintre obiectul curent
(obiectul care ofera serviciul de adunare) si cel primit ca parametru. Tipul
returnat de aceasta metoda este Complex.
• o metoda care returneaza de cate ori s-au afisat pe ecran numere complexe.
Pe langa clasa Complex se va defini o clasa ClientComplex care va contine ıntr-o
metoda main exemple de utilizare ale metodelor clasei Complex. */
public class Complex {
    private double real;
    private double imaginar;
    private static int contor=0;

    public Complex(double parte_reala, double parte_imaginara){
        real=parte_reala;
        imaginar=parte_imaginara;
    }

    public double Calcul(){
        double m;
        m=Math.sqrt(real*real+imaginar*imaginar);
        return m;
    }
    public void afisare()
    {
        System.out.println("Numar complex:"+real+"+"+"i*"+imaginar);
        contor++;
    }
    public Complex suma(Complex numar)
    {
       double prt_reala=this.real+numar.real;
       double prt_imaginara=this.imaginar+numar.imaginar;
       return new Complex(prt_reala,prt_imaginara);
    } 

    public int getNumereComplexe(){
        return contor;
    }

}

class ClientComplex{
    public static void main(String[] args)
    {
        Complex numar1=new Complex(5, 2);
        Complex numar2=new Complex(3,6);
        numar1.afisare();
        System.out.println("Modulul numarului este:"+numar1.Calcul());
        numar2.afisare();
        System.out.println("Modulul numarului este:"+numar2.Calcul());
        Complex rezultat=numar1.suma(numar2);
        rezultat.afisare();
        System.out.println("Numere complexe afisate:"+numar1.getNumereComplexe());
        
    }
}
