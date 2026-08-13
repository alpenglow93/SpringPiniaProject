package com.sist.web.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.sist.web.mapper.*;
import com.sist.web.vo.*;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService
{
	private final RecipeMapper rMapper;
	private int ROWSIZE=12;

	@Override
	public List<RecipeVO> recipeListData(int page) {
		// TODO Auto-generated method stub
		int start = (page*ROWSIZE)-ROWSIZE;
		
		return rMapper.recipeListData(start);
	}

	@Override
	public int recipeCount() {
		// TODO Auto-generated method stub
		return rMapper.recipeCount();
	}

	@Override
	public RecipeDetailVO recipeDetailData(int no) {
		// TODO Auto-generated method stub
		rMapper.hitIncrement(no);
		return rMapper.recipeDetailData(no);
	}

	@Override
	public int[] recipePages(int page) {
		// TODO Auto-generated method stub
		int totalpage = recipeTotalPage();
		final int BLOCK = 10;
		int startPage = ((page-1)/BLOCK*BLOCK)+1;
		int endPage = ((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage = totalpage;
		int[] pages = {page, totalpage, startPage, endPage};
		
		return pages;
	}

	@Override
	public int recipeTotalPage() {
		// TODO Auto-generated method stub
		int totalpage = (int)(Math.ceil(rMapper.recipeCount()/(double)ROWSIZE));
		
		return totalpage;
	}

}