package com.biz.jdbc.exec;

import java.util.Scanner;

import com.biz.jdbc.model.ScoreVO;
import com.biz.jdbc.model.StudentVO;
import com.biz.jdbc.service.ScoreService;
import com.biz.jdbc.service.ScoreServiceImp_01;
import com.biz.jdbc.service.StdService;
import com.biz.jdbc.service.StdServiceImp_01;

public class ScoreExec_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		ScoreService ss = new ScoreServiceImp_01();
		StdService sts = new StdServiceImp_01();
		

		while(true) {
			System.out.print("학번 (종료: -E)>>");
			String strNo = scan.nextLine();
			if(strNo.contentEquals("-E")) break;
			
			StudentVO vo = sts.findByNum(strNo);
			ScoreVO vo2 = new ScoreVO();
			
			if(vo == null) {
				vo = new StudentVO();
				System.out.println("해당 학생의 정보가 없습니다. 새로 등록하세요.");
				System.out.println("---------------------------------------------");
				System.out.print("학번 >>");
				strNo = scan.nextLine();
				vo.setSt_no(strNo);
				
				System.out.print("이름 >>");
				String strName = scan.nextLine();
				vo.setSt_name(strName);
				
				System.out.print("학년 >>");
				String strGrade = scan.nextLine();
				int intGrade = Integer.valueOf(strGrade);
				vo.setSt_grade(intGrade);
				
				System.out.print("학과 >>");
				String strDept = scan.nextLine();
				vo.setSt_dept_name(strDept);
				
				if(sts.insert(vo) > 0) {
					System.out.println("학생정보를 새로 추가했습니다.");
					System.out.println();
					
					
					ss.makeScore(vo2, strNo);
					ss.insert(vo2);
					
					System.out.println("성적처리가 완료되었습니다.");
					System.out.println("============================");
								
					
				}
				else System.out.println("학생정보를 추가하지 못했습니다.");
				
				
			}
		}
		
	}

}
