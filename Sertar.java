/*Un sertar este caracterizat de o latime, lungime si ınaltime. Un birou are doua
sertare si, evident, o latime, lungime si ınaltime. Creati clasele Sertar si Birou
corespunzatoare specificatiilor de mai sus. Creati pentru fiecare clasa constructorul
potrivit astfel ıncat carateristicile instantelor sa fie setate la crearea acestora.
Clasa Sertar contine o metoda tipareste al carei apel va produce tiparirea pe ecran
a sertarului sub forma ”Sertar ” + l + L + H, unde l, L, H sunt valorile coresupunzatoare
 latimii, lungimii si ınaltimii sertarului. Clasa Birou contine o metoda
tipareste cu ajutorul careia se vor tipari toate componentele biroului. Creati ıntr-o
metoda main doua sertare, un birou si tipariti componentele biroului */
public class Sertar {
    private int latime;
    private int lungime;
    private int inaltime;

    public Sertar(int l, int L, int H) {
        latime = l;
        lungime = L;
        inaltime = H;
    }

    public void tipareste() {
        System.out.println("Sertar " + latime + " " + lungime + " " + inaltime);
    }
}

class Birou {
    private Sertar sertar1;
    private Sertar sertar2;
    private int latime;
    private int lungime;
    private int inaltime;

    public Birou(Sertar sertar1, Sertar sertar2, int l, int L, int H) {
        this.sertar1 = sertar1;
        this.sertar2 = sertar2;
        this.latime = l;
        this.lungime = L;
        this.inaltime = H;
    }

    public void tipareste() {
        System.out.println("Componente birou:");
        sertar1.tipareste();
        sertar2.tipareste();
        System.out.println("Dimensiuni birou: " + latime + " " + lungime + " " + inaltime);
    }

    public static void main(String[] args) {
        Sertar s1 = new Sertar(1, 3, 5);
        Sertar s2 = new Sertar(2, 5, 9);
        Birou b = new Birou(s1, s2, 4, 5, 7);
        b.tipareste();
    }
}
