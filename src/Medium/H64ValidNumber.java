package Medium;

class H64ValidNumber {
    public boolean isNumber(String s) {
        if (s == null) return false;
        String afterTrim = s.trim();

        if (afterTrim.equals("")) return false;

        String[] splitSpace = cSplit(afterTrim," ");
        if (splitSpace.length >= 2) return false;

        String[] splitE = cSplit(afterTrim, "e");
        if (splitE.length > 2) return false;
        else if(splitE.length == 2) {
            return isValidBeforeE(splitE[0]) && isValidAfterE(splitE[1]);
        } else {
            return isValidNoENumber(splitE[0]);
        }
    }


    public boolean isValidNoENumber(String s) {
        if (s == null || s.equals("")) return false;

        char ch = s.charAt(0);
        if(ch == '+' || ch == '-') {
            return isValidNumberWithNoSignIncludingNothingAroundDot(s.substring(1, s.length()));
        } else {
            return isValidNumberWithNoSignIncludingNothingAroundDot(s);
        }
    }

    public boolean isValidNumberWithNoSignIncludingNothingAroundDot(String s) {
        if (s == null || s.equals("")) return false;
        String[] splitDot = cSplit(s, ".");
        if (splitDot.length > 2) {
            return false;
        } else if(splitDot.length == 2) {
            return isValidBeforeDotIntegerWithNoSignIncludingNothing(splitDot[0])
                && isValidAfterDotIntegerWithNoSignIncludingNothing(splitDot[1])
                && (isValidBeforeDotIntegerWithNoSign(splitDot[0]) || isValidAfterDotIntegerWithNoSign(splitDot[1]));
        } else {
            return isValidIntegerWithNoSignIncludingHeadingZero(splitDot[0]);
        }
    }

    public boolean isValidIntegerWithNoSignIncludingHeadingZero(String s) {
        if (s == null || s.equals("")) return false;
        if (s.charAt(0) == '0' && s.length() > 1) {
            return isValidIntegerWithNoSignIncludingHeadingZero(s.substring(1, s.length()));
        }
        else {
            return isAllDigit(s);
        }
    }

    public boolean isValidBeforeDotIntegerWithNoSignIncludingNothing(String s) {
        if (s == null) return false;
        if (s.equals("")) return true;
        return isValidBeforeDotIntegerWithNoSign(s);
    }

    public boolean isValidAfterDotIntegerWithNoSignIncludingNothing(String s) {
        if (s == null) return false;
        if (s.equals("")) return true;
        return isValidAfterDotIntegerWithNoSign(s);
    }

    public boolean isValidNumberWithNoSign(String s) {
        if (s == null || s.equals("")) return false;
        String[] splitDot = cSplit(s, ".");
        if (splitDot.length > 2) {
            return false;
        } else if(splitDot.length == 2) {
            return isValidBeforeDotIntegerWithNoSign(splitDot[0]) && isValidAfterDotIntegerWithNoSign(splitDot[1]);
        } else {
            return isValidIntegerWithNoSign(splitDot[0]);
        }
    }

    public boolean isValidBeforeDotIntegerWithNoSign(String s) {
        return isValidIntegerWithNoSignIncludingHeadingZero(s);
    }

    public boolean isValidAfterDotIntegerWithNoSign(String s) {
        if (s == null || s.equals("")) return false;
        return isAllDigit(s);
    }

    public boolean isValidIntegerWithNoSign(String s) {
        if (s == null || s.equals("")) return false;
        if (s.charAt(0) == '0' && s.length() > 1) return false;
        else {
            return isAllDigit(s);
        }
    }

    public boolean isAllDigit(String s) {
        if (s == null || s.equals("")) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!isDigit(s.charAt(i))) return false;
        }
        return true;
    }

    public boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }


    public boolean isValidBeforeE(String s) {
        return isValidNoENumber(s);
    }


    public boolean isValidAfterE(String s) {
        return isValidNoEInteger(s);
    }


    public boolean isValidNoEInteger(String s) {
        if (s == null || s.equals("")) return false;

        char ch = s.charAt(0);
        if(ch == '+' || ch == '-') {
            return isValidIntegerWithNoSignIncludingHeadingZero(s.substring(1, s.length()));
        } else {
            return isValidIntegerWithNoSignIncludingHeadingZero(s);
        }
    }

    // return 2 if exist, return 1 if not exist
    public String[] cSplit(String s, String del) {
        if (s == null || s.equals("")) return new String[3];

        char delCh = del.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == delCh) {
                String[] result = new String[2];
                result[0] = s.substring(0,i);
                result[1] =  i + 1 >= s.length() ? "" : s.substring(i+1, s.length());
                return result;
            }
        }

        String[] result = new String[1];
        result[0] = s;
        return result;
    }
}