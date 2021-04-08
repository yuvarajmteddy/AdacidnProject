package org.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sample {
	public static void main(String[] args) throws IOException {
		File file = new File("D:\\Eclipse\\Work\\execl\\datas.xlsx");
		// inside
		FileInputStream fileInputStream = new FileInputStream(file);
		// xl read
		Workbook workbook = new XSSFWorkbook(fileInputStream);

		Sheet sheet = workbook.getSheet("sheet2");
		// print all row & cell or colum
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);

			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);

				int type = cell.getCellType();

				if (type == 1) {
					String name = cell.getStringCellValue();
					System.out.println(name);

				}
				if (type == 0) {
					double d = cell.getNumericCellValue();
					long l = (long) d;
					String name = String.valueOf(l);
					System.out.println(name);
				}
			}

		}

	}

}
