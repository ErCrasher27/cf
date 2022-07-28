/*Modifica effettuata da Nicola Piccirillo il giorno 28/07/2022*/
/*Modifica effettuata: Acquisione dei dati da input per il calcolo del codice fiscale*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
        
public class Main {
    public static void main(String[] args) throws IOException {
        // git repo added

        Scanner input = new Scanner(System.in);
        
        /*Acquisione del cognome da tastiera*/
        System.out.println("Inserire il cognome della persona: ");
        String cognome = input.nextLine();
        /*Acquisione del nome da tastiera*/
        System.out.println("Inserire il nome della persona: ");
        String nome = input.nextLine();
        /*Acquisione del giorno di nascita da tastiera*/
        System.out.println("Inserire il giorno di nascita: ");
        int giornonascita = input.nextInt();
        /*Acquisione del mese di nascita da tastiera*/
        System.out.println("Inserire il mese di nascita(INSERIRE IL NUMERO DEL MESE COMPRESO TRA 1 e 12): ");
        int mesenascita = input.nextInt();
        /*Acquisione dell'anno di nascita da tastiera*/
        System.out.println("Inserire l'anno di nascita: ");
        int annonascita = input.nextInt();
        boolean f = false;
        String M = "M";
        String F = "F";
        String sesso;
        while(f==true)
        {
                /*Acquisione del sesso da tastiera*/
                System.out.println("Inserire il sesso della persona(INSERIE M o F): ");
                sesso = input.nextLine();
                if(sesso.equals(M))
                {
                        f = true;
                }
                else if(sesso.equals(F))
                {
                        f = true;
                }
        }
        /*Acquisione del comune di nascita da tastiera*/
        System.out.println("Inserisci il comune di nascita: ");
        String comune = input.nextLine();
        Persona persona = new Persona(cognome,nome,giornonascita,mesenascita,annonascita,sesso,comune);

        // prendo le due liste di nome cognome (le scelte per il cf)
        List<Character> cognome_cf_lista = persona.cognome_cf();
        List<Character> nome_cf_lista = persona.nome_cf();

        // converto in stringa le due liste
        String cognome_cf_stringa = cognome_cf_lista.toString()
                .substring(1, 3 * cognome_cf_lista.size() - 1)
                .replaceAll(", ", "");
        String nome_cf_stringa = nome_cf_lista.toString()
                .substring(1, 3 * nome_cf_lista.size() - 1)
                .replaceAll(", ", "");

        // buildo la stringa codice fiscale base (senza lettera di controllo)
        String cf_base = cognome_cf_stringa + "" + nome_cf_stringa + "" +
                persona.anno_cf() + "" +
                persona.mese_cf() + "" + persona.giorno_sesso_cf() + "" + persona.luogo_nascita_cf();

        // lettera di controllo
        String lettera_di_controllo = persona.lettera_controllo_cf(cf_base);

        // stampo cf completo
        String cf_completo = cf_base.toUpperCase() + lettera_di_controllo.toUpperCase();
        System.out.println(cf_completo);

    }
}