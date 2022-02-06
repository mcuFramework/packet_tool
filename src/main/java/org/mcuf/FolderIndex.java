package org.mcuf;

import net.mckitsu.file.FileManager;
import net.mckitsu.file.FolderManager;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.StreamSupport;

public class FolderIndex {
    private final String textHeader =
            "/**\n" +
            " * Copyright (c) 2020 ZxyKira\n" +
            " * All rights reserved.\n" +
            " * \n" +
            " * SPDX-License-Identifier: MIT\n" +
            " */\n";

    private final String textFolder =
            "/* ****************************************************************************************\n" +
            " * Include folder\n" +
            " */\n";

    private final String textInclude =
            "/* ****************************************************************************************\n" +
            " * Include\n" +
            " */\n";

    private final String textEnd =
            "/* ****************************************************************************************\n" +
            " * End of file\n" +
            " */\n";

    private FolderManager path;
    private List<String> files;
    private List<FolderIndex> nextLevel = new LinkedList<>();
    private String definePath;

    public FolderIndex(FolderManager path){
        this.path = path;
        String guid = UUID.randomUUID().toString().toUpperCase(Locale.ROOT);
        guid = guid.replace('-', '_');

        this.definePath = PacketTool.guidPrefix + guid;
    }

    private List<FolderManager> getFolders(){
        List<String> files = this.path.list();
        List<FolderManager> result = new LinkedList<>();

        for(String name : files){
            int index = name.lastIndexOf(".");
            if(index == -1){
                result.add(new FolderManager(this.path + "\\" + name));
            }
        }

        return result;
    }

    private List<FileManager> getFiles(){
        List<String> files = this.path.list();
        List<FileManager> result = new LinkedList<>();

        for(String name : files){
            int index = name.lastIndexOf(".");
            if(index != -1)
                result.add(new FileManager(this.path, name));
        }
        return result;
    }

    public void make(){
        this.files = new LinkedList<>();

        for(FolderManager folder: this.getFolders()){
            FolderIndex folderIndex = new FolderIndex(folder);
            this.nextLevel.add(folderIndex);
            folderIndex.make();
        }

        for(FileManager fileManager : this.getFiles()){
            if(fileManager.getFileName().equalsIgnoreCase("package-info.h"))
                continue;

            if(fileManager.getExtension().equalsIgnoreCase("h")){
                this.files.add(fileManager.getFileName());
            }else if(fileManager.getExtension().equalsIgnoreCase("hpp")){
                this.files.add(fileManager.getFileName());
            }
        }

        FileManager packetInfo = new FileManager(this.path, "package-info.h");
        System.out.println("\n\n");
        System.out.println(packetInfo);
        packetInfo.deleteFile();
        packetInfo.createFile();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(this.textHeader);
        stringBuilder.append(String.format("#ifndef %s\n", this.definePath));
        stringBuilder.append(String.format("#define %s\n\n", this.definePath));

        stringBuilder.append(this.textFolder);
        for(FolderManager folder: this.getFolders()){
            stringBuilder.append(String.format("#include \"%s/package-info.h\"\n", folder.getFolderName()));
            System.out.printf("include packet file: %s\n", folder.getFolderName());
        }

        stringBuilder.append("\n");

        stringBuilder.append(this.textInclude);


        for(String file: this.files){
            stringBuilder.append(String.format("#include \"%s\"\n", file));
            System.out.printf("include file: %s\n", file);
        }

        stringBuilder.append("\n");

        stringBuilder.append(this.textEnd);
        stringBuilder.append("\n");
        stringBuilder.append(String.format("#endif /* %s */\n", this.definePath));
        packetInfo.write(stringBuilder.toString(), StandardCharsets.UTF_8);
    }



}
