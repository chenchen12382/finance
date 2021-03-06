package com.pz.utils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.ClientAnchor;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/10/25.
 */
public class ExcelUtil<T>   {
    public void exportExcel(Collection<T> dataset, OutputStream out) {
        exportExcel("测试POI导出EXCEL文档", null, dataset, out, "yyyy-MM-dd");
    }

    public void exportExcel(String[] headers, Collection<T> dataset,
                            OutputStream out) {
        exportExcel("测试POI导出EXCEL文档", headers, dataset, out, "yyyy-MM-dd");
    }

    public void exportExcel(String[] headers, Collection<T> dataset,
                            OutputStream out, String pattern) {
        exportExcel("测试POI导出EXCEL文档", headers, dataset, out, pattern);
    }

    /**
     * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
     *
     * @param title   表格标题名
     * @param headers 表格属性列名数组
     * @param dataset 需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
     *                javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
     * @param out     与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
     * @param pattern 如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
     */
    @SuppressWarnings("unchecked")
    public synchronized void exportExcel(String title, String[] headers,
                            Collection<T> dataset, OutputStream out, String pattern) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(title);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 15);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.VIOLET.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
        // 生成并设置另一个样式
        HSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        HSSFFont font2 = workbook.createFont();
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style2.setFont(font2);

        // 声明一个画图的顶级管理器
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置,详见文档
        HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
                0, 0, 0, (short) 4, 2, (short) 6, 5));
        // 设置注释内容
        comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
        comment.setAuthor("leno");

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);
            T t = (T) it.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            for (short i = 0; i < fields.length; i++) {
                HSSFCell cell = row.createCell(i);
                cell.setCellStyle(style2);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[]
                                    {});
                    Object value = getMethod.invoke(t, new Object[]
                            {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    if (value instanceof Boolean) {
                        boolean bValue = (Boolean) value;
                        textValue = "男";
                        if (!bValue) {
                            textValue = "女";
                        }
                    } else if (value instanceof Date) {
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        textValue = sdf.format(date);
                    } else if (value instanceof byte[]) {
                        // 有图片时，设置行高为60px;
                        row.setHeightInPoints(60);
                        // 设置图片所在列宽度为80px,注意这里单位的一个换算
                        sheet.setColumnWidth(i, (short) (35.7 * 80));
                        // sheet.autoSizeColumn(i);
                        byte[] bsValue = (byte[]) value;
                        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,
                                1023, 255, (short) 6, index, (short) 6, index);
                        anchor.setAnchorType(ClientAnchor.AnchorType.byId(2));
                        patriarch.createPicture(anchor, workbook.addPicture(
                                bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
                    }else if(value == null){
                        value = "";
                        textValue = value.toString();
                    } else {
                        // 其它数据类型都当作字符串简单处理
                        textValue = value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(
                                    textValue);
                            HSSFFont font3 = workbook.createFont();
                            font3.setColor(HSSFColor.BLUE.index);
                            richString.applyFont(font3);
                            cell.setCellValue(richString);
                        }
                    }
                } catch (SecurityException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } finally {
                    // 清理资源
                }
            }
        }
        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<Map<String, String>> readExcel(InputStream fis) {
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();;
        try {
            HSSFWorkbook book = new HSSFWorkbook(fis);
            HSSFSheet sheet = book.getSheetAt(0);
            int firstRow = sheet.getFirstRowNum();
            int lastRow = sheet.getLastRowNum();
            //除去表头和第一行
//          ComnDao dao = SysBeans.getComnDao();
            for(int i = firstRow + 1; i<lastRow+1; i++) {
                Map map = new HashMap();

                HSSFRow row = sheet.getRow(i);
                int firstCell = row.getFirstCellNum();
                int lastCell = row.getLastCellNum();


                for(int j=firstCell; j<lastCell; j++) {

                    HSSFCell cell2 = sheet.getRow(firstRow + 1).getCell(j);
                    String key = cell2.getStringCellValue();

                    HSSFCell cell = row.getCell(j);

                    if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    }
                    String val = cell.getStringCellValue();

//              System.out.println(val);

                    if(i == firstRow + 1) {
                        break;
                    }else{
                        map.put(key, val);

                    }
//              System.out.println(map);
                }
                if(i != firstRow + 1) {
                    data.add(map);
                    System.out.println(map);
                }
            }
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

//    public static void main(String[] args) {
//        // 测试学生
//        ExcelUtil<Student> ex = new ExcelUtil();
//        String[] headers =
//                {"学号", "姓名", "年龄", "性别", "出生日期"};
//        List<Student> dataset = new ArrayList<Student>();
//        dataset.add(new Student(10000001, "张三", 20, true, new Date()));
//        dataset.add(new Student(20000002, "李四", 24, false, new Date()));
//        dataset.add(new Student(30000003, "王五", 22, true, new Date()));
//        // 测试图书
//        ExcelUtil<Book> ex2 = new ExcelUtil<Book>();
//        String[] headers2 =
//                {"图书编号", "图书名称", "图书作者", "图书价格", "图书ISBN", "图书出版社", "封面图片"};
//        List<Book> dataset2 = new ArrayList<Book>();
//        try {
//            BufferedInputStream bis = new BufferedInputStream(
//                    new FileInputStream("c://book.bmp"));
//            byte[] buf = new byte[bis.available()];
//            while ((bis.read(buf)) != -1) {
//                //
//            }
//            dataset2.add(new Book(1, "jsp", "leno", 300.33f, "1234567",
//                    "清华出版社", buf));
//            dataset2.add(new Book(2, "java编程思想", "brucl", 300.33f, "1234567",
//                    "阳光出版社", buf));
//            dataset2.add(new Book(3, "DOM艺术", "lenotang", 300.33f, "1234567",
//                    "清华出版社", buf));
//            dataset2.add(new Book(4, "c++经典", "leno", 400.33f, "1234567",
//                    "清华出版社", buf));
//            dataset2.add(new Book(5, "c#入门", "leno", 300.33f, "1234567",
//                    "汤春秀出版社", buf));
//
//            OutputStream out = new FileOutputStream("E://a.xls");
//            OutputStream out2 = new FileOutputStream("E://b.xls");
//            ex.exportExcel(headers, dataset, out);
//            ex2.exportExcel(headers2, dataset2, out2);
//            out.close();
//            out2.close();
//            JOptionPane.showMessageDialog(null, "导出成功!");
//            System.out.println("excel导出成功！");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
