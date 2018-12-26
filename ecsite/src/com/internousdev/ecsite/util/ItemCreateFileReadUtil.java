package com.internousdev.ecsite.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.internousdev.ecsite.dto.ItemCreateFileReadDTO;

public class ItemCreateFileReadUtil{

	public ArrayList<ItemCreateFileReadDTO> excelRead(String excelname, String sheetname) throws FileNotFoundException, IOException{
		ArrayList<ItemCreateFileReadDTO> excelDTO = new ArrayList<ItemCreateFileReadDTO>();

		/*パス*/
		String filename1 = "C://Users/internousdev/Desktop/workspace/workspace-oode/test/ecsite/WebContent/file/";
		/*ファイル名*/
		String filename2 = excelname;

		/*ファイルパスを生成*/
		StringBuilder buf = new StringBuilder();
		buf.append(filename1);
		buf.append(filename2);
		String filename = buf.toString();

		FileInputStream filein = new FileInputStream(filename);
		try{
			XSSFWorkbook wb = new XSSFWorkbook(filein);
			XSSFSheet sheet = wb.getSheet(sheetname);
			XSSFRow row;
			XSSFCell cell;

			/*エクセルから商品情報を取得し、DTOに保存*/
			for(int i=1;i<=sheet.getLastRowNum();i++){
				ItemCreateFileReadDTO dto = new ItemCreateFileReadDTO();

				/*i行目を指定*/
				row = sheet.getRow(i);

				/*i行1列目を指定*/
				cell = row.getCell(0);
				/*i行1列目の情報を取得*/
				dto.setItemName(cell.getStringCellValue());
				/*i行2列目を指定*/
				cell = row.getCell(1);
				/*i行2列目の情報を取得*/
				dto.setPrice(String.valueOf((int)cell.getNumericCellValue()));
				/*i行3列目を指定*/
				cell = row.getCell(2);
				/*i行3列目の情報を取得*/
				dto.setStock(String.valueOf((int)cell.getNumericCellValue()));
				/*i行4列目を指定*/
				cell = row.getCell(3);
				/*i行4列目の情報を取得*/
				dto.setGenre(cell.getStringCellValue());

				/*DTOリストに保存*/
				excelDTO.add(dto);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			filein.close();
		}

		return excelDTO;
	}
}
