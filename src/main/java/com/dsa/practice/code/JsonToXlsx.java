package com.dsa.practice.code;

//import java.io.*;
//import java.nio.charset.StandardCharsets;

public class JsonToXlsx {
    public static void main(String[] args) {
//        String[] headers = new String[] {"No", "Name"};
//
//        InputStream inputStream = new FileInputStream(new File("C:\\Users\\DAIR_092104\\Downloads\\sample.json"));
//
//        String json = getString(inputStream);
//
//        JSONArray array = new JSONArray(json);
//
//        //declare file name to be create
//        String filename = "C:\\Users\\DAIR_092104\\Downloads\\Test.xlsx";
//
//        //creating an instance of HSSFWorkbook class
//        HSSFWorkbook workbook = new HSSFWorkbook();
//
//        //invoking creatSheet() method and passing the name of the sheet to be created
//        HSSFSheet sheet = workbook.createSheet("Data");
//
//
//
//        int cnt = 0;
//        for (Object o: array){
//
//            JSONObject object = (JSONObject) o;
//
//            if(cnt == 0){
//
//                // create header
//
//                //creating the 0th row using the createRow() method
//                HSSFRow rowhead = sheet.createRow((short)0);
//
//                for (int i = 0; i < headers.length; i++) {
//                    rowhead.createCell(i).setCellValue(headers[i]);
//                }
//
//                cnt++;
//                continue;
//            }
//
//
//            HSSFRow row = sheet.createRow((short)cnt);
//
//            //inserting data in the first row
//            row.createCell(0).setCellValue(object.getString("No"));
//            row.createCell(1).setCellValue(object.getString("Name"));
//
//            cnt++;
//        }
//
//        FileOutputStream fileOut = new FileOutputStream(filename);
//        workbook.write(fileOut);
//
//        //closing the Stream
//        fileOut.close();
//
//        //closing the workbook
//        workbook.close();
//
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Done");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
    }

//    static String getString(InputStream stream) throws IOException {
//        int bufferSize = 1024;
//        char[] buffer = new char[bufferSize];
//        StringBuilder out = new StringBuilder();
//        Reader in = new InputStreamReader(stream, StandardCharsets.UTF_8);
//        for (int numRead; (numRead = in.read(buffer, 0, buffer.length)) > 0;) {
//            out.append(buffer, 0, numRead);
//        }
//        return out.toString();
//    }
}
