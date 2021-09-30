public class MyRange {

    private String input;

    public MyRange(String input) {
        this.input = input;
    }

    public boolean startWithInClude() {
        return input.startsWith("[");
    }

    public boolean startWith1() {
        return "1".equals(input.substring(1,2));
    }

    public int getStart() {
        return Integer.parseInt(input.charAt(1) + "");
    }

    public void validate() {
        if(!input.startsWith("[") || !input.startsWith("(")){
            throw new InputInvalidException("Input error");
        }

    }
}
