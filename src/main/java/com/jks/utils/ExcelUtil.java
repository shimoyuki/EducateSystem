package com.jks.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelUtil {
	private File file;
	private OutputStream os;
	private XSSFWorkbook book = null;
	private Sheet sheet = null;
	private int[] width;

	public ExcelUtil() {
		super();
	}

	public ExcelUtil(File file) throws IOException, InvalidFormatException {
		super();
		this.file = file;
		if (!file.exists()) {
			file.createNewFile();
		}
		os = new FileOutputStream(file);
		book = new XSSFWorkbook();
		sheet = book.createSheet();
	}

	public ExcelUtil(OutputStream os) {
		super();
		this.os = os;
		book = new XSSFWorkbook();
		sheet = book.createSheet();
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public OutputStream getOs() {
		return os;
	}

	public void setOs(OutputStream os) {
		this.os = os;
	}

	public XSSFWorkbook getBook() {
		return book;
	}

	public void setBook(XSSFWorkbook book) {
		this.book = book;
	}

	public Sheet getSheet() {
		return sheet;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}

	public void nextSheet() {
		this.sheet = book.createSheet();
	}

	public void nextSheet(String sheet) {
		this.sheet = book.createSheet(sheet);
	}

	/**
	 * 在excel表第一行写入标题，，用于write()方法之前
	 * 
	 * @param title
	 *            所有项标题组成的字符串数组
	 */
	public void writeTitle(String[] title) {
		XSSFCellStyle cellStyle = book.createCellStyle();
		cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setWrapText(true);
		Row titleRow = sheet.createRow(0);
		width = new int[title.length];
		for (int i = 0; i < title.length; i++) {
			Cell cell = titleRow.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(cellStyle);
			width[i] = title[i].length() * 2 * 256;
			sheet.setColumnWidth(i, width[i]);
		}
	}

	/**
	 * 将指定对象object写入excel表中新添的一行
	 * 
	 * @param object
	 * @throws IOException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public void write(Object object) throws IOException, IllegalArgumentException, IllegalAccessException {
		XSSFCellStyle cellStyle = book.createCellStyle();
		cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setWrapText(true);
		int lastRowNum = sheet.getLastRowNum();
		Row curColRow = sheet.createRow(lastRowNum + 1);
		Cell cell = null;
		int curCol = 0, length = 0;

		//System.out.println("Writing class " + object.getClass().getName() + "……");
		Field[] fields = object.getClass().getDeclaredFields();
		if (width == null) {
			width = new int[fields.length - 2];
		}
		for (int i = 0; i < fields.length; i++) {
			// System.out.println(fields[i].getName()+";"+fields[i].getType());
			if (!fields[i].getName().equals("id") && !fields[i].getName().equals("audit")) {
				fields[i].setAccessible(true);
				cell = curColRow.createCell(curCol);
				if (fields[i].getType().toString().equals("class java.lang.String")) {
					String value = (String) fields[i].get(object);
					cell.setCellValue(value);
					cell.setCellStyle(cellStyle);
					if (value != null) {
						length = value.length();
					}
				} else if (fields[i].getType().toString().equals("class java.lang.Integer")
						|| fields[i].getType().toString().equals("int")) {
					Integer value = (Integer) fields[i].get(object);
					cell.setCellValue(value);
					cell.setCellStyle(cellStyle);
					if (value != null) {
						length = value.toString().length();
					}	
				} else if (fields[i].getType().toString().equals("class java.lang.Float")
						|| fields[i].getType().toString().equals("float")) {
					Float value = (Float) fields[i].get(object);
					cell.setCellValue(value.intValue());
					cell.setCellStyle(cellStyle);
					if (value != null) {
						length = value.toString().length();
					}	
				} else {
					BigDecimal value = (BigDecimal) fields[i].get(object);
					System.out.println(value);
					System.out.println(value.floatValue());
					System.out.println(value.doubleValue());
					value.setScale(2, BigDecimal.ROUND_HALF_UP);
					System.out.println(value);
					System.out.println(value.floatValue());
					System.out.println(value.doubleValue());
					cell.setCellValue(value.floatValue());
					cell.setCellStyle(cellStyle);
					if (value != null) {
						length = value.toString().length();
					}	
				}
				length = length * 2 * 256;
				// System.out.println(length+" ; "+width[curCol]);
				if (length > width[curCol]) {
					width[curCol] = length;
					//System.out.println("Length:" +length);
					sheet.setColumnWidth(curCol, width[curCol]<50*256?width[curCol]:50*256);
				}
				curCol++;
			}
		}
	}


	 /**
	  * 在excel表前两行写入标题，用于writeList()方法之前
	  * @param title
	  * 所有项标题组成的字符串数组
	  * @param year
	  * 所有数据年份组成的字符串数组
	  */
	public void writeListTitle(String[] title, List<String> year) {
		XSSFCellStyle cellStyle = book.createCellStyle();
		cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		
		Row titleRow = sheet.createRow(0);
		Row yearRow = sheet.createRow(1);
		width = new int[(title.length-1)*year.size()+1];
		
		CellRangeAddress cra = new CellRangeAddress(0, 1, 0, 0);
		sheet.addMergedRegion(cra);
		Cell cell = titleRow.createCell(0);
		cell.setCellValue(title[0]);//一般为合并单元格“招生代码”
		cell.setCellStyle(cellStyle);
		width[0] = title[0].length() * 2 * 256;
		sheet.setColumnWidth(0, width[0]);
		
		for (int i = 1; i < title.length; i++) {
			for (int j = 0; j < year.size(); j++) {
				int curCol = (i-1) * year.size() + j+1;//当前列
				cell = yearRow.createCell(curCol);
				cell.setCellValue(year.get(j));
				cell.setCellStyle(cellStyle);
				width[curCol] = year.get(j).length() * 2 * 256;
				sheet.setColumnWidth(curCol, width[curCol]);
			}
			cra = new CellRangeAddress(0, 0, (i-1)*year.size()+1,  i*year.size());
			sheet.addMergedRegion(cra);
			cell = titleRow.createCell((i-1)*year.size()+1);
			cell.setCellValue(title[i]);
			cell.setCellStyle(cellStyle);
		}
	}
	
	/**
	 * 将指定对象objectList写入excel表中,该list需按照admcode，year顺序排列
	 * @param objectList
	 * @param year
	 * @throws IOException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public void writeList(List<Object> objectList, List<String> year)
			throws IOException, IllegalArgumentException, IllegalAccessException {
		XSSFCellStyle cellStyle = book.createCellStyle();
		cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setWrapText(true);
		int lastRowNum = sheet.getLastRowNum();
		Row curColRow = null;//当前行
		Cell cell = null;
		int curCol = 0, curDev = 0, length = 0;//当前基准列，当前列偏移量，数据字符数（用于控制单元格宽度）
		String curAdm = "";//当前学院
		
		Iterator<Object> iterator = objectList.iterator();
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			Field[] fields = object.getClass().getDeclaredFields();
			if (width == null) {
				width = new int[fields.length - 4];
			}
			for (int i = 0; i < fields.length; i++) {//确定行和列偏移量
				fields[i].setAccessible(true);
				if (fields[i].getName().equals("admcode")) {
					if (!curAdm.equals(fields[i].get(object))) {//学校改变时换行
						curAdm = (String) fields[i].get(object);
						lastRowNum += 1;
						curColRow = sheet.createRow(lastRowNum);
					}
					
					cell = curColRow.createCell(0);//第一列
					String value = (String) fields[i].get(object);
					cell.setCellValue(value);
					cell.setCellStyle(cellStyle);
					length = value.length();
					if (length > width[0]) {
						width[0] = length;
						sheet.setColumnWidth(0, width[0]);
					}
				}
				if (fields[i].getName().equals("year")) {
					for (int j = 0; j < year.size(); j++) {
						if (year.get(j).equals(fields[i].get(object))) {
							curDev = j+1;
						}
					}
				}
			}
			curCol = 0;//重置基准列为第一列
			for (int i = 0; i < fields.length; i++) {
				if (!fields[i].getName().equals("id") && !fields[i].getName().equals("audit")
						&& !fields[i].getName().equals("city") && !fields[i].getName().equals("year") && !fields[i].getName().equals("admcode")) {
					cell = curColRow.createCell(curCol * year.size() + curDev);//需要插入的属性值所在列为基准列+列偏移量
					if (fields[i].getType().toString().equals("class java.lang.String")) {
						String value = (String) fields[i].get(object);
						cell.setCellValue(value);
						cell.setCellStyle(cellStyle);
						length = value.length();
					} else if (fields[i].getType().toString().equals("class java.lang.Integer")
							|| fields[i].getType().toString().equals("int")) {
						Integer value = (Integer) fields[i].get(object);
						cell.setCellValue(value);
						cell.setCellStyle(cellStyle);
						length = value.toString().length();
					} else if (fields[i].getType().toString().equals("class java.lang.Float")
							|| fields[i].getType().toString().equals("float")) {
						Float value = (Float) fields[i].get(object);
						cell.setCellValue(value.intValue());
						cell.setCellStyle(cellStyle);
						length = value.toString().length();
					} else {
						BigDecimal value = (BigDecimal) fields[i].get(object);
						cell.setCellValue(value.floatValue());
						cell.setCellStyle(cellStyle);
						length = value.toString().length();
					}
					length = length * 2 * 256;
					// System.out.println(length+" ; "+width[curCol]);
					if (length > width[curCol]) {
						width[curCol] = length;
						sheet.setColumnWidth(curCol, width[curCol]<50*256?width[curCol]:50*256);
					}
					curCol++;
				}
			}
			
		}
	}

	/**
	 * 从excel工作表中指定行row读取类型为cls的对象
	 * 
	 * @param row
	 * @param cls
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static Object read(Row row, Class<?> cls) throws InstantiationException, IllegalAccessException {
		if (row == null)
			return null;
		Object object = cls.newInstance();
		Field[] fields = cls.getDeclaredFields();
		int curCol = row.getFirstCellNum();

		for (int i = 0; i < fields.length; i++) {
			// System.out.println(fields[i].getName()+";"+fields[i].getType());
			if (!fields[i].getName().equals("id") && !fields[i].getName().equals("audit")) {
				Cell cell = row.getCell(curCol);
				if (null != cell) {
					fields[i].setAccessible(true);
					if (fields[i].getType().toString().equals("class java.lang.String")) {
						if (cell.getCellTypeEnum() == CellType.BLANK) {
							fields[i].set(object, "");
						} else if (cell.getCellTypeEnum() == CellType.STRING) {
							fields[i].set(object, cell.getStringCellValue());
						} else {
							if ((int) cell.getNumericCellValue() != 0) {
								fields[i].set(object, (long) cell.getNumericCellValue() + "");
							}
						}
					} else if (fields[i].getType().toString().equals("class java.lang.Integer")
							|| fields[i].getType().toString().equals("int")) {
						if (cell.getCellTypeEnum() == CellType.BLANK) {
							fields[i].set(object, 0);
						} else if (cell.getCellTypeEnum() == CellType.STRING) {
							if (!"".equals(cell.getStringCellValue())) {
								try {
									fields[i].set(object, Integer.parseInt(cell.getStringCellValue()));
								} catch (Exception e) {
									fields[i].set(object, 0);
								}
							}
						} else {
							fields[i].set(object, (int) cell.getNumericCellValue());
						}
					} else if (fields[i].getType().toString().equals("class java.lang.Float")
							|| fields[i].getType().toString().equals("float")) {
						if (cell.getCellTypeEnum() == CellType.BLANK) {
							fields[i].set(object, 0f);
						} else if (cell.getCellTypeEnum() == CellType.STRING) {
							if (!"".equals(cell.getStringCellValue())) {
								try {
									fields[i].set(object, Float.parseFloat(cell.getStringCellValue()));
								} catch (Exception e) {
									fields[i].set(object, 0f);
								}
							}
						} else {
							fields[i].set(object, (float) cell.getNumericCellValue());
						}
					} else {
						if (cell.getCellTypeEnum() == CellType.BLANK) {
							fields[i].set(object, new BigDecimal(0));
						} else if (cell.getCellTypeEnum() == CellType.STRING) {
							if (!"".equals(cell.getStringCellValue())) {
								try {
									fields[i].set(object, new BigDecimal(Double.parseDouble(cell.getStringCellValue())));
								} catch (Exception e) {
									fields[i].set(object, new BigDecimal(0));
								}
							}
						} else {
							fields[i].set(object, new BigDecimal(cell.getNumericCellValue()));
						}
					}
				}
				curCol++;
			}
		}
		return object;
	}

	/**
	 * 从excel工作表sheet中读取类型为cls的对象
	 * 
	 * @param sheet
	 * @param cls
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static List<Object> read(Sheet sheet, Class<?> cls) throws InstantiationException, IllegalAccessException {
		List<Object> result = new ArrayList<Object>();
		int rowStart = sheet.getFirstRowNum() + 1;
		int rowEnd = sheet.getLastRowNum();

		for (int i = rowStart; i <= rowEnd; i++) {
			Row row = sheet.getRow(i);
			Object object = ExcelUtil.read(row, cls);
			if (object != null) {
				result.add(object);
			}
		}
		return result;
	}

	/**
	 * 从excel文件file读取所有类型为cls的对象
	 * 
	 * @param file
	 * @param cls
	 * @return
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static List<Object> read(String file, Class<?> cls)
			throws InvalidFormatException, IOException, InstantiationException, IllegalAccessException {
		List<Object> result = new ArrayList<Object>();

		Workbook book;
		Sheet sheet;
		if (file.indexOf(".xlsx") > -1) {
			book = new XSSFWorkbook(new FileInputStream(file));
		} else {
			book = new HSSFWorkbook(new FileInputStream(file));
		}
		for (int i = 0; i < book.getNumberOfSheets(); i++) {
			sheet = book.getSheetAt(i);
			result.addAll(ExcelUtil.read(sheet, cls));
		}
		book.close();
		return result;
	}

	public static List<Object> read(MultipartFile file, Class<?> cls)
			throws InvalidFormatException, IOException, InstantiationException, IllegalAccessException {
		List<Object> result = new ArrayList<Object>();

		Workbook book;
		Sheet sheet;
		if (file.getOriginalFilename().indexOf(".xlsx") > -1) {
			book = new XSSFWorkbook(file.getInputStream());
		} else {
			book = new HSSFWorkbook(file.getInputStream());
		}
		for (int i = 0; i < book.getNumberOfSheets(); i++) {
			sheet = book.getSheetAt(i);
			result.addAll(ExcelUtil.read(sheet, cls));
		}
		book.close();
		return result;
	}

	/**
	 * 关闭输出流
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException {
		book.write(os);
		book.close();
	}
}
