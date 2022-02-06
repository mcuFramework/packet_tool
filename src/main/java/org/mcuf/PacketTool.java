package org.mcuf;

import net.mckitsu.file.FolderManager;

public class PacketTool implements Runnable {
    public static String filePath = ".\\";
    public static String guidPrefix = "";

    public static void main(String[] args){
        if(args.length >= 1)
            filePath = args[0];

        if(args.length >= 2)
            guidPrefix = args[1];

        new PacketTool().run();
    }

    @Override
    public void run() {
        FolderManager root = new FolderManager(PacketTool.filePath);
        FolderIndex packetTool = new FolderIndex(root);
        packetTool.make();
        System.out.println("finish");
    }
}
