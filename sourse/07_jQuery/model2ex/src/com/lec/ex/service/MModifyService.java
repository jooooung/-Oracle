package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MModifyService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("mPhotoUp"); // 서버폴더
		int maxSize = 1024 * 1024; // 최대 업로드 용량 : 1M
		String mphoto = ""; // 첨부파일 이름이 저장될 변수
		int result = MemberDao.FAIL;
		try {
			// mRequest 객체 생성 (서버에 업로드된 파일저장) 후 파일 이름 받기
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "UTF-8",
					new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement(); // param이 "mphoto"
			mphoto = mRequest.getFilesystemName(param);
			// 파라미터 받아 DB에 수정 적용
			String dbMpw = mRequest.getParameter("dbMpw");
			String dbMphoto = mRequest.getParameter("dbMphoto");
			String mid = mRequest.getParameter("mid");
			String oldMpw = mRequest.getParameter("oldMpw");
			if (!oldMpw.equals(dbMpw)) {
				request.setAttribute("modifyErrorMsg", "비밀번호를 확인하세요");
				return;
			}
			String mpw = mRequest.getParameter("mpw");
			if (mpw.equals("")) { // 새비밀번호 미입력 시 현 비밀번호로
				mpw = dbMpw;
			}
			String mname = mRequest.getParameter("mname");
			String memail = mRequest.getParameter("memail");
			// 정보 수정시 사진 미첨부시 기존의 사진(dbMphoto)으로
			mphoto = mphoto == null ? dbMphoto : mphoto;
			String mbirthStr = mRequest.getParameter("mbirth");
			Date mbirth = null;
			if (!mbirthStr.equals("")) {
				mbirth = Date.valueOf(mbirthStr);
			}
			String maddress = mRequest.getParameter("maddress");
			// 회원 정보 수정
			MemberDao mDao = new MemberDao();
			MemberDto mDto = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
			result = mDao.modifyMember(mDto);
			if (result == MemberDao.SUCCESS) { // 수정성공 시 세션도 수정
				HttpSession session = request.getSession();
				session.setAttribute("member", mDto);
				request.setAttribute("modifyResult", "정보수정 성공");
			} else { // 수정 실패시
				request.setAttribute("modifyErrorMsg", "정보수정 실패");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// 서버에 업로드된 파일을 소스 폴더로 복사
		File serverFile = new File(path + "/" + mphoto);
		if (serverFile.exists() && !mphoto.equals("NOIMG.png") && result == MemberDao.SUCCESS) {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("C:/Full-stack/sourse/07_jQuery/model2ex/WebContent/mPhotoUp/" + mphoto);
				byte[] bs = new byte[(int) serverFile.length()];
				while (true) {
					int readByteCnt = is.read(bs);
					if (readByteCnt == -1)
						break;
					os.write(bs, 0, readByteCnt);
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (os != null)
						os.close();
					if (is != null)
						is.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			} // try-catch-finally
		} // if - serverFile
	}
}
