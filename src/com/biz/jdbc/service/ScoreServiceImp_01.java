package com.biz.jdbc.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.jdbc.config.DBConnection;
import com.biz.jdbc.model.ScoreVO;

public class ScoreServiceImp_01 implements ScoreService {
	Scanner scan = new Scanner(System.in);
	List<ScoreVO> scList = null;
	@Override
	public List<ScoreVO> selectAll() {
		// TODO Auto-generated method stub
		scList = new ArrayList<ScoreVO>();
		return null;
	}

	@Override
	public ScoreVO findBySeq(Long seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScoreVO> findByStNum(String stNum) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_score ( ";
			sql += " WHERE sc_st_no = ? ";
			
			try {
				PreparedStatement ps = null;
				ps = DBConnection.dbConn.prepareStatement(sql);
				ps.setString(3, stNum);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					ScoreVO vo = new ScoreVO(
							rs.getLong( " SC_SEQ "),
							rs.getString( " SC_DATE "),
							rs.getString( " SC_ST_NO "),
							rs.getString( " SC_SUBJECT "),
							rs.getInt( " SC_SCORE ")
							);
										
						scList.add(vo);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return null;
	}

	@Override
	public int insert(ScoreVO vo) {
		// TODO 
		String sql = " INSERT INTO tbl_score ( ";
			sql += " SC_SEQ ," ;
			sql += " SC_DATE ," ;
			sql += " SC_ST_NO ," ;
			sql += " SC_SUBJECT, " ;
			sql += " SC_SCORE ) " ;
			sql += " VALUES ( seq_score.nextval, ?, ?, ?, ? )" ;
			
			PreparedStatement ps = null;
				try {
					ps = DBConnection.dbConn.prepareStatement(sql);
					
//					ps.setLong(1, vo.getSc_seq());
					ps.setString(1, vo.getSc_date());
					ps.setString(2, vo.getSc_st_no());
					ps.setString(3, vo.getSc_subject());
					ps.setInt(4, vo.getSc_score());
					
					return ps.executeUpdate();
				} catch (SQLException e) {
							// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		return 0;
	}

	@Override
	public int update(ScoreVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long seq) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void makeScore(ScoreVO vo2, String strNum) {
		System.out.println("성적을 입력하세요");
		System.out.println("---------------------");
		
		System.out.print("날짜 >>");
		String strDate = scan.nextLine();
		vo2.setSc_date(strDate);
		
		System.out.print("학번 >>");
		strNum = scan.nextLine();
		vo2.setSc_st_no(strNum);
		
		System.out.print("과목 >>");
		String strSub = scan.nextLine();
		vo2.setSc_subject(strSub);
		
		System.out.print("성적 >>");
		String strScore = scan.nextLine();
		int intScore = Integer.valueOf(strScore);
		vo2.setSc_score(intScore);
		
		
	}

}
