public class Brackets
{
    public static void main(String[] args) throws StackUnderflowException 
    {
        System.out.println("Should be true");
        System.out.println(checkBrackets(" "));
        System.out.println(checkBrackets("{}"));
        System.out.println(checkBrackets("{}{}"));
        System.out.println(checkBrackets("{{}}"));
        System.out.println(checkBrackets("{{{}{{}}}}"));

        System.out.println("\nShould be false");
        System.out.println(checkBrackets("{"));
        System.out.println(checkBrackets("}{"));
        System.out.println(checkBrackets("{}}{"));
        System.out.println(checkBrackets("{{}"));
        System.out.println(checkBrackets("{{}}}{}"));
    }
    
    public static boolean checkBrackets(String b) throws StackUnderflowException 
    {
        LinkedStack stack = new LinkedStack();
        int count = 0;
        int openCount = 0;
        String previousCharacter = "";
        for(int i = 0; i < b.length(); i++) {
            String s = b.charAt(i) + "";
            if(s.equals("{")) {
                stack.push("{");
            }
            if(s.equals("}")) {
                if(stack.size() != 0) {
                    stack.pop();
                    count--;
                }
                else {
                    return false;
                }
            }
        }
        if(stack.size() == 0) {
            return true;
        }
        return false;
    }
}
