public class ex2 {
    private  int valoare1=12;
    private  int valoare2=15;

    public void Maxim(){
        if(valoare1>valoare2)
        {
            System.out.println(valoare1);
        }
        else
        {
            System.out.println(valoare2);
        }
    }
    public static void main(String argv[])
    {
        ex2 obj=new ex2();
        obj.Maxim();
    }

}
