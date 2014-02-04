package com.prayaasjain.futurebound;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import jxl.*;
import jxl.write.*;
import jxl.write.Number;

import java.util.ArrayList;
import java.util.HashMap;


public class exploreScript {

	  public static void main(String argv[]) {
		  
		    try {
		    	
		    	WritableWorkbook workbook = Workbook.createWorkbook(new File("futureboundData.xls"));
		    	File dir = new File("/Users/prayaasjain/Desktop/FutureBound");
    			WritableSheet sheet = workbook.createSheet("Foshay",0);
    			WritableCellFormat sansserif10 = new WritableCellFormat();
    			Label L1 = new Label(1,0, "Student Name", sansserif10);
		    	Label L2 = new Label(3,0, "Session Start Time", sansserif10);
		    	Label L3 = new Label(4,0, "Game Start Time", sansserif10);
		    	Label L4 = new Label(5,0, "Session/Game End Time", sansserif10);
		    	Label L5 = new Label(6,0, "Duration of Play", sansserif10);
		    	Label L6 = new Label(7,0, "Load Game Time", sansserif10);
		    	Label L7 = new Label(8,0, "Load Game Scene", sansserif10);
		    	Label L8 = new Label(9,0, "Grade 7 Duration", sansserif10);
		    	Label L9 = new Label(10,0, "Grade 8 Duration", sansserif10);
		    	Label L10 = new Label(11,0, "Grade 9 Duration", sansserif10);
		    	Label L11 = new Label(12,0, "Total Doubts Encountered", sansserif10);
		    	Label L12 = new Label(13,0, "Total Conversations", sansserif10);
		    	Label L13 = new Label(14,0, "Total Powers Unlocked", sansserif10);
		    	
		    	ArrayList<String> powers = new ArrayList<String>();
		    	HashMap<String, Integer> powerMap = new HashMap<String, Integer>();
		    	int powerCounter = 15;
    			int i = 2;
		    	
		    	powers.add("Goaaaaal!"); // - Soccer Player
		    	powers.add("Angry Moon"); // - Astronomer
		    	powers.add("Air Guitar"); // - Rock Star
		    	powers.add("Mach Speed"); // - Pilot
		    	powers.add("Green Energy"); // - Energy Researcher
		    	powers.add("Objection!"); // - Defense Attorney 
		    	powers.add("Spotlight"); // - Actor
		    	powers.add("Robot Security"); // - Robotocist 
		    	powers.add("Reverse Psychology"); // - Therapist
		    	powers.add("Killer Outfit"); // - Fashion Designer
		    	powers.add("Veto"); // - Governor
		    	powers.add("Mummy Friend"); // - Archaeologist 
		    	powers.add("Pow Kazam!"); // - Comic Book Artist
		    	powers.add("Ocean Swarm"); // - Marine Biologist
		    	powers.add("Wrecking Ball"); // - Civil Engineer 
		    	powers.add("News Flash"); // - Reporter
		    	powers.add("Dance Party"); // - Dancer
		    	powers.add("Sweet Heart"); // - Cardiologist 
		    	powers.add("Teamwork"); // - CEO
		    	powers.add("Crime Tape"); // - FBI Agent
		    	
		    	for(int j=0; j<powers.size(); j++) {
		    		
		    		Label powerName = new Label(powerCounter,0, powers.get(j), sansserif10);
	    			sheet.addCell(powerName);
	    			Label powerUnlckd = new Label(powerCounter+0,1, "Power Unlocked", sansserif10);
	    			Label powerUsed = new Label(powerCounter+1,1, "Times Power Used", sansserif10);
	    			Label powerLvldUp = new Label(powerCounter+2,1, "Times Power Leveled Up", sansserif10);
	    			sheet.addCell(powerUnlckd);
	   				sheet.addCell(powerUsed);
	   				sheet.addCell(powerLvldUp);
	    			powerMap.put(powers.get(j), powerCounter);
	    			powerCounter += 3;
		    	}
		    	
		    	sheet.addCell(L1);
		    	sheet.addCell(L2);
		    	sheet.addCell(L3);
		    	sheet.addCell(L4);
		    	sheet.addCell(L5);
		    	sheet.addCell(L6);
		    	sheet.addCell(L7);
		    	sheet.addCell(L8);
		    	sheet.addCell(L9);
		    	sheet.addCell(L10);
		    	sheet.addCell(L11);
		    	sheet.addCell(L12);
		    	sheet.addCell(L13);
		    	
    			
		    	for(File file: dir.listFiles()) {
		    		if(file.getName().endsWith(".xml")) {
		    			
				    	//Student Details
		    			System.out.println("File Name: " + file.getName());
				    	Label l1 = new Label(1,i, file.getName(), sansserif10);
		    			sheet.addCell(l1);
				    	
				    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				    	Document doc = dBuilder.parse(file);
				    	doc.getDocumentElement().normalize();
				    	
				    	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				    	
				    	//Session start time
				    	NodeList nL1 = doc.getElementsByTagName("StartSession");
				    	Node n1 = nL1.item(0);
				    	Element child1 = (Element) n1;
				    	Number num1 = new Number(3,i, Integer.parseInt(child1.getAttribute("time")), sansserif10);
				    	sheet.addCell(num1);

				    	System.out.println("Current Element: "+ n1.getNodeName());
//				    	System.out.println("Device : " + child1.getAttribute("device"));
//				    	System.out.println("Session Start Time : " + child1.getAttribute("time"));
				    	
				    	//New game start time
				    	NodeList nL2 = doc.getElementsByTagName("NewGame");
				    	Node n2 = nL2.item(0);
				    	Element child2 = (Element) n2;
				    	Number num2 = new Number(4,i, Integer.parseInt(child2.getAttribute("time")), sansserif10);
		    			sheet.addCell(num2);

				    	System.out.println("Current Element: "+ n2.getNodeName());
//				    	System.out.println("Game Start Time : " + child2.getAttribute("time"));
				    	
				    	//Application quit time
				    	NodeList nL3 = doc.getElementsByTagName("ApplicationQuit");
				    	Node n3 = nL3.item(0);
				    	Element child3 = (Element) n3;
				    	Number num3 = new Number(5,i, Integer.parseInt(child3.getAttribute("time")), sansserif10);
		    			sheet.addCell(num3);

		    			//Load game time & scene
				    	NodeList nL4 = doc.getElementsByTagName("LoadGame");
			    		Node n4 = nL4.item(0);
			    		Element child4 = null;
				    	if(n4 != null) {
				    		child4 = (Element) n4;
				    		Number num5 = new Number(7,i, Integer.parseInt(child4.getAttribute("time")), sansserif10);
				    		Label l2 = new Label(8,i, child4.getAttribute("scene"), sansserif10);
				    		sheet.addCell(num5);
				    		sheet.addCell(l2);
				    	}
				    	
				    	//Duration of play - calculated as NewGame - ApplicationQuit
				    	Integer playdur = 0;
				    	
				    	if(n4 != null) {
				    		playdur = Integer.parseInt(child3.getAttribute("time")) - Integer.parseInt(child4.getAttribute("time"));
				    	}
				    	if(n4 == null && n2 != null) {
				    		playdur = Integer.parseInt(child3.getAttribute("time")) - Integer.parseInt(child2.getAttribute("time"));
				    	}
				    	
				    	Number num4 = new Number(6,i, playdur, sansserif10);
		    			sheet.addCell(num4);

				    	
				    	
				    	//Grade completion
				    	NodeList nL5 = doc.getElementsByTagName("CompleteGrade");
				    	
				    	for(int j=0; j<=nL5.getLength(); j++) {
				    		Node n5 = nL5.item(j);
				    		
				    		if(n5 != null) {
				    			Element child5 = (Element) n5;
				    			System.out.println(child5.getAttribute("gradeName"));
				    			Integer leveldur = 0;
				    			
				    			if(n4 != null) {
					    			leveldur = Integer.parseInt(child5.getAttribute("time")) - Integer.parseInt(child4.getAttribute("time"));	
				    			}
				    			else {
					    			leveldur = Integer.parseInt(child5.getAttribute("time")) - Integer.parseInt(child2.getAttribute("time"));	
				    			}
				    			Number num6 = null;
				    			if(child5.getAttribute("gradeName").equals("Grade7")) {
				    				num6 = new Number(9,i, leveldur, sansserif10);
				    			}
				    			if(child5.getAttribute("gradeName").equals("Grade8")) {
				    				num6 = new Number(10,i, leveldur, sansserif10);
				    			}
				    			if(child5.getAttribute("gradeName").equals("Grade9")) {
				    				num6 = new Number(11,i, leveldur, sansserif10);
				    			}
				    			sheet.addCell(num6);
				    		}
				    		
				    	}
				    	
				    	//Doubts Stunned/Encountered in BattleMode
				    	NodeList nL7 = doc.getElementsByTagName("DoubtStunned");
				    	Integer doubtsStunnedInBattle = 0;
				    	Integer doubtsStunnedInNonBattle = 0;
				    	
				    	for(int j=0; j<nL7.getLength(); j++) {
				    		Node n7 = nL7.item(j);
				    		Element child7 = (Element) n7;
				    		if(child7.getAttribute("battleMode").equals("True")) {
				    			++doubtsStunnedInBattle;
				    		}
				    		else {
				    			++doubtsStunnedInNonBattle;
				    		}
				    	}
				    	
				    	Number num8 = new Number(12,i, doubtsStunnedInBattle, sansserif10);
				    	sheet.addCell(num8);
				    	
				    	//Conversations
				    	NodeList nL8 = doc.getElementsByTagName("StartConversation");
				    	Integer convosHad = nL8.getLength();
				    	Number num9 = new Number(13,i, convosHad, sansserif10);
				    	sheet.addCell(num9);
				    	
				    	//Powers & Power related attributes - Unlocked/Used/Leveled-up
				    	
				    	//Powers Unlocked
				    	NodeList nL6 = doc.getElementsByTagName("PowerUnlocked");
				    	Integer powersunlckd = nL6.getLength();
				    	Number num7 = new Number(14,i, powersunlckd, sansserif10);
				    	sheet.addCell(num7);
				    	
				    	for(int j=0; j<nL6.getLength(); j++) {
				    		Node n6 = nL6.item(j);
				    		Element child6 = (Element) n6;
				    		if(powerMap.containsKey(child6.getAttribute("powerName"))) {
				    			Integer unlockedIndex = powerMap.get(child6.getAttribute("powerName"));
				    			Number unlocked = new Number(unlockedIndex,i, 1, sansserif10);
				    			sheet.addCell(unlocked);
				    		}
				    		else {
				    			System.out.println("Power Doesn't Exist in Map: "+child6.getAttribute("powerName"));
				    		}
				    		
				    	}
				    	
				    	//Powers Used
				    	NodeList nL9 = doc.getElementsByTagName("PowerUsed");
				    	for(String pname : powers) {
				    		Integer powerUsedCount = 0;
				    		for(int j=0; j<nL9.getLength(); j++) {
					    		Node n9 = nL9.item(j);
					    		Element child9 = (Element) n9;
					    		if(child9.getAttribute("powerName").equals(pname)) {
					    			++powerUsedCount;
					    		}
					    	}
				    		int powerUsedIndex = powerMap.get(pname);
				    		Number powerUsed = new Number(powerUsedIndex+1,i, powerUsedCount, sansserif10);
				    		sheet.addCell(powerUsed);
				    	}
				    	
				    	

				    	//Powers LeveledUp
				    	NodeList nL10 = doc.getElementsByTagName("PowerLeveledUp");
				    	for(String pname : powers) {
				    		Integer powerLvldUpCount = 0;
				    		for(int j=0; j<nL10.getLength(); j++) {
					    		Node n10 = nL10.item(j);
					    		Element child10 = (Element) n10;
					    		if(child10.getAttribute("powerName").equals(pname)) {
					    			++powerLvldUpCount;
					    		}
					    	}
				    		int powerLvlIndex = powerMap.get(pname);
				    		Number powerLvldUp = new Number(powerLvlIndex+2,i, powerLvldUpCount, sansserif10);
				    		sheet.addCell(powerLvldUp);
				    	}
    	
		    			i++;
		    			
		    		}	
		    	}
		    	workbook.write();
	    		workbook.close();

		    	
		    }catch (Exception e) {
		    	e.printStackTrace();
		    }

	  }
}
