package com.sist.web.service;

import java.util.List;
import com.sist.web.vo.*;

/*
 * 	user ===== DispatcherServlet
 * 					|
 * 				Service
 * 					|
 * 				Mapper
 * 					|
 * 				Oracle(DB)
 * 
 */

public interface RecipeService {
	public List<RecipeVO> recipeListData(int page);
	public int recipeCount();
	public int recipeTotalPage();
	public RecipeDetailVO recipeDetailData(int no);
	public int[] recipePages(int page);
}
