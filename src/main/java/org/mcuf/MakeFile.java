package org.mcuf;

import net.mckitsu.file.FileManager;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.UUID;

public class MakeFile {
    private final String path;

    public static final String textHeaderInterface =
            "/**\n" +
            " * Copyright (c) 2020 ZxyKira\n" +
            " * All rights reserved.\n" +
            " * \n" +
            " * SPDX-License-Identifier: MIT\n" +
            " */\n" +
            "#ifndef %DEFINE-HEADER%\n" +
            "#define %DEFINE-HEADER%\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Include\n" +
            " */\n" +
            "\n" +
            "//-----------------------------------------------------------------------------------------\n" +
            "\n" +
            "//-----------------------------------------------------------------------------------------\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Namespace\n" +
            " */\n" +
            "%NAMESPACE%\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Class/Interface/Struct/Enum\n" +
            " */\n" +
            "interface %PATH%{\n" +
            "\n" +
            "  /* **************************************************************************************\n" +
            "   * Method\n" +
            "   */\n" +
            "\n" +
            "};\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * End of file\n" +
            " */\n" +
            "\n" +
            "#endif /* %DEFINE-HEADER% */\n";

    public static final String textHeaderEnum =
            "/**\n" +
            " * Copyright (c) 2020 ZxyKira\n" +
            " * All rights reserved.\n" +
            " * \n" +
            " * SPDX-License-Identifier: MIT\n" +
            " */\n" +
            "#ifndef %DEFINE-HEADER%\n" +
            "#define %DEFINE-HEADER%\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Include\n" +
            " */\n" +
            "\n" +
            "//-----------------------------------------------------------------------------------------\n" +
            "\n" +
            "//-----------------------------------------------------------------------------------------\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Namespace\n" +
            " */\n" +
            "%NAMESPACE%\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Class/Interface/Struct/Enum\n" +
            " */\n" +
            "enum struct %PATH% : char{\n" +
            "\n" +
            "};\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * End of file\n" +
            " */\n" +
            "\n" +
            "#endif /* %DEFINE-HEADER% */\n";

    public static final String textHeader =
            "/**\n" +
            " * Copyright (c) 2020 ZxyKira\n" +
            " * All rights reserved.\n" +
            " * \n" +
            " * SPDX-License-Identifier: MIT\n" +
            " */\n" +
            "#ifndef %DEFINE-HEADER%\n" +
            "#define %DEFINE-HEADER%\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Include\n" +
            " */  \n" +
            "\n" +
            "//-----------------------------------------------------------------------------------------\n"+
            "\n" +
            "//-----------------------------------------------------------------------------------------\n"+
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Namespace\n" +
            " */  \n" +
            "%NAMESPACE%\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Class/Interface/Struct/Enum\n" +
            " */  \n" +
            "class %PATH%{\n" +
            "\n" +
            "  /* **************************************************************************************\n" +
            "   * Variable <Public>\n" +
            "   */\n" +
            "\n" +
            "  /* **************************************************************************************\n" +
            "   * Variable <Protected>\n" +
            "   */\n" +
            "\n" +
            "  /* **************************************************************************************\n" +
            "   * Variable <Private>\n" +
            "   */\n" +
            "\n" +
            "  /* **************************************************************************************\n" +
            "   * Abstract method <Public>\n" +
            "   */\n" +
            "\n" +
            "  /* **************************************************************************************\n" +
            "   * Abstract method <Protected>\n" +
            "   */\n" +
            "\n" +
            "  /* **************************************************************************************\n" +
            "   * Construct Method\n" +
            "   */\n" +
            "  public: \n" +
            "\t%CLASS%(void) = default;\n" +
            "\n" +
            "\tvirtual ~%CLASS%(void) = default;\n" +
            "\n" +
            "  /* **************************************************************************************\n" +
            "   * Operator Method\n" +
            "   */\n" +
            "\n" +
            "  /* **************************************************************************************\n" +
            "   * Public Method <Static>\n" +
            "   */\n" +
            "\n" +
            "  /* **************************************************************************************\n" +
            "   * Public Method <Override>\n" +
            "   */\n" +
            "\n" +
            "  /* **************************************************************************************\n" +
            "   * Public Method\n" +
            "   */\n" +
            "\n" +
            "  /* **************************************************************************************\n" +
            "   * Protected Method <Static>\n" +
            "   */\n" +
            "\n" +
            "  /* **************************************************************************************\n" +
            "   * Protected Method <Override>\n" +
            "   */\n" +
            "\n" +
            "  /* **************************************************************************************\n" +
            "   * Protected Method\n" +
            "   */\n" +
            "\n" +
            "  /* **************************************************************************************\n" +
            "   * Private Method <Static>\n" +
            "   */\n" +
            "\n" +
            "  /* **************************************************************************************\n" +
            "   * Private Method <Override>\n" +
            "   */\n" +
            "\n" +
            "  /* **************************************************************************************\n" +
            "   * Private Method\n" +
            "   */\n" +
            "\n" +
            "};\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * End of file\n" +
            " */ \n" +
            "\n" +
            "#endif /* %DEFINE-HEADER% */\n";

    public static final String textSource =
            "/**\n" +
            " * Copyright (c) 2020 ZxyKira\n" +
            " * All rights reserved.\n" +
            " * \n" +
            " * SPDX-License-Identifier: MIT\n" +
            " */\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Include\n" +
            " */\n" +
            "\n" +
            "//-----------------------------------------------------------------------------------------\n" +
            "\n" +
            "//-----------------------------------------------------------------------------------------\n" +
            "%INCLUDE%\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Macro\n" +
            " */\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Using\n" +
            " */\n" +
            "\n" +
            "//-----------------------------------------------------------------------------------------\n" +
            "\n" +
            "//-----------------------------------------------------------------------------------------\n" +
            "%USING-PATH%\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Variable <Static>\n" +
            " */\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Construct Method\n" +
            " */\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Operator Method\n" +
            " */\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Public Method <Static>\n" +
            " */\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Public Method <Override>\n" +
            " */\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Public Method\n" +
            " */\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Protected Method <Static>\n" +
            " */\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Protected Method <Override>\n" +
            " */\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Protected Method\n" +
            " */\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * Private Method\n" +
            " */\n" +
            "\n" +
            "/* ****************************************************************************************\n" +
            " * End of file\n" +
            " */\n";


    public MakeFile(String path){
        this.path = path;
    }



    public void makeInterface(){
        FileManager header = new FileManager("", getClassName() + ".h");
        String stringHeader = textHeaderInterface;
        stringHeader = stringHeader.replace("%DEFINE-HEADER%", this.getTextHeader());
        stringHeader = stringHeader.replace("%NAMESPACE%", this.getNamespace("enum struct"));
        stringHeader = stringHeader.replace("%PATH%", this.path);
        stringHeader = stringHeader.replace("%CLASS%", this.getClassName());

        header.deleteFile();
        header.createFile();
        header.write(stringHeader, StandardCharsets.UTF_8);
    }

    public void makeEnum(){
        FileManager header = new FileManager("", getClassName() + ".h");
        String stringHeader = textHeaderEnum;
        stringHeader = stringHeader.replace("%DEFINE-HEADER%", this.getTextHeader());
        stringHeader = stringHeader.replace("%NAMESPACE%", this.getNamespace("enum struct"));
        stringHeader = stringHeader.replace("%PATH%", this.path);
        stringHeader = stringHeader.replace("%CLASS%", this.getClassName());

        header.deleteFile();
        header.createFile();
        header.write(stringHeader, StandardCharsets.UTF_8);
    }

    public void makeClass(){
        FileManager header = new FileManager("", getClassName() + ".h");
        FileManager source = new FileManager("", getClassName() + ".cpp");

        String stringHeader = textHeader;
        stringHeader = stringHeader.replace("%DEFINE-HEADER%", this.getTextHeader());
        stringHeader = stringHeader.replace("%NAMESPACE%", this.getNamespace("class"));
        stringHeader = stringHeader.replace("%PATH%", this.path);
        stringHeader = stringHeader.replace("%CLASS%", this.getClassName());

        String stringSource = textSource;
        stringSource = stringSource.replace("%INCLUDE%", this.getInclude());
        stringSource = stringSource.replace("%USING-PATH%", this.getUsing());

        header.deleteFile();
        header.createFile();
        header.write(stringHeader, StandardCharsets.UTF_8);

        source.deleteFile();
        source.createFile();
        source.write(stringSource, StandardCharsets.UTF_8);
    }

    private String getUsing(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("using ");
        stringBuilder.append(path);
        stringBuilder.append(";");

        return stringBuilder.toString();
    }

    private String getInclude(){
        StringBuilder stringBuilder = new StringBuilder();
        String[] name = this.path.split("::");

        stringBuilder.append("#include \"");

        for(int i=0; i< name.length; ++i){
            if(i == name.length-1){
                stringBuilder.append(name[i]);
                stringBuilder.append(".h");
            }else{
                stringBuilder.append(name[i]);
                stringBuilder.append("/");
            }

        }
        stringBuilder.append("\"");

        return stringBuilder.toString();
    }

    private String getTextHeader(){
        String guid = UUID.randomUUID().toString().toUpperCase(Locale.ROOT);
        guid = guid.replace('-', '_');
        return PacketTool.guidPrefix + guid;
    }

    private String getNamespace(String type){
        String[] name = this.path.split("::");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i< name.length-1; ++i){
            for(int j=0; j<i; ++j){
                stringBuilder.append("  ");
            }
            stringBuilder.append(String.format("namespace %s{\n", name[i]));
        }

        for(int j=0; j<(name.length - 1); ++j){
            stringBuilder.append("  ");
        }

        stringBuilder.append(String.format("%s %s;\n", type, name[name.length-1]));

        for(int i=0; i< name.length - 1; ++i){
            for(int j=0; j<(name.length - i - 2); ++j){
                stringBuilder.append("  ");
            }
            stringBuilder.append("}\n");
        }
        return stringBuilder.toString();
    }

    private String getClassName(){
        String[] name = this.path.split("::");
        return name[name.length-1];
    }
}
