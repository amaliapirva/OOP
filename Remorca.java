/*Un obiect tir este format dintr-un număr de maxim 5 obiecte remorcă. 
Un tir memorează întrun tablou referințe la obiectele remorcă pe care le conține la un moment dat. 
Fiecare remorcă este caracterizată de un întreg care reprezintă cantitatea de cutii de marfă pe care le poate transporta și de un număr de înmatriculare (String).
Pentru o remorcă vom avea doi constructori.
Unul va seta ambele caracteristici așa cum sunt date prin parametrii constructorului. 
Al doilea, primește ca valoare doar numărul de înmatriculare și va seta numărul de cutii ce pot fi transportate ca fiind 1 + numărul de cutii a ultimului obiect remorcă creat anterior celui curent.
Dacă nu s-a mai creat un astfel de obiect până acum, numărul de cutii va fi setat pe 10. 
Evident, o remorcă poate conține și alte elemente de care considerați că este nevoie. 
Asupra unui tir se pot realiza următoarele operații: 
• adaugaRemorca: ce primește ca parametru numărul de cutii de marfă și un număr de înmatriculare. 
Dacă mai există poziții libere în tabloul de remorci, se crează un nou obiect remorcă ce este adăugat tirului iar metoda de adăugare întoarce true.
 Altfel, metoda întoarce false.
  • adaugaRemorca: ce primește ca parametru o referință la o remorcă pe care o adaugă în tabloul de remorci a tirului pe următoarea poziție liberă. 
  Dacă operația nu se poate efectua (nu mai este loc) metoda returnează false altfel true. 
  • stergeRemorca: ce primește ca parametru un număr de înmatriculare pentru o remorcă.
   Dacă în tir există o remorcă cu acel număr de înmatriculare, atunci ea va fi înlăturată din tir și metoda întoarce o referință la obiectul remorcă eliminat.
    Altfel, metoda întoarce null. 
    • o operație ce ne spune dacă două tiruri sunt egale, situație adevărată atunci când două tiruri pot transporta în total aceeași cantitate de cutii de marfă.
     • o operație ce întoarce reprezentarea obiectului tir sub formă de șir de caractere. 
     Acesta va avea forma: “T -> R1 -> … -> Rn” unde Ri sunt reprezentarea sub formă de șir de caractere a fiecărei remorci (sub forma “R(nr_inmatriculare, nr_cutii)” conținute de tir.
Se va implementa și o metodă main (într-o clasă separată) în care se vor crea cel puțin două tiruri distincte și se va exemplifica funcționarea fiecărei operații cu fiecare comportament distinct observabil de către client. */
public class Remorca {
    private static int lastCuti = 10;
    private int cutii;
    private String nrInmatriculare;

    public Remorca(int cutii, String nrInmatriculare) {
        this.cutii = cutii;
        this.nrInmatriculare = nrInmatriculare;
        lastCuti = cutii;
    }


    public Remorca(String nrInmatriculare) {
        this.cutii = lastCuti + 1;
        this.nrInmatriculare = nrInmatriculare;
        lastCuti = this.cutii;
    }

    public int getCutii() {
        return cutii;
    }

    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    
    public String toString() {
        return "R(" + nrInmatriculare + ", " + cutii + ")";
    }
}
class Tir {
    private static final int MAX_REMORCI = 5;
    private Remorca[] remorci;
    private int nrRemorci;

    public Tir() {
        remorci = new Remorca[MAX_REMORCI];
        nrRemorci = 0;
    }
    
    public boolean adaugaRemorca(int cutii, String nrInmatriculare) {
        if (nrRemorci < MAX_REMORCI) {
            remorci[nrRemorci++] = new Remorca(cutii, nrInmatriculare);
            return true;
        }
        return false;
    }

    
    public boolean adaugaRemorca(Remorca remorca) {
        if (nrRemorci < MAX_REMORCI) {
            remorci[nrRemorci++] = remorca;
            return true;
        }
        return false;
    }


    public Remorca stergeRemorca(String nrInmatriculare) {
        for (int i = 0; i < nrRemorci; i++) {
            if (remorci[i].getNrInmatriculare().equals(nrInmatriculare)) {
                Remorca eliminata = remorci[i];
                for (int j = i; j < nrRemorci - 1; j++) {
                    remorci[j] = remorci[j + 1];
                }
                remorci[--nrRemorci] = null; 
                return eliminata;
            }
        }
        return null;
    }

    
    public boolean equals(Tir altTir) {
        return this.getTotalCutii() == altTir.getTotalCutii();
    }

    
    private int getTotalCutii() {
        int total = 0;
        for (int i = 0; i < nrRemorci; i++) {
            total += remorci[i].getCutii();
        }
        return total;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("T");
        for (int i = 0; i < nrRemorci; i++) {
            sb.append(" -> ").append(remorci[i].toString());
        }
        return sb.toString();
    }
    
}

class Main {
    public static void main(String[] args) {        
        Tir tir1 = new Tir();
        Tir tir2 = new Tir();

        tir1.adaugaRemorca(10, "TM01PRW");
        tir1.adaugaRemorca(5, "TM02WSS");

        Remorca remorcaNoua = new Remorca("TM03GRU"); 
        tir2.adaugaRemorca(remorcaNoua);
        tir2.adaugaRemorca(15, "TM04EVE");

        System.out.println("Tir 1: " + tir1);
        System.out.println("Tir 2: " + tir2);

        Remorca eliminata = tir1.stergeRemorca("TM02WSS");
        System.out.println("Remorca eliminata din tir1: " + eliminata);
        System.out.println("Tir 1 dupa stergere: " + tir1);

        System.out.println("Tir 1 egal cu Tir 2? " + tir1.equals(tir2));

        if (eliminata != null) {
            tir2.adaugaRemorca(eliminata);
        }

        System.out.println("Tir 2 dupa adaugare remorca eliminata: " + tir2);
        System.out.println("Tir 1 egal cu Tir 2? " + tir1.equals(tir2));
    }
}
