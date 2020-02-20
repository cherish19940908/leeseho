package controll; //db占쏙옙占쏙옙占쏙옙占쏙옙 처占쏙옙 -> 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙


import java.time.LocalDate;
import java.util.ArrayList;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.Action;
import model.Action_license;
import model.LicenseDTO;
import party.partyAction;
import vo.PageInfo_party;
import vo.ReviewBean;
import party.PartyDTO;
import party.ApplyDTO;
import party.Preview;

public class partyService implements partyCommandInter {
	static partyService impl = new partyService();

	public static partyService instance() {
		return impl;

	}
//================파티등록================================================
	@Override
	public String inseParty(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			System.out.println("1번 inseparty작동");
			
			PartyDTO PartyDTO = new PartyDTO();
			String realFolder = "";
			String saveFolder = "/party";
			int fileSize = 5 * 1024 * 1024;
			ServletContext context = request.getServletContext();
			realFolder = context.getRealPath(saveFolder);
			MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8",
					new DefaultFileRenamePolicy());
			
			PartyDTO.setTitle(multi.getParameter("title"));
			PartyDTO.setId(multi.getParameter("id1"));
			PartyDTO.setNick(multi.getParameter("nick1"));
			PartyDTO.setEmail(multi.getParameter("email"));
			PartyDTO.setPhone(multi.getParameter("phone"));
			PartyDTO.setCate(multi.getParameter("cate"));
			PartyDTO.setRname(multi.getParameter("rname"));
			PartyDTO.setRfile(multi.getOriginalFileName((String) multi.getFileNames().nextElement()));
			
			PartyDTO.setAddno(multi.getParameter("addno"));
			PartyDTO.setAddr(multi.getParameter("addr"));
			PartyDTO.setAddr1(multi.getParameter("addr1"));
			PartyDTO.setAddr2(multi.getParameter("addr2"));
			
			PartyDTO.setPdate(multi.getParameter("pdate"));
			PartyDTO.setPtime(multi.getParameter("hour")+"시"+multi.getParameter("minu")+"분");
			
			PartyDTO.setSins(LocalDate.of(Integer.parseInt("20"+multi.getParameter("pdate").substring(0, 2)), Integer.parseInt(multi.getParameter("pdate").substring(3, 4)), Integer.parseInt(multi.getParameter("pdate").substring(5, 6))).minusDays(11).toString());
			PartyDTO.setSinf(LocalDate.of(Integer.parseInt("20"+multi.getParameter("pdate").substring(0, 2)), Integer.parseInt(multi.getParameter("pdate").substring(3, 4)), Integer.parseInt(multi.getParameter("pdate").substring(5, 6))).minusDays(1).toString());
			
			
			PartyDTO.setPno(multi.getParameter("pno"));
			PartyDTO.setPreprice(multi.getParameter("preprice"));
			PartyDTO.setPtalk(multi.getParameter("ptalk"));
			partyAction model = partyAction.instance();
			
			model.insertParty(PartyDTO);

		} catch (Exception e) {
			System.out.println(e);
		}

		return "party.jsp";
	}
	
	@Override
	public String selelistParty(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{partyAction model = partyAction.instance();
		
	    ArrayList<PartyDTO> list = (ArrayList<PartyDTO>) model.selectlistParty(request.getParameter("cate"));
		if(list.size()!=0) {request.setAttribute("list", list);
		return "partycate.jsp";}
		else {
			return "noparty.jsp";
		}
		}
		catch(Exception e) {
			System.out.println(e);
			return "noparty.jsp";
		}
		
	}
	
	@Override
	public String seleParty(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{partyAction model = partyAction.instance();
		
	    ArrayList<PartyDTO> sic = (ArrayList<PartyDTO>) model.selectParty(Integer.parseInt(request.getParameter("pnum")));
		if(sic.size()!=0) {request.setAttribute("sic", sic);
		return "party_info.jsp";}
		else {
			return "noparty.jsp";
		}}
		catch(Exception e) {
			System.out.println(e);
			return "noparty.jsp";
		}
	}
	
	@Override
	public String selelistPartyre(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{partyAction model = partyAction.instance();
		
	    ArrayList<PartyDTO> list = (ArrayList<PartyDTO>) model.selectlistPartyre(request.getParameter("cate"));
		if(list.size()!=0) {request.setAttribute("list", list);
		return "partycatere.jsp";}
		else {
			return "noparty.jsp";
		}
		}
		catch(Exception e) {
			System.out.println(e);
			return "noparty.jsp";
		}
		
	}
	
	@Override
	public String selePartyre(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{partyAction model = partyAction.instance();
	    ArrayList<PartyDTO> sic = (ArrayList<PartyDTO>) model.selectPartyre(Integer.parseInt(request.getParameter("pnum")));
		if(sic.size()!=0) {request.setAttribute("sic", sic);
		return "party_infore.jsp";}
		else {
			return "noparty.jsp";
		}}
		catch(Exception e) {
			System.out.println(e);
			return "noparty.jsp";
		}
	}
	
	@Override
	public boolean insePreview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Preview Preview = new Preview();
            Preview.setPnum(Integer.parseInt(request.getParameter("pnum")));
            Preview.setId(request.getParameter("id"));
            Preview.setNick(request.getParameter("nick"));
            Preview.setRcontent(request.getParameter("rcontent"));
            
            
            System.out.println(request.getParameter("pnum"));
            System.out.println(request.getParameter("id"));
            System.out.println(request.getParameter("nick"));
            System.out.println(request.getParameter("rcontent"));
            
			partyAction model = partyAction.instance();
			model.insertPreview(Preview);

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	@Override
	public ArrayList<Preview> selelistPreview(HttpServletRequest request, HttpServletResponse response){
		try{partyAction model = partyAction.instance();
	    ArrayList<Preview> list = (ArrayList<Preview>) model.selectlistPreview(Integer.parseInt(request.getParameter("pnum")));
	    if(list != null) {
	    return list;
	    }
	    else {
	    	return null;
	    }
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@Override
	public String inseApply(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			ApplyDTO ApplyDTO = new ApplyDTO();
			ApplyDTO.setPnum(Integer.parseInt(request.getParameter("pnum")));
			ApplyDTO.setId(request.getParameter("id"));
			partyAction model = partyAction.instance();
			model.insertApply(ApplyDTO);
			

		} catch (Exception e) {
			System.out.println(e);
		}

		return "apply_success.jsp";
	}
	
	@Override
	public boolean seleApply(HttpServletRequest request, HttpServletResponse response){
		try{
			ApplyDTO adto = new ApplyDTO();
			adto.setPnum(Integer.parseInt(request.getParameter("pnum")));
			adto.setId(request.getParameter("id"));
			partyAction model = partyAction.instance();
	        boolean tf = model.selectApply(adto);
	    if(tf) {
	    return true;
	    }
	    else {
	    	return false;
	    }
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
	}

	@Override
	public String license(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("2");
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("license"));
		request.setCharacterEncoding("utf-8");		
		Action_license model = Action_license.instance();
		LicenseDTO dto=new LicenseDTO();	
		dto.setId(request.getParameter("id"));
		dto.setLicense(request.getParameter("license"));
		
		model.insert(dto);
		
		
		return "gpindex.jsp";
	}

	@Override
	public String search(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("locasearch_start");
		String local = request.getParameter("local");
		System.out.println(local);
		int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("page")==null){
			page=1;
		}
		
		Action model = Action.instance();
		Integer listCount = model.boardListcount();
		ArrayList<ReviewBean> list = (ArrayList<ReviewBean>)model.locasearch(local);
		int maxPage=(int)((double)listCount/limit+0.95); //0.95占쏙옙 占쏙옙占쌔쇽옙 占시몌옙 처占쏙옙.
   		//占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙(1, 11, 21 占쏙옙...)
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙.(10, 20, 30 占쏙옙...)
   	        int endPage = startPage+10-1;

   		if (endPage> maxPage) endPage= maxPage;

   		PageInfo_party pageInfo = new PageInfo_party();
   		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);	
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("searchList", list);
		System.out.println("bb"+list.size());
		return "board1.jsp";
	}

}
