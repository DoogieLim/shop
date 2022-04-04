//package com.shop.util;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.shop.constant.MetaGroupType;
//import com.shop.entity.MetaGroup;
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVParser;
//import org.apache.commons.csv.CSVRecord;
//import org.springframework.web.multipart.MultipartFile;
//
//public class CSVHelper {
//  public static String TYPE = "text/csv";
//  static String[] HEADERs = { "그룹_ID(integer)", "그룹타입(varchar)", "이름(varchar)", "설명(varchar)", "삭제여부(varchar)" };
//  public static boolean hasCSVFormat(MultipartFile file) {
//    if (!TYPE.equals(file.getContentType())) {
//      return false;
//    }
//    return true;
//  }
//  public static List<MetaGroup> csvToTutorials(InputStream is) {
//    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//         CSVParser csvParser = new CSVParser(fileReader,
//                 CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
//      List<MetaGroup> tutorials = new ArrayList<MetaGroup>();
//      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
//      for (CSVRecord csvRecord : csvRecords) {
//        MetaGroup tutorial = new MetaGroup(
//                MetaGroupType.valueOf(csvRecord.get(HEADERs[1])),
////                Long.parseLong(csvRecord.get(HEADERs[2])),
//                csvRecord.get(HEADERs[2]),
//                csvRecord.get(HEADERs[3]),
////                Boolean.parseBoolean(csvRecord.get(HEADERs[4]))
//                csvRecord.get(HEADERs[4]))
//        );
//        tutorials.add(tutorial);
//      }
//      return tutorials;
//    } catch (IOException e) {
//      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
//    }
//  }
//}