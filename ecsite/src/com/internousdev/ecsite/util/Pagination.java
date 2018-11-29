package com.internousdev.ecsite.util;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.dto.PaginationDTO;

public class Pagination {

	public PaginationDTO initialize(List<ItemInfoDTO> list, int pageSize){
		PaginationDTO paginationDTO =new PaginationDTO();

		//全ページ数
		paginationDTO.setTotalPageSize((int)Math.ceil((double)list.size()/pageSize));
		//現在のページ数
		paginationDTO.setCurrentPageNo(1);
		//全レコード数
		paginationDTO.setTotalRecordSize(list.size() - 1);
		//現在のページ番号に対する開始レコード数
		paginationDTO.setStartRecordNo(pageSize * (paginationDTO.getCurrentPageNo() - 1));
		//現在のページ番号に対する終了レコード数
		paginationDTO.setEndRecordNo(paginationDTO.getStartRecordNo() + (pageSize - 1));
		//ページャーに表示するページ番号一覧
		List<Integer> pageNumberList = new ArrayList<Integer>();
		//全ページ数分だけループ
		for(int pageNumber =1; pageNumber <= paginationDTO.getTotalPageSize();pageNumber++){
			pageNumberList.add(pageNumber);
		}
		//1ページ分の商品情報
		List<ItemInfoDTO> itemInfoPages = new ArrayList<ItemInfoDTO>();
		for(int pageNumberOffset=paginationDTO.getStartRecordNo(); pageNumberOffset <= paginationDTO.getEndRecordNo(); pageNumberOffset++){
			if(pageNumberOffset > list.size() -1 ){
				break;
			}
			itemInfoPages.add(list.get(pageNumberOffset));
//			System.out.println(paginationDTO.getCurrentItemInfoPage().get(pageNumberOffset).getItemName());
		}
		paginationDTO.setCurrentItemInfoPage(itemInfoPages);

		for(int i=0;i<pageSize;i++){
//		System.out.println(paginationDTO.getCurrentItemInfoPage().get(i).getItemName());
	}

		//前ページが存在するか
		if((paginationDTO.getStartRecordNo() - 1) <= 0){
			//前ページは存在しない
			paginationDTO.setHasPreviousPage(false);
		}else{
			//前ページは存在する
			paginationDTO.setHasPreviousPage(true);
			paginationDTO.setPreviousPageNo(paginationDTO.getCurrentPageNo() - 1);
		}
		//次ページが存在するか
		if((paginationDTO.getStartRecordNo() + pageSize ) > paginationDTO.getTotalRecordSize()){
			//次ページは存在しない
			paginationDTO.setHasNextPage(false);
		}else{
			paginationDTO.setHasNextPage(true);
			paginationDTO.setNextPageNo(paginationDTO.getCurrentPageNo() + 1);
		}
		return paginationDTO;
	}

	//商品リスト画面からページ番号をクリックし再び商品リスト画面に移った場合の処理？
	public PaginationDTO getPage(List<ItemInfoDTO> list, int pageSize, String pageNo) {
		PaginationDTO paginationDTO = new PaginationDTO();
		// 全ページ数
		paginationDTO.setTotalPageSize((int)(Math.ceil((double)list.size() / pageSize)));
		// 現在のページ番号
		paginationDTO.setCurrentPageNo(Integer.parseInt(pageNo));
		// 全レコード数
		paginationDTO.setTotalRecordSize(list.size() - 1);
		// 現在のページ番号に対する開始レコード番号（オフセット）
		paginationDTO.setStartRecordNo(pageSize * (paginationDTO.getCurrentPageNo() -1));
		// 現在のページ番号に対する開始レコード番号
//		paginationDTO.setStartRecordNo((pageSize * paginationDTO.getCurrentPageNo()) + 1);
		// 現在のページ番号に対する終了レコード番号
		paginationDTO.setEndRecordNo(paginationDTO.getStartRecordNo() + (pageSize - 1));


		//ページャーに表示するページ番号一覧
		List<Integer> pageNumberList = new ArrayList<Integer>();
		//全ページ番号分だけループ
		for(int pageNumber = 1;pageNumber <= paginationDTO.getTotalPageSize(); pageNumber++) {
			pageNumberList.add(pageNumber);
		}

		//1ページ分のリストページ情報
		List<ItemInfoDTO> productInfoPages = new ArrayList<ItemInfoDTO>();
		//開始レコード番号から；最終レコード番号まで；インクリメント
		for(int pageNumberOffset=paginationDTO.getStartRecordNo(); pageNumberOffset <= paginationDTO.getEndRecordNo(); pageNumberOffset++) {
			//オフセットが(全商品数-1)より大きい場合
			if(pageNumberOffset > list.size() -1) {
				//商品リストの終端に着いたので処理を終える？
				break;
			}
			productInfoPages.add(list.get(pageNumberOffset));
		}
		paginationDTO.setCurrentItemInfoPage(productInfoPages);

		if((paginationDTO.getStartRecordNo() - 1) <= 0) {
			paginationDTO.setHasPreviousPage(false);
		}else {
			paginationDTO.setHasPreviousPage(true);
			paginationDTO.setPreviousPageNo(paginationDTO.getCurrentPageNo() - 1);
		}

		if(paginationDTO.getEndRecordNo() + pageSize > paginationDTO.getTotalRecordSize()) {
			paginationDTO.setHasNextPage(false);
		}else {
			paginationDTO.setHasNextPage(true);
			paginationDTO.setNextPageNo(paginationDTO.getCurrentPageNo() + 1);
		}
		return paginationDTO;
	}

}
