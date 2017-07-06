package temp_0706;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParser;

import util.ConstanceValue;
import util.ConstanceValue.MailDataParam;

public class MailDataDto{
    private String attachCount;
    private String attachInfo;
    private String bccList;
    private String bigFile;
    private String color;
    private String firstLocatedTim;
    private String folderName;
    private String folderSN;
    private String from;
    private String iDomainEmail;
    private String iconType;
    private String isDomainMail;
    private String mailSN;
    private String mimeSN;
    private String preview;
    private String priority;
    private String reSend;
    private String receiveByBcc;
    private String receivedTime;
    private String remindAt;
    private String securityLevel;
    private String size;
    private String spamType;
    private String status;
    private String statusHex;
    private String subject;
    private String threadCount;
    private String threadId;
    private String threadRemindAt;
    private String threadRemindFlag;
    private String toList;
    private String email;
    private String name;
    private String toMe;
    private String unreadThreadCount;
    private String sendTime;

    private FromToListDto fromDto;
    private ArrayList<FromToListDto> toArrayList;
    
    

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public MailDataDto() {
	toArrayList = new ArrayList<>();
    }

    public String getAttachCount() {
	return attachCount;
    }

    public void setAttachCount(String attachCount) {
	this.attachCount = attachCount;
    }

    public String getAttachInfo() {
	return attachInfo;
    }

    public void setAttachInfo(String attachInfo) {
	this.attachInfo = attachInfo;
    }

    public String getBccList() {
	return bccList;
    }

    public void setBccList(String bccList) {
	this.bccList = bccList;
    }

    public String getBigFile() {
	return bigFile;
    }

    public void setBigFile(String bigFile) {
	this.bigFile = bigFile;
    }

    public String getColor() {
	return color;
    }

    public void setColor(String color) {
	this.color = color;
    }

    public String getFirstLocatedTim() {
	return firstLocatedTim;
    }

    public void setFirstLocatedTim(String firstLocatedTim) {
	this.firstLocatedTim = firstLocatedTim;
    }

    public String getFolderName() {
	return folderName;
    }

    public void setFolderName(String folderName) {
	this.folderName = folderName;
    }

    public String getFolderSN() {
	return folderSN;
    }

    public void setFolderSN(String folderSN) {
	this.folderSN = folderSN;
    }

    public String getFrom() {
	return from;
    }

    public void setFrom(String from) {
	this.from = from;
	setFromDto();
    }

    public String getiDomainEmail() {
	return iDomainEmail;
    }

    public void setiDomainEmail(String iDomainEmail) {
	this.iDomainEmail = iDomainEmail;
    }

    public String getIconType() {
	return iconType;
    }

    public void setIconType(String iconType) {
	this.iconType = iconType;
    }

    public String getIsDomainMail() {
	return isDomainMail;
    }

    public void setIsDomainMail(String isDomainMail) {
	this.isDomainMail = isDomainMail;
    }

    public String getMailSN() {
	return mailSN;
    }

    public void setMailSN(String mailSN) {
	this.mailSN = mailSN;
    }

    public String getMimeSN() {
	return mimeSN;
    }

    public void setMimeSN(String mimeSN) {
	this.mimeSN = mimeSN;
    }

    public String getPreview() {
	return preview;
    }

    public void setPreview(String preview) {
	this.preview = preview;
    }

    public String getPriority() {
	return priority;
    }

    public void setPriority(String priority) {
	this.priority = priority;
    }

    public String getReSend() {
	return reSend;
    }

    public void setReSend(String reSend) {
	this.reSend = reSend;
    }

    public String getReceiveByBcc() {
	return receiveByBcc;
    }

    public void setReceiveByBcc(String receiveByBcc) {
	this.receiveByBcc = receiveByBcc;
    }

    public String getReceivedTime() {
	return receivedTime;
    }

    public void setReceivedTime(String receivedTime) {
	this.receivedTime = receivedTime;
    }

    public String getRemindAt() {
	return remindAt;
    }

    public void setRemindAt(String remindAt) {
	this.remindAt = remindAt;
    }

    public String getSecurityLevel() {
	return securityLevel;
    }

    public void setSecurityLevel(String securityLevel) {
	this.securityLevel = securityLevel;
    }


    public String getSize() {
	return size;
    }

    public void setSize(String size) {
	this.size = size;
    }

    public String getSpamType() {
	return spamType;
    }

    public void setSpamType(String spamType) {
	this.spamType = spamType;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getStatusHex() {
	return statusHex;
    }

    public void setStatusHex(String statusHex) {
	this.statusHex = statusHex;
    }

    public String getSubject() {
	return subject;
    }

    public void setSubject(String subject) {
	this.subject = subject;
    }

    public String getThreadCount() {
	return threadCount;
    }

    public void setThreadCount(String threadCount) {
	this.threadCount = threadCount;
    }

    public String getThreadId() {
	return threadId;
    }

    public void setThreadId(String threadId) {
	this.threadId = threadId;
    }

    public String getThreadRemindAt() {
	return threadRemindAt;
    }

    public void setThreadRemindAt(String threadRemindAt) {
	this.threadRemindAt = threadRemindAt;
    }

    public String getThreadRemindFlag() {
	return threadRemindFlag;
    }

    public void setThreadRemindFlag(String threadRemindFlag) {
	this.threadRemindFlag = threadRemindFlag;
    }

    public String getToList() {
	return toList;
    }

    public void setToList(String toList) {
	this.toList = toList;
	setToArrayList();
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getToMe() {
	return toMe;
    }

    public void setToMe(String toMe) {
	this.toMe = toMe;
    }

    public String getUnreadThreadCount() {
	return unreadThreadCount;
    }

    public void setUnreadThreadCount(String unreadThreadCount) {
	this.unreadThreadCount = unreadThreadCount;
    }

    public FromToListDto getFromDto() {
	return fromDto;
    }

    public void setFromDto() {
	try {
	    JSONParser parser = new JSONParser();
	    JSONObject obj = (JSONObject) parser.parse(from);
	    fromDto = new FromToListDto();
	    fromDto.setField(obj);
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public ArrayList<FromToListDto> getToArrayList() {
	return toArrayList;
    }

    public void setToArrayList() {
	try {
	    JSONParser parser = new JSONParser();
	    JSONArray array = (JSONArray) parser.parse(toList);

	    int size = array.size();
	    FromToListDto dto;
	    JSONObject obj;
	    for (int i = 0; i < size; i++) {
		obj = (JSONObject) array.get(i);
		dto = new FromToListDto();
		dto.setField(obj);
		toArrayList.add(dto);
	    }
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public void setField(JSONObject field) {
	attachCount = String.valueOf(field.get(ConstanceValue.MailDataParam.ATTACH_COUNT.param));
	attachInfo = String.valueOf(field.get(ConstanceValue.MailDataParam.ATTACH_INFO.param));
	bccList = String.valueOf(field.get(ConstanceValue.MailDataParam.BCC_LIST.param));
	bigFile = String.valueOf(field.get(ConstanceValue.MailDataParam.BIG_FILE.param));
	color = String.valueOf(field.get(ConstanceValue.MailDataParam.COLOR.param));
	firstLocatedTim = String.valueOf(field.get(ConstanceValue.MailDataParam.FIRST_LOCATION_TIME.param));
	folderName = String.valueOf(field.get(ConstanceValue.MailDataParam.FOLDER_NAME.param));
	folderSN = String.valueOf(field.get(ConstanceValue.MailDataParam.FOLDER_SN.param));
	setFrom(String.valueOf(field.get(ConstanceValue.MailDataParam.FROM.param)));
	iDomainEmail = String.valueOf(field.get(ConstanceValue.MailDataParam.IS_DOMAIN_MAIL.param));
	iconType = String.valueOf(field.get(ConstanceValue.MailDataParam.ICON_TYPE.param));
	isDomainMail = String.valueOf(field.get(ConstanceValue.MailDataParam.IS_DOMAIN_MAIL.param));
	mailSN = String.valueOf(field.get(ConstanceValue.MailDataParam.MAIL_SN.param));
	mimeSN = String.valueOf(field.get(ConstanceValue.MailDataParam.MIME_SN.param));
	preview = String.valueOf(field.get(ConstanceValue.MailDataParam.PREVIEW.param));
	priority = String.valueOf(field.get(ConstanceValue.MailDataParam.PRIORITY.param));
	reSend = String.valueOf(field.get(ConstanceValue.MailDataParam.RE_SEND.param));
	receiveByBcc = String.valueOf(field.get(ConstanceValue.MailDataParam.RECEIVE_BY_BBC.param));
	receivedTime = String.valueOf(field.get(ConstanceValue.MailDataParam.RECEIVE_TIME.param));
	remindAt = String.valueOf(field.get(ConstanceValue.MailDataParam.REMIND_AT.param));
	securityLevel = String.valueOf(field.get(ConstanceValue.MailDataParam.SECURITY_LEVEL.param));
	sendTime = String.valueOf(field.get(ConstanceValue.MailDataParam.SEND_TIME.param));
	size = String.valueOf(field.get(ConstanceValue.MailDataParam.SIZE.param));
	spamType = String.valueOf(field.get(ConstanceValue.MailDataParam.SPAM_TYPE.param));
	status = String.valueOf(field.get(ConstanceValue.MailDataParam.STATUS.param));
	statusHex = String.valueOf(field.get(ConstanceValue.MailDataParam.STATUS_HEX.param));
	subject = String.valueOf(field.get(ConstanceValue.MailDataParam.SUBJECT.param));
	threadCount = String.valueOf(field.get(ConstanceValue.MailDataParam.THREAD_COUNT.param));
	threadId = String.valueOf(field.get(ConstanceValue.MailDataParam.THREAD_ID.param));
	threadRemindAt = String.valueOf(field.get(ConstanceValue.MailDataParam.THREAD_REMIND_AT.param));
	threadRemindFlag = String.valueOf(field.get(ConstanceValue.MailDataParam.THREAD_REMIND_FLAG.param));
	setToList(String.valueOf(field.get(ConstanceValue.MailDataParam.TO_LIST.param)));
	toMe = String.valueOf(field.get(ConstanceValue.MailDataParam.TO_ME.param));
	unreadThreadCount = String.valueOf(field.get(ConstanceValue.MailDataParam.UNREAD_THREAD_COUNT.param));
    }

    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();
	StringBuilder value = new StringBuilder();

	for (MailDataParam param : MailDataParam.values()) {
	    str.append("\t" + param.param + " : ");
	    switch(param) {
	    case ATTACH_COUNT:
		value.append(attachCount);
		break;
	    case ATTACH_INFO:
		value.append(attachInfo);
		break;
	    case BCC_LIST:
		value.append(bccList);
		break;
	    case BIG_FILE:
		value.append(bigFile);
		break;
	    case COLOR:
		value.append(color);
		break;
	    case FIRST_LOCATION_TIME:
		value.append(firstLocatedTim);
		break;
	    case FOLDER_NAME:
		value.append(folderName);
		break;
	    case FOLDER_SN:
		value.append(folderSN);
		break;
	    case FROM:
		value.append(fromDto.toString());
		break;
	    case I_DOMAIN_EMAIL:
		value.append(iDomainEmail);
		break;
	    case ICON_TYPE:
		value.append(iconType);
		break;
	    case IS_DOMAIN_MAIL:
		value.append(isDomainMail);
		break;
	    case MAIL_SN:
		value.append(mailSN);
		break;
	    case MIME_SN:
		value.append(mimeSN);
		break;
	    case PREVIEW:
		value.append(preview);
		break;
	    case PRIORITY:
		value.append(priority);
		break;
	    case RE_SEND:
		value.append(reSend);
		break;
	    case RECEIVE_BY_BBC:
		value.append(receiveByBcc);
		break;
	    case RECEIVE_TIME:
		value.append(receivedTime);
		break;
	    case REMIND_AT:
		value.append(remindAt);
		break;
	    case SECURITY_LEVEL:
		value.append(securityLevel);
		break;
	    case SEND_TIME:
		value.append(sendTime);
		break;
	    case SIZE:
		value.append(size);
		break;
	    case SPAM_TYPE:
		value.append(spamType);
		break;
	    case STATUS:
		value.append(status);
		break;
	    case STATUS_HEX:
		value.append(statusHex);
		break;
	    case SUBJECT:
		value.append(subject);
		break;
	    case THREAD_COUNT:
		value.append(threadCount);
		break;
	    case THREAD_ID:
		value.append(threadId);
		break;
	    case THREAD_REMIND_AT:
		value.append(threadRemindAt);
		break;
	    case THREAD_REMIND_FLAG:
		value.append(threadRemindFlag);
		break;
	    case TO_LIST:
		int size = toArrayList.size();
		
		for(int i = 0; i < size; i++) {
		    value.append(toArrayList.get(i).toString());
		}
		break;
	    case TO_ME:
		value.append(toMe);
		break;
	    case UNREAD_THREAD_COUNT:
		value.append(unreadThreadCount);
		break;
		default:
		    value.append("null");
	    }
	    
	    str.append(value + "\n");

	    value = new StringBuilder();
	}

	return str.toString();
    }

}
