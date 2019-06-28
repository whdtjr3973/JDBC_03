package com.biz.jdbc.exec;

import java.util.Scanner;

import com.biz.jdbc.model.ScoreVO;
import com.biz.jdbc.service.ScoreService;
import com.biz.jdbc.service.ScoreServiceImp_01;

public class ScoreExec_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ScoreService ss = new ScoreServiceImp_01();
		
		
		while(true) {
			
			ScoreVO vo = new ScoreVO();
			
//		System.out.print("SEQ입력 >>");
//		String strSeq = scan.nextLine();
//		long lSeq = Long.valueOf(strSeq);
//		vo.setSc_seq(lSeq);
			
		System.out.print("날짜입력 >>");
		String strDate = scan.nextLine();
		vo.setSc_date(strDate);
		
		System.out.print("학번입력 >>");
		String strNum = scan.nextLine();
		vo.setSc_st_no(strNum);
		
		System.out.print("과목입력 >>");
		String strSub = scan.nextLine();
		vo.setSc_subject(strSub);
		
		System.out.print("점수입력 >>");
		String strScore = scan.nextLine();
		int intScore = Integer.valueOf(strScore);
		vo.setSc_score(intScore);
		
		if(ss.insert(vo) > 0) System.out.println("추가성공");
		else System.out.println("추가 실패");
			
		}

	}

}
