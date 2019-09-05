package com.demo.boot_pro.demo;

import com.alibaba.fastjson.JSON;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Excel操作工具
 * Created by DIAN on 2018/9/6.
 */
public final class ExcelUntils {
    private static Logger logger = LoggerFactory.getLogger(ExcelUntils.class);
    /**
     * 不可实例化
     * */
    public ExcelUntils(){}
    /**
     * 读取Excel内容
     * */
    public static List<List<Object>> readExcel(File file) throws IOException {
        String fName = file.getName();
        String extension = fName.lastIndexOf(".") == -1 ? "" : fName
                .substring(fName.lastIndexOf(".") + 1);
        if ("xls".equals(extension)) {
            return readExcelByXls(file);
        } else if ("xlsx".equals(extension)) {
            return readExcelByXlsx(file);
        } else {
            throw new IOException("不支持的文件类型:" + extension);
        }
    }
    /**
     *
     * 读取excel xls格式  jxl
     * */
   public static List<List<Object>> readExcelByXls(File xlsFile) {
       // 获得工作簿对象
       Workbook workbook = null;
       new XSSFWorkbook();
       List<List<Object>> resultList = new ArrayList<>();
       List<Object> one = null;
       try {
           // 创建输入流，读取Excel
           InputStream is = new FileInputStream(xlsFile.getAbsolutePath());
           // jxl提供的Workbook类
           WorkbookSettings workbookSettings = new WorkbookSettings();
           //可以设置为UTF-8或者GBK或者ISO-8859-1
           workbookSettings.setEncoding("GBK");
           workbook = Workbook.getWorkbook(is, workbookSettings);
           // 获得所有工作表
           Sheet[] sheets = workbook.getSheets();
           // 遍历工作表
           if (sheets != null) {
               for (Sheet sheet : sheets) {
                   // 获得行数
                   int rows = sheet.getRows();
                   // 获得列数
                   int cols = sheet.getColumns();
                   // 读取数据
                   for (int row = 0; row < rows; row++) {
                       one = new ArrayList<>();
                       for (int col = 0; col < cols; col++) {
                           one.add(sheet.getCell(col, row).getContents());
                       }
                       resultList.add(one);
                   }
               }
           }
           workbook.close();
           is.close();
           return resultList;
       } catch (IOException | BiffException e) {
           e.printStackTrace();
           return resultList;
       }
   }
    /**
     *
     * 读取excel xlsx格式 poi
     * */
    public static List<List<Object>> readExcelByXlsx(File file) throws IOException {
        List<List<Object>> dataList = new ArrayList<List<Object>>();
        XSSFWorkbook xwb = null;
        xwb = new XSSFWorkbook(new FileInputStream(file));
        int sheetNum = xwb.getNumberOfSheets();
        if(sheetNum>0){
            for(int a = 0;a<sheetNum;a++){
                XSSFSheet sheet = xwb.getSheetAt(a);
                XSSFRow row = null;
                XSSFCell cell = null;
                Object val = null;
                // 格式化数字
                DecimalFormat df = new DecimalFormat("0");
                // 格式化日期字符串
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                for (int i = sheet.getFirstRowNum(); i < sheet
                        .getPhysicalNumberOfRows(); i++) {
                    row = sheet.getRow(i);
                    if (row == null) {
                        continue;
                    }
                    List<Object> objList = new ArrayList<Object>();
                    for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                        cell = row.getCell(j);
                        if (cell == null) {
                            val = null;
                            objList.add(val);
                            continue;
                        }
                        switch (cell.getCellType()) {
                            case XSSFCell.CELL_TYPE_STRING:
                                val = cell.getStringCellValue();
                                break;
                            case XSSFCell.CELL_TYPE_NUMERIC:
                                if ("@".equals(cell.getCellStyle().getDataFormatString())) {
                                    val = df.format(cell.getNumericCellValue());
                                } else if ("General".equals(cell.getCellStyle()
                                        .getDataFormatString())) {
                                    val = df.format(cell.getNumericCellValue());
                                } else {
                                    val = sdf.format(HSSFDateUtil.getJavaDate(cell
                                            .getNumericCellValue()));
                                }
                                break;
                            case XSSFCell.CELL_TYPE_BOOLEAN:
                                val = cell.getBooleanCellValue();
                                break;
                            case XSSFCell.CELL_TYPE_BLANK:
                                val = "";
                                break;
                            default:
                                val = cell.toString();
                                break;
                        }
                        objList.add(val);
                    }
                    dataList.add(objList);
                }
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\DIAN\\Desktop\\sj.xls");
        Set<Object> provinceList =new HashSet<>();
        try {
            List<List<Object>> dd  = ExcelUntils.readExcel(file);
            List<Map<String,Object>> result = new ArrayList<>();
            for(List<Object> list:dd){
                 Map<String ,Object> map = new HashMap<>();
                 map.put("name",list.get(0));
                 map.put("province",list.get(1));
                 map.put("city",list.get(2));
                 map.put("grade",list.get(3).toString());
                 provinceList.add(list.get(1));
                 result.add(map);
            }
            Map<Object,Object> ss = new HashMap<>();
            for(Object one: provinceList){
                 Set<Object>  set = new HashSet<>();
                 for(List<Object> list:dd){
                     if(one.equals(list.get(1))){
                         set.add(list.get(2));
                     }
                 }
                ss.put(one,set);
            }
            System.out.println(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
