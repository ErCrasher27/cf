package codicefiscalecalcolatore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        Persona persona = new Persona("grauso ", "francesco", 27, 8, 2002, "M",
                "MASSA DI SOMMA");a

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