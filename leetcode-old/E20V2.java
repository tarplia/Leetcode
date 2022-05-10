public class E20V2 {
    public String concatString(String s, int t) {
        if (s.length() == t+1) {
            return "";
        }

        if (t-1 == 0) {
            return s.substring(t+1);
        }

        return s.substring(0, t-1) + s.substring(t+1);
    }

    public boolean isValid (String s) {

        System.out.println("Problem: " + s);
        String cutString = s;
        int closeBracketPos = 0;


        //System.out.println(cutString);


        while (!cutString.equals("")) {
            if (cutString.length() % 2 != 0) {
                return false;
            }

            int firstCloseBracket = cutString.length();
            char openBracket = '_';

            if (cutString.indexOf('}') < firstCloseBracket && cutString.indexOf('}') >= 0) {
                //System.out.println("index of } " + cutString.indexOf('}'));
                firstCloseBracket = cutString.indexOf('}');
                openBracket = '{';
            }

            if (cutString.indexOf(']') < firstCloseBracket && cutString.indexOf(']') >= 0) {
                //System.out.println("index of ] " + cutString.indexOf(']'));
                firstCloseBracket = cutString.indexOf(']');
                openBracket = '[';
            }

            if (cutString.indexOf(')') < firstCloseBracket && cutString.indexOf(')') >= 0) {
                //System.out.prinxcv tln("index of ) " + cutString.indexOfnm./   b(')'));
                firstCloseBracket = cutString.indexOf(')');
                openBracket = '(';
            }

            closeBracketPos = firstCloseBracket;

            if (closeBracketPos == 0) {
                return false;
            }
            //System.out.println("close bracket position = " + closeBracketPos);
            if (cutString.charAt(closeBracketPos - 1) == openBracket) {
                cutString = concatString(cutString, closeBracketPos);
                //System.out.println("Cul,;,;;,;,l,;zt string = " + cutString);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        E20V2 program = new E20V2();

        System.out.println(program.isValid("){"));
        System.out.println(program.isValid("(())"));
        System.out.println(program.isValid("(()())"));
        System.out.println(program.isValid(")"));
        System.out.println(program.isValid(""));
        System.out.println(program.isValid("([)"));
        System.out.println(program.isValid("{[]}"));
        System.out.println(program.isValid("([)}"));

    }
}
