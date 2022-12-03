package randomjoinmessage.listeners;

import me.blackphoenix.randomjoinmessage.misc.Names;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Random;

public class JoinLeaveListener implements Listener {

    Random rnd = new Random();
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        try {
            switch (player.getName()) {
                case "BlackPhoenix200":
                    event.setJoinMessage(ChatColor.WHITE + Names.getNames("basti")[rnd.nextInt(0, Names.getNames("basti").length)] + " " + ChatColor.GREEN + joinMessages[rnd.nextInt(0, joinMessagesInt)]);
                    break;
                case "Im_2D":
                    event.setJoinMessage(ChatColor.WHITE + Names.getNames("cvin")[rnd.nextInt(0, Names.getNames("cvin").length)] + " " + ChatColor.GREEN + joinMessages[rnd.nextInt(0, joinMessagesInt)]);
                    break;
                case "JSLP0208":
                    event.setJoinMessage(ChatColor.WHITE + Names.getNames("jonas")[rnd.nextInt(0, Names.getNames("jonas").length)] + " " + ChatColor.GREEN + joinMessages[rnd.nextInt(0, joinMessagesInt)]);
                    break;
                case "Broy_05":
                    event.setJoinMessage(ChatColor.WHITE + Names.getNames("felix")[rnd.nextInt(0, Names.getNames("felix").length)] + " " + ChatColor.GREEN + joinMessages[rnd.nextInt(0, joinMessagesInt)]);
                    break;
                case "_pgcraft":
                    event.setJoinMessage(ChatColor.WHITE + Names.getNames("paul")[rnd.nextInt(0, Names.getNames("paul").length)] + " " + ChatColor.GREEN + joinMessages[rnd.nextInt(0, joinMessagesInt)]);
                    break;
                default:
                    event.setJoinMessage(ChatColor.WHITE + player.getName() + " " + ChatColor.GREEN + joinMessages[rnd.nextInt(0, joinMessagesInt)]);
                    break;
            }
        } catch (Exception ex) {
            event.setJoinMessage(player.getName() + " ist da" + ChatColor.RED + " | Basti hat verkackt. Sagt ihm bescheid \"Fehler im Join Plugin\"" + Names.getNames("basti").length);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        try {
            switch (player.getName()) {
                case "BlackPhoenix200":
                    event.setQuitMessage(ChatColor.WHITE + Names.getNames("basti")[rnd.nextInt(0, Names.getNames("basti").length)] + " " + ChatColor.RED + leaveMessages[rnd.nextInt(0, leaveMessagesInt)]);
                    break;
                case "Im_2D":
                    event.setQuitMessage(ChatColor.WHITE + Names.getNames("cvin")[rnd.nextInt(0, Names.getNames("cvin").length)] + " " + ChatColor.RED + leaveMessages[rnd.nextInt(0, leaveMessagesInt)]);
                    break;
                case "JSLP0208":
                    event.setQuitMessage(ChatColor.WHITE + Names.getNames("jonas")[rnd.nextInt(0, Names.getNames("jonas").length)] + " " + ChatColor.RED + leaveMessages[rnd.nextInt(0, leaveMessagesInt)]);
                    break;
                case "Broy_05":
                    event.setQuitMessage(ChatColor.WHITE + Names.getNames("felix")[rnd.nextInt(0, Names.getNames("felix").length)] + " " + ChatColor.RED + leaveMessages[rnd.nextInt(0, leaveMessagesInt)]);
                    break;
                case "_pgcraft":
                    event.setQuitMessage(ChatColor.WHITE + Names.getNames("paul")[rnd.nextInt(0, Names.getNames("paul").length)] + " " + ChatColor.RED + leaveMessages[rnd.nextInt(0, leaveMessagesInt)]);
                    break;
                default:
                    event.setQuitMessage(ChatColor.WHITE + player.getName() + " " + ChatColor.RED + leaveMessages[rnd.nextInt(0, leaveMessagesInt)]);
                    break;
            }
        } catch (Exception ex) {
            event.setQuitMessage(player.getName() + " ist weg" + ChatColor.RED + " | Basti hat verkackt. Sagt ihm bescheid \"Fehler im Join Plugin\"");
        }
    }

    private String[] joinMessages = {
            "hat sich auf den Server bequemt",
            "ist auch endlich da",
            "schaut so rein",
            "will auch mitspielen",
            "ist gelandet",
            "ist drin"
    };
    private int joinMessagesInt = joinMessages.length;
    private String[] leaveMessages = {
            "hat mies keinen Bock mehr",
            "ist raus",
            "ist einfach gegangen",
            "hat uns verlassen"
    };
    private int leaveMessagesInt = leaveMessages.length;
}
