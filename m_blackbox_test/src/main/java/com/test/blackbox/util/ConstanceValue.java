package com.test.blackbox.util;

public class ConstanceValue {
  public static enum MailResponseParam {
    MESSAGE("message"), RESULT("result"), CURRENT_TIMe("currentTime"), FOLDER_NAME(
        "folderName"), LAST_OFFSET("lastOffset"), LAST_PAGE("lastPage"), LIST_COUNT(
            "listCount"), MAIL_DATA("mailData"), PAGE_SIZE(
                "pageSize"), TOTAL_COUNT("totalCount"), UNREAD_COUNT("unreadCount");

    public String param;

    MailResponseParam(String param) {
      this.param = param;
    }
  }

  public static enum MailDataParam {
    ATTACH_COUNT("attachCount"), ATTACH_INFO("attachInfo"), BCC_LIST("bccList"), BIG_FILE(
        "bigFile"), COLOR("color"), FIRST_LOCATION_TIME("firstLocationTime"), FOLDER_NAME(
            "folderName"), FOLDER_SN("folerSN"), FROM("from"), I_DOMAIN_EMAIL(
                "iDomailEmail"), ICON_TYPE("iconType"), IS_DOMAIN_MAIL("isDomainMail"), MAIL_SN(
                    "mailSN"), MIME_SN("miemeSN"), PREVIEW("preview"), PRIORITY(
                        "priority"), RE_SEND("reSend"), RECEIVE_TIME("receiveTime"), REMIND_AT(
                            "remindAt"), SECURITY_LEVEL("securityLevel"), SEND_TIME(
                                "sendTime"), SIZE("size"), SPAM_TYPE("spamType"), STATUS(
                                    "status"), STATUS_HEX("statusHex"), SUBJECT(
                                        "subject"), THREAD_COUNT(
                                            "threadCount"), THREAD_ID("threadId"), THREAD_REMIND_AT(
                                                "threadRemindAt"), THREAD_REMIND_FLAG(
                                                    "threadRemindFlag"), TO_LIST("toList"), TO_ME(
                                                        "toMe"), UNREAD_THREAD_COUNT(
                                                            "unreadThreadCount"), RECEIVE_BY_BBC(
                                                                "receiveByBcc");

    public String param;

    MailDataParam(String param) {
      this.param = param;
    }
  }

  public static enum APIs {
    LIST("/json/list");

    public String api;

    APIs(String api) {
      this.api = api;
    }
  }

  public static enum FromAndToListParam {
    EMAIL("email"), NAME("name");

    public String param;

    FromAndToListParam(String param) {
      this.param = param;
    }
  }

}
