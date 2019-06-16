package org.mushare.login.component.config.common;

import org.mushare.login.dao.ConfigDao;
import org.mushare.login.domain.Config;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ConfigUnit {

    public ConfigUnit(ConfigDao configDao) {
        Class clazz = getClass();
        Map<String, String> configs = new HashMap<>();
        configDao.findByClazz(clazz.getName()).forEach(config -> {
            configs.put(config.getName(), config.getContent());
        });
        for (Field field : clazz.getFields()) {
            String content = configs.get(field.getName());
            if (content == null) {
                content = "";
                Config config = Config.builder()
                        .clazz(clazz.getName())
                        .name(field.getName())
                        .content(content)
                        .build();
                configDao.save(config);
            }

            try {
                if (field.getType().equals(String.class)) {
                    field.set(this, content);
                } else if (field.getType().equals(boolean.class)) {
                    field.setBoolean(this, Boolean.valueOf(content));
                } else if (field.getType().equals(int.class)) {
                    if (content.equals("")) {
                        field.setInt(this, 0);
                    } else {
                        field.setInt(this, Integer.valueOf(content));
                    }
                } else if (field.getType().equals(double.class)) {
                    if (content.equals("")) {
                        field.setInt(this, 0);
                    } else {
                        field.setDouble(this, Double.valueOf(content));
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }

    public Map toMap() {
        return Arrays.asList(getClass().getFields()).stream().collect(Collectors.toMap(field -> {
            return field.getName();
        }, field -> {
            try {
                return field.get(this).toString();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return "";
        }));
    }

    @Override
    public String toString() {
        Class clazz = getClass();
        String string = clazz.getName() + "\n";
        for (Field field : clazz.getFields()) {
            try {
                string += "\t" + field.getName() + "<" + field.getType().getName() + ">: " + field.get(this) + "\n";
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return string;
    }

}
