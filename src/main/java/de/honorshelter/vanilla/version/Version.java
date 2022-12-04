package de.honorshelter.vanilla.version;

import de.honorshelter.vanilla.Main;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Version {

    private Main _main;

    public Version(Main main) {
        this._main = main;

        checkVersion();
    }

    private void checkVersion() {
        try {
            URL url = new URL("http://116.203.114.218:8000/version.txt");
            Scanner scanner = new Scanner(url.openStream());

            int thisVersion = Integer.parseInt(Main.VERSION.replace(".", ""));
            int version = Integer.parseInt(scanner.nextLine().replace(".", ""));

            if (version > thisVersion) {
                downloadNewVersion();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void downloadNewVersion() {
        try (BufferedInputStream in = new BufferedInputStream(new URL("http://116.203.114.218:8000/vanilla.jar").openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("vanilla.jar")) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        this._main.getServer().reload();
    }

}
