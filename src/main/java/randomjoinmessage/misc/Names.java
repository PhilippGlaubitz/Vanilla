package randomjoinmessage.misc;

public class Names {
    public static String[] getNames(String name) {

        switch (name) {
            case "basti":
                return getBasti();
            case "cvin":
                return getCvin();
            case "jonas":
                return getJonas();
            case "felix":
                return getFelix();
            case "paul":
                return getPaul();
        }

        return null;
    }
    private static String[] getBasti() {
        String[] names = {
                "BlackPhoenix200",
                "Basti",
                "BlackPhoenix",
                "BlackFönigs",
                "Sensei San él Sébastianõ Senpai",
                "Baguette-Basti",
                "Meeresmais",
                "Bingo-Bob",
                "Der Kräutersalat",
                "Das Wachtelei"
        };

        return names;
    }

    private static String[] getCvin() {
        String[] names = {
                "Kevin",
                "Cvin",
                "2D",
                "Im_2D",
                "Großherzog Cvin",
                "Spastsalat",
                "K-K-Kissner",
        };

        return names;
    }

    private static String[] getJonas() {
        String[] names = {
                "Jonas",
                "Der NPC",
                "Junge Jonas",
                "Nonas"
        };

        return names;
    }

    private static String[] getFelix() {
        String[] names = {
                "Felix",
                "Felirex",
                "Broy",
                "Frechdachs"
        };

        return names;
    }

    private static String[] getPaul() {
        String[] names = {
                "Paul",
                "Gertler",
                "pgcraft",
                "pgguaft",
                "Der Profi-DJ",
                "Der Kinderschänder",
                "NajG"
        };

        return names;
    }

}
