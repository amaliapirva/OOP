/*Un obiect telefon este caracterizat de numele proprietarului (String) ce se setează la crearea obiectului respectiv.
Un telefon mai conține un tablou (eventual și un contor dacă se consideră necesar ;)) ce memorează nume de proprietari
de telefoane (String-uri) care au apelat telefonul respectiv.
Pentru simplitate, acest tablou va conține maxim 100 de elemente. 
Cu un telefon se pot realiza următoarele operații:
  • apeleaza: această metodă primește ca parametru o referință la obiectul telefon apelat de telefonul curent.
În continuare se adaugă numele proprietarului telefonului pe care s-a apelat metoda, în lista de nume a telefonului dat ca parametru la aceasta metodă.
Dacă nu mai este loc în tabloul respectiv, metoda apelare întoarce valoarea false (adică apelul nu a reușit).
Altfel, metoda întoarce valoarea true.
 • numarDeApeluri: această metodă primește ca parametru un String reprezentând numele unui proprietar de telefon și întoarce o referintă la un obiect Integer ce conține numărul de apeluri efectuate de respectiva persoană la telefonul curent.
 • toString: returnează un șir de caractere conținând numele proprietarului și numele tuturor persoanelor care au apelat telefonul respectiv.
  Pentru exemplificare, creați o clasă separată care conține o metodă main în care: 
  • Se citește de la intrarea standard un număr întreg. Acest număr reprezintă câte telefoane trebuie create.
   Se vor crea apoi aceste telefoane și se vor memora într-un tablou referințe la ele.
Numele proprietarilor vor fi citite tot de la intrarea standard. 
• Se citește de la intrarea standard un număr A reprezentând un număr de apeluri de efectuat.
Apoi se generează aleator A perechi de numere întregi (x,y) semnificând faptul ca telefonul x din tabloul de mai sus apelează telefonul y din același tablou.
Pentru generarea de numere aleatoare vezi documentația de aici sau de aici (în al doilea caz trebuind să aveți un import java.util.Random; 
la începutul fișierului). 
• Se citește de la intrarea standard un nume de proprietar. 
Pentru fiecare telefon se va afișa la ieșirea standard reprezentarea sa sub formă de șir de caractere și de căte ori persoana cu numele dat a apelat acel telefon. */
import java.util.*;

public class Telefon {

    private String proprietar;
    private String[] apeluri;
    private int nrApeluri;
    public Telefon(String proprietar)
    {
        this.proprietar=proprietar;
        this.apeluri=new String[100];
        this.nrApeluri=0;
    }

    public boolean apeleaza(Telefon destinatar)
    {
        if(destinatar.nrApeluri>=100)
        {
            return false;
        }else{
            destinatar.apeluri[destinatar.nrApeluri++]=this.proprietar;
            return true;
        }
    }
    public Integer numarDeApeluri(String nume){

        int count=0;
        for(int i=0; i< nrApeluri; i++)
        {
            if(apeluri[i].equals(nume)){
                count++;
            }
        }
        return count;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder("Telefonul lui"+ proprietar+"Apeluri primite de la: ");
        if(nrApeluri==0){
            sb.append("nimeni");
        }else{
            for(int i=0; i<nrApeluri; i++)
            {
                sb.append(apeluri[i]);
                if(i<nrApeluri-1){
                    sb.append(", ");
                }
            }
        }
        return sb.toString();
    }
}

class Main{
    public static void main(String[] args) {
        Random random = new Random();

        int n = 3;
        Telefon[] telefoane = new Telefon[n];

        
        telefoane[0] = new Telefon("Alice");
        telefoane[1] = new Telefon("Bob");
        telefoane[2] = new Telefon("Carol");

        
        int A = 5;

        for (int i = 0; i < A; i++) {
            int x = random.nextInt(n);
            int y = random.nextInt(n);

            if (x != y) { 
                boolean succes = telefoane[x].apeleaza(telefoane[y]);
                if (!succes) {
                    System.out.println("Telefonul lui " + telefoane[y].toString() + " are lista de apeluri plină.");
                }
            }
        }

        String numeVerificare = "Bob";

        for (Telefon telefon : telefoane) {
            System.out.println(telefon.toString());
            System.out.println("Numar de apeluri de la " + numeVerificare + ": " + telefon.numarDeApeluri(numeVerificare));
            System.out.println();
        }
    }
}
