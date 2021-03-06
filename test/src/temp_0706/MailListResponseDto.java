package temp_0706;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import util.ConstanceValue;
import util.ConstanceValue.MailListParam;

public class MailListResponseDto extends MailResponseDto{
    private String currentTime;
    private String folderName;
    private String lastOffset;
    private String lastPage;
    private String listCount;
    private String mailData;
    private String pageSize;
    private String totalCount;
    private String unreadCount;

    private ArrayList<MailDataDto> mailDataList;

    public MailListResponseDto() {
	mailDataList = new ArrayList<>();
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public String getResult() {
	return result;
    }

    public void setResult(String result) {
	this.result = result;
    }

    public String getCurrentTime() {
	return currentTime;
    }

    public void setCurrentTime(String currentTime) {
	this.currentTime = currentTime;
    }

    public String getFolderName() {
	return folderName;
    }

    public void setFolderName(String folderName) {
	this.folderName = folderName;
    }

    public String getLastOffset() {
	return lastOffset;
    }

    public void setLastOffset(String lastOffset) {
	this.lastOffset = lastOffset;
    }

    public String getLastPage() {
	return lastPage;
    }

    public void setLastPage(String lastPage) {
	this.lastPage = lastPage;
    }

    public String getListCount() {
	return listCount;
    }

    public void setListCount(String listCount) {
	this.listCount = listCount;
    }

    public String getMailData() {
	return mailData;
    }

    public void setMailData(String mailData) {
	this.mailData = mailData;
	setMailDataList();
    }

    public String getPageSize() {
	return pageSize;
    }

    public void setPageSize(String pageSize) {
	this.pageSize = pageSize;
    }

    public String getTotalCount() {
	return totalCount;
    }

    public void setTotalCount(String totalCount) {
	this.totalCount = totalCount;
    }

    public String getUnreadCount() {
	return unreadCount;
    }

    public void setUnreadCount(String unreadCount) {
	this.unreadCount = unreadCount;
    }

    public void setField(JSONObject field) {
	message = String.valueOf(field.get(ConstanceValue.MailListParam.MESSAGE.param));
	result = String.valueOf(field.get(ConstanceValue.MailListParam.RESULT.param));
	currentTime = String.valueOf(field.get(ConstanceValue.MailListParam.CURRENT_TIMe.param));
	folderName = String.valueOf(field.get(ConstanceValue.MailListParam.FOLDER_NAME.param));
	lastOffset = String.valueOf(field.get(ConstanceValue.MailListParam.LAST_OFFSET.param));
	lastPage = String.valueOf(field.get(ConstanceValue.MailListParam.LAST_PAGE.param));
	listCount = String.valueOf(field.get(ConstanceValue.MailListParam.LIST_COUNT.param));
	setMailData(String.valueOf(field.get(ConstanceValue.MailListParam.MAIL_DATA.param)));
	pageSize = String.valueOf(field.get(ConstanceValue.MailListParam.PAGE_SIZE.param));
	totalCount = String.valueOf(field.get(ConstanceValue.MailListParam.TOTAL_COUNT.param));
	unreadCount = String.valueOf(field.get(ConstanceValue.MailListParam.UNREAD_COUNT.param));
    }

    public ArrayList<MailDataDto> getMailDataList() {
	return mailDataList;
    }

    public void setMailDataList() {
	try {
	    JSONParser parser = new JSONParser();
	    JSONArray mailDataArray = (JSONArray) parser.parse(mailData);
	    int size = mailDataArray.size();

	    MailDataDto dto;
	    JSONObject obj;
	    for (int i = 0; i < size; i++) {
		obj = (JSONObject) mailDataArray.get(i);
		dto = new MailDataDto();
		dto.setField(obj);
		mailDataList.add(dto);
	    }
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();

	StringBuilder value = new StringBuilder();
	for (MailListParam param : MailListParam.values()) {
	    str.append(param + " : ");
	    
	    switch(param) {
	    case CURRENT_TIMe:
		value.append(currentTime);
		break;
	    case FOLDER_NAME:
		value.append(folderName);
		break;
	    case LAST_OFFSET:
		value.append(lastOffset);
		break;
	    case LAST_PAGE:
		value.append(lastPage);
		break;
	    case LIST_COUNT:
		value.append(listCount);
		break;
	    case MAIL_DATA:
		int size = mailDataList.size();
		for(int i = 0; i < size; i++) {
		    value.append(mailDataList.get(i).toString());

		    value.append("=========================================================\n");
		}
		break;
	    case MESSAGE:
		value.append(message);
		break;
	    case PAGE_SIZE:
		value.append(pageSize);
		break;
	    case RESULT:
		value.append(result);
		break;
	    case TOTAL_COUNT:
		value.append(totalCount);
		break;
	    case UNREAD_COUNT:
		value.append(unreadCount);
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
