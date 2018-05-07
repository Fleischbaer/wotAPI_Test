package commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class C_worlds implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player) {
			Player p = (Player) sender;

			if(p.isOp()) {

				if(args.length != 0) {

					if(args[0].equalsIgnoreCase("tp")) {

						if(args.length == 2) {

							if(args[1].length() <= 20 && args[1].length() >= 3) {

								if(Bukkit.getWorlds().contains(Bukkit.getWorld(args[1]))) {

									if(p.getWorld().equals(Bukkit.getWorld(args[1]))) {
										p.teleport(Bukkit.getWorld(args[1]).getSpawnLocation());
										p.sendMessage("§aDa du dich bereits in dieser Welt befindest, wurdest du zum Spawn teleportiert!");
									}else{
										p.teleport(Bukkit.getWorld(args[1]).getSpawnLocation());
										p.sendMessage("§aDu wurdest in die Welt '"+args[1]+"' teleportiert!");
									}

								}else p.sendMessage("§cDie Welt '"+args[1]+"' existiert nicht oder ist nicht geladen!");

							}else p.sendMessage("§cEin Weltenname hat eine Zeichenlänge von 3-20 Zeichen! (Eingabe: "+args[1].length()+")");

						}else p.sendMessage("§cBitte benutze '/worlds tp (Weltenname)");

					}else if(args[0].equalsIgnoreCase("load")) {

						if(args.length == 2) {

							if(args[1].length() <= 20 && args[1].length() >= 3) {

								File file = new File(args[1]);

								if(file.exists()) {

									if(!Bukkit.getWorlds().contains(Bukkit.getWorld(args[1]))) {
										
										p.sendMessage("§aDie Welt '"+args[1]+"' wird geladen...");
										WorldCreator wc = new WorldCreator(args[1]);
										wc.createWorld();
										p.sendMessage("§aDie Welt '"+args[1]+"' wurde geladen!");

									}else p.sendMessage("§cDiese Welt ist bereits geladen!");

								}else p.sendMessage("§cDiese Welt existiert nicht!");

							}else p.sendMessage("§cEin Weltenname hat eine Zeichenlänge von 3-20 Zeichen! (Eingabe: "+args[1].length()+")");

						}else p.sendMessage("§cBitte benutze '/worlds load (Weltenname)'");

					}else if(args[0].equalsIgnoreCase("unload")) {

						if(args.length == 2) {

							if(args[1].length() <= 20 && args[1].length() >= 3) {

								if(!args[1].equals("Spawn")) {

									if(Bukkit.getWorlds().contains(Bukkit.getWorld(args[1]))) {

										int players = 0;
										for(Player all : Bukkit.getWorld(args[1]).getPlayers()) {
											all.teleport(Bukkit.getWorld("Spawn").getSpawnLocation());
											all.sendMessage("§cDie Welt, in der du dich gerade befandest, wurde entladen und somit wurdest du zum Spawn verschoben!");
											players++;
										}
										Bukkit.unloadWorld(args[1], true);
										p.sendMessage("§aDie Welt '"+args[1]+"' wurde erfolgreich entladen!");
										if(players != 0) {
											p.sendMessage("§a"+players+" Spieler wurden deswegen zum Spawn verschoben!");
										}

									}else p.sendMessage("§cDiese Welt ist nicht geladen!");

								}else p.sendMessage("§cDu kannst den Spawn nicht entladen!");

							}else p.sendMessage("§cEin Weltenname hat eine Zeichenlänge von 3-20 Zeichen! (Eingabe: "+args[1].length()+")");

						}else p.sendMessage("§cBitte benutze '/worlds unload (Weltenname)'");

					}else if(args[0].equalsIgnoreCase("list")) {

						if(args.length == 1) {
							p.sendMessage("§aAlle geladenen Welten:");
							
							File server = Bukkit.getWorldContainer();
							File[] files = server.listFiles();
							for(File dire : files) {
								if(dire.isDirectory()) {
									File level = new File(dire.getName()+"/level.dat");
									if(level.exists()) {
										
										if(Bukkit.getWorlds().contains(Bukkit.getWorld(dire.getName()))) {
											p.sendMessage("§8 - §2"+dire.getName()+"  §7(§aGeladen§7)");
										}else{
											p.sendMessage("§8 - §2"+dire.getName()+"  §7(§cEntladen§7)");
										}
										
									}
								}
							}

						}else p.sendMessage("§cBitte benutze '/worlds loadedworlds'");

					}else if(args[0].equalsIgnoreCase("setspawn")) {

						if(args.length == 1) {

							p.getWorld().setSpawnLocation(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ());
							p.sendMessage("§aDer Welten-Spawn wurde neu gesetzt!");

						}else p.sendMessage("§cBitte benutze '/worlds setspawn'!");

					}else if(args[0].equalsIgnoreCase("help")) {

						if(args.length == 1) {

							p.sendMessage("§aAlle Welten-Befehle:");
							p.sendMessage(" §6tp (Weltenname) §8- §eTeleportiert dich zu einer Welt");
							p.sendMessage(" §6load (Weltenname) §8- §eLädt eine Welt");
							p.sendMessage(" §6unload (Weltenname) §8- §eEntlädt eine Welt");
							p.sendMessage(" §6list §8- §eListet alle Welten auf");
							p.sendMessage(" §6setspawn §8- §eSetzt den Welten-Spawn");

						}else p.sendMessage("§cBitte benutze '/worlds help'!");

					}else p.sendMessage("§cFür alle Welten-Befehle benutze '/worlds help'!");

				}else p.sendMessage("§cFür alle Welten-Befehle benutze '/worlds help'!");

			}else p.sendMessage("§cDazu hast du keine Rechte!");

		}

		return false;
	}
}