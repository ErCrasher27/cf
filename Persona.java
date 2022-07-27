package codicefiscalecalcolatore;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Persona {
    String cognome, nome, luogo_nascita = null;
    int giorno_nascita, mese_nascita, anno_nascita = 0;
    String sesso = null;

    public Persona(String cognome, String nome, int giorno_nascita, int mese_nascita, int anno_nascita, String sesso,
            String luogo_nascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.giorno_nascita = giorno_nascita;
        this.mese_nascita = mese_nascita;
        this.anno_nascita = anno_nascita;
        this.sesso = sesso;
        this.luogo_nascita = luogo_nascita;
    }

    public List<Character> cognome_cf() {

        // dichiaro lista risultato
        List<Character> res_cognome = new ArrayList<Character>();

        // dichiaro booleano e tentativi
        boolean vocale = false;
        int tentativi = 1;

        // dichiaro gli array vocali
        char[] vocali = { 'a', 'e', 'i', 'o', 'u' };

        // scompongo il cognome in array char
        char[] cognome_scomposto = new char[this.cognome.length()];
        // copia array in cognome_scomposto
        for (int i = 0; i < this.cognome.length(); i++) {
            cognome_scomposto[i] = this.cognome.charAt(i);
        }

        // ciclo per la lenght del cognome, setto la booleana vocale a false come
        // semaforo, poi ciclo per quante sono le vocali e setto la booleana, se false
        // copio in array result

        while (res_cognome.size() < 3) {
            if (tentativi == 1) {
                for (int i = 0; i < this.cognome.length(); i++) {
                    // se il res è = 3 allora break
                    if (res_cognome.size() == 3) {
                        break;
                    }
                    vocale = false;
                    for (int j = 0; j < vocali.length; j++) {
                        // comparo cognome[i] e vocale[j]
                        if (cognome_scomposto[i] == vocali[j]) {
                            vocale = true;
                            break;
                        }
                    }
                    // pusho il risultato
                    if (!vocale) {
                        res_cognome.add(cognome_scomposto[i]);
                    }
                }
            } else if (tentativi == 2) {
                for (int i = 0; i < this.cognome.length(); i++) {
                    // se il res è = 3 allora break
                    if (res_cognome.size() == 3) {
                        break;
                    }
                    vocale = false;
                    for (int j = 0; j < vocali.length; j++) {
                        // comparo cognome[i] e vocale[j]
                        if (cognome_scomposto[i] == vocali[j]) {
                            vocale = true;
                        }
                    }
                    // pusho il risultato (stavolta solo se è vocale)
                    if (vocale) {
                        res_cognome.add(cognome_scomposto[i]);
                    }
                }
                // riempio di x fino a 3
            } else if (tentativi == 3) {
                while (res_cognome.size() < 3) {
                    res_cognome.add('x');
                }

            }
            tentativi += 1;
        }

        return res_cognome;
    }

    public List<Character> nome_cf() {

        // dichiaro lista risultato
        List<Character> res_nome = new ArrayList<Character>();

        // dichiaro booleano, tentativi e secondo carattere
        boolean vocale = false;
        int tentativi = 1;
        boolean sec_char = true;

        // dichiaro gli array vocali
        char[] vocali = { 'a', 'e', 'i', 'o', 'u' };

        // scompongo il nome in array char
        char[] nome_scomposto = new char[this.nome.length()];
        // copia array in nome_scomposto
        for (int i = 0; i < this.nome.length(); i++) {
            nome_scomposto[i] = this.nome.charAt(i);
        }

        // conto le consonanti per verificare se saltare o meno la seconda consonant
        // (solo se minore di 4 consonanti)
        int count_consonanti = 0;
        for (int i = 0; i < this.nome.length(); i++) {
            char ch = this.nome.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                System.out.print("");
            } else if (ch != ' ') {
                count_consonanti += 1;
            }
        }
        // in caso di consonanti minori di 4, allora non salterò la seconda consonante
        if (count_consonanti < 4) {
            sec_char = false;
        }

        // ciclo per la lenght del nome, setto la booleana vocale a false come
        // semaforo, poi ciclo per quante sono le vocali e setto la booleana, se false
        // copio in array result
        while (res_nome.size() < 3) {
            if (tentativi == 1) {
                for (int i = 0; i < this.nome.length(); i++) {
                    // se il res è = 3 allora break
                    if (res_nome.size() == 3) {
                        break;
                    }
                    vocale = false;
                    for (int j = 0; j < vocali.length; j++) {
                        // comparo nome[i] e vocale[j]
                        if (nome_scomposto[i] == vocali[j]) {
                            vocale = true;
                            break;
                        }
                    }
                    // pusho il risultato
                    if (!vocale) {
                        if (res_nome.size() == 1 && sec_char == true) {
                            sec_char = false;
                            continue;
                        }
                        res_nome.add(nome_scomposto[i]);
                    }
                }
            } else if (tentativi == 2) {
                for (int i = 0; i < this.nome.length(); i++) {
                    // se il res è = 3 allora break
                    if (res_nome.size() == 3) {
                        break;
                    }
                    vocale = false;
                    for (int j = 0; j < vocali.length; j++) {
                        // comparo nome[i] e vocale[j]
                        if (nome_scomposto[i] == vocali[j]) {
                            vocale = true;
                        }
                    }
                    // pusho il risultato (stavolta solo se è vocale)
                    if (vocale) {
                        res_nome.add(nome_scomposto[i]);
                    }
                }
                // riempio di x fino a 3
            } else if (tentativi == 3) {
                while (res_nome.size() < 3) {
                    res_nome.add('x');
                }
            }
            tentativi += 1;
        }

        return res_nome;
    }

    // funzione che ritorna ultime 2 cifre dell'anno di nascita
    public String anno_cf() {
        String ultime_due_cifre = String.valueOf(this.anno_nascita).substring(2);
        return ultime_due_cifre;
    }

    // funzione che ritorna mese associato a lettera (array associativo)
    public String mese_cf() {
        Map<Integer, String> mese_lettera = new HashMap<Integer, String>();
        mese_lettera.put(1, "A");
        mese_lettera.put(2, "B");
        mese_lettera.put(3, "C");
        mese_lettera.put(4, "D");
        mese_lettera.put(5, "E");
        mese_lettera.put(6, "H");
        mese_lettera.put(7, "L");
        mese_lettera.put(8, "M");
        mese_lettera.put(9, "P");
        mese_lettera.put(10, "R");
        mese_lettera.put(11, "S");
        mese_lettera.put(12, "T");

        return mese_lettera.get(this.mese_nascita);
    }

    // funzione che ritorna ultime 2 cifre dell'anno di nascita
    public String giorno_sesso_cf() {
        String res = null;
        if (this.sesso.toUpperCase() == "M") {
            int length = String.valueOf(this.giorno_nascita).length();
            if (length == 1) {
                res = "0" + String.valueOf(this.giorno_nascita);
            } else {
                res = String.valueOf(this.giorno_nascita);
            }
        } else if (this.sesso.toUpperCase() == "F") {
            int somma = this.giorno_nascita + 40;
            res = String.valueOf(somma);
        }
        return res;
    }

    // funzione che ritorna un codice in base al luogo di nascita, tramite
    // comuni.txt...
    // esegue inoltre una scelta multipla per i match doppi...
    public String luogo_nascita_cf() throws IOException {
        List<String> risultati_matchati = new ArrayList<String>();
        String linea_matchata = null;
        List<String> lines = Files.readAllLines(Paths.get("codicefiscalecalcolatore/comuni.txt"));
        for (String line : lines) {
            if (line.contains(this.luogo_nascita.toUpperCase())) {
                risultati_matchati.add(line);
            }
        }

        for (int i = 0; i < risultati_matchati.size(); i++) {
            System.out.println((i + 1) + ")" + risultati_matchati.get(i));
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Quale di questi comuni intendi?: ");
        int scelta = input.nextInt();

        linea_matchata = risultati_matchati.get(scelta - 1);

        int size = linea_matchata.length();
        String codice_comune = linea_matchata.substring(size - 4);

        return codice_comune;
    }

    public String lettera_controllo_cf(String cf) {
        String res = null;

        // scompongo cf in array char
        List<Character> cf_scomposto = new ArrayList<>();
        for (char ch : cf.toUpperCase().toCharArray()) {
            cf_scomposto.add(ch);
        }

        // map valori dispari
        Map<Character, String> valore_pari = new HashMap<Character, String>();
        valore_pari.put('A', "0");
        valore_pari.put('B', "1");
        valore_pari.put('C', "2");
        valore_pari.put('D', "3");
        valore_pari.put('E', "4");
        valore_pari.put('F', "5");
        valore_pari.put('G', "6");
        valore_pari.put('H', "7");
        valore_pari.put('I', "8");
        valore_pari.put('J', "9");
        valore_pari.put('0', "0");
        valore_pari.put('1', "1");
        valore_pari.put('2', "2");
        valore_pari.put('3', "3");
        valore_pari.put('4', "4");
        valore_pari.put('5', "5");
        valore_pari.put('6', "6");
        valore_pari.put('7', "7");
        valore_pari.put('8', "8");
        valore_pari.put('9', "9");
        valore_pari.put('K', "10");
        valore_pari.put('L', "11");
        valore_pari.put('M', "12");
        valore_pari.put('N', "13");
        valore_pari.put('O', "14");
        valore_pari.put('P', "15");
        valore_pari.put('Q', "16");
        valore_pari.put('R', "17");
        valore_pari.put('S', "18");
        valore_pari.put('T', "19");
        valore_pari.put('U', "20");
        valore_pari.put('V', "21");
        valore_pari.put('W', "22");
        valore_pari.put('X', "23");
        valore_pari.put('Y', "24");
        valore_pari.put('Z', "25");

        // map valori dispari
        Map<Character, String> valore_dispari = new HashMap<Character, String>();
        valore_dispari.put('A', "1");
        valore_dispari.put('B', "0");
        valore_dispari.put('C', "5");
        valore_dispari.put('D', "7");
        valore_dispari.put('E', "9");
        valore_dispari.put('F', "13");
        valore_dispari.put('G', "15");
        valore_dispari.put('H', "17");
        valore_dispari.put('I', "19");
        valore_dispari.put('J', "21");
        valore_dispari.put('0', "1");
        valore_dispari.put('1', "0");
        valore_dispari.put('2', "5");
        valore_dispari.put('3', "7");
        valore_dispari.put('4', "9");
        valore_dispari.put('5', "13");
        valore_dispari.put('6', "15");
        valore_dispari.put('7', "17");
        valore_dispari.put('8', "19");
        valore_dispari.put('9', "21");
        valore_dispari.put('K', "2");
        valore_dispari.put('L', "4");
        valore_dispari.put('M', "18");
        valore_dispari.put('N', "20");
        valore_dispari.put('O', "11");
        valore_dispari.put('P', "3");
        valore_dispari.put('Q', "6");
        valore_dispari.put('R', "8");
        valore_dispari.put('S', "12");
        valore_dispari.put('T', "14");
        valore_dispari.put('U', "16");
        valore_dispari.put('V', "10");
        valore_dispari.put('W', "22");
        valore_dispari.put('X', "25");
        valore_dispari.put('Y', "24");
        valore_dispari.put('Z', "23");

        // map lettera di controllo
        HashMap<Integer, String> lettera_di_controllo = new HashMap<Integer, String>();
        lettera_di_controllo.put(0, "A");
        lettera_di_controllo.put(1, "B");
        lettera_di_controllo.put(2, "C");
        lettera_di_controllo.put(3, "D");
        lettera_di_controllo.put(4, "E");
        lettera_di_controllo.put(5, "F");
        lettera_di_controllo.put(6, "G");
        lettera_di_controllo.put(7, "H");
        lettera_di_controllo.put(8, "I");
        lettera_di_controllo.put(9, "J");
        lettera_di_controllo.put(10, "K");
        lettera_di_controllo.put(11, "L");
        lettera_di_controllo.put(12, "M");
        lettera_di_controllo.put(13, "N");
        lettera_di_controllo.put(14, "O");
        lettera_di_controllo.put(15, "P");
        lettera_di_controllo.put(16, "Q");
        lettera_di_controllo.put(17, "R");
        lettera_di_controllo.put(18, "S");
        lettera_di_controllo.put(19, "T");
        lettera_di_controllo.put(20, "U");
        lettera_di_controllo.put(21, "V");
        lettera_di_controllo.put(22, "W");
        lettera_di_controllo.put(23, "X");
        lettera_di_controllo.put(24, "Y");
        lettera_di_controllo.put(25, "Z");

        int sommatore = 0;
        for (int i = 1; i <= cf_scomposto.size(); i++) {
            if (i % 2 == 0) {
                sommatore += Integer.parseInt(valore_pari.get(cf_scomposto.get(i - 1)));
            } else {
                sommatore += Integer.parseInt(valore_dispari.get(cf_scomposto.get(i - 1)));
            }
        }
        res = lettera_di_controllo.get(sommatore % 26);
        return res;
    }
}