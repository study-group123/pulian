package com.pulian.mall.controller.impl;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pulian.mall.dto.AchievementDto;
import com.pulian.mall.request.AchievementManagerRequest;
import com.pulian.mall.request.BaseResultT;
import com.pulian.mall.service.impl.AchievementManagerServiceImpl;
import com.pulian.mall.util.DateUtil;
import com.pulian.mall.util.Pagination;
/**
 * 
 * @author wangxiaoqiang
 * @date 2017-3-22
 */
@Controller
@RequestMapping("/achievement")
public class AchievementControllerImpl {

	@Autowired
	private AchievementManagerServiceImpl achievementManagerService;
	
	private static final Log log = LogFactory.getLog(AchievementControllerImpl.class);

	@RequestMapping("/toTimeAchievement")
	public String toTimeAchievement(Model model,HttpServletRequest request, HttpServletResponse response) {
		
		
		return "time_achievement";
	}
	@RequestMapping("exportVasCouponOrderListCsv")
	public String exportAchievementList(Model model,AchievementManagerRequest achievementManagerRequest, HttpServletResponse response) {
		
    	BaseResultT<List<AchievementDto>> baseResult = null;

		try {
			
			baseResult = achievementManagerService.queryAchievementList(new Pagination(1, 9999),achievementManagerRequest);
			
			String title = DateUtil.getCurrentDateByFormat(DateUtil.YYMMDD)+"_vas_coupon_order_list";
			String[] headers = new String[]{"", "", "", "","","", "", "", "", "","", "", "", "",""};
			HSSFWorkbook workbook = getHssfWorkbook(baseResult.getResult(), title, headers);
			
			response.reset();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("octets/stream");
			response.addHeader("Content-Disposition", "attachment;filename=" + title + ".xls");
			response.setHeader("Connection", "close");
			//response.setContentLength(1024);
			response.setHeader("Content-Type", "application/vnd.ms-excel");
			
			OutputStream os = response.getOutputStream();

			workbook.write(os);
			workbook = null;
			os.close();
			os = null;
		} catch (Exception e) {
			log.error("导出业绩异常", e);
		}
		return null;
	}
	
	
    private HSSFWorkbook getHssfWorkbook(List<AchievementDto> results, String title, String[] headers) {
		
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth(15);
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

		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i<headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			cell.setCellValue(headers[i]);
		}
		for (int i = 0; i < results.size(); i++) {
			AchievementDto achievementDto = results.get(i);
			row = sheet.createRow(i + 1);
			/*row.createCell(0).setCellValue();
			row.createCell(1).setCellValue();
			row.createCell(2).setCellValue();
			row.createCell(3).setCellValue();
			row.createCell(4).setCellValue();
			row.createCell(5).setCellValue();
			row.createCell(6).setCellValue();
			row.createCell(7).setCellValue();
			row.createCell(8).setCellValue();
			row.createCell(9).setCellValue();
			row.createCell(10).setCellValue();
			row.createCell(11).setCellValue();
			row.createCell(12).setCellValue();
			row.createCell(13).setCellValue();
			row.createCell(14).setCellValue();*/
			
		}
		return workbook;
	}
	
}

