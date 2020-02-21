package controll; //�������̽�

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import party.Preview;

public interface partyCommandInter {
	
	String inseParty(HttpServletRequest request, HttpServletResponse response) throws Exception;
	String seleParty(HttpServletRequest request, HttpServletResponse response) throws Exception;
	String selelistParty(HttpServletRequest request, HttpServletResponse response) throws Exception;
	String selePartyre(HttpServletRequest request, HttpServletResponse response) throws Exception;
	String selelistPartyre(HttpServletRequest request, HttpServletResponse response) throws Exception;
    ArrayList<Preview> selelistPreview(HttpServletRequest request, HttpServletResponse response) throws Exception;
	boolean insePreview(HttpServletRequest request, HttpServletResponse response) throws Exception;
	String inseApply(HttpServletRequest request, HttpServletResponse response) throws Exception;
	boolean seleApply(HttpServletRequest request, HttpServletResponse response) throws Exception;
	String license(HttpServletRequest request, HttpServletResponse response) throws Exception;
	String search(HttpServletRequest request, HttpServletResponse response) throws Exception;
	String showData(HttpServletRequest request, HttpServletResponse response) throws Exception;
	}
	


