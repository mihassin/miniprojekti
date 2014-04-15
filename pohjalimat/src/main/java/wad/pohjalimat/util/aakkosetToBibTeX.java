

package wad.pohjalimat.util;

/**
 *
 * @author Lauri Kangassalo / lauri.kangassalo@helsinki.fi
 */
public class aakkosetToBibTeX {
    private String original;

    public aakkosetToBibTeX(String stringToConvert) {
        original = stringToConvert;
    }
    
    public String convert() {
        return original.replace("ä", "\\\"{a}")
                .replace("ö", "\\\"{o}")
                .replace("Ä", "\\\"{A}")
                .replace("Ö", "\\\"{O}");
    }
    
}
