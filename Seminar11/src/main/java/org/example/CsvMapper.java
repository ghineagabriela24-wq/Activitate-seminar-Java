package org.example;

import java.lang.reflect.Field;

public class CsvMapper {

    public static <T> T fromCsv(String headerLine, String valueLine, Class<T> clazz) throws Exception {
        String[] headers = headerLine.split(",");
        String[] values = valueLine.split(",");

        T obj = clazz.getConstructor().newInstance();

        for (int i = 0; i < headers.length; i++) {
            String fieldName = headers[i].trim();
            String fieldValue = values[i].trim();

            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);

            if (field.getType() == String.class) {
                field.set(obj, fieldValue);
            } else if (field.getType() == int.class) {
                field.set(obj, Integer.parseInt(fieldValue));
            } else if (field.getType() == double.class) {
                field.set(obj, Double.parseDouble(fieldValue));
            } else if (field.getType() == boolean.class) {
                field.set(obj, Boolean.parseBoolean(fieldValue));
            }
        }

        return obj;
    }
}