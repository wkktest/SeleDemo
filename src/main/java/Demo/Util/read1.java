package Demo.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class read1 {
	/**
	 * xls  xlsx 不兼容，无法同时使用
	 * @param excelFilePath
	 * @param sheetName
	 * @return
	 * @throws IOException
	 */
	// 从Excel文件获取测试数据的静态方法
		public static Object[][] getTestData(String excelFilePath,String sheetName) throws IOException {		
			 //读取路径中的文件
			File file = new File(excelFilePath);
			// 创建FileInputStream对象用于读取Excel文件
			FileInputStream inputStream = new FileInputStream(file);
			Workbook Workbook = null;
			// 获取文件名参数的扩展名，判断是.xlsx文件还是.xls文件
			String fileExtensionName = excelFilePath.substring(excelFilePath.indexOf("."));
			if (fileExtensionName.equals(".xlsx")) {
				Workbook = new XSSFWorkbook(inputStream);
			} else if (fileExtensionName.equals(".xls")) {
				Workbook = new HSSFWorkbook(inputStream);
			}
			// 通过sheetName参数，声称Sheet对象
			Sheet Sheet = Workbook.getSheet(sheetName);
			// 获取Excel数据文件Sheet中数据的行数，getLastRowNum()方法获取数据的最后一行行号
			// getFirstRowNum()方法获取数据的第一行行号，相减之后得出数据的行数，Excel文件的行号和列号都是从0开始
			int rowCount = Sheet.getLastRowNum() - Sheet.getFirstRowNum();
			// 创建list对象存储从Excel数据文件读取的数据
			List<Object[]> records = new ArrayList<Object[]>();
			// 循环遍历Excel数据文件的所有数据，除了第一行，第一行是数据列名称
			for (int i = 1; i < rowCount + 1; i++) {
				// 使用getShow方法获取行对象
				Row row = Sheet.getRow(i);
				/*
				 * 声明一个数组，存储Excel数据文件每行中的测试用例和数据，数组大小用getLastCellNum()-2来进行动态声明。
				 * 因为Excel中测试数据行的最后一个单元格为测试执行结果，倒数第二个单元格为此测试数据行是否运行的状态，
				 * 所以最后2列的数据不需要传入测试方法中
				 */
				Object fields[] = new Object[row.getLastCellNum()];
				// 判断数据行是否要参与测试执行，标记为 y表示数据行被测试执行，非y则不会执行，会被跳过
				// if(row.getCell(row.getLastCellNum()).getStringCellValue().equals("y")){
				for (int j = 0; j < row.getLastCellNum(); j++) {
					// 使用getCell()和getStringCellValue()方法获取Excel文件中的单元格数据
					// 判断Excel的单元格字段是数字还是字符，字符串格式用getStringCellValue方法获取，数字用getNumericCellValue方法获取
					fields[j] = (row.getCell(j).getCellType() == Cell.CELL_TYPE_STRING
							? row.getCell(j).getStringCellValue() : "" + row.getCell(j).getNumericCellValue());
					// 将fields的数据对象存入records的list中

				}
				records.add(fields);
			}

			// 将存储测试数据的List转换为一个Object的二维数组
			Object[][] results = new Object[records.size()][];
			// 设置二位数组每行的值，每行是一个Object对象
			for (int m = 1; m < records.size(); m++) {
				results[m] = records.get(m);

			}
			return results;
		}
}

