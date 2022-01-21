package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;


@Repository
public class GuestbookDao {

	// 필드
	@Autowired
	private SqlSession sqlSession;

	// 전체 리스트 가져오기
	public List<GuestbookVo> getList() {
		System.out.println("GuestbookDao > getList()");
		List<GuestbookVo> guestbookList = sqlSession.selectList("guestbook.selectList");
		System.out.println(guestbookList);
		return guestbookList;
	}

	public int guestbookInsert(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao > guestbookInsert()");
		return sqlSession.insert("guestbook.insert", guestbookVo);
	}

	public int guestbookDelete(int num, String password) {
		System.out.println("GuestbookDao > guestbookInsert()");
		GuestbookVo guestbookVo = new GuestbookVo();
		guestbookVo.setNo(num);
		guestbookVo.setPassword(password);
		return sqlSession.delete("guestbook.delete", guestbookVo);
	}
}
