package com.sandeep.string;

import org.apache.commons.lang3.StringUtils;

public class StringOps {

    public static void main(String[] args) {
        String string = "Dahaval is idiot, he is duffer";
        int ind = StringUtils.ordinalIndexOf(string,"is",2);
        string.substring(ind,ind+2);
        System.out.println(""+ string.substring(ind,ind+2));
    }
}
