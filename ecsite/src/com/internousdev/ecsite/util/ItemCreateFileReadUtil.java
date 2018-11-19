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
		StringBuilder buf = new StringBuilder();

		String filename1 = "C://Users/internousdev.103163804/Desktop/workspace/workspace-oode/test/ecsite/WebContent/file/";
		String filename2 = excelname;
		buf.append(filename1);
		buf.append(filename2);
		String filename = buf.toString();

		FileInputStream filein = new FileInputStream(filename);

		try{
			/*Excelのワークブックを読み込む*/
//			POIFSFileSystem filein = new POIFSFileSystem(new FileInputStream(filename));

			/*新規ワークシートを作成する*/
//			HSSFWorkbook wb = new HSSFWorkbook(filein);

//			filein = new FileInputStream(filename);
			XSSFWorkbook wb = new XSSFWorkbook(filein);

			/*シートを読み込む*/
			/*シート名がわかっている場合*/
//			HSSFSheet sheet = wb.getSheet("Sheet1");
			/*取得したいシートが何番目かわかっている場合(今回は1番目？)*/
//			HSSFSheet sheet = wb.getSheetAt(0);

			/*取得する行数を指定*/
			/*取得したい行数がわかっている場合*/
//			HSSFRow row = sheet.getRow(0);
			/*全行を繰り返し処理する場合*/
//			Iterator<Row> rows = sheet.rowIterator();
//			while(rows.hasNext()){
//				Row row = rows.next();
//			}

			/*取得するセルを指定*/
			/*取得したいセルの位置がわかっている場合*/
			/*(引数はshort型でキャストしなければならない点に注意)*/
//			HSSFCell cell = row.getCell((short)0);
			/*全セルを繰り返し処理する場合*/
//			Iterator<Cell> cells = row.cellIterator();
//			while(cells.hasNext()){
//				Cell cell = cells.next();
//			}

			XSSFSheet sheet = wb.getSheet(sheetname);
			XSSFRow row;
			XSSFCell cell;

			for(int i=1;i<=sheet.getLastRowNum();i++){
				ItemCreateFileReadDTO dto = new ItemCreateFileReadDTO();

				row = sheet.getRow(i);

				cell = row.getCell(0);
				dto.setItemName(cell.getStringCellValue());
				cell = row.getCell(1);
				dto.setPrice(String.valueOf((int)cell.getNumericCellValue()));
				cell = row.getCell(2);
				dto.setStock(String.valueOf((int)cell.getNumericCellValue()));
				cell = row.getCell(3);
				dto.setGenre(cell.getStringCellValue());
				excelDTO.add(dto);
			}

//			int rowCount = sheet.getLastRowNum();
//			System.out.println("int = " + rowCount);

		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("ファイルの読み込みに失敗しました");
		}
		finally{
			filein.close();
		}

		return excelDTO;
	}
}
