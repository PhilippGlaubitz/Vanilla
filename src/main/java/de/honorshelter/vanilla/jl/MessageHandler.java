package de.honorshelter.vanilla.jl;

import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MessageHandler {

    private static MessageHandler instance;

    private String[] _joinMessages;
    private String[] _leaveMessages;

    private Map<String, String[]> _names;

    private Random _random;

    public MessageHandler() {

        this.instance = this;

        this._random = new Random();

        this._names = new HashMap<>();

        this._joinMessages = new String[]{
                "hat sich auf den Server bequemt",
                "ist auch endlich da",
                "schaut so rein",
                "will auch mitspielen",
                "ist gelandet",
                "ist drin",
                "hat kein bock mehr auf Overwatch",
                "hat nix besseres zu tun"
        };

        this._leaveMessages = new String[]{
                "hat mies keinen Bock mehr",
                "ist raus",
                "ist einfach gegangen",
                "hat uns verlassen",
                "geht jetzt Fortnite spielen",
                "geht simpen"
        };

        this._names.put("BlackPhoenix200", new String[]{
                "BlackPhoenix200",
                "Basti",
                "BlackPhoenix",
                "BlackFönigs",
                "Sensei San él Sébastianõ Senpai",
                "Baguette-Basti",
                "Meeresmais",
                "Bingo-Bob",
                "Der Kräutersalat",
                "Das Wachtelei",
                "Basti der Spermaschütze"
        });

        this._names.put("Im_2D", new String[]{
                "Kevin",
                "Cvin",
                "2D",
                "Im_2D",
                "Großherzog Cvin",
                "Spastsalat",
                "K-K-Kissner",
        });

        this._names.put("JSLP0208", new String[]{
                "Jonas",
                "Der NPC",
                "Junge Jonas",
                "Nonas"
        });

        this._names.put("Broy_05", new String[]{
                "Felix",
                "Felirex",
                "Broy",
                "Frechdachs"
        });

        this._names.put("_pgcraft", new String[]{
                "Paul",
                "Gertler",
                "pgcraft",
                "pgguaft",
                "Der Profi-DJ",
                "Der Kinderschänder",
                "NajG"
        });

        this._names.put("_pgcraft", new String[]{
                "Paul",
                "Gertler",
                "pgcraft",
                "pgguaft",
                "Der Profi-DJ",
                "Der Kinderschänder",
                "NajG"
        });

        this._names.put("OdinProHD", new String[]{
                "Der Gassenhauer",
                "Der Gullianheber",
                "Der Manga Professor",
                "PHILÖÖÖP",
                "Der Magiekundige Großmeister",
                "Der Tretbootpilot",
                "Lord Julius",
                "Der Pullundertragender Sören",
                "Philipp der Kirchler"
        });

    }

    private String getRandomName(String playerName){
        String[] names = this._names.get(playerName);

        if(names == null){
            return playerName;
        }

        int rInt = this._random.nextInt(names.length);

        return names[rInt];
    }

    public String getJoinMessage(String playerName) {
        String message = this.getRandomJoinMessage();
        String name = getRandomName(playerName);

        return ChatColor.WHITE
                + name
                + " "
                + ChatColor.GREEN
                + message;

    }

    public String getLeaveMessage(String playerName) {
        String message = this.getRandomLeaveMessage();
        String name = getRandomName(playerName);

        return ChatColor.WHITE
                + name
                + " "
                + ChatColor.RED
                + message;

    }

    private String getRandomJoinMessage(){
        int rInt = this._random.nextInt(this._joinMessages.length);

        return this._joinMessages[rInt];
    }

    private String getRandomLeaveMessage(){
        int rInt = this._random.nextInt(this._leaveMessages.length);

        return this._leaveMessages[rInt];
    }

    public static MessageHandler getInstance(){
        return instance;
    }

}
