package test;

import util.ConstanceValue.ListRequestParam;
import util.ConstanceValue.ListType;

public class ListRequestParameter {
    private String page;
    private String sortField;
    private String sortType;
    private String folderSN;
    private String type;
    private String isUnread;
    private String viewMode;
    private String startOffset;
    private String pageSize4SeeMore;
    private String u;

    public String getPage() {
	return page;
    }

    public void setPage(String page) {
	this.page = page;
    }

    public String getSortField() {
	return sortField;
    }

    public void setSortField(String sortField) {
	this.sortField = sortField;
    }

    public String getSortType() {
	return sortType;
    }

    public void setSortType(String sortType) {
	this.sortType = sortType;
    }

    public String getFolderSN() {
	return folderSN;
    }

    public void setFolderSN(String folderSN) {
	this.folderSN = folderSN;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getIsUnread() {
	return isUnread;
    }

    public void setIsUnread(String isUnread) {
	this.isUnread = isUnread;
    }

    public String getViewMode() {
	return viewMode;
    }

    public void setViewMode(String viewMode) {
	this.viewMode = viewMode;
    }

    public String getStartOffset() {
	return startOffset;
    }

    public void setStartOffset(String startOffset) {
	this.startOffset = startOffset;
    }

    public String getPageSize4SeeMore() {
	return pageSize4SeeMore;
    }

    public void setPageSize4SeeMore(String pageSize4SeeMore) {
	this.pageSize4SeeMore = pageSize4SeeMore;
    }

    public String getU() {
	return u;
    }

    public void setU(String u) {
	this.u = u;
    }

    public void resetParam() {
	page = null;
	sortField = null;
	sortType = null;
	folderSN = null;
	type = null;
	isUnread = null;
	viewMode = null;
	startOffset = null;
	pageSize4SeeMore = null;
	u = null;
    }

    public void setParam(ListType listType) {
	resetParam();
	switch (listType) {
	case ALL:
	    folderSN = "-1";
	    type = "all";
	    break;
	case IMPORTANT:
	    folderSN = "-1";
	    type = "mark";
	    break;
	case MEMO:
	    folderSN = "6";
	    break;
	case RECEIVE:
	    folderSN = "0";
	    break;
	case RECEIVE_PERSON:
	    folderSN = "-1";
	    type = "tome";
	    break;
	case SEND:
	    folderSN = "1";
	    break;
	case SPAM:
	    folderSN = "5";
	    break;
	case TEMPORARY:
	    folderSN = "3";
	    break;
	case WASTE:
	    folderSN = "4";
	    break;
	default:

	}
    }

    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();
	str.append("?");

	String value;
	for (ListRequestParam param : ListRequestParam.values()) {
	    switch (param) {
	    case FOLDER_SN:
		value = folderSN;
		break;
	    case IS_Unread:
		value = isUnread;
		break;
	    case PAGE:
		value = page;
		break;
	    case PAGE_SIZE_4_SEE_MORE:
		value = pageSize4SeeMore;
		break;
	    case SORT_FIELD:
		value = sortField;
		break;
	    case SORT_TYPE:
		value = sortType;
		break;
	    case START_OFFSET:
		value = startOffset;
		break;
	    case TYPE:
		value = type;
		break;
	    case U:
		value = u;
		break;
	    case VIEW_MODE:
		value = viewMode;
	    default:
		value = null;
	    }

	    if (value != null) {
		str.append(param.param);
		str.append(value);
		str.append("&");
	    }
	}

	return str.toString();
    }

}
