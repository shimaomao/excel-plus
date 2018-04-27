package io.github.biezhi.excel.plus;

import io.github.biezhi.excel.plus.enums.ParseType;
import io.github.biezhi.excel.plus.model.CardSecret;
import io.github.biezhi.excel.plus.model.Test07;
import io.github.biezhi.excel.plus.reader.Reader;

import java.io.File;
import java.util.List;

/**
 * Excel read write examples
 *
 * @author biezhi
 * @date 2018/2/5
 */
public class Examples {

    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();

        ExcelPlus excelPlus = new ExcelPlus();

        Reader reader = Reader.create()
                .parseType(ParseType.SAX)
                .startRowIndex(2)
                .sheetIndex(0)
                .excelFile(new File("/Users/biezhi/Downloads/test07.xlsx"));

        List<Test07> test07List = excelPlus.read(Test07.class, reader).asList();
        System.out.println(test07List);

        reader = Reader.create()
                .parseType(ParseType.SAX)
                .startRowIndex(2)
                .sheetIndex(0)
                .excelFile(new File("/Users/biezhi/workspace/projects/java/excel-plus/src/test/resources/卡密列表.xlsx"));

        List<CardSecret> stations = excelPlus.read(CardSecret.class, reader).asList();

        System.out.println(stations.size());
        System.out.println(stations);
        System.out.println((System.currentTimeMillis() - start) + "ms");
    }

}
