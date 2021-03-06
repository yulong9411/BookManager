
package com.cpf.constant;
/**
 * 
 * @author CPF
 *
 */
public class WebConstant
{
	public static final String ERROR_ISBN_CODE="isbn错误";
	public static final String BOOK_IS_NO_EXIST="图书不存在";
	public static final String BOOROW_COUNT_NOT_ENOUGH="已超过用户可借阅数";
	
	public static final String SESSION_KEY_MANAGER="manager";
	public static final String SESSION_KEY_READER="reader";
	
	//默认借书时长（单位天）
	public static final int BORROW_TIME=60;
	
	//是否续借
	public static final String IS_RENEW_NO="0";
	public static final String IS_RENEW_YES="1";
	
	//是否删除
	public static final String HAS_DELETE_YES="1";
	public static final String HAS_DELETE_NO="0";
	
	//身份
	public static final String READER_ROLE_TYPE="0";//读者
	public static final String MANAGER_ROLE_TYPE="1";//管理员
	
	//记录类型type
	public static final String BORROW_RECORDE="0";//借阅记录
	public static final String ORDER_RECORDE="1";//预订记录
	
	public static final String VIEW_LOGIN_CONTROL="login_control";
	public static final String VIEW_USER_INDEX="user_index";
	public static final String VIEW_MANAGER_INDEX="manager_index";
	public static final String VIEW_SEARCH_BOOK="search_book";
	
	/*---------------------豆瓣API---------------------*/
	public static final String DOUBAN_API="https://api.douban.com/v2/book/isbn/";
	public static final String KEY_DOUBAN_ORIGIN_TITLE="origin_title";
	public static final String KEY_DOUBAN_SMALL="small";
	public static final String KEY_DOUBAN_AVERAGE="average";
	public static final String KEY_DOUBAN_CATALOG="catalog";
	public static final String KEY_DOUBAN_TRANSLATOR="translator";
	public static final String KEY_DOUBAN_RATING="rating";
	public static final String KEY_DOUBAN_BINDING="binding";
	public static final String KEY_DOUBAN_MEDIUM="medium";
	public static final String KEY_DOUBAN_TITLE="title";
	public static final String KEY_DOUBAN_AUTHOR_INTRO="author_intro";
	public static final String KEY_DOUBAN_MIN="min";
	public static final String KEY_DOUBAN_PAGES="pages";
	public static final String KEY_DOUBAN_NUMRATERS="numRaters";
	public static final String KEY_DOUBAN_PRICE="price";
	public static final String KEY_DOUBAN_ID="id";
	public static final String KEY_DOUBAN_PUBDATE="pubdate";
	public static final String KEY_DOUBAN_SUMMARY="summary";
	public static final String KEY_DOUBAN_IMAGE="image";
	public static final String KEY_DOUBAN_IMAGES="images";
	public static final String KEY_DOUBAN_LARGE="large";
	public static final String KEY_DOUBAN_MAX="max";
	public static final String KEY_DOUBAN_AUTHOR="author";
	public static final String KEY_DOUBAN_COUNT="count";
	public static final String KEY_DOUBAN_ALT="alt";
	public static final String KEY_DOUBAN_URL="url";
	public static final String KEY_DOUBAN_TAGS="tags";
	public static final String KEY_DOUBAN_ALT_TITLE="alt_title";
	public static final String KEY_DOUBAN_SUBTITLE="subtitle";
	public static final String KEY_DOUBAN_ISBN13="isbn13";
	public static final String KEY_DOUBAN_NAME="name";
	public static final String KEY_DOUBAN_PUBLISHER="publisher";
	public static final String KEY_DOUBAN_ISBN10="isbn10";
	/*---------------------豆瓣API---------------------*/
}