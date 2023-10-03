public class MyArrayDataexception extends Exception{
    public MyArrayDataexception(int x, int y) {
        super("Not valid data in arra cell [%d, %d]". formatted(x, y));
    }
}
