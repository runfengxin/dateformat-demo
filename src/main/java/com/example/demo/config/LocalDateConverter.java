package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

/**
 * @author xinrunfeng
 * @description:
 */
public class LocalDateConverter implements Converter<String, LocalDateTime> {

    private Logger logger = LoggerFactory.getLogger(LocalDateConverter.class);

    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private static final String shortDateFormat = "yyyy-MM-dd";
    private static final String timeStampFormat = "^\\d+$";

    @Override
    public LocalDateTime convert(String value) {
        logger.info("转换日期：" + value);

        if(value == null || value.trim().equals("") || value.equalsIgnoreCase("null")) {
            return null;
        }

        value = value.trim();

        try {
            if (value.contains("-")) {
                DateTimeFormatter dateTimeFormatter;
                if (value.contains(":")) {
                    dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
                } else {
                    dateTimeFormatter = DateTimeFormatter.ofPattern(shortDateFormat);
                }
                LocalDateTime parse = LocalDateTime.parse(value, dateTimeFormatter);
                System.out.println("parse" + parse.format(dateTimeFormatter));
                return parse;
            } else if (value.matches(timeStampFormat)) {
                Long lDate = new Long(value);
                return LocalDateTime.ofEpochSecond(lDate/1000,0, ZoneOffset.ofHours(8));
            }
        } catch (Exception e) {
            throw new RuntimeException(String.format("parser %s to Date fail", value));
        }
        throw new RuntimeException(String.format("parser %s to Date fail", value));
    }
}