package com.zhuc;

/**
 * @author John.Yao
 * @title
 * @description
 * @usage
 * @copyright Copyright 2011  SHCMCT Corporation. All rights reserved.
 * @company 上海中移通信技术工程有限公司
 * @create 2013-13-6-26 下午6:29
 */
public interface Constant {

	/**
	 * 包头标记
	 */
	byte[] HEADER = new byte[] { (byte) 0xfd, (byte) 0xdf };
	/**
	 * 包尾标记
	 */
	byte[] TAIL = new byte[] { (byte) 0xdf, (byte) 0xfd };

	/**
	 * 消息类型 -- 登录请求返回
	 */
	byte TYPE_LOGIN_RESULT = 0x10;

	/**
	 * 消息类型 -- 下发指令返回结果
	 */
	byte TYPE_COMMAND_RESULT = 0x11;

	/**
	 * 消息类型 -- GIS数据推送
	 */
	byte TYPE_GIS = 0x04;

	/**
	 * 消息类型 -- 数据上行透传
	 */
	byte TYPE_UPLOAD = 0x07;

	/**
	 * 登陆成功
	 */
	byte RESULT_LOGIN_SUCCESS = 0x00;
	/**
	 * 登陆消息格式错误
	 */
	byte RESULT_LOGIN_DATA_ERROR = (byte) 0xe0;
	/**
	 * 登陆appid错误
	 */
	byte RESULT_LOGIN_APPID_ERROR = (byte) 0xe1;
	/**
	 * 登陆用户名错误
	 */
	byte RESULT_LOGIN_ACCOUNT_ERROR = (byte) 0xe2;

	/**
	 * 登陆口令错误
	 */
	byte RESULT_LOGIN_PWD_ERROR = (byte) 0xe3;

	/**
	 * 该账号已经登陆
	 */
	byte RESULT_LOGIN_REPEAT = (byte) 0xe4;

	/**
	 * 指令下发成功
	 */
	byte RESULT_COMMAND_SUCCESS = 0x00;

	/**
	 * 指令非法
	 */
	byte RESULT_COMMAND_INVALID = (byte) 0xf1;

	/**
	 * 指令超时
	 */
	byte RESULT_COMMAND_TIMEOUT = (byte) 0xf2;

	/**
	 * 消息ID-终端通用应答
	 */
	byte[] RESPONSE_TERMINAL = new byte[] { 0x00, 0x01 };

	/**
	 * 消息ID-查询终端参数应答
	 */
	byte[] RESPONSE_QUERY_TERMINAL_PARAM = new byte[] { 0x01, 0x04 };

	/**
	 * 消息ID-位置信息查询应答
	 */
	byte[] RESPONSE_QUERY_LOCATION = new byte[] { 0x02, 0x01 };

	/**
	 * 消息ID-终端通用应答-结果字段-成功
	 */
	byte RESPONSE_TERMINAL_RESULT_SUCCESS = 0x00;

	/**
	 * 消息ID-终端通用应答-结果字段-失败
	 */
	byte RESPONSE_TERMINAL_RESULT_FAILURE = 0x01;

	/**
	 * 消息ID-终端通用应答-结果字段-消息有误
	 */
	byte RESPONSE_TERMINAL_RESULT_MSG_ERROR = 0x02;

	/**
	 * 消息ID-终端通用应答-结果字段-不支持
	 */
	byte RESPONSE_TERMINAL_RESULT_NOT_SUPPORT = 0x03;

	/**
	 * 消息ID-设置终端参数
	 */
	byte[] MESSAGEID_SET_TERMINAL_PARAM = new byte[] { (byte) 0x81, 0x03 };

	/**
	 * 消息ID-获取终端参数
	 */
	byte[] MESSAGEID_GET_TERMINAL_PARAM = new byte[] { (byte) 0x81, 0x04 };

	/**
	 * 消息ID-获取位置信息
	 */
	byte[] MESSAGEID_GET_LOCATION = new byte[] { (byte) 0x82, 0x01 };

	/**
	 * 消息ID-设置圆形区域
	 */
	byte[] MESSAGEID_SET_CIRCLE_AREA = new byte[] { (byte) 0x86, 0x00 };

	/**
	 * 消息ID-删除圆形区域
	 */
	byte[] MESSAGEID_DEL_CIRCLE_AREA = new byte[] { (byte) 0x86, 0x01 };

	/**
	 * 消息ID-消息下行数据透传
	 */
	byte[] MESSAGEID_DOWNSTREAM_DATA = new byte[] { (byte) 0x89, 0x00 };

	/**
	 * 消息ID-消息上行数据透传
	 */
	byte[] MESSAGEID_UPSTREAM_DATA = new byte[] { 0x09, 0x00 };

	/**
	 * 消息ID-心跳
	 */
	byte[] MESSAGEID_HEART = new byte[] { 0x00, 0x02 };

	/**
	 * 消息ID-终端控制
	 */
	byte[] MESSAGEID_CONSOLE_CONTROL = new byte[] { (byte) 0x81, 0x05 };

    /**
     * 消息ID-远程查询
     */
    byte[] MESSAGEID_REMOTE_SEARCH = new byte[] { (byte) 0x81, 0x08 };

	/**
	 * 消息报文标志位
	 */
	byte MSG_FLAG = 0x7e;

	/**
	 * 参数ID-设置终端参数-APN
	 */
	byte[] PARAMID_SET_TERMINAL_PARAM_APN = new byte[] { 0x00, 0x00, 0x00, 0x10 };

	/**
	 * 参数ID-设置终端参数-APN用户名
	 */
	byte[] PARAMID_SET_TERMINAL_PARAM_USERNAME = new byte[] { 0x00, 0x00, 0x00, 0x11 };

	/**
	 * 参数ID-设置终端参数-APN密码
	 */
	byte[] PARAMID_SET_TERMINAL_PARAM_PASSWORD = new byte[] { 0x00, 0x00, 0x00, 0x12 };

	/**
	 * 参数ID-设置终端参数-主服务器IP
	 */
	byte[] PARAMID_SET_TERMINAL_PARAM_MASTERIP = new byte[] { 0x00, 0x00, 0x00, 0x13 };

	/**
	 * 参数ID-设置终端参数-备份服务器IP
	 */
	byte[] PARAMID_SET_TERMINAL_PARAM_SLAVERYIP = new byte[] { 0x00, 0x00, 0x00, 0x17 };

	/**
	 * 参数ID-设置终端参数-TCP端口
	 */
	byte[] PARAMID_SET_TERMINAL_PARAM_PORT = new byte[] { 0x00, 0x00, 0x00, 0x18 };

	/**
	 * 参数ID-设置终端参数-短信网关
	 */
	byte[] PARAMID_SET_TERMINAL_PARAM_GATEWAY = new byte[] { 0x00, 0x00, 0x00, 0x49 };

	/**
	 * 参数ID-设置终端参数-心跳间隔
	 */
	byte[] PARAMID_SET_TERMINAL_PARAM_BEATINTERVAL = new byte[] { 0x00, 0x00, 0x00, 0x01 };

	/**
	 * 参数ID-设置终端参数-最大速度
	 */
	byte[] PARAMID_SET_TERMINAL_PARAM_SPEED = new byte[] { 0x00, 0x00, 0x00, 0x55 };

	/**
	 * 参数ID-设置终端参数-超速持续时间
	 */
	byte[] PARAMID_SET_TERMINAL_PARAM_DURATION = new byte[] { 0x00, 0x00, 0x00, 0x56 };

	/**
	 * 设置圆形区域属性-更新区域
	 */
	byte SETCIRCLEAREA_ATTRIBUTE_UPDATE = 0x00;

	/**
	 * 设置圆形区域属性-追加区域
	 */
	byte SETCIRCLEAREA_ATTRIBUTE_ADD = 0x01;

	/**
	 * 设置圆形区域属性-修改区域
	 */
	byte SETCIRCLEAREA_ATTRIBUTE_MODIFY = 0x02;

	/**
	 * 部标数据包标志位
	 */
	byte GNSS_PACKET_MARK = 0x7e;

	/**
	 * 转义码
	 */
	byte GNSS_PACKET_MARK_ESCAPE_CODER = 0x7d;

	/**
	 * 标志位转义码A （0x7d -> 0x7d 0x01）
	 */
	byte GNSS_PACKET_MARK_ESCAPE_CODER_A = 0x01;
	/**
	 * 标志位转移码B (0x7e -> 0x7d 0x02)
	 */
	byte GNSS_PACKET_MARK_ESCAPE_CODER_B = 0x02;

	/*****************************************************************************************************/

	String GV320_DATA_SEPARATE = "|";

	String GV320_DATA_HEAD = "AT+GTDAT=";

	String GV320_DATA_UP_HEAD = "+RESP:GTDAT,0E0100,IMEI,,";

	String GV320_DATA_UP_TYPE_SEND = "U";

	String GV320_DATA_UP_TYPE_RESPONSE = "R";

	String GV320_DATA_TAIL = "$";

	/**
	 * 类型-下发派车单(主动下发)
	 */
	int GV320_OP_TYPE_SEND_ACTIVE = 1;

	/**
	 * 类型-下发派车单(平板上行的批量下发)
	 */
	int GV320_OP_TYPE_SEND_UNACTIVE = 5;

	/**
	 * 类型-撤销派车单
	 */
	int GV320_OP_TYPE_CANCEL = 2;

	/**
	 * 类型-退返派车单
	 */
	int GV320_OP_TYPE_RETREAT = 3;

	/**
	 * 类型-手工结单
	 */
	int GV320_OP_TYPE_MANUAL = 4;

	/**
	 * GV320对主动下行派车单的响应-成功
	 */
	int GV320_RESPONSE_SUCCESS = 1;

	/**
	 * GV320对主动下行派车单的响应-失败
	 */
	int GV320_RESPONSE_FAILURE = 0;

	//gv320 业务数据最大长度
	int GV320_DATA_BODY_SIZE_MAX = 200;

	//默认密码
	String GV320_DATA_DEFAULT_PASSWORD = "gv320";

	//用于在下发时站位总包数的不可见字符
	char GV320_DATA_PACKET_REPALCE_COUNT = 29;

	//用于在下发时站位当前包号的不可见字符
	char GV320_DATA_PACKET_REPALCE_NUMBER = 28;

	/**
	 * 上行数据的类型-出车
	 */
	int UPSTEAM_TYPE_1 = 1;

	/**
	 * 上行数据的类型-回场
	 */
	int UPSTEAM_TYPE_2 = 2;

	/**
	 * 上行数据的类型-车辆抛锚
	 */
	int UPSTEAM_TYPE_3 = 3;

	/**
	 * 上行数据的类型-车辆事故
	 */
	int UPSTEAM_TYPE_4 = 4;

	/**
	 * 上行数据的类型-夜间停放
	 */
	int UPSTEAM_TYPE_5 = 5;

	/**
	 * 上行数据的类型-到达提醒
	 */
	int UPSTEAM_TYPE_6 = 6;

	/**
	 * 上行数据的类型-编辑短信
	 */
	int UPSTEAM_TYPE_7 = 7;

	/**
	 * 上行数据的类型-获取派车单
	 */
	int UPSTEAM_TYPE_8 = 8;

	/**
	 * 上行数据的类型-加油记录
	 */
	int UPSTEAM_TYPE_9 = 9;

	/**
	 * 上行数据的类型-车辆例保
	 */
	int UPSTEAM_TYPE_10 = 10;

	/**
	 * 上行数据的类型-车辆检查
	 */
	int UPSTEAM_TYPE_11 = 11;

	/**
	 * 附加消息ID-里程
	 */
	byte[] ADDTIONAL_MESSAGEID_MILEAGE = new byte[] { 0x01 };

	/**
	 * 附加消息ID-MCC 移动国家码
	 */
	byte[] ADDTIONAL_MESSAGEID_MCC = new byte[] { 0x05 };

	/**
	 * 附加消息ID-MNC 移动网络码
	 */
	byte[] ADDTIONAL_MESSAGEID_MNC = new byte[] { 0x06 };

	/**
	 * 附加消息ID-LAC
	 */
	byte[] ADDTIONAL_MESSAGEID_LAC = new byte[] { 0x07 };

	/**
	 * 附加消息ID-CELLID
	 */
	byte[] ADDTIONAL_MESSAGEID_CELLID = new byte[] { 0x08 };

	/**
	 * 报表类型-违规
	 */
	int REPORT_TYPE_OUT = 1;

	/**
	 * 报表类型-超速
	 */
	int REPORT_TYPE_OVERSPEED = 2;

	/**
	 * 报表类型-超时
	 */
	int REPORT_TYPE_OVERTIME = 3;

	/**
	 * 报表类型-车机状态
	 */
	int REPORT_TYPE_STATUS = 4;

	// --------------------------------------------

	/**
	 * 固定短信报表类型-夜间停放
	 */
	int SMS_REPORT_TYPE_NIGHT = 1;

	/**
	 * 固定短信报表类型-车辆抛锚
	 */
	int SMS_REPORT_TYPE_BROKEN = 2;

	/**
	 * 固定短信报表类型-车辆事故
	 */
	int SMS_REPORT_TYPE_ACCIDENT = 3;

	/**
	 * 固定短信报表状态-已处理
	 */
	int SMS_REPORT_STATUS_1 = 1;

	/**
	 * 固定短信报表状态-未处理
	 */
	int SMS_REPORT_STATUS_0 = 0;

	// --------------------------------------------

	/**
	 * 全局出车回场状态-出车
	 */
	int GLOBAL_GO = 1;

	/**
	 * 全局出车回场状态-回场
	 */
	int GLOBAL_COME = 0;

	/**
	 * 车机状态-正常
	 */
	int STATUS_NORMAL = 1;

	/**
	 * 车机状态-不正常
	 */
	int STATUS_NOT_NORMAL = 0;

	// 调度系统派车单状态
	/**
	 * 未执行
	 */
	int DISPATCH_STATUS_0 = 0;

	/**
	 * 已执行
	 */
	int DISPATCH_STATUS_1 = 1;

	/**
	 * 车辆派车单出省标志
	 */
	int DISPATCH_OUT = 1;

	/****************************SERVER-CLIENT-CONSTANT-DEFINE*******************************************/

	/**
	 * 登录
	 */
	byte CLIENT_OPERATE_TYPE_LOGIN = 0x01;

	/**
	 * 心跳
	 */
	byte CLIENT_OPERATE_TYPE_HEARTBEAT = 0x00;

	/**
	 * 设备指令
	 */
	byte CLIENT_OPERATE_TYPE_EQU_COMMAND = 0x02;

    /**
     * 设备指令回复
     */
    byte CLIENT_OPERATE_TYPE_EQU_COMMAND_REPLY = 0x03;

	/**
	 * 回复客户端的消息-成功
	 */
	String MSG_SUCCESS = "成功";

	/**
	 * 回复客户端的消息-失败
	 */
	String MSG_FAILURE = "失败";

	/**
	 * 登录回复消息
	 */
	String MSG_LOGIN_ERROR = "登录鉴权失败";

	String MSG_LOGIN_FAILURE = "用户名或密码错误";

	String MSG_LOGIN_INVALID = "您还未登录或登录超时";

	String MSG_LOGIN_EXIST = "该账号已登录";

	/**
	 * 车机回复状态-成功
	 */
	String COMMAND_RESPONSE_SUCCESS = "1";

    /**
     * 定位方式-GPS定位
     */
    Integer POSITION_TYPE_GPS = 1;

    /**
     * 定位方式-基站定位
     */
    Integer POSITION_TYPE_STATION = 2;

}
