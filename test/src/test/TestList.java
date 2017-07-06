package test;

public interface TestList {
    TestListResult testSameRequest(int testCase);
    
    TestListResult testValue(MailList mailList);
}
