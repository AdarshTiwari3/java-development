package core_java.src.corejava.core_concepts;

class DataTypes {
    public static void main(String args[]) {
        int num = 10, second = 2;
        System.out.println("Hello Java");
        System.out.println("My Number=" + num);
        System.out.println("My Number2=" + second);

        int result = num + second;
        System.out.println("Sum=" + result);

        // primitive datatype in Java

        int a = 10; // 4 byte
        byte by = 126; // 1 byte = 8 bit
        short sh = 239; // 2 byte
        char ch = 'a'; // 2 byte because it follows unicode characters(16 bit) not ASCII
        long l = 2367l; // 8 byte , l is required to be put at the end otherwise it will consider it
                        // int
        float ft = 10.89f; // by default in java decimal is considered in double - 4 byte, we need
                           // to put f (literal) after value for float identification, ~7 Digits
                           // precision

        double d = 10.464699; // 8 byte ,Precision is about 15-17 decimal digits.
        boolean b = true; // boolean can only be true/false not 0/1 in java

        String output = """
                --- All Variables ---
                Integer: %d
                Byte:    %d
                Short:   %d
                Char:    %s
                Long:    %d
                Float:   %.2f
                Double:  %.4f
                Boolean: %b
                """.formatted(a, by, sh, ch, l, ft, d, b);

        System.out.println(output);


    }
}
