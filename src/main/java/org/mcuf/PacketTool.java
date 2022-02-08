package org.mcuf;

import net.mckitsu.file.FolderManager;

import java.util.Locale;

public class PacketTool implements Runnable {
    public static String filePath = ".\\";
    public static String guidPrefix = "";
    public static String func = "";

    public static void main(String[] args){
        if(args.length == 0)
            return;

        func = args[0].toLowerCase(Locale.ROOT);

        if(args.length >= 2)
            filePath = args[1];

        if(args.length >= 3)
            guidPrefix = args[2];

        new PacketTool().run();
    }

    @Override
    public void run() {

        switch (func){
            case "package":
                MakeFilePackageList packetTool = new MakeFilePackageList(new FolderManager(PacketTool.filePath));
                packetTool.make();
                break;

            case "struct":
                new MakeFile(filePath).makeStruct();
                break;

            case "class":
                new MakeFile(filePath).makeClass();
                break;

            case "enum":
                new MakeFile(filePath).makeEnum();
                break;

            case "interface":
                new MakeFile(filePath).makeInterface();
                break;

            default:
                System.out.println("command not found");
                break;

        }

        System.out.println("finish");
    }
}
