package by.lashkevich.arrays.arraysutill.creator;

import java.security.SecureRandom;
import java.util.Arrays;

public enum ArrayCreator {
    BYTE_ARRAY(1) {
        @Override
        public <T extends Number> T[] createArray() {
            SecureRandom random = new SecureRandom();
            int randomCapacity = (int) (Math.random() * (35 - 1)) + 1;
            byte[] bytes = new byte[randomCapacity];
            random.nextBytes(bytes);
            Byte[] array = new Byte[randomCapacity];

            for (int i = 0; i < randomCapacity; i++) {
                array[i] = bytes[i];
            }

            return (T[]) array;

        }
    },
    INTEGER_ARRAY(2) {
        @Override
        public <T extends Number> T[] createArray() {
            int randomCapacity = (int) (Math.random() * (35 - 1)) + 1;
            Integer[] array = new Integer[randomCapacity];
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * (100 - 1)) + 1;
            }

            return (T[]) array;
        }
    },
    LONG_ARRAY(3) {
        @Override
        public <T extends Number> T[] createArray() {
            int randomCapacity = (int) (Math.random() * (35 - 1)) + 1;
            Long[] array = new Long[randomCapacity];
            for (int i = 0; i < array.length; i++) {
                array[i] = (long) (Math.random() * (100 - 1)) + 1;
            }

            return (T[]) array;
        }
    },
    DOUBLE_ARRAY(4) {
        @Override
        public <T extends Number> T[] createArray() {
            int randomCapacity = (int) (Math.random() * (35 - 1)) + 1;
            Double[] array = new Double[randomCapacity];
            for (int i = 0; i < array.length; i++) {
                array[i] = (Math.random() * (100 - 1)) + 1;
            }

            return (T[]) array;
        }
    },
    FLOAT_ARRAY(5) {
        @Override
        public <T extends Number> T[] createArray() {
            int randomCapacity = (int) (Math.random() * (35 - 1)) + 1;
            Float[] array = new Float[randomCapacity];
            for (int i = 0; i < array.length; i++) {
                array[i] = (float) (Math.random() * (100 - 1)) + 1;
            }

            return (T[]) array;
        }
    };


    private final int arrayTypeNumber;

    ArrayCreator(int arrayTypeNumber) {
        this.arrayTypeNumber = arrayTypeNumber;
    }

    public int getArrayTypeNumber() {
        return arrayTypeNumber;
    }

    public abstract <T extends Number> T[] createArray();

    public static ArrayCreator findArrayType(int number) {
        return Arrays.stream(ArrayCreator.values())
                .filter(arrayCreator -> number == arrayCreator.getArrayTypeNumber())
                .findAny().orElse(INTEGER_ARRAY);
    }
}
