package test;

import java.util.ArrayList;

import util.ConstanceValue.MailListParam;

public class TestListImpl implements TestList {

    @Override
    public TestListResult testSameRequest(int testCase) {
	TestListResult testListResult = new TestListResult();
	ArrayList<ArrayList<MailList>> testCaseArray = new ArrayList<>();

	for (int i = 0; i < testCase; i++) {
	    testCaseArray.add(new MailListRequestImpl().requestAllList());
	}

	for (MailListParam param : MailListParam.values()) {
	    
	    for (int i = 0; i < testCase; i++) {
		if(param == MailListParam.MAIL_DATA) {
		    
		} else {
		    
		}
		
	    }

	}

	return testListResult;
    }

    @Override
    public TestListResult testValue(MailList mailList) {
	TestListResult testListResult = new TestListResult();
	
	
	
	return testListResult;
    }
    
   

}
