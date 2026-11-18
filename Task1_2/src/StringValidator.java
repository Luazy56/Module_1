public interface StringValidator {
    boolean isValid(String s);
    int getErrorPos();
    String getErrorMessage();
}