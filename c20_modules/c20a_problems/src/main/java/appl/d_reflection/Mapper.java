package appl.d_reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Mapper {

    public static Map<String, Object> extractFields(Object obj) {
        final Map<String, Object> map = new HashMap<>();
        try {
            for (final Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                final Object value = field.get(obj);
                map.put(field.getName(), value);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return map;
    }

}
