package com.shop.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.shop.constant.MetaGroupType;
import com.shop.constant.TrueFalse;
import com.shop.entity.MetaGroup;
import com.shop.entity.MetaItem;
import com.shop.repository.MetaGroupRepository;
import com.shop.repository.MetaItemRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class UploadController {

  @Autowired
  MetaGroupRepository metaGroupRepository;

  @Autowired
  MetaItemRepository metaItemRepository;


  @GetMapping("/excelUpload")
  public String main() { // 1
    return "/thymeleafEx/excelUpload";
  }


  // type : A (메타그룹), B (메타아이템)
  @PostMapping("/excel/read")
  public String readExcel(@RequestParam("file") MultipartFile file, @RequestParam("type") String type, Model model)
          throws IOException { // 2
    List<MetaGroup> dataList = new ArrayList<>();

    String extension = FilenameUtils.getExtension(file.getOriginalFilename()); // 3

    if (!extension.equals("csv")) {
      throw new IOException("CSV파일만 업로드 해주세요.");
    }

    String uploadFoler = "C:\\dev\\upload";
    File saveFile = new File(uploadFoler, file.getOriginalFilename());
    try {
      file.transferTo(saveFile);
    }catch (Exception e) {
      e.printStackTrace();
    }
    if(extension.equals("csv")) {
      List<List<String>> csvList = new ArrayList<List<String>>();
      File csv = new File(saveFile.getPath());
      BufferedReader br = null;
      String line = "";

      try {
        br = new BufferedReader(new FileReader(csv));
        while ((line = br.readLine()) != null) { // readLine()은 파일에서 개행된 한 줄의 데이터를 읽어온다.
//          List<String> aLine = new ArrayList<String>();

          if(type.equals("A")) { // 메타 그룹 인서트
            MetaGroup data = new MetaGroup();
            String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.
            data.setGroupType(MetaGroupType.valueOf(lineArr[1]));
            data.setGroupName(lineArr[2]);
            data.setDescription(lineArr[3]);
            data.setIsDeleted(TrueFalse.valueOf(lineArr[4]));
            metaGroupRepository.save(data);
          }
          else if(type.equals("B")) {
            MetaItem data = new MetaItem();
            String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.
            data.setItemType(lineArr[1]);
            MetaGroup metaGroup = new MetaGroup();
            metaGroup.setId(Long.parseLong(lineArr[2]));
            data.setMetaGroup(metaGroup);
            data.setItemName(lineArr[3]);
            data.setDefaultValue1(lineArr[4]);
            data.setDefaultValue2(lineArr[5]);
            data.setDefaultValue3(lineArr[6]);
            data.setOrderNums(Integer.parseInt(lineArr[7]));
            data.setIsDeleted(TrueFalse.valueOf(lineArr[8]));
            metaItemRepository.save(data);
          }

//          aLine = Arrays.asList(lineArr);
//          csvList.add(aLine);

        }

        //model.addAttribute("datas", csvList); // 5
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          if (br != null) {
            br.close(); // 사용 후 BufferedReader를 닫아준다.
          }
        } catch(IOException e) {
          e.printStackTrace();
        }
      }
    }
    return "thymeleafEx/excelList";
  }
}
