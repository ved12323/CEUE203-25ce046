import java.util.Scanner;
public class Driver{
    public static void main(String[] args)
    {
        String logs[]={
            "10:05 alice Hello there",
            "10:06 charlie",
            "10:07 bob Good Morning",
            "10:08 Hello"
        };

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Keyword: ");
        String Keyword = sc.nextLine();

        String result=ChatFilter.Filterlogs(logs,Keyword);
        System.out.println(result);

        sc.close();
    }
}