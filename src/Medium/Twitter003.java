package Medium;

import sun.applet.resources.MsgAppletViewer;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Twitter003 {
    public static String decode(List<String> codes, String encoded) {
        // Write your code here
        Map<String, String> coding = new HashMap();
        for (String str : codes) {
            String[] twopart = str.split("\t");
            coding.put(twopart[1],twopart[0]);
        }

        List<String> result = new ArrayList<>();

        wrappedDecode(encoded, coding, result, 0);
        String res = "";
        for (String str : result){
            if (str == "\n") {
                res += "\r";
            } else {
                res += str;
            }

        }
        return res;
    }

    public static void wrappedDecode(String encoded, Map <String, String>coding, List<String> result, int loc) {
        if (loc == encoded.length()) return;
        for (Map.Entry<String, String> code : coding.entrySet()) {
            if (tryMatch(code.getKey(), encoded, loc)) {
                result.add(code.getValue());
                wrappedDecode(encoded,coding,result,loc + code.getKey().length());
                return;
            }
        }
    }

    public static Boolean tryMatch(String key, String encoded, int loc) {
        for  (int i = 0 ;i < key.length(); i++) {
            if (loc + i >= encoded.length()) return false;
            if (key.charAt(i) != encoded.charAt(loc + i)) return false;
        }
        return true;
    }
}

