package schoolrecords.records;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

    //region args
    private static final String[] lastNames = new String[]
            {
                    "Ádám",
                    "István",
                    "József",
                    "János",
                    "Ferenc",
                    "György",
                    "Péter",
                    "Sándor",
                    "Gábor",
                    "András",
                    "Károly",
                    "Béla",
                    "Gyula",
                    "Lajos",
                    "Tibor",
                    "Imre",
                    "Miklós",
                    "Tamás",
                    "Zoltán",
                    "Attila",
                    "Pál",
                    "Géza",
                    "Mihály",
                    "Antal",
                    "Jenő",

                    "Mária",
                    "Éva",
                    "Erzsébet",
                    "Katalin",
                    "Zsuzsanna",
                    "Ilona",
                    "Anna",
                    "Judit",
                    "Ágnes",
                    "Margit",
                    "Julianna",
                    "Ildikó",
                    "Magdolna",
                    "Márta",
                    "Klára",
                    "Edit",
                    "Irén",
                    "Gabriella",
                    "Veronika",
                    "Györgyi",
                    "Gizella",
                    "Terézia",
                    "Ibolya",
                    "Anikó",
                    "Annamária"
            };
    private static final String[] firstNames = new String[]
            {
                    "Nagy",
                    "Lukács",
                    "Jónás",
                    "Kovács",
                    "Gulyás",
                    "Szücs",
                    "Tóth",
                    "Biró",
                    "Hajdu",
                    "Szabó",
                    "Király",
                    "Halász",
                    "Horváth",
                    "Balog",
                    "Máté",
                    "Varga",
                    "László",
                    "Székely",
                    "Kiss",
                    "Bogdán",
                    "Gáspár",
                    "Molnár",
                    "Jakab",
                    "Kozma",
                    "Németh",
                    "Katona",
                    "Pásztor",
                    "Farkas",
                    "Sándor",
                    "Bakos",
                    "Balogh",
                    "Váradi",
                    "Dudás",
                    "Papp",
                    "Boros",
                    "Virág",
                    "Lakatos",
                    "Fazekas",
                    "Major",
                    "Takács",
                    "Kelemen",
                    "Orbán",
                    "Juhász",
                    "Antal",
                    "Hegedüs",
                    "Oláh",
                    "Orosz",
                    "Barna",
                    "Mészáros",
                    "Somogyi",
                    "Novák",
                    "Simon",
                    "Fülöp",
                    "Soós",
                    "Rácz",
                    "Veres",
                    "Tamás",
                    "Fekete",
                    "Budai",
                    "Nemes",
                    "Szilágyi",
                    "Vincze",
                    "Pataki",
                    "Török",
                    "Hegedűs",
                    "Balla",
                    "Fehér",
                    "Deák",
                    "Faragó",
                    "Balázs",
                    "Pap",
                    "Kerekes",
                    "Gál",
                    "Bálint",
                    "Barta",
                    "Kis",
                    "Illés",
                    "Péter",
                    "Szűcs",
                    "Pál",
                    "Borbély",
                    "Orsós",
                    "Vass",
                    "Csonka",
                    "Kocsis",
                    "Szőke",
                    "Mezei",
                    "Fodor",
                    "Fábián",
                    "Sárközi",
                    "Pintér",
                    "Vörös",
                    "Berki",
                    "Szalai",
                    "Lengyel",
                    "Márton",
                    "Sipos",
                    "Bognár",
                    "Magyar",
                    "Bodnár"
            };
    //endregion

    public static String getRandomName() {
        Random rnd1 = new Random();
        Random rnd2 = new Random();
        return firstNames[rnd1.nextInt(firstNames.length)] + " " + lastNames[rnd2.nextInt(lastNames.length)];
    }

    public static List<Subject> getRandomSubjects(List<Subject> subjects, int subjectsCount) {
        List<Subject> subjectList = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < subjectsCount; i++) {
            subjectList.add(subjects.get(rnd.nextInt(subjects.size())));
        }
        return subjectList;
    }

}
