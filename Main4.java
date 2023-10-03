public class Main4 {
    public static void main(String[] args) {
        try {
            String[][] arr = new String[][] {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
            };
            int sum = getAllElementsSum(arr);
            System.out.println(sum);
        } catch (MyArrayDataexception | MyArraySizeException e) {
            e.printStackTrace();
        }
    }
    private static int getAllElementsSum(String[][] arr) throws MyArrayDataexception, MyArraySizeException{
        if (arr.length != arr[0].length) {
            throw new MyArraySizeException("Array is not square");
        }
        int sum = 0;
        for (int i=0; i < arr.length; i++) {
            for (int j=0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataexception(i, j);
                }
            }
        }
        return sum;
    }
}
