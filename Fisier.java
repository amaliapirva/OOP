/*Versiuni de fișiere
Într-un sistem de versionare de fișiere text (un sistem care ține minte conținutul fișierului dar și conținutul fișierului 
înainte de fiecare modificare a sa), un fișier este reprezentat ca și obiect.
Un astfel de obiect este caracterizat de numele său (String), conținut (String) și un id unic (int) al obiectului. 
Conținutul și numele fișierului se setează la crearea obiectului folosind un constructor. 
Identificatorul trebuie și el setat la crearea obiectului folosind un mecanism implementat de voi și trebuie să fie transparent pentru clientul unui obiect fișier 
(adică, de exemplu,  valoare id-ului nu trebuie să fie dat de client prin constructor, etc.). 
Fiecare fișier mai conține în starea sa o referință către un alt obiect fișier care reprezintă versiunea anterioară a obietului 
fișier curent. La crearea unui obiect fișier, acesta nu are versiuni anterioare. 
Pe un fișier putem realiza în continuare următoarele operații: 
salveazaVersiune: această metodă crează un nou obiect fișier a cărui nume e dat de numele f ișierului pe care s-a apelat metoda,
 la care se adaugă șirul “bak”.
Conținutul noului fisier va fi identic cu al fișierului pe care am apelat operația. 
În continuare, noul fișier este înregistrat ca versiune anterioară a fișierului curent folosind câmpul descris anterior și dedicat acestui lucru.
Evident, versiunea anterioară a fisierului pe care am apelat metoda este inregistrată ca și versiune anterioară a noului obiect fișier creat. 
concateneaza: care primește ca parametru o referință către un alt obiect fișier și concatenează conținutul său la conținutul obiectului pe care am apelat metoda. 
Înainte de a face aceste operații, se salveaza o nouă versiune pentru fișierul pe care am apelat metoda toString: care întoarece un șir de caractere de forma: “id nume_fisier [ continut ] <sirul de caractere similar corespunzător versiunii anterioare 
(daca exista) a fișierului curent>
 numărConcatenari: care intoarce numărul de concatenări care au fost efectuate pe un fișier 
Implementați clasa Fisier iar într-o clasă separată implementați un main în care să se evidențieze toate funcționalitățile descrise anterior.  */
public class Fisier {
    private String nume;
    private String continut;
    private int ID_unic;
    private static int generatorID=0;
    private Fisier versiune_anterioara=null;
    private  int numărConcatenari=0;

    public Fisier(String c,String n){
        this.continut=c;
        this.nume=n;
        this.ID_unic=++generatorID;
    }

    public Fisier salveazaVersiune()
    {
        Fisier versiuneNoua=new Fisier(this.continut,this.nume+"bak");
        versiuneNoua.versiune_anterioara=this.versiune_anterioara;
        this.versiune_anterioara=versiuneNoua;
        return versiuneNoua;
    }
    public Fisier concateneaza(Fisier altFisier)
    {
        this.salveazaVersiune();
        this.continut+=altFisier.continut;
        this.numărConcatenari++;
        return this;
    } 

    public String toString(){
        if(versiune_anterioara != null)
            return ID_unic+" "+nume+"["+continut+"]"+"<"+versiune_anterioara.toString()+">";
        else
            return ID_unic+" "+nume+"["+continut+"]";
    }
    public int getNumarConcatenari()
    {
        return this.numărConcatenari;
    }

}
class Main{
    public static void main(String[] args) {
        Fisier f1=new Fisier("Acesta este primul fisier","Fisier1");
        Fisier f2=new Fisier("Acesta este al doilea fisier", "Fisier2");
        
        System.out.println(f1.toString());
        System.out.println(f2.toString());
        System.out.println(f1.concateneaza(f2));
        
        System.out.println(f1.getNumarConcatenari());  
        
    }
}
