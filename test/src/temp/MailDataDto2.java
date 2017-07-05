package temp;
//package test;
//
//import javax.annotation.Generated;
//
//import org.json.simple.JSONObject;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@Generated("org.jsonschema2pojo")
//@JsonPropertyOrder({
//	 "attachCount",
//	 "attachInfo",
//	 "bccList",
//	 "bigFile",
//	 "color",
//	 "firstLocatedTim",
//	 "folderName",
//	 "folderSN",
//	 "from",
//	 "iDomainEmail",
//	 "iconType",
//	 "isDomainMail",
//	 "mailSN",
//	 "mimeSN",
//	 "preview",
//	 "priority",
//	 "reSend",
//	 "receiveByBcc",
//	 "receivedTime",
//	 "remindAt",
//	 "securityLevel",
//	 "sentTime",
//	 "size",
//	 "spamType",
//	 "status",
//	 "statusHex",
//	 "subject",
//	 "threadCount",
//	 "threadId",
//	 "threadRemindAt",
//	 "threadRemindFlag",
//	 "toList",
//	 "email",
//	 "name",
//	 "toMe",
//	 "unreadThreadCount",
//})
//public class MailDataDto2 {
//	@JsonProperty("attachCount")
//	private String attachCount;
//	@JsonProperty("attachInfo")
//	private String attachInfo;
//	@JsonProperty("bccList")
//	private String bccList;
//	@JsonProperty("bigFile")
//	private String bigFile;
//	@JsonProperty("color")
//	private String color;
//	@JsonProperty("firstLocatedTim")
//	private String firstLocatedTim;
//	private String folderName;
//	private String folderSN;
//	private String from;
//	private String iDomainEmail;
//	private String iconType;
//	private String isDomainMail;
//	private String mailSN;
//	private String mimeSN;
//	private String preview;
//	private String priority;
//	private String reSend;
//	private String receiveByBcc;
//	private String receivedTime;
//	private String remindAt;
//	private String securityLevel;
//	private String sentTime;
//	private String size;
//	private String spamType;
//	private String status;
//	private String statusHex;
//	private String subject;
//	private String threadCount;
//	private String threadId;
//	private String threadRemindAt;
//	private String threadRemindFlag;
//	private String toList;
//	private String email;
//	private String name;
//	private String toMe;
//	private String unreadThreadCount;
//
//	public String getAttachCount() {
//		return attachCount;
//	}
//
//	public void setAttachCount(String attachCount) {
//		this.attachCount = attachCount;
//	}
//
//	public String getAttachInfo() {
//		return attachInfo;
//	}
//
//	public void setAttachInfo(String attachInfo) {
//		this.attachInfo = attachInfo;
//	}
//
//	public String getBccList() {
//		return bccList;
//	}
//
//	public void setBccList(String bccList) {
//		this.bccList = bccList;
//	}
//
//	public String getBigFile() {
//		return bigFile;
//	}
//
//	public void setBigFile(String bigFile) {
//		this.bigFile = bigFile;
//	}
//
//	public String getColor() {
//		return color;
//	}
//
//	public void setColor(String color) {
//		this.color = color;
//	}
//
//	public String getFirstLocatedTim() {
//		return firstLocatedTim;
//	}
//
//	public void setFirstLocatedTim(String firstLocatedTim) {
//		this.firstLocatedTim = firstLocatedTim;
//	}
//
//	public String getFolderName() {
//		return folderName;
//	}
//
//	public void setFolderName(String folderName) {
//		this.folderName = folderName;
//	}
//
//	public String getFolderSN() {
//		return folderSN;
//	}
//
//	public void setFolderSN(String folderSN) {
//		this.folderSN = folderSN;
//	}
//
//	public String getFrom() {
//		return from;
//	}
//
//	public void setFrom(String from) {
//		this.from = from;
//	}
//
//	public String getiDomainEmail() {
//		return iDomainEmail;
//	}
//
//	public void setiDomainEmail(String iDomainEmail) {
//		this.iDomainEmail = iDomainEmail;
//	}
//
//	public String getIconType() {
//		return iconType;
//	}
//
//	public void setIconType(String iconType) {
//		this.iconType = iconType;
//	}
//
//	public String getIsDomainMail() {
//		return isDomainMail;
//	}
//
//	public void setIsDomainMail(String isDomainMail) {
//		this.isDomainMail = isDomainMail;
//	}
//
//	public String getMailSN() {
//		return mailSN;
//	}
//
//	public void setMailSN(String mailSN) {
//		this.mailSN = mailSN;
//	}
//
//	public String getMimeSN() {
//		return mimeSN;
//	}
//
//	public void setMimeSN(String mimeSN) {
//		this.mimeSN = mimeSN;
//	}
//
//	public String getPreview() {
//		return preview;
//	}
//
//	public void setPreview(String preview) {
//		this.preview = preview;
//	}
//
//	public String getPriority() {
//		return priority;
//	}
//
//	public void setPriority(String priority) {
//		this.priority = priority;
//	}
//
//	public String getReSend() {
//		return reSend;
//	}
//
//	public void setReSend(String reSend) {
//		this.reSend = reSend;
//	}
//
//	public String getReceiveByBcc() {
//		return receiveByBcc;
//	}
//
//	public void setReceiveByBcc(String receiveByBcc) {
//		this.receiveByBcc = receiveByBcc;
//	}
//
//	public String getReceivedTime() {
//		return receivedTime;
//	}
//
//	public void setReceivedTime(String receivedTime) {
//		this.receivedTime = receivedTime;
//	}
//
//	public String getRemindAt() {
//		return remindAt;
//	}
//
//	public void setRemindAt(String remindAt) {
//		this.remindAt = remindAt;
//	}
//
//	public String getSecurityLevel() {
//		return securityLevel;
//	}
//
//	public void setSecurityLevel(String securityLevel) {
//		this.securityLevel = securityLevel;
//	}
//
//	public String getSentTime() {
//		return sentTime;
//	}
//
//	public void setSentTime(String sentTime) {
//		this.sentTime = sentTime;
//	}
//
//	public String getSize() {
//		return size;
//	}
//
//	public void setSize(String size) {
//		this.size = size;
//	}
//
//	public String getSpamType() {
//		return spamType;
//	}
//
//	public void setSpamType(String spamType) {
//		this.spamType = spamType;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public String getStatusHex() {
//		return statusHex;
//	}
//
//	public void setStatusHex(String statusHex) {
//		this.statusHex = statusHex;
//	}
//
//	public String getSubject() {
//		return subject;
//	}
//
//	public void setSubject(String subject) {
//		this.subject = subject;
//	}
//
//	public String getThreadCount() {
//		return threadCount;
//	}
//
//	public void setThreadCount(String threadCount) {
//		this.threadCount = threadCount;
//	}
//
//	public String getThreadId() {
//		return threadId;
//	}
//
//	public void setThreadId(String threadId) {
//		this.threadId = threadId;
//	}
//
//	public String getThreadRemindAt() {
//		return threadRemindAt;
//	}
//
//	public void setThreadRemindAt(String threadRemindAt) {
//		this.threadRemindAt = threadRemindAt;
//	}
//
//	public String getThreadRemindFlag() {
//		return threadRemindFlag;
//	}
//
//	public void setThreadRemindFlag(String threadRemindFlag) {
//		this.threadRemindFlag = threadRemindFlag;
//	}
//
//	public String getToList() {
//		return toList;
//	}
//
//	public void setToList(String toList) {
//		this.toList = toList;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getToMe() {
//		return toMe;
//	}
//
//	public void setToMe(String toMe) {
//		this.toMe = toMe;
//	}
//
//	public String getUnreadThreadCount() {
//		return unreadThreadCount;
//	}
//
//	public void setUnreadThreadCount(String unreadThreadCount) {
//		this.unreadThreadCount = unreadThreadCount;
//	}
//	
//	public void setField(JSONObject field) {
//		 attachCount = (String)field.get(TestClass.MailDataParam.ATTACH_COUNT);
//		 attachInfo = (String)field.get(TestClass.MailDataParam.ATTACH_INFO);
////		 bccList;
////		 bigFile;
////		 color;
////		 firstLocatedTim;
////		 folderName;
////		 folderSN;
////		 from;
////		 iDomainEmail;
////		 iconType;
////		 isDomainMail;
////		 mailSN;
////		 mimeSN;
////		 preview;
////		 priority;
////		 reSend;
////		 receiveByBcc;
////		 receivedTime;
////		 remindAt;
////		 securityLevel;
////		 sentTime;
////		 size;
////		 spamType;
////		 status;
////		 statusHex;
////		 subject;
////		 threadCount;
////		 threadId;
////		 threadRemindAt;
////		 threadRemindFlag;
////		 toList;
////		 email;
////		 name;
////		 toMe;
////		 unreadThreadCount;
//	}
//
//}
