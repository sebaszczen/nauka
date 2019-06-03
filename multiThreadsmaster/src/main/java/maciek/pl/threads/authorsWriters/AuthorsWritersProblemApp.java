package maciek.pl.threads.authorsWriters;
//mogą się odwolywć do tego samego obiektu.
//Auto podrzuca teksty
//writer wypisuje na konsoli
//problem-> jeden wspóldzielony zasob cyzli tekst obiektu
//syngronizowac jeden zasob lub całą metodę -> lepiej mniej synchronizować
// autor wymysla i dopiero jak to zrobi to writer to wypisze. Ale nie wczesniej

public class AuthorsWritersProblemApp {

    public static void main(String[] args) {
        Article a = new Article();

        Thread threadA = new Thread(new Author(a));
        Thread threadW = new Writer(a);
        threadA.start();
        threadW.start();



    }




}
