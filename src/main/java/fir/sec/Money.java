package fir.sec;

import org.bukkit.event.Listener;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Money implements Listener {

    public static void CreateMoney(String player) {
        File filename = new File("plugins/DoxaShop/Money/" + player + ".yml");
        File folder_Location1 = new File("plugins/DoxaShop/");
        File folder_Location2 = new File("plugins/DoxaShop/Money");
        try {
            if (!filename.exists()) {
                folder_Location1.mkdir();
                folder_Location2.mkdir();
                filename.createNewFile();
            }
            BufferedWriter w = new BufferedWriter(new FileWriter(filename));
            w.append("보유 자산 백까지:0"+"\r\n"+"보유 자산 십만까지:0"+"\r\n"+"보유 자산 억까지:0"+"\r\n"+"보유 자산 천억까지:0"+"\r\n"+"추가금:0");
            w.flush();
            w.close();
        } catch (IOException ignored) {
        }
    }

    public static long[] getMoney(String player) {
        File filename = new File("plugins/DoxaShop/Money/" + player + ".yml");
        File folder_Location1 = new File("plugins/DoxaShop/");
        File folder_Location2 = new File("plugins/DoxaShop/Money");
        long[] money = new long[5];
        try {
            if (!filename.exists()) {
                folder_Location1.mkdir();
                folder_Location2.mkdir();
                filename.createNewFile();
            }
            BufferedReader R = new BufferedReader(new FileReader(filename));
            List list = new ArrayList();
            String s;
            while ((s = R.readLine()) != null) {
                list.add(Cutter(s));
            }
            R.close();
            for (int count = 0; count < 4; count++) {
                money[count] = (Long) list.get(count);
            }
            return money;
        } catch (IOException ignored) {
        }
        return money;
    }

    public static long Cutter(String line) {
        String[] cut = line.split(":");
        return Long.parseLong(cut[1]);
    }

    public static void setMoney(String player, long[] money) {
        File filename = new File("plugins/DoxaShop/Money/" + player + ".yml");
        File folder_Location1 = new File("plugins/DoxaShop/");
        File folder_Location2 = new File("plugins/DoxaShop/Money");
        try {
            if (!filename.exists()) {
                folder_Location1.mkdir();
                folder_Location2.mkdir();
                filename.createNewFile();
            }
            BufferedWriter W = new BufferedWriter(new FileWriter(filename));
            W.append("보유 자산 백까지:"+money[0]+"\r\n"+"보유 자산 십만까지:"+money[1]+"\r\n"+"보유 자산 억까지:"+money[2]+"\r\n"+"보유 자산 천억까지:"+money[3]+"추가금:"+money[4]);
            W.flush();
            W.close();
        } catch (IOException localIoException) {
        }
    }

}
