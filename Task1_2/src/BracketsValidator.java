public class BracketsValidator implements StringValidator {
    private int errorPos = -1;
    private String errorMsg = "";
    @Override
    public boolean isValid(String s) {
        errorPos = -1;
        errorMsg = "";
        if (s == null) return true;
        char[] stack = new char[s.length()];
        int top = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[' || c == '<') {
                stack[top] = c;
                top++;
            }
            else if (c == ')' || c == '}' || c == ']' || c == '>') {
                if (top == 0) {
                    errorPos = i;
                    errorMsg = "Лишняя закрывающая скобка: " + c;
                    return false;
                }
                top--;
                char lastOpen = stack[top];
                boolean isMatch = false;
                if (lastOpen == '(' && c == ')') isMatch = true;
                if (lastOpen == '{' && c == '}') isMatch = true;
                if (lastOpen == '[' && c == ']') isMatch = true;
                if (lastOpen == '<' && c == '>') isMatch = true;
                if (!isMatch) {
                    errorPos = i;
                    errorMsg = "Несовпадение: ожидалось закрытие для " + lastOpen + ", а встретилось " + c;
                    return false;
                }
            }
        }
        if (top > 0) {
            errorMsg = "Не хватает закрывающих скобок. Открыта: " + stack[top - 1];
            errorPos = s.length();
            return false;
        }
        return true;
    }
    @Override
    public int getErrorPos() {
        return errorPos;
    }
    @Override
    public String getErrorMessage() {
        return errorMsg;
    }
}