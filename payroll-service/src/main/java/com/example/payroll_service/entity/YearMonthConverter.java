package com.example.payroll_service.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import javax.swing.text.AbstractDocument;
import java.time.YearMonth;


@Converter(autoApply = true)
public class YearMonthConverter implements AttributeConverter<YearMonth ,String> {
    @Override
    public String convertToDatabaseColumn(YearMonth yearMonth) {
        return yearMonth !=null ?yearMonth.toString() :null;
    }

    @Override
    public YearMonth convertToEntityAttribute(String value) {
        return value != null ? YearMonth.parse(value) : null;
    }
}
