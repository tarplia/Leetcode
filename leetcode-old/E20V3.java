public class E20V3 {
    static class Stack {
        private char[] slots;
        private char secondTop;
        private int indexTop;

        public Stack(String s) {
            slots = new char[s.length()];
            secondTop = 'x';
            indexTop = 0;

            for (int i  = 0; i < slots.length; i++) {
                slots[i] = 'a';
            }
        }

        public void addChar(char x) {
            slots[indexTop] = x;
            //System.out.println("Index top current " + indexTop);

            if (indexTop != 0) {
                secondTop = slots[indexTop-1];
            }

            if(indexTop <= slots.length - 1) {
                indexTop++;
            }
        }

        public void remove2Top() {
            slots[indexTop - 1] = 'a';
            slots[indexTop - 2] = 'a';
            indexTop -= 2;
        }

        public void print() {
            for (char c: slots) {
                System.out.println(c);
            }
        }

        public char getSecondTop() {
            return secondTop;
        }

        public char[] getSlots() {
            return slots;
        }

        public boolean isEmpty() {
            return indexTop == 0;
        }
    }

    public boolean isCharAClosingBracket(char c) {
        return (c == ')' || c == '}' || c == ']');
    }

    public boolean isMatching(char c1, char c2) {
        return ((c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']'));
    }

    public boolean isValid(String s) {
        Stack stack = new Stack(s);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.addChar(c);

            if (isCharAClosingBracket(c)) {
                //stack.print();
                //System.out.println("comparing " + stack.getSecondTop() + " and " + c);
                if (isMatching(stack.getSecondTop(), c)) {
                    stack.remove2Top();
                } else {
                    //System.out.println("sdf");
                    return false;
                }
            }
        }
        //stack.print();
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        E20V3 program = new E20V3();

        //Stack stack = new Stack("()");
        //stack.addChar('{');

        //stack.print();
        System.out.println(program.isValid("}["));
        System.out.println(program.isValid("([])]"));
        System.out.println(program.isValid("()[]{}"));
        System.out.println(program.isValid(""));
        System.out.println(program.isValid("()"));

    }
}
